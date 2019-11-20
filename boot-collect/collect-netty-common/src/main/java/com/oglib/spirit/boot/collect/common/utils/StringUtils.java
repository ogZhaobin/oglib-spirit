package com.oglib.spirit.boot.collect.common.utils;

public class StringUtils {

    /**
     * 把字符串的首先字母变成小写
     * @param dest
     * @return
     */
    public static String lowerFirst(String dest) {
        if (dest == null  || dest.isEmpty()) {
            return dest;
        }
        char c[] = dest.toCharArray();
        c[0] += 32;
        return new String(c);
    }

}
