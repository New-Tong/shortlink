package com.newtong.shortlink.admin.common.constant;

import java.util.concurrent.TimeUnit;

/**
 * @author NewTong
 * @Date 2024/7/30 -16:37
 * @Description 短链接后台管理系统缓存常量类
 */
public class RedisCacheConstant {
    public static final String LOCK_USER_REGISTER_CACHE_KEY = "short-link:lock:user:register";

    public static final String USER_LOGIN_TOKEN_CACHE_KEY_PREFIX = "short-link:user:login:";

    public static final Integer USER_LOGIN_TOKEN_CACHE_EXPIRE_TIME = 30;

    public static final TimeUnit USER_LOGIN_TOKEN_CACHE_TIME_UNIT = TimeUnit.DAYS;

}
