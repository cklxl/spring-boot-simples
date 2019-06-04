package org.cklxl.console.log.config;

import org.cklxl.console.log.interceptor.OperLogInterceptor;
import org.cklxl.console.log.service.LogService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 操作日记bean自动加载
 * 
 * @author Kun.Chen
 * @date 2019-06-04 11:36:00
 */
@Slf4j
public class OperLogAutoConfig {

    @Bean
    @ConditionalOnMissingBean(LogService.class)
    public LogService logService() {
        log.info("loading ... bean logService");
        return new LogService();
    }
    
    @Bean
    @ConditionalOnBean(LogService.class)
    public OperLogInterceptor operLogInterceptor() {
        log.info("loading ... bean operLogInterceptor");
        return new OperLogInterceptor();
    }

}
