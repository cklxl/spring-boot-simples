package org.cklxl.i18n;

import org.cklxl.i18n.locale.util.I18nUtil;
import org.cklxl.i18n.locale.util.LocaleInterceptor;
import org.cklxl.i18n.locale.util.MyMessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Kun.Chen
 * @date 2019-04-09 14:16:13
 */
@SpringBootApplication
@MapperScan("org.cklxl.i18n.locale.mapper")
public class I18nApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(I18nApplication.class, args);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        return new MyMessageSource();
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Bean
    public I18nUtil i18nUtil() {
        I18nUtil i18nUtil = new I18nUtil();
        i18nUtil.setMessageSource(new MyMessageSource());
        return i18nUtil;
    }

    @Bean
    public LocaleInterceptor localeInterceptor() {
        return new LocaleInterceptor();
    }
    
    @Bean
    public ExceptionInterceptor exceptionInterceptor() {
        return new ExceptionInterceptor();
    }

    /**
     * 配置自己的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
        registry.addInterceptor(exceptionInterceptor());
    }
}
