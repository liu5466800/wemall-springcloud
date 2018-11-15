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

 Date: 11/15/2018 23:27:58 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `clientdetails`
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` varchar(128) NOT NULL,
  `resourceIds` varchar(256) DEFAULT NULL,
  `appSecret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `grantTypes` varchar(256) DEFAULT NULL,
  `redirectUrl` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` varchar(4096) DEFAULT NULL,
  `autoApproveScopes` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `clientdetails`
-- ----------------------------
BEGIN;
INSERT INTO `clientdetails` VALUES ('client', null, 'secret', 'app', 'authorization_code', 'http://localhost:8080/test', null, null, null, null, null), ('segema1', null, 'segemasecret1', 'app', 'authorization_code', 'http://localhost:8080/index.html', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `demo_personal`
-- ----------------------------
DROP TABLE IF EXISTS `demo_personal`;
CREATE TABLE `demo_personal` (
  `personalid` varchar(255) COLLATE utf8_bin NOT NULL,
  `bloodtype` decimal(19,2) DEFAULT NULL,
  `bornaddressid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `borntime` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `groupid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `height` decimal(19,2) DEFAULT NULL,
  `homeaddressid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `identitynumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobilenumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `personalname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `weight` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`personalid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `demo_role`
-- ----------------------------
DROP TABLE IF EXISTS `demo_role`;
CREATE TABLE `demo_role` (
  `roleid` varchar(255) COLLATE utf8_bin NOT NULL,
  `deletestatus` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `locked` int(11) DEFAULT NULL,
  `rolecode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `rolename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `demo_user`
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `userid` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `credentialssalt` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobilenumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `demo_user_personal`
-- ----------------------------
DROP TABLE IF EXISTS `demo_user_personal`;
CREATE TABLE `demo_user_personal` (
  `userpersonalid` varchar(255) COLLATE utf8_bin NOT NULL,
  `personalid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userpersonalid`),
  KEY `FK14tu7s2t7wnb63riro0xfh13o` (`personalid`),
  KEY `FKl3e0twurup924udvhw9h6hqhw` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `file_filecenter`
-- ----------------------------
DROP TABLE IF EXISTS `file_filecenter`;
CREATE TABLE `file_filecenter` (
  `fileid` bigint(64) NOT NULL COMMENT '文件ID',
  `absolutepath` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '绝对路径',
  `businessid` bigint(255) DEFAULT NULL COMMENT '业务ID',
  `businesscode` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '业务编码',
  `fiilecontent` blob COMMENT '文件内容',
  `filename` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文件名',
  `fiiletype` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '文件类型',
  `relativepath` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '相对路径',
  `suffix` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '后缀',
  `totalsize` decimal(19,2) DEFAULT NULL COMMENT '大小',
  `filecontent` longblob COMMENT '文件内容',
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='文件中心';

-- ----------------------------
--  Records of `file_filecenter`
-- ----------------------------
BEGIN;
INSERT INTO `file_filecenter` VALUES ('1022739668321435648', '/Users/wangyong/Downloads/test/testfiles/1022739668321435648/index.html', '1', 'attachment', null, 'index.html', 'text/html', '1022739668321435648/index.html', '.html', '1177.00', null, '123'), ('1022739668359184384', '/Users/wangyong/Downloads/test/testfiles/1022739668359184384/1.png', '2', 'attachment', null, '1.png', 'image/png', '1022739668359184384/1.png', '.png', '253003.00', null, null), ('1022743579384086528', '/Users/wangyong/Downloads/test/testfiles/1022743579384086528/index.html', '3', 'attachment', null, 'index.html', 'text/html', '1022743579384086528/index.html', '.html', '1177.00', null, '123'), ('1022743579392475136', '/Users/wangyong/Downloads/test/testfiles/1022743579392475136/1.png', '4', 'attachment', null, '1.png', 'image/png', '1022743579392475136/1.png', '.png', '253003.00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `mall_address`
-- ----------------------------
DROP TABLE IF EXISTS `mall_address`;
CREATE TABLE `mall_address` (
  `addressid` varchar(255) COLLATE utf8_bin NOT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `district` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `doornumber` decimal(19,2) DEFAULT NULL,
  `latitude` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `longitude` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `town` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `village` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`addressid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `mall_order`
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `orderid` bigint(20) NOT NULL,
  `ordername` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `mall_product`
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
  PRIMARY KEY (`productid`),
  KEY `parent_id` (`parentid`),
  KEY `created` (`createtime`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品内容';

-- ----------------------------
--  Records of `mall_product`
-- ----------------------------
BEGIN;
INSERT INTO `mall_product` VALUES ('1', '1', '1', '1', null, null, null, null, '0', null, '0', '0.00', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `mall_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `mall_product_category`;
CREATE TABLE `mall_product_category` (
  `categoryid` bigint(64) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `categoryname` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '类别名称',
  `text` text CHARACTER SET utf8mb4 COMMENT '内容描述',
  `icon` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '图标',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `ordernumber` int(11) DEFAULT NULL COMMENT '排序编码',
  `parentid` bigint(20) unsigned DEFAULT NULL COMMENT '父级分类的ID',
  `description` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '内容描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`categoryid`),
  KEY `parent_id` (`parentid`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=250565864543233 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品类别';

-- ----------------------------
--  Records of `mall_product_category`
-- ----------------------------
BEGIN;
INSERT INTO `mall_product_category` VALUES ('3', '大枣', '大枣', null, '0', '0', null, '', null), ('6', '黑枸杞', '黑枸杞', null, '0', '0', '5', null, null), ('250074376726528', '产品分类1', '分类1', null, '1', '0', null, '', null), ('250565812874240', '测试分类1', '测试分类1', null, '1', '0', null, '', null), ('250565864543232', '测试分类2', '测试分类2', null, '1', '0', null, '', null);
COMMIT;

-- ----------------------------
--  Table structure for `mall_product_detail`
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
  PRIMARY KEY (`productdetailid`),
  KEY `content_id` (`productid`),
  KEY `spec_id` (`specificationid`),
  KEY `spec_value_id` (`valueid`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品，规格，规格值，价格，库存关系表';

-- ----------------------------
--  Records of `mall_product_detail`
-- ----------------------------
BEGIN;
INSERT INTO `mall_product_detail` VALUES ('1', '13', '4', '10004', '123.00', '111', '2018-01-25 22:36:35', null), ('2', '14', '4', '10004', '123.00', '12', '2018-01-25 22:51:49', null), ('3', '15', '4', '10004', '1.00', '200', '2018-06-05 22:24:49', null), ('4', '16', '5', '10005', '23.00', '333', '2018-07-15 23:10:41', null);
COMMIT;

-- ----------------------------
--  Table structure for `mall_specification`
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification`;
CREATE TABLE `mall_specification` (
  `specificationId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `specificationname` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '规格名称',
  `ordernumber` int(11) DEFAULT NULL COMMENT '排序编码',
  `remarks` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `status` varchar(32) CHARACTER SET utf8mb4 DEFAULT 'normal' COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`specificationId`),
  KEY `status` (`status`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格表';

-- ----------------------------
--  Records of `mall_specification`
-- ----------------------------
BEGIN;
INSERT INTO `mall_specification` VALUES ('1', '规格', '1001', '规格1', 'delete', '2017-11-28 17:21:33'), ('2', '库存', '1002', '库存1', 'delete', '2017-11-28 17:24:14'), ('3', '价格', '1003', '价格1', 'delete', '2017-11-28 17:38:33'), ('4', '规格', '0', null, 'normal', '2017-12-18 23:08:17'), ('5', '价格', '0', null, 'normal', '2017-12-18 23:08:41');
COMMIT;

-- ----------------------------
--  Table structure for `mall_specification_value`
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
  PRIMARY KEY (`valueid`),
  KEY `spec_id` (`specificationid`),
  KEY `status` (`status`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品规格值表';

-- ----------------------------
--  Records of `mall_specification_value`
-- ----------------------------
BEGIN;
INSERT INTO `mall_specification_value` VALUES ('10001', '1', '20', null, '1', 'delete', '2017-11-28 17:36:20', null), ('10002', '2', '30', null, '2', 'delete', '2017-11-28 17:36:40', null), ('10003', '3', '40', null, '3', 'delete', '2017-11-28 17:38:54', null), ('10004', '4', '200', null, '1', 'normal', '2017-12-18 23:08:17', null), ('10005', '5', '50', null, '2', 'normal', '2017-12-18 23:08:41', null);
COMMIT;

-- ----------------------------
--  Table structure for `mall_user`
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `userid` bigint(20) NOT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `idcard` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `idcardtype` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `openid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `qq` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `realname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `signature` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `mall_user`
-- ----------------------------
BEGIN;
INSERT INTO `mall_user` VALUES ('1', '1', '2018-09-27 16:19:15', '2018-09-27 16:19:04', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `mall_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_address`;
CREATE TABLE `mall_user_address` (
  `useraddressid` varchar(255) COLLATE utf8_bin NOT NULL,
  `addressid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `created` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`useraddressid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) CHARACTER SET utf8 NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `oauth_access_token`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_access_token` VALUES ('b22a96826065f1d766a387dab5421c72', 0xaced0005737200436f72672e737072696e676672616d65776f726b2e73656375726974792e6f61757468322e636f6d6d6f6e2e44656661756c744f4175746832416363657373546f6b656e0cb29e361b24face0200064c00156164646974696f6e616c496e666f726d6174696f6e74000f4c6a6176612f7574696c2f4d61703b4c000a65787069726174696f6e7400104c6a6176612f7574696c2f446174653b4c000c72656672657368546f6b656e74003f4c6f72672f737072696e676672616d65776f726b2f73656375726974792f6f61757468322f636f6d6d6f6e2f4f417574683252656672657368546f6b656e3b4c000573636f706574000f4c6a6176612f7574696c2f5365743b4c0009746f6b656e547970657400124c6a6176612f6c616e672f537472696e673b4c000576616c756571007e000578707372001e6a6176612e7574696c2e436f6c6c656374696f6e7324456d7074794d6170593614855adce7d002000078707372000e6a6176612e7574696c2e44617465686a81014b5974190300007870770800000165368930387870737200256a6176612e7574696c2e436f6c6c656374696f6e7324556e6d6f6469666961626c65536574801d92d18f9b80550200007872002c6a6176612e7574696c2e436f6c6c656374696f6e7324556e6d6f6469666961626c65436f6c6c656374696f6e19420080cb5ef71e0200014c0001637400164c6a6176612f7574696c2f436f6c6c656374696f6e3b7870737200176a6176612e7574696c2e4c696e6b656448617368536574d86cd75a95dd2a1e020000787200116a6176612e7574696c2e48617368536574ba44859596b8b7340300007870770c000000103f400000000000017400036170707874000662656172657274002434613732633633382d643131392d346263642d626163332d613930666136656231393761, '4fc22277cc4e335186985f7ed7511b9d', 'client', 'client', 0xaced0005737200416f72672e737072696e676672616d65776f726b2e73656375726974792e6f61757468322e70726f76696465722e4f417574683241757468656e7469636174696f6ebd400b02166252130200024c000d73746f7265645265717565737474003c4c6f72672f737072696e676672616d65776f726b2f73656375726974792f6f61757468322f70726f76696465722f4f4175746832526571756573743b4c00127573657241757468656e7469636174696f6e7400324c6f72672f737072696e676672616d65776f726b2f73656375726974792f636f72652f41757468656e7469636174696f6e3b787200476f72672e737072696e676672616d65776f726b2e73656375726974792e61757468656e7469636174696f6e2e416273747261637441757468656e7469636174696f6e546f6b656ed3aa287e6e47640e0200035a000d61757468656e746963617465644c000b617574686f7269746965737400164c6a6176612f7574696c2f436f6c6c656374696f6e3b4c000764657461696c737400124c6a6176612f6c616e672f4f626a6563743b787000737200266a6176612e7574696c2e436f6c6c656374696f6e7324556e6d6f6469666961626c654c697374fc0f2531b5ec8e100200014c00046c6973747400104c6a6176612f7574696c2f4c6973743b7872002c6a6176612e7574696c2e436f6c6c656374696f6e7324556e6d6f6469666961626c65436f6c6c656374696f6e19420080cb5ef71e0200014c00016371007e00047870737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a657870000000007704000000007871007e000c707372003a6f72672e737072696e676672616d65776f726b2e73656375726974792e6f61757468322e70726f76696465722e4f41757468325265717565737400000000000000010200075a0008617070726f7665644c000b617574686f72697469657371007e00044c000a657874656e73696f6e7374000f4c6a6176612f7574696c2f4d61703b4c000b72656469726563745572697400124c6a6176612f6c616e672f537472696e673b4c00077265667265736874003b4c6f72672f737072696e676672616d65776f726b2f73656375726974792f6f61757468322f70726f76696465722f546f6b656e526571756573743b4c000b7265736f7572636549647374000f4c6a6176612f7574696c2f5365743b4c000d726573706f6e7365547970657371007e0011787200386f72672e737072696e676672616d65776f726b2e73656375726974792e6f61757468322e70726f76696465722e426173655265717565737436287a3ea37169bd0200034c0008636c69656e74496471007e000f4c001172657175657374506172616d657465727371007e000e4c000573636f706571007e00117870740006636c69656e74737200256a6176612e7574696c2e436f6c6c656374696f6e7324556e6d6f6469666961626c654d6170f1a5a8fe74f507420200014c00016d71007e000e7870737200116a6176612e7574696c2e486173684d61700507dac1c31660d103000246000a6c6f6164466163746f724900097468726573686f6c6478703f4000000000000c77080000001000000006740004636f646574000637584d6d797174000a6772616e745f74797065740012617574686f72697a6174696f6e5f636f646574000d726573706f6e73655f74797065740004636f646574000d636c69656e745f73656372657474000673656372657474000c72656469726563745f757269740014687474703a2f2f7777772e62616964752e636f6d740009636c69656e745f696471007e001478737200256a6176612e7574696c2e436f6c6c656374696f6e7324556e6d6f6469666961626c65536574801d92d18f9b80550200007871007e0009737200176a6176612e7574696c2e4c696e6b656448617368536574d86cd75a95dd2a1e020000787200116a6176612e7574696c2e48617368536574ba44859596b8b7340300007870770c000000103f4000000000000174000361707078017371007e0027770c000000103f40000000000000787371007e00173f400000000000007708000000100000000078740014687474703a2f2f7777772e62616964752e636f6d707371007e0027770c000000103f40000000000000787371007e0027770c000000103f4000000000000171007e001e787372004f6f72672e737072696e676672616d65776f726b2e73656375726974792e61757468656e7469636174696f6e2e557365726e616d6550617373776f726441757468656e7469636174696f6e546f6b656e00000000000001a40200024c000b63726564656e7469616c7371007e00054c00097072696e636970616c71007e00057871007e0003017371007e00077371007e000b000000007704000000007871007e0032737200486f72672e737072696e676672616d65776f726b2e73656375726974792e7765622e61757468656e7469636174696f6e2e57656241757468656e7469636174696f6e44657461696c7300000000000001a40200024c000d72656d6f74654164647265737371007e000f4c000973657373696f6e496471007e000f787074000f303a303a303a303a303a303a303a317070740006636c69656e74, null);
COMMIT;

-- ----------------------------
--  Table structure for `oauth_approvals`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `clientId` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `lastModifiedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(256) COLLATE utf8_bin NOT NULL,
  `resource_ids` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `client_secret` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `scope` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `authorized_grant_types` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `authorities` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) COLLATE utf8_bin DEFAULT NULL,
  `autoapprove` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `oauth_client_details`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('client1', null, '$2a$10$dYRcFip80f0jIKGzRGulFelK12036xWQKgajanfxT65QB4htsEXNK', 'app', 'authorization_code', 'http://localhost:8080/login', null, null, null, null, null), ('client2', null, '$2a$10$dYRcFip80f0jIKGzRGulFelK12036xWQKgajanfxT65QB4htsEXNK', 'app', 'authorization_code', 'http://localhost:8080/test', null, null, null, null, null), ('system', null, '$2a$10$dYRcFip80f0jIKGzRGulFelK12036xWQKgajanfxT65QB4htsEXNK', 'app', 'authorization_code', 'http://localhost:12000/login', null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `oauth_client_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) CHARACTER SET utf8 NOT NULL,
  `user_name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `client_id` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `sys_address`
-- ----------------------------
DROP TABLE IF EXISTS `sys_address`;
CREATE TABLE `sys_address` (
  `address_id` bigint(64) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地址信息';

-- ----------------------------
--  Table structure for `sys_option`
-- ----------------------------
DROP TABLE IF EXISTS `sys_option`;
CREATE TABLE `sys_option` (
  `option_id` bigint(20) NOT NULL,
  `option_key` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '配置KEY',
  `option_value` text CHARACTER SET utf8mb4 COMMENT '配置内容',
  PRIMARY KEY (`option_id`),
  KEY `option_key` (`option_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配置参数信息';

-- ----------------------------
--  Records of `sys_option`
-- ----------------------------
BEGIN;
INSERT INTO `sys_option` VALUES ('2', 'alipay_appid', 'alipayid'), ('3', 'autosave', 'alipay_appid,alipay_rsa_private_key,alipay_rsa_public_key,alipay_public_key,alipay_timeout_express'), ('4', 'alipay_timeout_express', '10'), ('5', 'alipay_rsa_private_key', 'shiyao'), ('6', 'ucode', '360e50a748531a82b67ed669282341cc'), ('7', 'alipay_rsa_public_key', 'gongyao'), ('8', 'alipay_public_key', 'zhifubaogongyao'), ('9', 'oauth2_facebook_appsecret', null), ('10', 'oauth2_wechat_appkey', 'wxb51514a2739c3e42'), ('11', 'oauth2_weibo_appsecret', null), ('12', 'oauth2_twitter_appsecret', null), ('13', 'oauth2_qq_appsecret', null), ('14', 'oauth2_linkedin_appsecret', null), ('15', 'oauth2_linkedin_appkey', null), ('16', 'oauth2_github_appsecret', null), ('17', 'register_sms_valid_content', null), ('18', 'oauth2_github_appkey', null), ('19', 'oauth2_oschina_appsecret', null), ('20', 'register_email_valid_enable', null), ('21', 'register_email_valid_content', null), ('22', 'oauth2_weibo_appkey', null), ('23', 'oauth2_oschina_appkey', null), ('24', 'oauth2_facebook_appkey', null), ('25', 'oauth2_wechat_appsecret', '96449b80b25d005f68087416872bae3b'), ('26', 'oauth2_qq_appkey', null), ('27', 'oauth2_twitter_appkey', null), ('28', 'register_sms_valid_enable', null), ('29', 'wechat_jsSign_enable', null), ('30', 'wechat_partner', '语味果业'), ('31', 'wechat_paternerKey', null), ('32', 'wechat_appid', 'wx341e1ecdc00e388f'), ('33', 'wechat_appsecret', '8d488da99b02d61899f76e3240328139'), ('34', 'wechat_dkf_enter_key', null), ('35', 'wechat_search_mall_enable', null), ('36', 'wechat_token', 'jpress_mall_test'), ('37', 'wechat_dkf_quit_key', null), ('38', 'wechat_transferDesc', null), ('39', 'wechat_search_mall_prefix', null), ('40', 'wechat_search_mall_count', null), ('41', 'attachment_must_audited', null), ('42', 'web_subtitle', null), ('43', 'attachment_image_must_compress', null), ('44', 'web_copyright', null), ('45', 'web_administrator_email', null), ('46', 'web_administrator_wechat_openid', null), ('47', 'web_icp_number', null), ('48', 'web_title', '语味果业'), ('49', 'web_domain', 'http://172.20.10.2:8080'), ('50', 'content_must_audited', null), ('51', 'web_administrator_phone', null), ('52', 'wechat_signature', 'dacf9774c61c1be80409301f24a7a3414a35c841'), ('53', 'wechat_timestamp', '1521720638'), ('54', 'wechat_nonceStr', '3c3cb269-50f2-4ae8-8b52-0f3de5c000d7'), ('60', 'wechat_pay_spbill_create_ip', 'm.yuweiguoye.com'), ('61', 'tencent_sms_APPID', '1400070735'), ('62', 'tencent_sms_APPKEY', '38b1e95302833109287dc76a4006363f'), ('63', 'wechat_pay_mchid', '1337083401'), ('64', 'wechat_pay_mchsecret', 'yuweiguoye2018opentmallbanzhangA'), ('65', 'share_title', '语味果业'), ('66', 'share_desc', '健康生活从这里开始'), ('67', 'share_img_url', 'https://m.yuweiguoye.com/attachment/logo/sharelogo.png'), ('68', 'option_web_domain', 'm.yuweiguoye.com');
COMMIT;

-- ----------------------------
--  Table structure for `sys_organization`
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `organization_id` bigint(64) NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `organization_code` bigint(64) DEFAULT NULL,
  `organization_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `parent_id` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`organization_id`),
  KEY `FK9uj0q85um3yi8t3otqfprcnln` (`parent_id`),
  CONSTRAINT `FK9uj0q85um3yi8t3otqfprcnln` FOREIGN KEY (`parent_id`) REFERENCES `sys_organization` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='机构信息';

-- ----------------------------
--  Records of `sys_organization`
-- ----------------------------
BEGIN;
INSERT INTO `sys_organization` VALUES ('0', '0', '0', '根组织', '0', null), ('101', '101', '101', '分中心1', '0', '0'), ('102', '', '102', '分中心2', '0', '0'), ('101002', '', '101002', '人事部', '2', '101');
COMMIT;

-- ----------------------------
--  Table structure for `sys_organization_personal`
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization_personal`;
CREATE TABLE `sys_organization_personal` (
  `organization_personal_id` bigint(64) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `organization_id` bigint(64) DEFAULT NULL,
  `personal_id` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`organization_personal_id`),
  KEY `FKsm8vjg8plgahasmy2acnvjtb3` (`organization_id`),
  KEY `FKbal23papu49hcmp4ypndnmdfm` (`personal_id`),
  CONSTRAINT `FKbal23papu49hcmp4ypndnmdfm` FOREIGN KEY (`personal_id`) REFERENCES `sys_personal` (`personal_id`),
  CONSTRAINT `FKsm8vjg8plgahasmy2acnvjtb3` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='机构人员关系';

-- ----------------------------
--  Table structure for `sys_personal`
-- ----------------------------
DROP TABLE IF EXISTS `sys_personal`;
CREATE TABLE `sys_personal` (
  `personal_id` bigint(64) NOT NULL,
  `blood_type` decimal(19,2) DEFAULT NULL,
  `bornaddress_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `borntime` tinyblob,
  `createtime` tinyblob,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `groupid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `height` decimal(19,2) DEFAULT NULL,
  `homeaddress_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `identity_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `personal_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `weight` decimal(19,2) DEFAULT NULL,
  `born_address_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `born_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `group_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `home_address_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`personal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='人员信息';

-- ----------------------------
--  Table structure for `sys_personal_organization`
-- ----------------------------
DROP TABLE IF EXISTS `sys_personal_organization`;
CREATE TABLE `sys_personal_organization` (
  `personal_organization_id` bigint(64) NOT NULL,
  `organization_id` bigint(64) DEFAULT NULL,
  `personal_id` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`personal_organization_id`),
  KEY `FKk4tk9so9b7ccgbgcv4an7ar88` (`organization_id`),
  KEY `FK4rn5e1fb520n26e3qljnd9spa` (`personal_id`),
  CONSTRAINT `FK4rn5e1fb520n26e3qljnd9spa` FOREIGN KEY (`personal_id`) REFERENCES `sys_personal` (`personal_id`),
  CONSTRAINT `FKk4tk9so9b7ccgbgcv4an7ar88` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='人员机构关系';

-- ----------------------------
--  Table structure for `sys_post`
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(64) NOT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `post_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `post_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='岗位信息';

-- ----------------------------
--  Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` bigint(64) NOT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hide` int(11) DEFAULT NULL,
  `rank` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parentid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `resource_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `resource_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `resource_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `clientid` varchar(255) COLLATE utf8_bin NOT NULL,
  `accesstokenvalidityseconds` int(11) DEFAULT NULL,
  `additionalinformation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `authorities` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `authorizedgranttypes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `autoapprovescopes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `clientsecret` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `refreshtokenvalidityseconds` int(11) DEFAULT NULL,
  `resourceids` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `scope` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `webserverredirecturi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资源信息';

-- ----------------------------
--  Records of `sys_resource`
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` VALUES ('101', null, '系统基础管理', 'fa-desktop', null, '1', '0', 'system', '系统管理', 'system', '0', '', null, null, null, null, null, null, null, null, null, null, null), ('102', null, '业务管理', 'large_chart', null, '1', '0', 'business', '业务管理', 'business', '0', '', null, null, null, null, null, null, null, null, null, null, null), ('103', null, '系统监控管理', 'fa-tag', null, '16', '0', 'monitor', '系统监控管理', 'monitor', '0', '', null, null, null, null, null, null, null, null, null, null, null), ('104', null, null, 'fa-desktop', null, '21', '0', 'log', '日志管理', 'log', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('101001', null, null, 'fa-desktop', null, '2', '101', 'system:user:listUI', '用户管理', 'system/user/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('101002', null, '组管理', 'fa-list', null, '7', '101', 'system:role:listUI', '角色管理', 'system/role/rolelistUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('101003', null, '菜单管理', 'fa-list-alt', null, '12', '101', 'system:resource:listUI', '菜单资源管理', 'system/resources/list.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('102001', null, '合同管理', 'large_chart', null, null, '102', 'business:contract:listUI', '合同管理', 'business/contract/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('103001', null, '实时监控', 'fa-desktop', null, '17', '103', 'monitor:realtime:listUI', '实时监控', 'monitor/realtime/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('103002', null, '告警列表', 'fa-desktop', null, null, '103', 'monitor:warn:listUI', '告警列表', 'monitor/warn/list.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('104001', null, '用户登录记录', 'fa-desktop', null, '19', '104', 'log:login:listUI', '登录日志管理', 'log/login/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null, null), ('104002', null, '操作日志管理', 'fa-picture-o', null, '20', '104', 'log:operation:listUI', '操作日志管理', 'log/operation/listUI.shtml', '0', '', null, null, null, null, null, null, null, null, null, null, null), ('101001001', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '3', '101001', 'system:user:addUI', '新增用户', 'system/user/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101001002', null, '&lt;button type=&quot;button&quot; id=&quot;editUser&quot; class=&quot;btn btn-info marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '4', '101001', 'system:user:editUI', '修改用户', 'system/user/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101001003', null, '&lt;button type=&quot;button&quot; id=&quot;delUser&quot; class=&quot;btn btn-danger marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '5', '101002', 'system:user:delete', '用户删除', 'system/user/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101001004', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;', 'fa-desktop', null, '6', '101001', 'system:user:authorization', '用户授权', 'system/user/authorization.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101001005', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '3', '101001', 'system:user:add', '用户新增', 'system/user/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101001006', null, null, null, null, null, '101001', 'system:user:edit', '用户编辑', null, null, '', null, null, null, null, null, null, null, null, null, null, null), ('101002001', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addRole&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '8', '101002', 'system:role:addUI', '新增角色', 'system/role/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101002002', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '9', '101002', 'system:role:editUI', '修改角色', 'system/role/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101002003', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '10', '101002', 'system:role:delete', '角色删除', 'system/role/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101002004', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;', 'fa-desktop', null, '11', '101002', 'system:role:authorization', '角色授权', 'system/role/authorization.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101002005', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '10', '101002', 'system:role:add', '角色新增', 'system/role/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101002006', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '9', '101002', 'system:role:edit', '角色修改', 'system/role/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101003001', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', '101003', 'system:resources:addUI', '新增菜单资源', 'system/resources/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101003002', null, '&lt;button type=&quot;button&quot; id=&quot;editResources&quot; class=&quot;btn btn-info marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '14', '101003', 'system:resource:editUI', '修改菜单资源', 'system/resources/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101003003', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delFun&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '15', '101003', 'system:resource:delete', '删除菜单资源', 'system/resource/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101003004', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', '101003', 'system:resources:add', '菜单资源新增', 'system/resources/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('101003005', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', '101003', 'system:resources:edit', '菜单资源编辑', 'system/resources/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('102001001', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:addUI', '新增合同', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('102001002', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:editUI', '编辑合同', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('102001003', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:delete', '合同删除', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('102001004', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:add', '合同新增', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null), ('102001005', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:edit', '合同编辑', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(64) NOT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `locked` int(11) DEFAULT NULL,
  `role_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `index_role_rolename` (`role_name`),
  KEY `index_role_rolecode` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='岗位信息';

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '0', '0', '0', 'ADMIN', 'ADMIN'), ('2', '0', '2', '0', 'NORMAL', 'NORMAL');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_resource_id` bigint(64) NOT NULL COMMENT '??????ID',
  `resource_id` bigint(64) DEFAULT NULL COMMENT ' ??ID',
  `role_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  PRIMARY KEY (`role_resource_id`),
  KEY `FKlquxtncq97x72r3dsbvlrpd4i` (`resource_id`),
  KEY `FKicubjaqbf5l8rqsdnrnkcc3xq` (`role_id`),
  CONSTRAINT `FKicubjaqbf5l8rqsdnrnkcc3xq` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FKlquxtncq97x72r3dsbvlrpd4i` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色资源关系';

-- ----------------------------
--  Records of `sys_role_resource`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_resource` VALUES ('1', '101', '1'), ('2', '101001', '2');
COMMIT;

-- ----------------------------
--  Table structure for `sys_system`
-- ----------------------------
DROP TABLE IF EXISTS `sys_system`;
CREATE TABLE `sys_system` (
  `system_id` bigint(64) NOT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `system_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `system_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='子系统信息';

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(64) NOT NULL,
  `credentials_salt` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nick_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('64013692067905536', null, '1', 'wangyong', '111111', 'wangyong', null, '0'), ('64013692067905537', null, '1', '1', '111111', '1', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_personal`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_personal`;
CREATE TABLE `sys_user_personal` (
  `user_personal_id` bigint(64) NOT NULL,
  `user_id` bigint(64) DEFAULT NULL,
  `personal_id` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`user_personal_id`),
  KEY `FKk845474wqogj2ofonev3l1h7r` (`user_id`),
  KEY `FKkf9fcj5u76cvjujj5we2ic5d2` (`personal_id`),
  CONSTRAINT `FKk845474wqogj2ofonev3l1h7r` FOREIGN KEY (`personal_id`) REFERENCES `sys_personal` (`personal_id`),
  CONSTRAINT `FKkf9fcj5u76cvjujj5we2ic5d2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户人员关系';

-- ----------------------------
--  Table structure for `sys_user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_resource`;
CREATE TABLE `sys_user_resource` (
  `user_resource_id` bigint(64) NOT NULL,
  `resource_id` bigint(64) DEFAULT NULL,
  `user_id` bigint(64) DEFAULT NULL,
  PRIMARY KEY (`user_resource_id`),
  KEY `FKi0ccsy3qnln6h86ik9m8j4f8f` (`resource_id`),
  KEY `FKblouye0rhfk45k1qjfv92b0rm` (`user_id`),
  CONSTRAINT `FKblouye0rhfk45k1qjfv92b0rm` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKi0ccsy3qnln6h86ik9m8j4f8f` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户资源关系';

-- ----------------------------
--  Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userrole_id` bigint(64) NOT NULL COMMENT '??????ID',
  `role_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  `user_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  `user_role_id` decimal(19,2) NOT NULL,
  PRIMARY KEY (`userrole_id`),
  KEY `FKo4jryuw2ef7sb3vedhdwddp9x` (`role_id`),
  KEY `FKp53n1gguvrlo0fy8y0f7o7cx9` (`user_id`),
  CONSTRAINT `FKo4jryuw2ef7sb3vedhdwddp9x` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FKp53n1gguvrlo0fy8y0f7o7cx9` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色关系';

SET FOREIGN_KEY_CHECKS = 1;
