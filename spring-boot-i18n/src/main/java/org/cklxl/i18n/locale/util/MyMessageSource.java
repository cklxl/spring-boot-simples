package org.cklxl.i18n.locale.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.cklxl.i18n.locale.service.I18nLanguageService;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.CollectionUtils;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Kun.Chen
 * @date 2019-04-29 14:50:09
 */
@Slf4j
@Setter
public class MyMessageSource extends AbstractMessageSource implements ResourceLoaderAware {
    private I18nLanguageService messageResource;
    // cache resource
    private static final Map<String, Map<String, String>> LOCAL_CACHE = new ConcurrentHashMap<>(256);
    // default base name
    @SuppressWarnings("unused")
    private ResourceLoader resourceLoader;

    public MyMessageSource() {
    }

    @PostConstruct
    public void init() {
        log.debug("reload message");
        this.reload();
    }

    public void reload() {
        LOCAL_CACHE.clear();
        // clear cache while reload data.
        Map<String, Map<String, String>> messageMap = messageResource.getAllMessage();
        if (CollectionUtils.isEmpty(messageMap)) {
            return;
        }
        LOCAL_CACHE.putAll(messageMap);
    }

    private String checkFromCachedOrBundResource(String code, Locale locale) {
        String language = locale.getLanguage();
        log.info("language----{}----{}----{}", language, code, LOCAL_CACHE);
        Map<String, String> props = LOCAL_CACHE.get(language);
        if (null != props && props.containsKey(code)) {
            return props.get(code);
        } else {
            // check from parent message resource. and catch no such element exception.
            try {
                if (null != this.getParentMessageSource()) {
                    return this.getParentMessageSource().getMessage(code, null, locale);
                }
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
            return code;
        }
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        // first check from local cache, is none exists. then query from parent message
        // resource which load from bundle resrouces
        String msg = checkFromCachedOrBundResource(code, locale);
        MessageFormat messageFormat = new MessageFormat(msg, locale);
        return messageFormat;
    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        return checkFromCachedOrBundResource(code, locale);
    }

}
