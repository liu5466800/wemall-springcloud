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

 Date: 01/07/2019 22:35:58 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `delete_status` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
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
  `delete_status` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`option_id`),
  KEY `option_key` (`option_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='配置参数信息';

-- ----------------------------
--  Records of `sys_option`
-- ----------------------------
BEGIN;
INSERT INTO `sys_option` VALUES ('2', 'alipay_appid', 'alipayid', null, null), ('3', 'autosave', 'alipay_appid,alipay_rsa_private_key,alipay_rsa_public_key,alipay_public_key,alipay_timeout_express', null, null), ('4', 'alipay_timeout_express', '10', null, null), ('5', 'alipay_rsa_private_key', 'shiyao', null, null), ('6', 'ucode', '360e50a748531a82b67ed669282341cc', null, null), ('7', 'alipay_rsa_public_key', 'gongyao', null, null), ('8', 'alipay_public_key', 'zhifubaogongyao', null, null), ('9', 'oauth2_facebook_appsecret', null, null, null), ('10', 'oauth2_wechat_appkey', 'wxb51514a2739c3e42', null, null), ('11', 'oauth2_weibo_appsecret', null, null, null), ('12', 'oauth2_twitter_appsecret', null, null, null), ('13', 'oauth2_qq_appsecret', null, null, null), ('14', 'oauth2_linkedin_appsecret', null, null, null), ('15', 'oauth2_linkedin_appkey', null, null, null), ('16', 'oauth2_github_appsecret', null, null, null), ('17', 'register_sms_valid_content', null, null, null), ('18', 'oauth2_github_appkey', null, null, null), ('19', 'oauth2_oschina_appsecret', null, null, null), ('20', 'register_email_valid_enable', null, null, null), ('21', 'register_email_valid_content', null, null, null), ('22', 'oauth2_weibo_appkey', null, null, null), ('23', 'oauth2_oschina_appkey', null, null, null), ('24', 'oauth2_facebook_appkey', null, null, null), ('25', 'oauth2_wechat_appsecret', '96449b80b25d005f68087416872bae3b', null, null), ('26', 'oauth2_qq_appkey', null, null, null), ('27', 'oauth2_twitter_appkey', null, null, null), ('28', 'register_sms_valid_enable', null, null, null), ('29', 'wechat_jsSign_enable', null, null, null), ('30', 'wechat_partner', '语味果业', null, null), ('31', 'wechat_paternerKey', null, null, null), ('32', 'wechat_appid', 'wx341e1ecdc00e388f', null, null), ('33', 'wechat_appsecret', '8d488da99b02d61899f76e3240328139', null, null), ('34', 'wechat_dkf_enter_key', null, null, null), ('35', 'wechat_search_mall_enable', null, null, null), ('36', 'wechat_token', 'jpress_mall_test', null, null), ('37', 'wechat_dkf_quit_key', null, null, null), ('38', 'wechat_transferDesc', null, null, null), ('39', 'wechat_search_mall_prefix', null, null, null), ('40', 'wechat_search_mall_count', null, null, null), ('41', 'attachment_must_audited', null, null, null), ('42', 'web_subtitle', null, null, null), ('43', 'attachment_image_must_compress', null, null, null), ('44', 'web_copyright', null, null, null), ('45', 'web_administrator_email', null, null, null), ('46', 'web_administrator_wechat_openid', null, null, null), ('47', 'web_icp_number', null, null, null), ('48', 'web_title', '语味果业', null, null), ('49', 'web_domain', 'http://172.20.10.2:8080', null, null), ('50', 'content_must_audited', null, null, null), ('51', 'web_administrator_phone', null, null, null), ('52', 'wechat_signature', 'dacf9774c61c1be80409301f24a7a3414a35c841', null, null), ('53', 'wechat_timestamp', '1521720638', null, null), ('54', 'wechat_nonceStr', '3c3cb269-50f2-4ae8-8b52-0f3de5c000d7', null, null), ('60', 'wechat_pay_spbill_create_ip', 'm.yuweiguoye.com', null, null), ('61', 'tencent_sms_APPID', '1400070735', null, null), ('62', 'tencent_sms_APPKEY', '38b1e95302833109287dc76a4006363f', null, null), ('63', 'wechat_pay_mchid', '1337083401', null, null), ('64', 'wechat_pay_mchsecret', 'yuweiguoye2018opentmallbanzhangA', null, null), ('65', 'share_title', '语味果业', null, null), ('66', 'share_desc', '健康生活从这里开始', null, null), ('67', 'share_img_url', 'https://m.yuweiguoye.com/attachment/logo/sharelogo.png', null, null), ('68', 'option_web_domain', 'm.yuweiguoye.com', null, null);
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
  `delete_status` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`organization_id`),
  KEY `FK9uj0q85um3yi8t3otqfprcnln` (`parent_id`),
  CONSTRAINT `FK9uj0q85um3yi8t3otqfprcnln` FOREIGN KEY (`parent_id`) REFERENCES `sys_organization` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='机构信息';

-- ----------------------------
--  Records of `sys_organization`
-- ----------------------------
BEGIN;
INSERT INTO `sys_organization` VALUES ('0', '0', '0', '根组织', '0', null, null, null), ('101', '101', '101', '分中心1', '0', '0', null, null), ('102', '', '102', '分中心2', '0', '0', null, null), ('101002', '', '101002', '人事部', '2', '101', null, null);
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
  `create_time` bigint(13) DEFAULT NULL,
  `group_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `home_address_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delete_status` int(2) DEFAULT NULL,
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
  `delete_status` int(2) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `post_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `post_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='岗位信息';

-- ----------------------------
--  Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` bigint(64) NOT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hide` int(11) DEFAULT NULL,
  `rank` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `parent_id` bigint(255) DEFAULT NULL,
  `resource_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `resource_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `resource_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资源信息';

-- ----------------------------
--  Records of `sys_resource`
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` VALUES ('101', null, '系统基础管理', 'fa-desktop', null, '1', null, 'system', '系统管理', 'system', '0', null), ('102', null, '业务管理', 'large_chart', null, '1', null, 'business', '业务管理', 'business', '0', null), ('103', null, '系统监控管理', 'fa-tag', null, '16', null, 'monitor', '系统监控管理', 'monitor', '0', null), ('104', null, null, 'fa-desktop', null, '21', null, 'log', '日志管理', 'log', '1', null), ('101001', null, null, 'fa-desktop', null, '2', null, 'system:user:listUI', '用户管理', 'system/user/listUI.shtml', '1', null), ('101002', null, '组管理', 'fa-list', null, '7', null, 'system:role:listUI', '角色管理', 'system/role/rolelistUI.shtml', '1', null), ('101003', null, '菜单管理', 'fa-list-alt', null, '12', null, 'system:resource:listUI', '菜单资源管理', 'system/resources/list.shtml', '1', null), ('102001', null, '合同管理', 'large_chart', null, null, null, 'business:contract:listUI', '合同管理', 'business/contract/listUI.shtml', '1', null), ('103001', null, '实时监控', 'fa-desktop', null, '17', null, 'monitor:realtime:listUI', '实时监控', 'monitor/realtime/listUI.shtml', '1', null), ('103002', null, '告警列表', 'fa-desktop', null, null, null, 'monitor:warn:listUI', '告警列表', 'monitor/warn/list.shtml', '1', null), ('104001', null, '用户登录记录', 'fa-desktop', null, '19', null, 'log:login:listUI', '登录日志管理', 'log/login/listUI.shtml', '1', null), ('104002', null, '操作日志管理', 'fa-picture-o', null, '20', null, 'log:operation:listUI', '操作日志管理', 'log/operation/listUI.shtml', '0', null), ('101001001', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '3', null, 'system:user:addUI', '新增用户', 'system/user/addUI.shtml', '2', null), ('101001002', null, '&lt;button type=&quot;button&quot; id=&quot;editUser&quot; class=&quot;btn btn-info marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '4', null, 'system:user:editUI', '修改用户', 'system/user/editUI.shtml', '2', null), ('101001003', null, '&lt;button type=&quot;button&quot; id=&quot;delUser&quot; class=&quot;btn btn-danger marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '5', null, 'system:user:delete', '用户删除', 'system/user/delete.shtml', '2', null), ('101001004', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;', 'fa-desktop', null, '6', null, 'system:user:authorization', '用户授权', 'system/user/authorization.shtml', '2', null), ('101001005', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '3', null, 'system:user:add', '用户新增', 'system/user/addUI.shtml', '2', null), ('101001006', null, null, null, null, null, null, 'system:user:edit', '用户编辑', null, null, null), ('101002001', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;addRole&quot;&nbsp;class=&quot;btn&nbsp;btn-primary&nbsp;marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '8', null, 'system:role:addUI', '新增角色', 'system/role/addUI.shtml', '2', null), ('101002002', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '9', null, 'system:role:editUI', '修改角色', 'system/role/editUI.shtml', '2', null), ('101002003', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '10', null, 'system:role:delete', '角色删除', 'system/role/delete.shtml', '2', null), ('101002004', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;permissions&quot;&nbsp;class=&quot;btn&nbsp;btn&nbsp;btn-grey&nbsp;marR10&quot;&gt;分配权限&lt;/button&gt;', 'fa-desktop', null, '11', null, 'system:role:authorization', '角色授权', 'system/role/authorization.shtml', '2', null), ('101002005', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delRole&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '10', null, 'system:role:add', '角色新增', 'system/role/delete.shtml', '2', null), ('101002006', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;editRole&quot;&nbsp;class=&quot;btn&nbsp;btn-info&nbsp;marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '9', null, 'system:role:edit', '角色修改', 'system/role/editUI.shtml', '2', null), ('101003001', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', null, 'system:resources:addUI', '新增菜单资源', 'system/resources/addUI.shtml', '2', null), ('101003002', null, '&lt;button type=&quot;button&quot; id=&quot;editResources&quot; class=&quot;btn btn-info marR10&quot;&gt;编辑&lt;/button&gt;', 'fa-desktop', null, '14', null, 'system:resource:editUI', '修改菜单资源', 'system/resources/editUI.shtml', '2', null), ('101003003', null, '&lt;button&nbsp;type=&quot;button&quot;&nbsp;id=&quot;delFun&quot;&nbsp;class=&quot;btn&nbsp;btn-danger&nbsp;marR10&quot;&gt;删除&lt;/button&gt;', 'fa-desktop', null, '15', null, 'system:resource:delete', '删除菜单资源', 'system/resource/delete.shtml', '2', null), ('101003004', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', null, 'system:resources:add', '菜单资源新增', 'system/resources/addUI.shtml', '2', null), ('101003005', null, '&lt;button type=&quot;button&quot; id=&quot;addResources&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, '13', null, 'system:resources:edit', '菜单资源编辑', 'system/resources/addUI.shtml', '2', null), ('102001001', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, null, 'business:contract:addUI', '新增合同', 'business/contract/addUI.shtml', '2', null), ('102001002', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, null, 'business:contract:editUI', '编辑合同', 'business/contract/addUI.shtml', '2', null), ('102001003', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, null, 'business:contract:delete', '合同删除', 'business/contract/addUI.shtml', '2', null), ('102001004', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, null, 'business:contract:add', '合同新增', 'business/contract/addUI.shtml', '2', null), ('102001005', null, '&lt;button type=&quot;button&quot; id=&quot;addUser&quot; class=&quot;btn btn-primary marR10&quot;&gt;新增&lt;/button&gt;', 'fa-desktop', null, null, null, 'business:contract:edit', '合同编辑', 'business/contract/addUI.shtml', '2', null);
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(64) NOT NULL,
  `delete_status` int(2) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `locked` int(2) DEFAULT NULL,
  `role_code` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`),
  KEY `index_role_rolename` (`role_name`),
  KEY `index_role_rolecode` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='岗位信息';

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '0', '0', '0', 'ADMIN', 'ADMIN', null), ('2', '0', '2', '0', 'NORMAL', 'NORMAL', null);
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
INSERT INTO `sys_role_resource` VALUES ('259625530728449', '101', '1'), ('259625530728450', '101001', '2');
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
  `create_time` bigint(13) DEFAULT NULL,
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
  `delete_status` int(2) DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('259625530728448', null, '18190767007', 'test1_nick', '$2a$10$XP7TNME251JiEIeVJAaKTO7Ka6aJ48rXZ4wkimdkeTOKRGfBtvYn2', 'zhangsan', '0', '1', '1546611602000'), ('259625868635136', null, '18190767007', 'test1_nick', '$2a$10$uVLTk6KI6Tshz2va9uU74eY0630JLjjSATJBkrZTeBWhOXYJK3aGO', 'zhangsan2', '0', '1', '1546611602000'), ('259625891326976', null, '18190767007', 'test1_nick', '$2a$10$Bw6Lad2aKa4.zjQLRf0NQ.PObCdH6/cFHCuQMinKcHUbmWFV0H5VK', 'zhangsan3', '0', '1', '1546611602000'), ('260392889939968', null, null, 'test1_u', 'test1_u', 'test1', '0', '1', '1546611602000'), ('64013692067905536', null, '1', 'wangyong', '111111', 'wangyong', '0', '0', '1546611602000'), ('64013692067905537', null, '1', '1', '111111', '1', '1', '0', '1546611602000');
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
--  Records of `sys_user_resource`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_resource` VALUES ('1', '101', '259625530728448');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_role_id` bigint(64) NOT NULL COMMENT '??????ID',
  `role_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  `user_id` bigint(64) DEFAULT NULL COMMENT '??ID',
  PRIMARY KEY (`user_role_id`),
  KEY `FKo4jryuw2ef7sb3vedhdwddp9x` (`role_id`),
  KEY `FKp53n1gguvrlo0fy8y0f7o7cx9` (`user_id`),
  CONSTRAINT `FKo4jryuw2ef7sb3vedhdwddp9x` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FKp53n1gguvrlo0fy8y0f7o7cx9` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色关系';

-- ----------------------------
--  Records of `sys_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('1', '1', '259625530728448'), ('2', '1', '259625868635136');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
