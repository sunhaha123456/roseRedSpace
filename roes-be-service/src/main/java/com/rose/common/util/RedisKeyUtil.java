package com.rose.common.util;

/**
 * 功能：生产redis key工具类
 * @author sunpeng
 * @date 2018
 */
public class RedisKeyUtil {
    public static String getRedisUserInfoKey(Object userId) {
        return "user_id_" + userId;
    }
}