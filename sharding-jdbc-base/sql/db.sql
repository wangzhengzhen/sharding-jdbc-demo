create database ds0;
create database ds1;

CREATE TABLE `ds0`.`t_user0` (
  `user_id` BIGINT NOT NULL,
  `user_name` VARCHAR(32) NULL COMMENT '用户姓名',
  `sex` CHAR(2) NULL COMMENT '性别',
  `pwd_plain` VARCHAR(32) NULL COMMENT '密码明文',
  `pwd_cipher` VARCHAR(32) NULL COMMENT '密码密文',
  `reg_date` DATE NULL COMMENT '注册时间',
  PRIMARY KEY (`user_id`))
COMMENT = '用户表';

create table ds0.t_user1 like ds0.t_user0;
create table ds1.t_user0 like ds0.t_user0;
create table ds1.t_user1 like ds0.t_user0;
