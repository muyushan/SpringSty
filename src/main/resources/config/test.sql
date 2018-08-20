/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-20 20:03:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baselistitem
-- ----------------------------
DROP TABLE IF EXISTS `baselistitem`;
CREATE TABLE `baselistitem` (
  `ListID` int(11) NOT NULL AUTO_INCREMENT COMMENT '列表项Id',
  `TypeID` smallint(6) NOT NULL COMMENT '列表项类型Id',
  `ListValue` varchar(20) NOT NULL COMMENT '列表项值',
  `ListName` varchar(20) NOT NULL COMMENT '列表项显示内容',
  `ListSort` smallint(6) DEFAULT NULL COMMENT '列表项排序',
  `Creator` varchar(20) NOT NULL COMMENT '创建人',
  `CreatDate` datetime NOT NULL COMMENT '创建时间',
  `Modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `ModifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ListID`),
  UNIQUE KEY `ListValue_UNIQUE` (`TypeID`,`ListValue`) USING BTREE,
  KEY `TypeID` (`TypeID`,`ListName`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='字典选项信息表';

-- ----------------------------
-- Records of baselistitem
-- ----------------------------
INSERT INTO `baselistitem` VALUES ('24', '35', 'AAAA', '蓝莓', null, 'muys2', '2018-08-20 20:00:33', null, null);
INSERT INTO `baselistitem` VALUES ('25', '35', 'AAAB', '芒果', null, 'muys2', '2018-08-20 20:01:44', null, null);

-- ----------------------------
-- Table structure for baselisttype
-- ----------------------------
DROP TABLE IF EXISTS `baselisttype`;
CREATE TABLE `baselisttype` (
  `TypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '列表项类型Id',
  `TypeValue` varchar(4) NOT NULL,
  `TypeName` varchar(8) NOT NULL COMMENT '列表项类型描述',
  `Enaled` tinyint(4) DEFAULT '1' COMMENT '是否有效',
  `Creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CreatDate` datetime DEFAULT NULL COMMENT '创建时间',
  `Modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `ModifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='字典类型信息表';

-- ----------------------------
-- Records of baselisttype
-- ----------------------------
INSERT INTO `baselisttype` VALUES ('35', 'AA', '口味', '1', 'muys2', '2018-08-20 19:31:14', null, null);
INSERT INTO `baselisttype` VALUES ('36', 'AB', '规格', '1', 'muys2', '2018-08-20 19:31:41', null, null);
INSERT INTO `baselisttype` VALUES ('37', 'AC', '单位', '1', 'muys2', '2018-08-20 19:32:01', null, null);
INSERT INTO `baselisttype` VALUES ('38', 'AD', '包装规格', '1', 'muys2', '2018-08-20 19:32:26', null, null);
INSERT INTO `baselisttype` VALUES ('39', 'AE', '包装类型', '1', 'muys2', '2018-08-20 19:32:36', null, null);

-- ----------------------------
-- Table structure for customerinfo
-- ----------------------------
DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `CustomerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `CustomerCode` varchar(10) NOT NULL COMMENT '客户编码，系统生成',
  `CustomerName` varchar(30) NOT NULL COMMENT '客户名称',
  `CustomerZipCode` varchar(10) DEFAULT NULL COMMENT '客户邮编',
  `CustomerPhone` varchar(30) DEFAULT NULL COMMENT '客户联系电话',
  `CustomerEmail` varchar(30) DEFAULT NULL COMMENT '客户电子邮件地址',
  `CustomerAddress` varchar(30) DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`CustomerId`),
  UNIQUE KEY `CustomerCode` (`CustomerCode`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customerinfo
-- ----------------------------

-- ----------------------------
-- Table structure for productinfo
-- ----------------------------
DROP TABLE IF EXISTS `productinfo`;
CREATE TABLE `productinfo` (
  `ProductCode` varchar(20) NOT NULL COMMENT '商品编码',
  `ProductName` varchar(30) DEFAULT NULL COMMENT '商品名称',
  `ProductCategory` int(11) DEFAULT NULL COMMENT '商品类表',
  `HasBarCode` int(11) DEFAULT '0' COMMENT '是否有条码0：没有，1:有',
  `BarCode` varchar(20) DEFAULT NULL COMMENT '条码',
  `Unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `Weight` float DEFAULT '0' COMMENT '单位重量',
  `Volume` float DEFAULT '0' COMMENT '单位体积',
  PRIMARY KEY (`ProductCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productinfo
-- ----------------------------

-- ----------------------------
-- Table structure for storageproduct
-- ----------------------------
DROP TABLE IF EXISTS `storageproduct`;
CREATE TABLE `storageproduct` (
  `StorageProductId` int(11) NOT NULL AUTO_INCREMENT,
  `ProductCode` varchar(20) DEFAULT NULL,
  `PlaceholderQuantity` double DEFAULT '0',
  `Quantity` double DEFAULT '0',
  `Type` int(11) DEFAULT NULL COMMENT '库存类型：1:正常库存2：损耗库存',
  PRIMARY KEY (`StorageProductId`),
  UNIQUE KEY `StorageProduct_type` (`ProductCode`,`Type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storageproduct
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
