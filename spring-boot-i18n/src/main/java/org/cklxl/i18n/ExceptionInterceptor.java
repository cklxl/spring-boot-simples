package org.cklxl.i18n;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理器
 * 
 * @author Kun.Chen
 * @date 2019-04-29 09:35:29
 */
@Slf4j
public class ExceptionInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("------------------------{}", "1");
        if (ex != null) {
            log.info("------------------------{}", "2");
            log.error(ex.getMessage(), ex);
        }
        log.info("------------------------{}", "3");
    }
}