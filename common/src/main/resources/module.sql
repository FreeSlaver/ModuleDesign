CREATE DATABASE IF NOT EXISTS db_vt DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE db_vt;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `phone` varchar(16) NOT NULL UNIQUE COMMENT '手机号',
  `email` varchar(64) UNIQUE COMMENT '邮箱',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  `real_name` varchar(16) COMMENT '真实姓名',
  `status` char(1) NOT NULL DEFAULT 'y' COMMENT '用户状态',
  `register_ip` int(10) NOT NULL COMMENT '注册ip',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `login_ip` int(10) NOT NULL COMMENT '最后一次登录ip',
  `login_time` datetime  NOT NULL COMMENT '最后一次登录时间',
	PRIMARY KEY (`id`),
	KEY (`phone`),
	KEY (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息表';


DROP TABLE IF EXISTS `t_user_auth`;
CREATE TABLE `t_user_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `identity` varchar(64) NOT NULL COMMENT '登录标示符（具体手机号，邮箱，wechat或者weibo的uid等）',
  `identity_type` varchar(16) NOT NULL COMMENT '登录标示符类型（用户名，手机登录，邮箱登录还是wechat，weibo等）',
  `credential` varchar(64) COMMENT '密码凭证（密码，wechat或者weibo的accessToken）',
	PRIMARY KEY (`id`),
	KEY `idx_user_id` (`user_id`),
	KEY `idx_identity_type` (`identity_type`),
	KEY `idx_identity` (`identity`)
	-- 联合索引要唯一 一个用户每种登录类型只能有一条记录 user_id,identity_type,identifier
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户认证表';
