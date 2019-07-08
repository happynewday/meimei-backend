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
}
