package com.haibo.future.web.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author:haibo.xiong
 * @date:2018/12/3
 * @description:
 */
@Component
public class JedisUtil {
    @Resource
    private JedisPool jedisPool;

    private Jedis getResource(){
        return jedisPool.getResource();
    }

    /**
     * 设置key，value
     * @param key
     * @param value
     * @return
     */
    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis = getResource();
        try {
            jedis.set(key,value);
            return value;
        }finally {
            jedis.close();
        }
    }

    /**
     * 设置超时时间
     * @param key
     * @param i
     */
    public void expire(byte[] key, int i) {
        Jedis jedis = getResource();
        try {
            jedis.expire(key,i);
        }finally {
            jedis.close();
        }
    }

    /**
     * 获取key的value
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
        Jedis jedis = getResource();
        try {
            byte[] value = jedis.get(key);
            return value;
        }finally {
            jedis.close();
        }
    }

    public void del(byte[] key) {
        Jedis jedis = getResource();
        try {
            jedis.del(key);
        }finally {
            jedis.close();
        }
    }

    public Set<byte[]> keys(String shiro_session_prefix) {
        Jedis jedis = getResource();
        try {
            return jedis.keys((shiro_session_prefix+"*").getBytes());
        }finally {
            jedis.close();
        }
    }
}
