package com.mm.backend.interceptor;

import com.mm.backend.common.RestResult;
import com.mm.backend.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
        || requestUri.equals("/backend/picture/favoratepictures")
        || requestUri.equals("/backend/order/orderrequest")
        || requestUri.equals("/backend/order/prepay")
        || requestUri.equals("/backend/video/favorate")
        || requestUri.equals("/backend/video/unfavorate")
        || requestUri.equals("/backend/user/logout")
        || requestUri.equals("/backend/user/uservipinfo")) {
            if (checkAuthInfo(request, response, requestUri)) {
                return super.preHandle(request, response, handler);
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkAuthInfo(HttpServletRequest request,HttpServletResponse response,String requestUri)
    {
        String token = request.getHeader(HEAD_AUTH_TOKEN);
        Object userObject = this.redisService.get(token);
        if(null == userObject){
            returnJson(response, "请先登录");
            //throw new Exception("用户未登录");
            return false;
        }

        String[] userInfo = userObject.toString().split(":");
        String userId = userInfo[0];
        String userLevel = userInfo[1];
        if((requestUri.equals("/backend/picture/unfavorate")
                || requestUri.equals("/backend/picture/favorate")
                || requestUri.equals("/backend/picture/favoratepictures"))
            && (Integer.valueOf(userLevel) < 2)){
            returnJson(response,"权限不足");
        }

        new RequestHeaderContext.RequestHeaderContextBuild()
                .token(token)
                .userId(userId)
                .userLevel(userLevel)
                .bulid();
        return true;
    }

    private void returnJson(HttpServletResponse response, String msg){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            RestResult<Void> result = RestResult.createByErrorMessage(msg);
            writer.write(JSON.toJSONString(result));
        } catch (IOException e){
            System.out.println("拦截器输出流异常"+e);
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
