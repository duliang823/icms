/*
Navicat MySQL Data Transfer

Source Server         : dl
Source Server Version : 50022
Source Host           : localhost:60823
Source Database       : icms

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-05-19 16:19:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL auto_increment,
  `detail` text,
  `imageurl` varchar(256) default NULL,
  `price` float(10,2) default NULL,
  `collectionnum` int(10) default '0',
  `sort` varchar(10) default NULL,
  `storename` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `sort` (`sort`),
  KEY `storename` (`storename`),
  CONSTRAINT `sort` FOREIGN KEY (`sort`) REFERENCES `goodssort` (`sortname`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `storename` FOREIGN KEY (`storename`) REFERENCES `store` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '蓝月亮洗衣液家庭装套装 薰衣草亮白手洗专用补充装特价批发 杜', './img/img_business/goodsImg/goodsimg1.jpg', '19.90', '2', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('2', '蓝月亮 亮白增艳洗衣液（自然清香）3kg/瓶 杜', './img/img_business/goodsImg/goodsimg2.jpg', '39.90', '0', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('3', '清扬(CLEAR)男士洗发水套装 清爽控油型750mlx2送活力运动薄荷 杜', './img/img_business/goodsImg/goodsimg3.jpg', '99.90', '2', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('4', '清扬(CLEAR)男士洗发露 活力运动薄荷型(去屑+清爽)500ml(洗发水) 杜', './img/img_business/goodsImg/goodsimg4.jpg', '35.90', '0', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('5', '海飞丝去屑护肤洗发水清爽去油型750ml（男女通用 洗发露 新老包 杜', './img/img_business/goodsImg/goodsimg5.jpg', '56.80', '0', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('6', '潘婷去屑洗发水丝质顺滑750ml（洗发露 新老包装随机发送）  杜', './img/img_business/goodsImg/goodsimg6.jpg', '40.80', '0', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('7', '海飞丝男士洗发露净爽控油去屑型730ml（护肤洗发水 头发护理 深层清洁） 杜', './img/img_business/goodsImg/goodsimg7.jpg', '86.90', '0', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('8', '飘柔洗发水人参滋养750ml（洗头膏 洗发露）  杜', './img/img_business/goodsImg/goodsimg8.jpg', '60.90', '0', '生活用品', '永辉超市');
INSERT INTO `goods` VALUES ('9', '拉芳（lovefun）家庭优惠装（1L去屑养护洗发露+900g怡神舒缓沐浴露） 杜', './img/img_business/goodsImg/goodsimg9.jpg', '49.00', '1', '生活用品', '永辉超市');

-- ----------------------------
-- Table structure for goodscollect
-- ----------------------------
DROP TABLE IF EXISTS `goodscollect`;
CREATE TABLE `goodscollect` (
  `id` int(64) NOT NULL auto_increment,
  `userid` int(10) default NULL,
  `goodsid` int(10) default NULL,
  PRIMARY KEY  (`id`),
  KEY `userid` (`userid`),
  KEY `goodsid` (`goodsid`),
  CONSTRAINT `goodsid` FOREIGN KEY (`goodsid`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodscollect
-- ----------------------------
INSERT INTO `goodscollect` VALUES ('69', '3', '1');
INSERT INTO `goodscollect` VALUES ('70', '3', '3');
INSERT INTO `goodscollect` VALUES ('80', '1', '1');
INSERT INTO `goodscollect` VALUES ('82', '1', '9');
INSERT INTO `goodscollect` VALUES ('84', '1', '3');

-- ----------------------------
-- Table structure for goodssort
-- ----------------------------
DROP TABLE IF EXISTS `goodssort`;
CREATE TABLE `goodssort` (
  `id` int(10) NOT NULL auto_increment,
  `sortname` varchar(10) default NULL,
  PRIMARY KEY  (`id`),
  KEY `sortname` (`sortname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodssort
-- ----------------------------
INSERT INTO `goodssort` VALUES ('1', '生活用品');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(15) default NULL,
  `phone` varchar(15) default NULL,
  `address` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '永辉超市', '1235647', '崇文路2号');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(32) NOT NULL auto_increment,
  `username` varchar(128) default NULL,
  `loginid` varchar(128) default NULL,
  `password` varchar(128) default NULL,
  `birthday` date default NULL,
  `blocknum` int(32) default NULL,
  `unitnum` int(32) default NULL,
  `housenum` int(32) default NULL,
  `administrator` int(2) default '0',
  `email` varchar(64) default NULL,
  `phonenumber` varchar(64) default NULL,
  `sex` varchar(10) default NULL,
  `age` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '杜亮666', '1', '123', null, '7', '3', '3', '1', 'gd@qq', '', '男', '7');
INSERT INTO `user_info` VALUES ('3', '杜亮3', '1234', '123456', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('4', '杜亮666', '1', '123456', null, '7', '3', '3', '0', 'gd@qq', '', '男', '7');
INSERT INTO `user_info` VALUES ('5', '杜亮5', '1234', '123456', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('6', '杜亮666', '1', '123456', null, '7', '3', '3', '0', 'gd@qq', '', '男', '7');
INSERT INTO `user_info` VALUES ('7', '杜亮7', '1234', '123456', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('10', '杜亮666', '1', '123456', null, '7', '3', '3', '0', 'gd@qq', '', '男', '7');
INSERT INTO `user_info` VALUES ('13', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('14', 'qaz', '1234', '123456}', null, null, '1', '3', '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('15', 'qazdfsdfsdf', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('16', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('17', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('18', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('19', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('20', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('21', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('22', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('23', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdflkjlklkj', '', '1234');
INSERT INTO `user_info` VALUES ('24', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('25', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('26', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('27', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('28', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('29', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('30', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('31', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
INSERT INTO `user_info` VALUES ('32', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdfbhjghjghj', '女', '1234');
INSERT INTO `user_info` VALUES ('33', 'qaz', '1234', '123456}', null, null, '1', null, '0', 'fsf@qq', 'sfsdf', '', '1234');
