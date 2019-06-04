-- ----------------------------------
-- Table structure for sys_user
-- ----------------------------------
drop table if exists sys_user;
create table sys_user (
  `id`                           bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code`                         varchar(36)   NOT NULL COMMENT '用户编码',
  `name`                         varchar(50)   NOT NULL COMMENT '用户名',
  `password`                     varchar(20)   NOT NULL COMMENT '密码',
  `create_time`                  datetime      NOT NULL default current_timestamp comment '创建时间',
  `update_time`                  datetime          NULL default null on update current_timestamp comment '最后修改时间',
  `version`                      int(11)       NOT NULL default 0 comment '版本号',
  `enable`                       bit(1)        not null default b'1' comment '启用;1-是/0-否',
  `is_delete`                    bit(1)        not null default b'0' comment '删除;1-是/0-否',
   primary key (`id`),
   unique uk_sys_user_name (`name`)
) comment '系统用户';

-- ----------------------------------
-- Table structure for sys_menu
-- ----------------------------------
drop table if exists sys_menu;
create table sys_menu (
  `id`                           bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code`                         varchar(36)   NOT NULL COMMENT '菜单编码',
  `name`                         varchar(50)   NOT NULL COMMENT '菜单名称',
  `link`                         varchar(255)  NOT NULL COMMENT '菜单链接地址',
  `create_time`                  datetime      NOT NULL default current_timestamp comment '创建时间',
  `update_time`                  datetime          NULL default null on update current_timestamp comment '最后修改时间',
  `version`                      int(11)       NOT NULL default 0 comment '版本号',
  `enable`                       bit(1)        not null default b'1' comment '启用;1-是/0-否',
  `is_delete`                    bit(1)        not null default b'0' comment '删除;1-是/0-否',
   primary key (`id`),
   unique uk_sys_menu_code (`code`)
) comment '菜单';

-- ----------------------------------
-- Table structure for sys_log
-- ----------------------------------
drop table if exists sys_log;
create table sys_log (
  `id`                           bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `serial_no`                    varchar(36)   NOT NULL COMMENT '流水号',
  `oper_type`                    varchar(20)   NOT NULL COMMENT '操作类型',
  `oper_biz`                     varchar(50)   NOT NULL COMMENT '操作业务',
  `oper_content`                 varchar(255)  NOT NULL COMMENT '操作内容',
  `oper_user_id`                 bigint(20)    NOT NULL COMMENT '操作用户id',
  `oper_user_name`               varchar(50)   NOT NULL COMMENT '操作用户姓名',
  `oper_ip`                      varchar(50)   NOT NULL default '' COMMENT '操作ip',
  `oper_time`                    datetime      NOT NULL default current_timestamp comment '操作时间',
  `create_time`                  datetime      NOT NULL default current_timestamp comment '创建时间',
   primary key (`id`)
) comment '系统日志表';
