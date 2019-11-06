package com.mm.backend.controller;

import com.mm.backend.common.RestResult;

import com.mm.backend.common.StringUtils;
import com.mm.backend.interceptor.RequestHeaderContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/backend/log")
@Api(tags = "日志相关API")
public class LogBackendController {
    private static final Logger logger = LoggerFactory.getLogger(LogBackendController.class);


    @RequestMapping(value = "/{source}",method = RequestMethod.POST,
            produces="application/json;charset=UTF-8")
    @ApiOperation(value = "日志打印", notes = "日志打印，source为来源")
    void getProductList(@PathVariable("source") String source, HttpServletRequest request) {
        Integer uid = null;
        if(null != RequestHeaderContext.getInstance()) {
            String uidStr = RequestHeaderContext.getInstance().getUserId();
            if (StringUtils.isNotBlank(uidStr)) {
                uid = Integer.valueOf(uidStr);
            }
        }
        String remoteIp = request.getRemoteAddr();

        logger.warn("user entered, uid={}, source={}, remoteAddr={}", uid, source, remoteIp);
    }
}
