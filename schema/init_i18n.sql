-- ----------------------------------
-- Table structure for i18n_language
-- ----------------------------------
drop table if exists i18n_language;
create table i18n_language (
  `id`                           int(11)       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `locale_code`                  varchar(10)   NOT NULL COMMENT '语言类型',
  `locale_name`                  varchar(20)   NOT NULL COMMENT '语言简称',
   primary key (`id`),
   unique uk_locale_code (`locale_code`)
) comment '国际化语言';

-- ----------------------------------
-- Table structure for i18n_language_content
-- ----------------------------------
drop table if exists i18n_language_content;
create table i18n_language_content (
  `id`                           int(11)       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `locale_code`                  varchar(10)   NOT NULL COMMENT '国际化语言id',
  `biz_type`                     varchar(10)   NOT NULL COMMENT '业务模块类型',
  `i18n_key`                     varchar(100)   NOT NULL COMMENT '编码值',
  `i18n_value`                   varchar(2000) NOT NULL COMMENT '显示值',
  `i18n_descr`                   varchar(200)  NOT NULL default '' COMMENT '描述',
   primary key (`id`),
   unique uk_locale_code_key (`locale_code`, `i18n_key`)
) comment '国际化语言内容';

truncate table i18n_language;
truncate table i18n_language_content;
insert into i18n_language(`locale_code`,`locale_name`) values('zh','中文');
insert into i18n_language_content(`locale_code`,`biz_type`,`i18n_key`,`i18n_value`) values
 ('zh','system','i18n.system.message.success','成功')
,('zh','system','i18n.system.message.fail','失败')
,('zh','system','i18n.system.message.nologin','未登录，请先登录')
;