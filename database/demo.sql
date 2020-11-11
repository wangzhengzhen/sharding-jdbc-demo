## 建库建表

create database engrz default character set utf8mb4 collate utf8mb4_general_ci;

use engrz;

CREATE TABLE `t_user_info` (
  `user_id` bigint NOT NULL COMMENT '主键',
  `login_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录名',
  `login_passwd` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录密码',
  `user_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名称',
  `mobile` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `status` char(2) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态，01(正常)/02(禁用)',
  `register_date` datetime NOT NULL COMMENT '注册时间',
  `last_login_date` datetime COMMENT '最后登录时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表';

create table t_user_info_0 like t_user_info;
create table t_user_info_1 like t_user_info;
create table t_user_info_2 like t_user_info;
create table t_user_info_3 like t_user_info;
create table t_user_info_4 like t_user_info;
create table t_user_info_5 like t_user_info;
create table t_user_info_6 like t_user_info;
create table t_user_info_7 like t_user_info;
create table t_user_info_8 like t_user_info;
create table t_user_info_9 like t_user_info;

CREATE TABLE `t_user_log` (
  `log_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_type` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志类型，01(普通日志)/02(重要日志)',
  `log_title` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '日志标题',
  `log_info` text COLLATE utf8mb4_unicode_ci COMMENT '日志信息',
  `log_date` datetime NOT NULL COMMENT '记录时间',
  PRIMARY KEY (`log_id`),
  KEY `index_log_date` (`log_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户日志表';

create table t_user_log_2019 like t_user_log;
create table t_user_log_2020 like t_user_log;
create table t_user_log_2021 like t_user_log;
