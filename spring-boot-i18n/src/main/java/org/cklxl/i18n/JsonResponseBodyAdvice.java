package org.cklxl.i18n;

import java.util.Map;

import javax.inject.Inject;

import org.cklxl.i18n.locale.util.I18nUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * 动态修改返回数据
 * 
 * @author Kun.Chen
 * @date 2019-04-29 15:16:29
 */
@Slf4j
@ControllerAdvice
public class JsonResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Inject
    private I18nUtil I18nUtil;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) { // 处理特殊路径，不需要做包装
        String url = request.getURI().getPath();
        log.info("url {}", url);
        try {
            Object result;
            if (body instanceof Map) {
                log.info("-------- {}", 111);
                result = body;
                ((Map) result).put("status", "测试");
                String value = (String) ((Map) result).get("msg");
                ((Map) result).put("msg", I18nUtil.getMessage(value, new Object[] { "求" }));
            } else {
                // TODO
                result = body;
            }
            log.info("response = {}", result);
            return result;
        } catch (Exception e) {
            log.warn(e.getMessage(), e);
        }
        return body;
    }
}
