/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : lab

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-10-19 20:59:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for asset
-- ----------------------------
DROP TABLE IF EXISTS `asset`;
CREATE TABLE `asset` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `asset_name` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `cate_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asset
-- ----------------------------
INSERT INTO `asset` VALUES ('1', '笔记本电脑', '联想Y-30', '6999.00', '1', '学习使用', '', '1', '2019-10-14 19:15:59', '2019-10-08 19:16:02', '1', '1');
INSERT INTO `asset` VALUES ('2', 'A4纸', '联想', null, null, '学习使用', null, null, '2019-10-18 20:37:35', null, '1', null);
INSERT INTO `asset` VALUES ('3', 'typec数据线', null, null, null, '学习使用', null, null, null, null, '1', null);
INSERT INTO `asset` VALUES ('4', '插座', null, null, null, '学习使用', null, null, null, null, '2', null);
INSERT INTO `asset` VALUES ('5', '打印机', null, null, null, null, null, null, null, null, '3', null);
INSERT INTO `asset` VALUES ('6', '台灯', null, null, null, null, null, null, null, null, '4', null);
INSERT INTO `asset` VALUES ('7', '投影仪', null, null, null, null, null, null, null, null, '2', null);
INSERT INTO `asset` VALUES ('8', '鼠标', null, null, null, null, null, null, null, null, '4', null);
INSERT INTO `asset` VALUES ('9', '激光笔', null, null, null, null, null, null, null, null, '4', null);
INSERT INTO `asset` VALUES ('10', '黑板', null, null, null, null, null, null, null, null, '4', null);
INSERT INTO `asset` VALUES ('11', null, '联想', '0.00', null, null, null, null, '2019-10-15 15:31:17', null, '2', null);
INSERT INTO `asset` VALUES ('19', '宠物狗', '柯基', '1555.00', '1', '学习使用', '', '1', '2019-10-14 20:53:37', null, '3', '1');
INSERT INTO `asset` VALUES ('21', null, 'gggggggggg', '0.00', null, null, null, null, '2019-10-15 15:27:17', null, '3', null);
INSERT INTO `asset` VALUES ('22', '旺财', null, null, null, null, null, null, '2019-10-18 20:35:09', null, null, null);
INSERT INTO `asset` VALUES ('23', 'lv', null, '100.00', null, null, null, null, '2019-10-18 20:37:19', null, null, null);
INSERT INTO `asset` VALUES ('25', 'cat', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `asset` VALUES ('26', '狗狗', null, null, null, '学习使用', null, null, null, null, null, null);
INSERT INTO `asset` VALUES ('27', '狗狗', null, null, null, null, null, null, '2019-10-18 20:07:52', null, null, null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '办公用品');
INSERT INTO `category` VALUES ('2', '笔记本');
INSERT INTO `category` VALUES ('3', '电脑软件');
INSERT INTO `category` VALUES ('4', '电脑硬件');
INSERT INTO `category` VALUES ('5', '服务器');
INSERT INTO `category` VALUES ('6', '手机通信');
INSERT INTO `category` VALUES ('7', '数码产品');
INSERT INTO `category` VALUES ('8', '数码配件');
INSERT INTO `category` VALUES ('9', '拓展配件');
INSERT INTO `category` VALUES ('10', '网络设备');
INSERT INTO `category` VALUES ('11', '无线网络');

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `use_date` datetime DEFAULT NULL,
  `ret_date` datetime DEFAULT NULL,
  `is_return` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lend
-- ----------------------------

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `as_name` varchar(255) DEFAULT NULL,
  `need_time` varchar(255) DEFAULT NULL,
  `cost` float(255,0) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `people` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('1', '联想电脑', '2', '150', '不显示', '2019-10-15 17:21:38', '黎明', '13988884444', '显卡坏了');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `power` varchar(255) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root', '1', '2019-10-13 10:12:51', null, null, null);
INSERT INTO `user` VALUES ('2', 'admin', 'admin', '0', '2019-10-13 23:26:03', null, null, null);
INSERT INTO `user` VALUES ('3', 'custom', 'custom', '', null, null, null, null);
INSERT INTO `user` VALUES ('4', 'custom2', 'custom3', '1', '2019-10-14 15:45:44', null, '15363396666', null);
INSERT INTO `user` VALUES ('5', 'custom4', 'custom4', '1', '2019-10-14 15:46:38', '啊啊', '15363336666', null);
