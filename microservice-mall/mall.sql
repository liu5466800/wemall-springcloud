/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : microservice_system

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-20 13:46:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_address
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
  PRIMARY KEY (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地址';

-- ----------------------------
-- Records of mall_address
-- ----------------------------

-- ----------------------------
-- Table structure for mall_category
-- ----------------------------
DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category` (
  `category_id` bigint(64) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_name` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类别名称',
  `text` text CHARACTER SET utf8mb4 COMMENT '内容描述',
  `icon` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图标',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `order_number` int(11) DEFAULT NULL COMMENT '排序编码',
  `parentid` bigint(20) unsigned DEFAULT NULL COMMENT '父级分类的ID',
  `description` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '内容描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`category_id`),
  KEY `parent_id` (`parentid`),
  KEY `created` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=250565864543233 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品类别';

-- ----------------------------
-- Records of mall_category
-- ----------------------------
INSERT INTO `mall_category` VALUES ('3', '大枣', '大枣', null, '0', '0', null, '', null);
INSERT INTO `mall_category` VALUES ('6', '黑枸杞', '黑枸杞', null, '0', '0', '5', null, null);
INSERT INTO `mall_category` VALUES ('250074376726528', '产品分类1', '分类1', null, '1', '0', null, '', null);
INSERT INTO `mall_category` VALUES ('250565812874240', '测试分类1', '测试分类1', null, '1', '0', null, '', null);
INSERT INTO `mall_category` VALUES ('250565864543232', '测试分类2', '测试分类2', null, '1', '0', null, '', null);

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `orderid` bigint(20) NOT NULL,
  `order_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单';

-- ----------------------------
-- Records of mall_order
-- ----------------------------

-- ----------------------------
-- Table structure for mall_product
-- ----------------------------
DROP TABLE IF EXISTS `mall_product`;
CREATE TABLE `mall_product` (
  `productid` bigint(15) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `productname` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '产品名称',
  `categoryid` bigint(15) DEFAULT NULL COMMENT '产品类别',
  `title` text CHARACTER SET utf8mb4 COMMENT '标题',
  `text` longtext CHARACTER SET utf8mb4 COMMENT '内容',
  `summary` text CHARACTER SET utf8mb4 COMMENT '摘要',
  `thumbnail` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '缩略图',
  `parentid` bigint(20) unsigned DEFAULT NULL COMMENT '父级内容ID',
  `ordernumber` int(11) unsigned DEFAULT '0' COMMENT '排序编号',
  `buyprice` decimal(10,0) DEFAULT NULL,
  `status` int(10) DEFAULT '1' COMMENT '状态',
  `saleprice` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `remarks` text CHARACTER SET utf8mb4 COMMENT '备注信息',
  `product_id` decimal(19,2) NOT NULL,
  `category_id` decimal(19,2) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `parent_id` decimal(19,2) DEFAULT NULL,
  `product_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `parent_id` (`parentid`),
  KEY `created` (`createtime`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品内容';

-- ----------------------------
-- Records of mall_product
-- ----------------------------
INSERT INTO `mall_product` VALUES ('1', '1', '1', '1', null, null, null, null, '0', null, '0', '0.00', null, null, '0.00', null, null, null, null);

-- ----------------------------
-- Table structure for mall_product_detail
-- ----------------------------
DROP TABLE IF EXISTS `mall_product_detail`;
CREATE TABLE `mall_product_detail` (
  `productdetailid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品明细ID',
  `productid` bigint(20) unsigned NOT NULL COMMENT '商品ID',
  `specificationid` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  `valueid` bigint(20) unsigned NOT NULL COMMENT '规格值ID',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `stock` decimal(11,0) DEFAULT '0' COMMENT '库存',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `unit` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `product_detail_id` decimal(19,2) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`productdetailid`),
  KEY `content_id` (`productid`),
  KEY `spec_id` (`specificationid`),
  KEY `spec_value_id` (`valueid`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品，规格，规格值，价格，库存关系';

-- ----------------------------
-- Records of mall_product_detail
-- ----------------------------
INSERT INTO `mall_product_detail` VALUES ('1', '13', '4', '10004', '123.00', '111', '2018-01-25 22:36:35', null, '0.00', null);
INSERT INTO `mall_product_detail` VALUES ('2', '14', '4', '10004', '123.00', '12', '2018-01-25 22:51:49', null, '0.00', null);
INSERT INTO `mall_product_detail` VALUES ('3', '15', '4', '10004', '1.00', '200', '2018-06-05 22:24:49', null, '0.00', null);
INSERT INTO `mall_product_detail` VALUES ('4', '16', '5', '10005', '23.00', '333', '2018-07-15 23:10:41', null, '0.00', null);

-- ----------------------------
-- Table structure for mall_specification
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification`;
CREATE TABLE `mall_specification` (
  `specification_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `specification_name` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '规格名称',
  `order_number` int(11) DEFAULT NULL COMMENT '排序编码',
  `remarks` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8mb4 DEFAULT 'normal' COMMENT '状态',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`specification_id`),
  KEY `status` (`status`),
  KEY `created` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格';

-- ----------------------------
-- Records of mall_specification
-- ----------------------------
INSERT INTO `mall_specification` VALUES ('1', '规格', '1001', '规格1', 'delete', '2017-11-28 17:21:33');
INSERT INTO `mall_specification` VALUES ('2', '库存', '1002', '库存1', 'delete', '2017-11-28 17:24:14');
INSERT INTO `mall_specification` VALUES ('3', '价格', '1003', '价格1', 'delete', '2017-11-28 17:38:33');
INSERT INTO `mall_specification` VALUES ('4', '规格', '0', null, 'normal', '2017-12-18 23:08:17');
INSERT INTO `mall_specification` VALUES ('5', '价格', '0', null, 'normal', '2017-12-18 23:08:41');

-- ----------------------------
-- Table structure for mall_specification_value
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification_value`;
CREATE TABLE `mall_specification_value` (
  `valueid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `specificationid` bigint(20) unsigned NOT NULL COMMENT '规格ID',
  `value` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '规格值',
  `unit` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '单位',
  `ordernumber` int(11) DEFAULT NULL COMMENT '排序编码',
  `status` varchar(32) CHARACTER SET utf8mb4 DEFAULT 'normal' COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `remarks` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `specification_id` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`valueid`),
  KEY `spec_id` (`specificationid`),
  KEY `status` (`status`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格值';

-- ----------------------------
-- Records of mall_specification_value
-- ----------------------------
INSERT INTO `mall_specification_value` VALUES ('10001', '1', '20', null, '1', 'delete', '2017-11-28 17:36:20', null, null, null, null);
INSERT INTO `mall_specification_value` VALUES ('10002', '2', '30', null, '2', 'delete', '2017-11-28 17:36:40', null, null, null, null);
INSERT INTO `mall_specification_value` VALUES ('10003', '3', '40', null, '3', 'delete', '2017-11-28 17:38:54', null, null, null, null);
INSERT INTO `mall_specification_value` VALUES ('10004', '4', '200', null, '1', 'normal', '2017-12-18 23:08:17', null, null, null, null);
INSERT INTO `mall_specification_value` VALUES ('10005', '5', '50', null, '2', 'normal', '2017-12-18 23:08:41', null, null, null, null);

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '邮件',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `idcard` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
  `idcard_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '证件类型',
  `mobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `openid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `qq` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `real_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '真实姓名',
  `salt` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `signature` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商城用户';

-- ----------------------------
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES ('1', null, '1', '2018-09-27 16:19:15', '2018-09-27 16:19:04', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for mall_user_address
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_address`;
CREATE TABLE `mall_user_address` (
  `user_address_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `address_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户地址关系';

-- ----------------------------
-- Records of mall_user_address
-- ----------------------------
