package org.cklxl.i18n.locale.service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.cklxl.i18n.locale.mapper.I18nLanguageContentMapper;
import org.cklxl.i18n.locale.mapper.I18nLanguageMapper;
import org.cklxl.i18n.locale.model.I18nLanguage;
import org.cklxl.i18n.locale.model.I18nLanguageContent;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kun.Chen
 * @date 2019-04-29 09:13:43
 */
@Service
@Slf4j
public class I18nLanguageService {

    @Inject
    private I18nLanguageMapper langMapper;
    @Inject
    private I18nLanguageContentMapper langContentMapper;
    private Locale locale;

    /**
     * 根据key取描述值
     * 
     * @param key
     * @return
     */
    public String getI18nLanguageContent(String key) {
        I18nLanguage lang = new I18nLanguage();
        log.info("locale {}", locale.toString());
        lang.setLocaleCode(locale.getLanguage());
        I18nLanguage ilang = langMapper.selectOne(lang);
        I18nLanguageContent record = new I18nLanguageContent();
        record.setLocaleCode(ilang.getLocaleCode());
        record.setI18nKey(key);
        I18nLanguageContent content = langContentMapper.selectOne(record);
        return content.getI18nValue();
    }

    /**
     * 根据key取描述值
     * 
     * @param key
     * @return
     */
    public String getI18nLanguageContent(String key, String... parms) {
        String content = getI18nLanguageContent(key);
        int i = 0;
        for (String parm : parms) {
            content.replace("{" + (i++) + "}", parm);
        }
        return content;
    }

    /**
     * 获取全部
     * 
     * @return
     */
    public Map<String, Map<String, String>> getAllMessage() {
        final Map<String, Map<String, String>> messageResources = new HashMap<>();
        List<I18nLanguage> ilangList = langMapper.selectAll();
        ilangList.forEach(v -> {
            I18nLanguageContent record = new I18nLanguageContent();
            record.setLocaleCode(v.getLocaleCode());
            List<I18nLanguageContent> contentList = langContentMapper.select(record);
            Map<String, String> message = contentList.stream()
                    .collect(Collectors.toMap(I18nLanguageContent::getI18nKey, I18nLanguageContent::getI18nValue));
            messageResources.put(v.getLocaleCode(), message);
        });
        return messageResources;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
