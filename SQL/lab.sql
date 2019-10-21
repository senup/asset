/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : lab

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-10-21 17:46:55
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of asset
-- ----------------------------
INSERT INTO `asset` VALUES ('1', '电脑', '外星人', '9999.00', '1', '个人使用', '没有', '1', '2019-10-21 17:30:31', '2019-10-21 17:31:21', '1', '1');
INSERT INTO `asset` VALUES ('2', 'A4纸', '联想', '2.00', '1', '学习使用', '4', '2', '2019-10-18 20:37:35', '2019-10-04 17:11:16', '1', '2');
INSERT INTO `asset` VALUES ('3', 'typec数据线', '华为', '5.00', '2', '学习使用', '3', '3', '2019-10-21 17:12:37', '2019-10-04 17:11:16', '1', '1');
INSERT INTO `asset` VALUES ('4', '插座', '小米', '6.00', '3', '学习使用', null, '2', '2019-10-21 17:12:41', '2019-10-04 17:11:16', '2', '3');
INSERT INTO `asset` VALUES ('5', '打印机', '海思', '5.00', '45', null, null, '1', '2019-10-21 17:12:44', '2019-10-21 17:11:29', '3', '4');
INSERT INTO `asset` VALUES ('6', '台灯', '格力', '3.00', '6', null, null, '2', '2019-10-21 17:12:58', '2019-10-21 17:12:03', '4', '2');
INSERT INTO `asset` VALUES ('7', '投影仪', '啊', '5.00', '6', null, null, '3', '2019-10-21 17:13:02', '2019-10-21 17:12:07', '2', '4');
INSERT INTO `asset` VALUES ('8', '鼠标', ' 的', '6.00', '3', null, null, '2', '2019-10-21 17:13:05', '2019-10-21 17:12:11', '4', '5');
INSERT INTO `asset` VALUES ('9', '激光笔', null, '77.00', '2', null, null, '3', '2019-10-21 17:13:07', '2019-10-21 17:11:32', '4', '2');
INSERT INTO `asset` VALUES ('10', '黑板', '森', '7.00', '4', null, null, '1', '2019-10-21 17:13:10', '2019-10-21 17:12:14', '4', '4');
INSERT INTO `asset` VALUES ('19', '宠物狗', '柯基', '1555.00', '1', '学习使用', '', '1', '2019-10-14 20:53:37', '2019-10-21 17:12:17', '3', '1');
INSERT INTO `asset` VALUES ('22', '旺财', null, '7.00', '2', null, null, '1', '2019-10-18 20:35:09', '2019-10-21 17:12:20', '1', '4');
INSERT INTO `asset` VALUES ('23', 'lv', null, '100.00', '4', null, null, '3', '2019-10-18 20:37:19', '2019-10-21 17:12:24', '2', '2');
INSERT INTO `asset` VALUES ('25', 'cat', null, '7.00', '5', null, null, '2', '2019-10-21 17:13:14', '2019-10-21 17:12:26', '3', '4');
INSERT INTO `asset` VALUES ('26', '狗狗', null, '5.00', '3', '学习使用', null, '1', '2019-10-21 17:13:34', '2019-10-21 17:12:29', '1', '2');
INSERT INTO `asset` VALUES ('28', '笔记本电脑', '玩家国度', '6999.00', '1', '备注：个人使用', '无', '1', '2019-10-20 18:21:25', '2019-10-21 17:12:32', '1', '1');
INSERT INTO `asset` VALUES ('29', '邓生', 'a1', '9.90', '1', '无', '无', '0', '2019-10-20 20:24:48', '2019-10-08 19:16:02', '1', '1');
INSERT INTO `asset` VALUES ('30', '鼠标,笔记本电脑', '雷蛇,玩家国度', '199.00', '5', '大赛奖品,备注：个人使用', '无,无', '1', '2019-10-20 18:55:38', '2011-09-01 03:30:33', '1', '1');
INSERT INTO `asset` VALUES ('31', '笔记本电脑', ',玩家国度', '99.00', '1', ',备注：个人使用', ',无', '1', '2019-10-20 19:17:31', '2019-10-21 17:12:35', '2', '4');
INSERT INTO `asset` VALUES ('32', '邓盛林', '国产', '9.90', '1', '备注', '无', '0', '2019-10-20 20:07:09', '2019-10-08 19:16:02', '1', '2');
INSERT INTO `asset` VALUES ('33', '邓盛林', '国产', '9.90', '1', '备注', '无', '0', '2019-10-20 20:07:39', '2019-10-08 19:16:02', '1', '1');
INSERT INTO `asset` VALUES ('34', '吉他', '雅马哈FG830', '2500.00', '1', '大赛奖品', '暂无', '1', '2019-10-21 17:29:09', '2019-10-21 17:12:17', '1', '1');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

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
INSERT INTO `category` VALUES ('14', '哈哈');

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
-- Table structure for myuser
-- ----------------------------
DROP TABLE IF EXISTS `myuser`;
CREATE TABLE `myuser` (
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
-- Records of myuser
-- ----------------------------
INSERT INTO `myuser` VALUES ('1', 'root', 'root', '1', '2019-10-13 10:12:51', null, null, null);
INSERT INTO `myuser` VALUES ('2', 'admin', 'admin', '0', '2019-10-13 23:26:03', null, null, null);
INSERT INTO `myuser` VALUES ('3', 'custom', 'custom', '', null, null, null, null);
INSERT INTO `myuser` VALUES ('4', 'custom2', 'custom3', '1', '2019-10-14 15:45:44', null, '15363396666', null);
INSERT INTO `myuser` VALUES ('5', 'custom4', 'custom4', '1', '2019-10-14 15:46:38', '啊啊', '15363336666', null);

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
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_nickname` varchar(20) DEFAULT NULL,
  `user_phone_no` varchar(20) DEFAULT NULL,
  `user_gender` varchar(5) DEFAULT NULL,
  `user_mail` varchar(20) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_state` int(5) DEFAULT NULL,
  `user_is_administrator` int(5) DEFAULT NULL,
  `user_sort` varchar(20) DEFAULT NULL,
  `user_department` varchar(20) DEFAULT NULL,
  `user_privilege` varchar(20) DEFAULT NULL,
  `user_motto` varchar(50) DEFAULT NULL,
  `user_createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_hobby` varchar(20) DEFAULT NULL,
  `user_newpassword` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '邓11', '123', '一一一', '15994969293', '女', '956923045@qq.com', '1997-12-30', '1', '0', '未分类', '暂无部门', '暂无权限限制', '这是我的个性签名', '2019-10-14 23:49:15', '这是我的爱好描述', '456');
