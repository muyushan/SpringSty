/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-14 19:27:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baselistitem
-- ----------------------------
DROP TABLE IF EXISTS `baselistitem`;
CREATE TABLE `baselistitem` (
  `ListID` int(11) NOT NULL AUTO_INCREMENT COMMENT '列表项Id',
  `TypeID` smallint(6) NOT NULL COMMENT '列表项类型Id',
  `ListValue` smallint(6) NOT NULL COMMENT '列表项值',
  `ListName` varchar(20) NOT NULL COMMENT '列表项显示内容',
  `ListSort` smallint(6) DEFAULT NULL COMMENT '列表项排序',
  `Creator` varchar(20) NOT NULL COMMENT '创建人',
  `CreatDate` datetime NOT NULL COMMENT '创建时间',
  `Modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `ModifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ListID`),
  UNIQUE KEY `ListValue_UNIQUE` (`TypeID`,`ListValue`) USING BTREE,
  KEY `TypeID` (`TypeID`,`ListName`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='字典选项信息表';

-- ----------------------------
-- Records of baselistitem
-- ----------------------------
INSERT INTO `baselistitem` VALUES ('3', '29', '1', '蓝莓', null, 'muys2', '2018-08-14 14:22:04', null, null);
INSERT INTO `baselistitem` VALUES ('4', '29', '2', '芒果', null, 'muys2', '2018-08-14 14:22:23', null, null);
INSERT INTO `baselistitem` VALUES ('5', '29', '3', '山楂', null, 'muys2', '2018-08-14 14:23:13', null, null);
INSERT INTO `baselistitem` VALUES ('6', '30', '1', '1.5大口', null, 'muys2', '2018-08-14 14:23:55', null, null);
INSERT INTO `baselistitem` VALUES ('7', '30', '2', '莲花', null, 'muys2', '2018-08-14 14:24:14', null, null);
INSERT INTO `baselistitem` VALUES ('8', '29', '4', '苹果', null, 'muys2', '2018-08-14 14:40:40', null, null);
INSERT INTO `baselistitem` VALUES ('9', '29', '5', '原味', null, 'muys2', '2018-08-14 14:41:34', null, null);
INSERT INTO `baselistitem` VALUES ('10', '29', '6', '水蜜桃', null, 'muys2', '2018-08-14 14:42:52', null, null);
INSERT INTO `baselistitem` VALUES ('11', '29', '7', '青柠', null, 'muys2', '2018-08-14 15:05:32', null, null);
INSERT INTO `baselistitem` VALUES ('12', '30', '3', '1.5把子', null, 'muys2', '2018-08-14 15:07:02', null, null);
INSERT INTO `baselistitem` VALUES ('13', '30', '4', '1.0把子', null, 'muys2', '2018-08-14 15:07:40', null, null);
INSERT INTO `baselistitem` VALUES ('14', '32', '1', '箱', null, 'muys2', '2018-08-14 15:08:38', null, null);
INSERT INTO `baselistitem` VALUES ('15', '32', '2', '件', null, 'muys2', '2018-08-14 15:09:12', null, null);
INSERT INTO `baselistitem` VALUES ('16', '32', '3', '支', null, 'muys2', '2018-08-14 15:10:16', null, null);
INSERT INTO `baselistitem` VALUES ('17', '32', '4', '个', null, 'muys2', '2018-08-14 15:10:56', null, null);
INSERT INTO `baselistitem` VALUES ('18', '32', '5', '瓶', null, 'muys2', '2018-08-14 15:11:23', null, null);

-- ----------------------------
-- Table structure for baselisttype
-- ----------------------------
DROP TABLE IF EXISTS `baselisttype`;
CREATE TABLE `baselisttype` (
  `TypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '列表项类型Id',
  `TypeName` varchar(8) NOT NULL COMMENT '列表项类型描述',
  `Enaled` tinyint(4) DEFAULT '1' COMMENT '是否有效',
  `Creator` varchar(20) NOT NULL COMMENT '创建人',
  `CreatDate` datetime NOT NULL COMMENT '创建时间',
  `Modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `ModifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='字典类型信息表';

-- ----------------------------
-- Records of baselisttype
-- ----------------------------
INSERT INTO `baselisttype` VALUES ('29', '口味', '1', 'muys2', '2018-08-14 14:16:48', null, null);
INSERT INTO `baselisttype` VALUES ('30', '包装规格', '1', 'muys2', '2018-08-14 14:17:27', 'muys2', '2018-08-14 14:17:47');
INSERT INTO `baselisttype` VALUES ('31', '包装类型', '1', 'muys2', '2018-08-14 14:17:41', null, null);
INSERT INTO `baselisttype` VALUES ('32', '包装单位', '1', 'muys2', '2018-08-14 14:18:22', null, null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email_phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `verificationCode` varchar(100) DEFAULT NULL,
  `statusCode` int(11) DEFAULT '0',
  `verificationLimitDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_phone_unique` (`email_phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'muyu@126.com', 'ddd', '68c0abd7-7026-4963-af57-66a88bfa3472', '3', '2017-01-18 11:25:14');
INSERT INTO `user` VALUES ('6', 'muys2', 'ddd', null, '3', null);
