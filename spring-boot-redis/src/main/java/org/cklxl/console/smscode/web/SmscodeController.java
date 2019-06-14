package org.cklxl.console.smscode.web;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 验证码失效规则：<br>
 * 1.获取验证码，存放redis记录失效时间为5分钟 <br>
 * 每天获取验证码次数上限为5次<br>
 * 2.验证验证码，redis中key值是否存在，如果存在校验值是否匹配，如果不存在校验验证失败<br>
 * 3.验证次数不得超过三次
 * </p>
 * 
 * @author Kun.Chen
 * @date 2019-06-14 10:35:26
 */
@Slf4j
@RestController
public class SmscodeController {

    @Inject
    private RedisTemplate<String, Object> redisTemplate;
    private static final String LOGIN_KEY = "_SMS_LOGIN";
    private static final String LOGIN_MAX_KEY = "_SMS_MAX_LOGIN";
    private static final String LOGIN_COUNT_KEY = "_SMS_LOGIN_ERR_COUNT";

    @GetMapping(path = "sendCode")
    public Boolean sendCode(String username) {
        Long maxCount = (Long) redisTemplate.opsForValue().get(username + LOGIN_MAX_KEY);
        if (maxCount != null && maxCount >= 5) {
            log.error("当天获取短信次数过多");
            return Boolean.FALSE;
        }
        // 设置当天获取次数
        maxCount = redisTemplate.opsForValue().increment(username + LOGIN_MAX_KEY, 1);
        if (maxCount == 1) {
            // 设置失效时间
            Date now = new Date();
            Date secondDay = DateUtils.addDays(DateUtils.truncate(now, Calendar.DAY_OF_MONTH), 1);
            long expireTime = (secondDay.getTime() - now.getTime()) / 1000L;
            log.info("expireTime-{}", expireTime);
            redisTemplate.expire(username + LOGIN_MAX_KEY, expireTime, TimeUnit.SECONDS);
        }
        String code = getRandomNum(6);
        redisTemplate.opsForValue().set(username + LOGIN_KEY, code, 300, TimeUnit.SECONDS);
        // 重置验证次数
        redisTemplate.delete(username + LOGIN_COUNT_KEY);
        return Boolean.TRUE;
    }

    @GetMapping(path = "check")
    public String check(String username, String code) {
        String cacheCode = (String) redisTemplate.opsForValue().get(username + LOGIN_KEY);
        if (StringUtils.isBlank(cacheCode)) {
            return "验证码失效";
        }
        Integer count = (Integer) redisTemplate.opsForValue().get(username + LOGIN_COUNT_KEY);
        if (count != null && count > 3) {
            log.error("校验次数大于三次");
            redisTemplate.delete(username + LOGIN_KEY);
            redisTemplate.delete(username + LOGIN_COUNT_KEY);
            return "验证码失效";
        }
        if (!code.equals(cacheCode)) {
            // 验证失败设置失败次数
            redisTemplate.opsForValue().increment(username + LOGIN_COUNT_KEY, 1);
            redisTemplate.expire(username + LOGIN_COUNT_KEY, 300, TimeUnit.SECONDS);
            return "验证码错误";
        } else {
            // 验证成功移除验证
            redisTemplate.delete(username + LOGIN_MAX_KEY);// 如果是单一入口业务则成功移除否则不移除
            redisTemplate.delete(username + LOGIN_KEY);
            redisTemplate.delete(username + LOGIN_COUNT_KEY);
        }
        return "成功";
    }

    /**
     * 获取指定长度的随机数字符串
     * 
     * @param length 长度
     * @return
     */
    private String getRandomNum(int length) {
        String randomNum = "";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            randomNum += r.nextInt(9);
        }
        return randomNum;
    }

}
