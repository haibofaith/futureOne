package com.haibo.future.web.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @author:haibo.xiong
 * @date:2018/12/3
 * @description:
 */
public class RedisCacheManager implements CacheManager {
    @Resource
    private RedisCache redisCache;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
