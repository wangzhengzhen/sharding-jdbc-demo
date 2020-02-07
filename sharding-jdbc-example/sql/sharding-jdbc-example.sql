create database ds0;

CREATE TABLE `ds0`.`t_log` (
  `log_id` BIGINT NOT NULL COMMENT '日志id',
  `log_level` INT NOT NULL COMMENT '级别',
  `log_title` VARCHAR(32) NOT NULL COMMENT '标题',
  `log_content` VARCHAR(256) NULL COMMENT '日志内容',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  UNIQUE INDEX `log_id_UNIQUE` (`log_id` ASC) VISIBLE)
COMMENT = '系统日志表';

create table ds0.t_log_2016 like ds0.t_log;
create table ds0.t_log_2017 like ds0.t_log;
create table ds0.t_log_2018 like ds0.t_log;
create table ds0.t_log_2019 like ds0.t_log;
create table ds0.t_log_2020 like ds0.t_log;
