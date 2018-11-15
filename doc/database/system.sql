/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : microservice_system

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-11-15 16:23:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientdetails
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
-- Records of clientdetails
-- ----------------------------
INSERT INTO `clientdetails` VALUES ('client', null, 'secret', 'app', 'authorization_code', 'http://localhost:8080/test', null, null, null, null, null);
INSERT INTO `clientdetails` VALUES ('segema1', null, 'segemasecret1', 'app', 'authorization_code', 'http://localhost:8080/index.html', null, null, null, null, null);

-- ----------------------------
-- Table structure for demo_personal
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
-- Records of demo_personal
-- ----------------------------

-- ----------------------------
-- Table structure for demo_role
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
-- Records of demo_role
-- ----------------------------

-- ----------------------------
-- Table structure for demo_user
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
-- Records of demo_user
-- ----------------------------

-- ----------------------------
-- Table structure for demo_user_personal
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
-- Records of demo_user_personal
-- ----------------------------

-- ----------------------------
-- Table structure for file_filecenter
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
-- Records of file_filecenter
-- ----------------------------
INSERT INTO `file_filecenter` VALUES ('1022739668321435648', '/Users/wangyong/Downloads/test/testfiles/1022739668321435648/index.html', '1', 'attachment', null, 'index.html', 'text/html', '1022739668321435648/index.html', '.html', '1177.00', null, '123');
INSERT INTO `file_filecenter` VALUES ('1022739668359184384', '/Users/wangyong/Downloads/test/testfiles/1022739668359184384/1.png', '2', 'attachment', null, '1.png', 'image/png', '1022739668359184384/1.png', '.png', '253003.00', null, null);
INSERT INTO `file_filecenter` VALUES ('1022743579384086528', '/Users/wangyong/Downloads/test/testfiles/1022743579384086528/index.html', '3', 'attachment', null, 'index.html', 'text/html', '1022743579384086528/index.html', '.html', '1177.00', null, '123');
INSERT INTO `file_filecenter` VALUES ('1022743579392475136', '/Users/wangyong/Downloads/test/testfiles/1022743579392475136/1.png', '4', 'attachment', null, '1.png', 'image/png', '1022743579392475136/1.png', '.png', '253003.00', null, null);

