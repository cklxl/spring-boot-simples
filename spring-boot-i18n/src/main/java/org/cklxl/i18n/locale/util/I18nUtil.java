package org.cklxl.i18n.locale.util;

import java.util.Locale;

import lombok.Setter;

/**
 * @author Kun.Chen
 * @date 2019-04-29 09:33:16
 */
@Setter
public class I18nUtil {

    private MyMessageSource messageSource;

    private Locale locale;

    public String getMessage(String code) {
        String message = messageSource.getMessage(code, null, locale == null ? Locale.CHINESE : locale);
        messageSource.setUseCodeAsDefaultMessage(true);
        return message == null ? code : message;
    }

    public String getMessage(String code, Object[] obj) {
        String message = messageSource.getMessage(code, obj, locale == null ? Locale.CHINESE : locale);
        return message == null ? code : message;
    }

    public String getMessage(String code, Locale locale) {
        String message = messageSource.getMessage(code, null, locale);
        return message == null ? code : message;
    }

    public String getMessage(String code, Object[] obj, Locale locale) {
        String message = messageSource.getMessage(code, obj, locale);
        return message == null ? code : message;
    }
}
