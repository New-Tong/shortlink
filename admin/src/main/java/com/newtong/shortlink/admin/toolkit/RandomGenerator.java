package com.newtong.shortlink.admin.toolkit;

/**
 * @author NewTong
 * @Date 2024/8/1 -19:27
 * @Description
 */

import java.security.SecureRandom;

/**
 * @Author NewTong
 * @Date 19:27 2024/8/1
 * @Description 生成随机分组ID的工具类
 */
public final class RandomGenerator {
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 6;

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateGroupId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(CHARS.length());
            sb.append(CHARS.charAt(randomIndex));
        }
        return sb.toString();
    }
}
