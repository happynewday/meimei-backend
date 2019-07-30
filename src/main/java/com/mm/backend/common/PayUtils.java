package com.mm.backend.common;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class PayUtils {
    private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(PayUtils.class);

    @Value("${paysapi.uid}")
    public static String UID;

    @Value("${server.notify_url}")
    public static String NOTIFY_URL;

    @Value("${server.return_url}")
    public static String RETURN_URL;

    public static String BASE_URL = "https://pay.paysapi.com";

    @Value("${paysapi.token}")
    public static String TOKEN;

    public static Map<String, Object> payOrder(Map<String, Object> remoteMap) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("uid", UID);
        paramMap.put("notify_url", NOTIFY_URL);
        paramMap.put("return_url", RETURN_URL);
        paramMap.putAll(remoteMap);
        paramMap.put("key", getKey(paramMap));
        return paramMap;
    }

    public static String getKey(Map<String, Object> remoteMap) {
        String key = "";
        if (null != remoteMap.get("goodsname")) {
            key += remoteMap.get("goodsname");
        }
        if (null != remoteMap.get("istype")) {
            key += remoteMap.get("istype");
        }
        if (null != remoteMap.get("notify_url")) {
            key += remoteMap.get("notify_url");
        }
        if (null != remoteMap.get("orderid")) {
            key += remoteMap.get("orderid");
        }
        if (null != remoteMap.get("orderuid")) {
            key += remoteMap.get("orderuid");
        }
        if (null != remoteMap.get("price")) {
            key += remoteMap.get("price");
        }
        if (null != remoteMap.get("return_url")) {
            key += remoteMap.get("return_url");
        }
        key += TOKEN;
        if (null != remoteMap.get("uid")) {
            key += remoteMap.get("uid");
        }
        return MD5Utils.encryption(key);
    }

    public static boolean checkPayKey(Map<String, String> payNotifyMap) {
        String key = "";
        if (null != payNotifyMap.get("orderid")) {
            logger.info("支付回来的订单号：" + payNotifyMap.get("orderid"));
            key += payNotifyMap.get("orderid");
        }
        if (null != payNotifyMap.get("orderuid")) {
            logger.info("支付回来的支付记录的ID：" + payNotifyMap.get("orderuid"));
            key += payNotifyMap.get("orderuid");
        }
        if (null != payNotifyMap.get("paysapi_id")) {
            logger.info("支付回来的平台订单号：" + payNotifyMap.get("paysapi_id"));
            key += payNotifyMap.get("paysapi_id");
        }
        if (null != payNotifyMap.get("price")) {
            logger.info("支付回来的价格：" + payNotifyMap.get("price"));
            key += payNotifyMap.get("price");
        }
        if (null != payNotifyMap.get("realprice")) {
            logger.info("支付回来的真实价格：" + payNotifyMap.get("realprice"));
            key += payNotifyMap.get("realprice");
        }

        key += TOKEN;
        logger.info("我们自己拼接的Key：" + MD5Utils.encryption(key));
        logger.info("支付回来的Key：" + payNotifyMap.get("key"));
        return payNotifyMap.get("key").equals(MD5Utils.encryption(key));
    }

    public static String getOrderIdByUUId() {
        int machineId = 1;// 最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0;d 代表参数为正数型
        return machineId + String.format("%01d", hashCodeV);
    }

}

