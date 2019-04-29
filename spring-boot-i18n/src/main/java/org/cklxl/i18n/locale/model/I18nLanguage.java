package org.cklxl.i18n.locale.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "`i18n_language`")
public class I18nLanguage {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 语言类型
     */
    @Column(name = "`locale_code`")
    private String localeCode;

    /**
     * 语言简称
     */
    @Column(name = "`locale_name`")
    private String localeName;
}