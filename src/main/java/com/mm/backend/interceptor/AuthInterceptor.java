package com.mm.backend.interceptor;

import com.mm.backend.common.ResponseCode;
import com.mm.backend.common.RestResult;
import com.mm.backend.common.StringUtils;
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

import static com.mm.backend.common.ResponseCode.USER_LOGIN_NO_AUTHORITY;
import static com.mm.backend.common.ResponseCode.USER_LOGIN_USER_NOT_LOGIN;

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
        parseAuthInfo(request);
        String requestUri = request.getRequestURI().toLowerCase();

        if(requestUri.equals("/backend/picture/unfavorate")
        || requestUri.equals("/backend/picture/favorate")
        || requestUri.equals("/backend/picture/favoratepictures")
        || requestUri.equals("/backend/picture/collectDetail")
        || requestUri.equals("/backend/order/orderrequest")
        || requestUri.equals("/backend/order/prepay")
        || requestUri.equals("/backend/video/favorate")
        || requestUri.equals("/backend/video/unfavorate")
        || requestUri.equals("/backend/user/logout")
        || requestUri.equals("/backend/user/uservipinfo")
        || requestUri.equals("/backend/user/changePasswd")) {
            if (checkAuthInfo(request, response, requestUri)) {
                return super.preHandle(request, response, handler);
            } else {
                return false;
            }
        }
        return true;
    }

    private void parseAuthInfo(HttpServletRequest request){
        String token = request.getHeader(HEAD_AUTH_TOKEN);
        if(StringUtils.isNotBlank(token)){
            Object userObject = this.redisService.get(token);
            if(null != userObject) {
                String[] userInfo = userObject.toString().split(":");
                String userId = userInfo[0];
                String userLevel = userInfo[1];

                new RequestHeaderContext.RequestHeaderContextBuild()
                        .token(token)
                        .userId(userId)
                        .userLevel(userLevel)
                        .bulid();
            }
        }
    }

    private boolean checkAuthInfo(HttpServletRequest request,HttpServletResponse response,String requestUri)
    {
        if(StringUtils.isBlank(RequestHeaderContext.getInstance()) || StringUtils.isBlank(RequestHeaderContext.getInstance().getUserId())){
            returnJson(response, USER_LOGIN_USER_NOT_LOGIN);
            //throw new Exception("用户未登录");
            return false;
        }

        String userLevel = RequestHeaderContext.getInstance().getLevel();
        if(requestUri.equals("/backend/picture/collectDetail")
                && (Integer.valueOf(userLevel) < 1)){
            returnJson(response,USER_LOGIN_NO_AUTHORITY);
        }

        if((requestUri.equals("/backend/picture/unfavorate")
                || requestUri.equals("/backend/picture/favorate")
                || requestUri.equals("/backend/picture/favoratepictures"))
            && (Integer.valueOf(userLevel) < 2)){
            returnJson(response,USER_LOGIN_NO_AUTHORITY);
        }

        return true;
    }

    private void returnJson(HttpServletResponse response, ResponseCode code){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            RestResult<Void> result = new RestResult<>(code);
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