-- ----------------------------
-- Table structure for mall_address
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
-- Records of mall_address
-- ----------------------------

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `orderid` bigint(20) NOT NULL,
  `ordername` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  PRIMARY KEY (`productid`),
  KEY `parent_id` (`parentid`),
  KEY `created` (`createtime`),
  KEY `status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品内容';

-- ----------------------------
-- Records of mall_product
-- ----------------------------
INSERT INTO `mall_product` VALUES ('1', '1', '1', '1', null, null, null, null, '0', null, '0', '0.00', null, null);

-- ----------------------------
-- Table structure for mall_product_category
-- ----------------------------
DROP TABLE IF EXISTS `mall_product_category`;
CREATE TABLE `mall_product_category` (
  `categoryid` bigint(64) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `categoryname` varchar(255) DEFAULT NULL COMMENT '类别名称',
  `text` text COMMENT '内容描述',
  `icon` varchar(128) DEFAULT NULL COMMENT '图标',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `ordernumber` int(11) DEFAULT NULL COMMENT '排序编码',
  `parentid` bigint(20) unsigned DEFAULT NULL COMMENT '父级分类的ID',
  `description` varchar(256) DEFAULT NULL COMMENT '内容描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`categoryid`),
  KEY `parent_id` (`parentid`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=250565864543233 DEFAULT CHARSET=utf8mb4 COMMENT='商品类别';

-- ----------------------------
-- Records of mall_product_category
-- ----------------------------
INSERT INTO `mall_product_category` VALUES ('3', '大枣', '大枣', null, '0', '0', null, '', null);
INSERT INTO `mall_product_category` VALUES ('6', '黑枸杞', '黑枸杞', null, '0', '0', '5', null, null);
INSERT INTO `mall_product_category` VALUES ('250074376726528', '产品分类1', '分类1', null, '1', '0', null, '', null);
INSERT INTO `mall_product_category` VALUES ('250565812874240', '测试分类1', '测试分类1', null, '1', '0', null, '', null);
INSERT INTO `mall_product_category` VALUES ('250565864543232', '测试分类2', '测试分类2', null, '1', '0', null, '', null);

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
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productdetailid`),
  KEY `content_id` (`productid`),
  KEY `spec_id` (`specificationid`),
  KEY `spec_value_id` (`valueid`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='商品，规格，规格值，价格，库存关系表';

-- ----------------------------
-- Records of mall_product_detail
-- ----------------------------
INSERT INTO `mall_product_detail` VALUES ('1', '13', '4', '10004', '123.00', '111', '2018-01-25 22:36:35', null);
INSERT INTO `mall_product_detail` VALUES ('2', '14', '4', '10004', '123.00', '12', '2018-01-25 22:51:49', null);
INSERT INTO `mall_product_detail` VALUES ('3', '15', '4', '10004', '1.00', '200', '2018-06-05 22:24:49', null);
INSERT INTO `mall_product_detail` VALUES ('4', '16', '5', '10005', '23.00', '333', '2018-07-15 23:10:41', null);

-- ----------------------------
-- Table structure for mall_specification
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification`;
CREATE TABLE `mall_specification` (
  `specificationId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `specificationname` varchar(128) DEFAULT NULL COMMENT '规格名称',
  `ordernumber` int(11) DEFAULT NULL COMMENT '排序编码',
  `remarks` varchar(256) DEFAULT NULL COMMENT '备注',
  `status` varchar(32) DEFAULT 'normal' COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`specificationId`),
  KEY `status` (`status`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='商品规格表';

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
  `value` varchar(200) DEFAULT NULL COMMENT '规格值',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `ordernumber` int(11) DEFAULT NULL COMMENT '排序编码',
  `status` varchar(32) DEFAULT 'normal' COMMENT '状态',
  `createtime` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`valueid`),
  KEY `spec_id` (`specificationid`),
  KEY `status` (`status`),
  KEY `created` (`createtime`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8mb4 COMMENT='商品规格值表';

-- ----------------------------
-- Records of mall_specification_value
-- ----------------------------
INSERT INTO `mall_specification_value` VALUES ('10001', '1', '20', null, '1', 'delete', '2017-11-28 17:36:20', null);
INSERT INTO `mall_specification_value` VALUES ('10002', '2', '30', null, '2', 'delete', '2017-11-28 17:36:40', null);
INSERT INTO `mall_specification_value` VALUES ('10003', '3', '40', null, '3', 'delete', '2017-11-28 17:38:54', null);
INSERT INTO `mall_specification_value` VALUES ('10004', '4', '200', null, '1', 'normal', '2017-12-18 23:08:17', null);
INSERT INTO `mall_specification_value` VALUES ('10005', '5', '50', null, '2', 'normal', '2017-12-18 23:08:41', null);

-- ----------------------------
-- Table structure for mall_user
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
-- Records of mall_user
-- ----------------------------
INSERT INTO `mall_user` VALUES ('1', '1', '2018-09-27 16:19:15', '2018-09-27 16:19:04', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for mall_user_address
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
-- Records of mall_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------
INSERT INTO `oauth_access_token` VALUES ('b22a96826065f1d766a387dab5421c72', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000165368930387870737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F400000000000017400036170707874000662656172657274002434613732633633382D643131392D346263642D626163332D613930666136656231393761, '4fc22277cc4e335186985f7ed7511b9d', 'client', 'client', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000007704000000007871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B72656469726563745572697400124C6A6176612F6C616E672F537472696E673B4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0011787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000F4C001172657175657374506172616D657465727371007E000E4C000573636F706571007E00117870740006636C69656E74737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E000E7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C77080000001000000006740004636F646574000637584D6D797174000A6772616E745F74797065740012617574686F72697A6174696F6E5F636F646574000D726573706F6E73655F74797065740004636F646574000D636C69656E745F73656372657474000673656372657474000C72656469726563745F757269740014687474703A2F2F7777772E62616964752E636F6D740009636C69656E745F696471007E001478737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000174000361707078017371007E0027770C000000103F40000000000000787371007E00173F400000000000007708000000100000000078740014687474703A2F2F7777772E62616964752E636F6D707371007E0027770C000000103F40000000000000787371007E0027770C000000103F4000000000000171007E001E787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B000000007704000000007871007E0032737200486F72672E737072696E676672616D65776F726B2E73656375726974792E7765622E61757468656E7469636174696F6E2E57656241757468656E7469636174696F6E44657461696C7300000000000001A40200024C000D72656D6F74654164647265737371007E000F4C000973657373696F6E496471007E000F787074000F303A303A303A303A303A303A303A317070740006636C69656E74, null);

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `lastModifiedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
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
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('client', null, 'secret', 'app', 'authorization_code', 'http://localhost:8080/test', null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('segema1', null, 'segemasecret1', 'app', 'authorization_code', 'http://localhost:8080/index.html', null, null, null, null, null);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for sys_address
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
-- Records of sys_address
-- ----------------------------

-- ----------------------------
-- Table structure for sys_option
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
-- Records of sys_option
-- ----------------------------
INSERT INTO `sys_option` VALUES ('2', 'alipay_appid', 'alipayid');
INSERT INTO `sys_option` VALUES ('3', 'autosave', 'alipay_appid,alipay_rsa_private_key,alipay_rsa_public_key,alipay_public_key,alipay_timeout_express');
INSERT INTO `sys_option` VALUES ('4', 'alipay_timeout_express', '10');
INSERT INTO `sys_option` VALUES ('5', 'alipay_rsa_private_key', 'shiyao');
INSERT INTO `sys_option` VALUES ('6', 'ucode', '360e50a748531a82b67ed669282341cc');
INSERT INTO `sys_option` VALUES ('7', 'alipay_rsa_public_key', 'gongyao');
INSERT INTO `sys_option` VALUES ('8', 'alipay_public_key', 'zhifubaogongyao');
INSERT INTO `sys_option` VALUES ('9', 'oauth2_facebook_appsecret', null);
INSERT INTO `sys_option` VALUES ('10', 'oauth2_wechat_appkey', 'wxb51514a2739c3e42');
INSERT INTO `sys_option` VALUES ('11', 'oauth2_weibo_appsecret', null);
INSERT INTO `sys_option` VALUES ('12', 'oauth2_twitter_appsecret', null);
INSERT INTO `sys_option` VALUES ('13', 'oauth2_qq_appsecret', null);
INSERT INTO `sys_option` VALUES ('14', 'oauth2_linkedin_appsecret', null);
INSERT INTO `sys_option` VALUES ('15', 'oauth2_linkedin_appkey', null);
INSERT INTO `sys_option` VALUES ('16', 'oauth2_github_appsecret', null);
INSERT INTO `sys_option` VALUES ('17', 'register_sms_valid_content', null);
INSERT INTO `sys_option` VALUES ('18', 'oauth2_github_appkey', null);
INSERT INTO `sys_option` VALUES ('19', 'oauth2_oschina_appsecret', null);
INSERT INTO `sys_option` VALUES ('20', 'register_email_valid_enable', null);
INSERT INTO `sys_option` VALUES ('21', 'register_email_valid_content', null);
INSERT INTO `sys_option` VALUES ('22', 'oauth2_weibo_appkey', null);
INSERT INTO `sys_option` VALUES ('23', 'oauth2_oschina_appkey', null);
INSERT INTO `sys_option` VALUES ('24', 'oauth2_facebook_appkey', null);
INSERT INTO `sys_option` VALUES ('25', 'oauth2_wechat_appsecret', '96449b80b25d005f68087416872bae3b');
INSERT INTO `sys_option` VALUES ('26', 'oauth2_qq_appkey', null);
INSERT INTO `sys_option` VALUES ('27', 'oauth2_twitter_appkey', null);
INSERT INTO `sys_option` VALUES ('28', 'register_sms_valid_enable', null);
INSERT INTO `sys_option` VALUES ('29', 'wechat_jsSign_enable', null);
INSERT INTO `sys_option` VALUES ('30', 'wechat_partner', '语味果业');
INSERT INTO `sys_option` VALUES ('31', 'wechat_paternerKey', null);
INSERT INTO `sys_option` VALUES ('32', 'wechat_appid', 'wx341e1ecdc00e388f');
INSERT INTO `sys_option` VALUES ('33', 'wechat_appsecret', '8d488da99b02d61899f76e3240328139');
INSERT INTO `sys_option` VALUES ('34', 'wechat_dkf_enter_key', null);
INSERT INTO `sys_option` VALUES ('35', 'wechat_search_mall_enable', null);
INSERT INTO `sys_option` VALUES ('36', 'wechat_token', 'jpress_mall_test');
INSERT INTO `sys_option` VALUES ('37', 'wechat_dkf_quit_key', null);
INSERT INTO `sys_option` VALUES ('38', 'wechat_transferDesc', null);
INSERT INTO `sys_option` VALUES ('39', 'wechat_search_mall_prefix', null);
INSERT INTO `sys_option` VALUES ('40', 'wechat_search_mall_count', null);
INSERT INTO `sys_option` VALUES ('41', 'attachment_must_audited', null);
INSERT INTO `sys_option` VALUES ('42', 'web_subtitle', null);
INSERT INTO `sys_option` VALUES ('43', 'attachment_image_must_compress', null);
INSERT INTO `sys_option` VALUES ('44', 'web_copyright', null);
INSERT INTO `sys_option` VALUES ('45', 'web_administrator_email', null);
INSERT INTO `sys_option` VALUES ('46', 'web_administrator_wechat_openid', null);
INSERT INTO `sys_option` VALUES ('47', 'web_icp_number', null);
INSERT INTO `sys_option` VALUES ('48', 'web_title', '语味果业');
INSERT INTO `sys_option` VALUES ('49', 'web_domain', 'http://172.20.10.2:8080');
INSERT INTO `sys_option` VALUES ('50', 'content_must_audited', null);
INSERT INTO `sys_option` VALUES ('51', 'web_administrator_phone', null);
INSERT INTO `sys_option` VALUES ('52', 'wechat_signature', 'dacf9774c61c1be80409301f24a7a3414a35c841');
INSERT INTO `sys_option` VALUES ('53', 'wechat_timestamp', '1521720638');
INSERT INTO `sys_option` VALUES ('54', 'wechat_nonceStr', '3c3cb269-50f2-4ae8-8b52-0f3de5c000d7');
INSERT INTO `sys_option` VALUES ('60', 'wechat_pay_spbill_create_ip', 'm.yuweiguoye.com');
INSERT INTO `sys_option` VALUES ('61', 'tencent_sms_APPID', '1400070735');
INSERT INTO `sys_option` VALUES ('62', 'tencent_sms_APPKEY', '38b1e95302833109287dc76a4006363f');
INSERT INTO `sys_option` VALUES ('63', 'wechat_pay_mchid', '1337083401');
INSERT INTO `sys_option` VALUES ('64', 'wechat_pay_mchsecret', 'yuweiguoye2018opentmallbanzhangA');
INSERT INTO `sys_option` VALUES ('65', 'share_title', '语味果业');
INSERT INTO `sys_option` VALUES ('66', 'share_desc', '健康生活从这里开始');
INSERT INTO `sys_option` VALUES ('67', 'share_img_url', 'https://m.yuweiguoye.com/attachment/logo/sharelogo.png');
INSERT INTO `sys_option` VALUES ('68', 'option_web_domain', 'm.yuweiguoye.com');

-- ----------------------------
-- Table structure for sys_organization
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
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('0', '0', '0', '根组织', '0', null);
INSERT INTO `sys_organization` VALUES ('101', '101', '101', '分中心1', '0', '0');
INSERT INTO `sys_organization` VALUES ('102', '', '102', '分中心2', '0', '0');
INSERT INTO `sys_organization` VALUES ('101002', '', '101002', '人事部', '2', '101');

-- ----------------------------
-- Table structure for sys_organization_personal
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
-- Records of sys_organization_personal
-- ----------------------------

-- ----------------------------
-- Table structure for sys_personal
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
  PRIMARY KEY (`personal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='人员信息';

-- ----------------------------
-- Records of sys_personal
-- ----------------------------

-- ----------------------------
-- Table structure for sys_personal_organization
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
-- Records of sys_personal_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_post
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
-- Records of sys_post
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
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
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资源信息';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('101', null, '系统基础管理', 'fa-desktop', null, '1', '0', 'system', '系统管理', 'system', '0', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102', null, '业务管理', 'large_chart', null, '1', '0', 'business', '业务管理', 'business', '0', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('103', null, '系统监控管理', 'fa-tag', null, '16', '0', 'monitor', '系统监控管理', 'monitor', '0', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('104', null, null, 'fa-desktop', null, '21', '0', 'log', '日志管理', 'log', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001', null, null, 'fa-desktop', null, '2', '101', 'system:user:listUI', '用户管理', 'system/user/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002', null, '组管理', 'fa-list', null, '7', '101', 'system:role:listUI', '角色管理', 'system/role/rolelistUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101003', null, '菜单管理', 'fa-list-alt', null, '12', '101', 'system:resource:listUI', '菜单资源管理', 'system/resources/list.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102001', null, '合同管理', 'large_chart', null, null, '102', 'business:contract:listUI', '合同管理', 'business/contract/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('103001', null, '实时监控', 'fa-desktop', null, '17', '103', 'monitor:realtime:listUI', '实时监控', 'monitor/realtime/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('103002', null, '告警列表', 'fa-desktop', null, null, '103', 'monitor:warn:listUI', '告警列表', 'monitor/warn/list.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('104001', null, '用户登录记录', 'fa-desktop', null, '19', '104', 'log:login:listUI', '登录日志管理', 'log/login/listUI.shtml', '1', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('104002', null, '操作日志管理', 'fa-picture-o', null, '20', '104', 'log:operation:listUI', '操作日志管理', 'log/operation/listUI.shtml', '0', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001001', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '3', '101001', 'system:user:addUI', '新增用户', 'system/user/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001002', null, '&lt;button type=&quot;button&quot; id=&quot;editUser&quot; class=&quot;btn btn-info marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '4', '101001', 'system:user:editUI', '修改用户', 'system/user/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001003', null, '&lt;button type=&quot;button&quot; id=&quot;delUser&quot; class=&quot;btn btn-danger marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '5', '101002', 'system:user:delete', '用户删除', 'system/user/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001004', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;', 'fa-desktop', null, '6', '101001', 'system:user:authorization', '用户授权', 'system/user/authorization.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001005', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '3', '101001', 'system:user:add', '用户新增', 'system/user/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101001006', null, null, null, null, null, '101001', 'system:user:edit', '用户编辑', null, null, '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002001', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addRole&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '8', '101002', 'system:role:addUI', '新增角色', 'system/role/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002002', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '9', '101002', 'system:role:editUI', '修改角色', 'system/role/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002003', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '10', '101002', 'system:role:delete', '角色删除', 'system/role/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002004', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;', 'fa-desktop', null, '11', '101002', 'system:role:authorization', '角色授权', 'system/role/authorization.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002005', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '10', '101002', 'system:role:add', '角色新增', 'system/role/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101002006', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '9', '101002', 'system:role:edit', '角色修改', 'system/role/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101003001', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', '101003', 'system:resources:addUI', '新增菜单资源', 'system/resources/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101003002', null, '&lt;button type=&quot;button&quot; id=&quot;editResources&quot; class=&quot;btn btn-info marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '14', '101003', 'system:resource:editUI', '修改菜单资源', 'system/resources/editUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101003003', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delFun&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '15', '101003', 'system:resource:delete', '删除菜单资源', 'system/resource/delete.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101003004', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', '101003', 'system:resources:add', '菜单资源新增', 'system/resources/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('101003005', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', '101003', 'system:resources:edit', '菜单资源编辑', 'system/resources/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102001001', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:addUI', '新增合同', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102001002', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:editUI', '编辑合同', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102001003', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:delete', '合同删除', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102001004', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:add', '合同新增', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_resource` VALUES ('102001005', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, '102001', 'business:contract:edit', '合同编辑', 'business/contract/addUI.shtml', '2', '', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
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
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '0', '0', '0', 'ADMIN', 'ADMIN');
INSERT INTO `sys_role` VALUES ('2', '0', '2', '0', 'NORMAL', 'NORMAL');

-- ----------------------------
-- Table structure for sys_role_resource
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
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '101', '1');
INSERT INTO `sys_role_resource` VALUES ('2', '101001', '2');

-- ----------------------------
-- Table structure for sys_system
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
-- Records of sys_system
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
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
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('64013692067905536', null, '1', 'wangyong', '111111', 'wangyong', null, '0');
INSERT INTO `sys_user` VALUES ('64013692067905537', null, '1', '1', '111111', '1', null, '0');

-- ----------------------------
-- Table structure for sys_user_personal
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
-- Records of sys_user_personal
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_resource
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
-- Records of sys_user_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userrole_id` bigint(64) NOT NULL COMMENT '??????ID',
  `role_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  `user_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  PRIMARY KEY (`userrole_id`),
  KEY `FKo4jryuw2ef7sb3vedhdwddp9x` (`role_id`),
  KEY `FKp53n1gguvrlo0fy8y0f7o7cx9` (`user_id`),
  CONSTRAINT `FKo4jryuw2ef7sb3vedhdwddp9x` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FKp53n1gguvrlo0fy8y0f7o7cx9` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