INSERT INTO `user` VALUES ('2', '邓11', '456', '一一一', '15994969293', '女', '956923045@qq.com', '1997-12-30', '1', '0', '未分类', '暂无部门', '暂无权限限制', '这是我的个性签名', '2019-10-19 14:32:56', '这是我的爱好描述', '123');
INSERT INTO `user` VALUES ('3', '邓33', '789', '三三三', '15959873211', '男', '25432465@qq.com', '1998-07-08', '1', '0', '未分类', '暂无部门', '暂无权限限制', '我的个性签名', '2019-10-15 00:14:27', '我的爱好', '456');
INSERT INTO `user` VALUES ('4', '邓44', '456', '四四四', '15646843134', '男', '68466@qq.com', null, null, null, null, null, null, null, '2019-10-15 00:13:40', null, null);
INSERT INTO `user` VALUES ('5', '邓55', '456', '五五五', '15994969293', '女', '956923045@qq.com', '1997-12-30', '1', null, '未分类', '暂无部门', '暂无权限限制', '这是我的个性签名', '2019-10-15 00:12:50', '这是我的爱好描述', '123');
INSERT INTO `user` VALUES ('6', '邓66', '1231564', '一一一', '15994969293', '女', '956923045@qq.com', '1997-12-30', '1', null, '未分类', '暂无部门', '暂无权限限制', '这是我的个性签名', '2019-10-15 20:13:44', '这是我的爱好描述', '123');
INSERT INTO `user` VALUES ('7', '邓66', '456', '一一一', '15994969293', '女', '956923045@qq.com', '1997-12-30', '1', null, '未分类', '暂无部门', '暂无权限限制', '这是我的个性签名', null, '这是我的爱好描述', '123');
