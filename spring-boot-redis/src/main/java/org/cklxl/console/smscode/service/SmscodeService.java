package org.cklxl.console.smscode.service;

import javax.inject.Inject;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SmscodeService {

    @Inject
    RedisTemplate<String, Object> redisTemplate;
    
    public void test() {
        
    }
}
