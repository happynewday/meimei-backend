package com.mm.backend.common;

import java.util.Random;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Date 2019/7/8 14:24
 */
public class StringUtils {
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }

        Random  randGen = new Random();

        char[]  numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

        char [] randBuffer = new char[length];

        for (int i=0; i<randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
    }

    /**
     * 一次性判断多个或单个对象为空。
     *
     * @param objects
     * @author ztt
     * @return 只要有一个元素为Blank，则返回true
     */
    public static boolean isBlank(Object... objects) {
        Boolean result = false;
        for (Object object : objects) {
            if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 一次性判断多个或单个对象不为空。
     *
     * @param objects
     * @author ztt
     * @return 只要有一个元素不为Blank，则返回true
     */
    public static boolean isNotBlank(Object... objects) {
        return !isBlank(objects);
    }

    public static boolean isBlank(String... objects) {
        Object[] object = objects;
        return isBlank(object);
    }

    public static boolean isNotBlank(String... objects) {
        Object[] object = objects;
        return !isBlank(object);
    }

    public static boolean isBlank(String str) {
        Object object = str;
        return isBlank(object);
    }

    public static boolean isNotBlank(String str) {
        Object object = str;
        return !isBlank(object);
    }
}
