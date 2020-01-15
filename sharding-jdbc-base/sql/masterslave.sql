create database ds_master;
create database ds_slave0;
create database ds_slave1;

CREATE TABLE `ds_master`.`t_user` (
  `user_id` BIGINT NOT NULL,
  `user_name` VARCHAR(32) NULL COMMENT '用户姓名',
  `sex` CHAR(2) NULL COMMENT '性别',
  `pwd_plain` VARCHAR(32) NULL COMMENT '密码明文',
  `pwd_cipher` VARCHAR(32) NULL COMMENT '密码密文',
  `reg_date` DATE NULL COMMENT '注册时间',
  PRIMARY KEY (`user_id`))
COMMENT = '用户表';

