package com.mm.backend.common;

import com.mm.backend.interceptor.RequestHeaderContext;

public class UidUtil {
    /**
     * 获取uid
     *
     * @return uid
     */
    public static Integer getUidFromRequest() {
        Integer uid = null;
        if(null != RequestHeaderContext.getInstance()) {
            String uidStr = RequestHeaderContext.getInstance().getUserId();
            if (StringUtils.isNotBlank(uidStr)) {
                uid = Integer.valueOf(uidStr);
            }
        }
        return uid;
    }
}
