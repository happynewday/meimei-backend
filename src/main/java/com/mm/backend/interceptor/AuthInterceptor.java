package com.mm.backend.interceptor;

import com.mm.backend.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName AuthInterceptor
 * @Description TODO
 * @Date 2019/7/8 22:09
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger =  LoggerFactory.getLogger(AuthInterceptor.class);

    private RedisService redisService;

    private static final String HEAD_AUTH_TOKEN = "x-auth-token";

    @Autowired
    public void RedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String requestUri = request.getRequestURI().toLowerCase();

        if(requestUri.equals("/backend/picture/unfavorate")
        || requestUri.equals("/backend/picture/favorate")
        || requestUri.equals("/backend/order/orderrequest")
        || requestUri.equals("/backend/video/favorate")
        || requestUri.equals("/backend/video/unfavorate")
        || requestUri.equals("/backend/user/uservipinfo")) {
            if (checkAuthInfo(request)) {
                return super.preHandle(request, response, handler);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkAuthInfo(HttpServletRequest request) throws Exception
    {
        String token = request.getHeader(HEAD_AUTH_TOKEN);
        Object userObject = this.redisService.get(token);
        if(null == userObject){
            throw new Exception("用户未登录");
        }

        String userId = userObject.toString();
        new RequestHeaderContext.RequestHeaderContextBuild()
                .token(token)
                .userId(userId)
                .bulid();
        return true;
    }
}
