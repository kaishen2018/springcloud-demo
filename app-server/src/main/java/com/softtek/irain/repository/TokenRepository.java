package com.softtek.irain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by kaishen on 07/09/2018.
 */
@Repository
public class TokenRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setKey(String key, String value) {
        ValueOperations<String, String > ops = redisTemplate.opsForValue();
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        return ops.get(key);
    }
}
