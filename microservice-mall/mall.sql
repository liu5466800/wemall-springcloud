/*
 Navicat Premium Data Transfer

 Source Server         : local_mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : microservice_system

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 01/07/2019 22:34:29 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `mall_address`
-- ----------------------------
DROP TABLE IF EXISTS `mall_address`;
CREATE TABLE `mall_address` (
  `address_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `district` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `door_number` decimal(19,2) DEFAULT NULL,
  `latitude` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `longitude` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `town` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `village` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地址';

-- ----------------------------
--  Table structure for `mall_category`
-- ----------------------------
DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category` (
  `category_id` bigint(64) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类别名称',
  `text` text CHARACTER SET utf8mb4 COMMENT '内容描述',
  `icon` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图标',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `order_number` int(11) DEFAULT NULL COMMENT '排序编码',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父级分类的ID',
  `description` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '内容描述',
  `delete_status` int(2) DEFAULT NULL COMMENT '创建日期',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`category_id`),
  KEY `parent_id` (`parent_id`),
  KEY `created` (`delete_status`)
) ENGINE=InnoDB AUTO_INCREMENT=250565864543233 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品类别';

-- ----------------------------
--  Table structure for `mall_member`
-- ----------------------------
DROP TABLE IF EXISTS `mall_member`;
CREATE TABLE `mall_member` (
  `member_id` bigint(20) NOT NULL,
  `member_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `birthday` bigint(20) DEFAULT NULL COMMENT '出生日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮件',
  `gender` int(2) DEFAULT NULL COMMENT '性别',
  `idcard` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
  `idcard_type` int(2) DEFAULT NULL COMMENT '证件类型',
  `mobile_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `openid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `qq` bigint(20) DEFAULT NULL,
  `real_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '真实姓名',
  `salt` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '盐值',
  `signature` int(11) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `delete_status` int(2) DEFAULT NULL COMMENT '删除标示',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商城用户';

-- ----------------------------
--  Table structure for `mall_order`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `orderid` bigint(20) NOT NULL,
  `order_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_code` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_money` decimal(20,0) DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单';

-- ----------------------------
--  Table structure for `mall_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_detail`;
CREATE TABLE `mall_order_detail` (
  `order_detail_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品明细ID',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `specification_id` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  `value_id` bigint(20) unsigned NOT NULL COMMENT '规格值ID',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `stock` decimal(11,0) DEFAULT '0' COMMENT '库存',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建日期',
  `unit` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `delete_status` int(2) NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `content_id` (`order_id`),
  KEY `spec_id` (`specification_id`),
  KEY `spec_value_id` (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品，规格，规格值，价格，库存关系';

-- ----------------------------
--  Table structure for `mall_product`
-- ----------------------------
DROP TABLE IF EXISTS `mall_product`;
CREATE TABLE `mall_product` (
  `title` text CHARACTER SET utf8mb4 COMMENT '标题',
  `text` longtext CHARACTER SET utf8mb4 COMMENT '内容',
  `summary` text CHARACTER SET utf8mb4 COMMENT '摘要',
  `thumbnail` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '缩略图',
  `parent_id` bigint(20) unsigned DEFAULT NULL COMMENT '父级ID',
  `buy_price` decimal(10,0) DEFAULT NULL,
  `status` int(10) DEFAULT '1' COMMENT '状态',
  `saleprice` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `remarks` text CHARACTER SET utf8mb4 COMMENT '备注信息',
  `product_id` decimal(19,2) NOT NULL,
  `category_id` decimal(19,2) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `product_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  KEY `parent_id` (`parent_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品内容';

-- ----------------------------
--  Table structure for `mall_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `mall_product_detail`;
CREATE TABLE `mall_product_detail` (
  `product_detail_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品明细ID',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `specification_id` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  `value_id` bigint(20) unsigned NOT NULL COMMENT '规格值ID',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `stock` decimal(11,0) DEFAULT '0' COMMENT '库存',
  `unit` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`product_detail_id`),
  KEY `content_id` (`product_id`),
  KEY `spec_id` (`specification_id`),
  KEY `spec_value_id` (`value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品，规格，规格值，价格，库存关系';

-- ----------------------------
--  Table structure for `mall_specification`
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification`;
CREATE TABLE `mall_specification` (
  `specification_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `specification_name` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '规格名称',
  `order_number` int(11) DEFAULT NULL COMMENT '排序编码',
  `remarks` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8mb4 DEFAULT 'normal' COMMENT '状态',
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建日期',
  `delete_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`specification_id`),
  KEY `status` (`status`),
  KEY `created` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格';

-- ----------------------------
--  Table structure for `mall_specification_value`
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification_value`;
CREATE TABLE `mall_specification_value` (
  `value_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `specification_id` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  `value` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '规格值',
  `unit` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '单位',
  `status` varchar(32) CHARACTER SET utf8mb4 DEFAULT 'normal' COMMENT '状态',
  `delete_status` int(2) DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL,
  `sort_number` int(10) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`value_id`),
  KEY `spec_id` (`specification_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格值';

-- ----------------------------
--  Table structure for `mall_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_address`;
CREATE TABLE `mall_user_address` (
  `user_address_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `address_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户地址关系';

SET FOREIGN_KEY_CHECKS = 1;
