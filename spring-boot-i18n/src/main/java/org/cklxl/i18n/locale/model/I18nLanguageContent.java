package org.cklxl.i18n.locale.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`i18n_language_content`")
public class I18nLanguageContent {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 国际化语言id
     */
    @Column(name = "`locale_code`")
    private String localeCode;

    /**
     * 业务模块类型
     */
    @Column(name = "`biz_type`")
    private String bizType;

    /**
     * 编码值
     */
    @Column(name = "`i18n_key`")
    private String i18nKey;

    /**
     * 显示值
     */
    @Column(name = "`i18n_value`")
    private String i18nValue;

    /**
     * 描述
     */
    @Column(name = "`i18n_descr`")
    private String i18nDescr;
}