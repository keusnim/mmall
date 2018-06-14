/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : shopdb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-12 09:58:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `item_name` varchar(30) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '商品名字',
  `price` float(30,1) NOT NULL COMMENT '商品价格',
  `item_type` int(10) NOT NULL COMMENT '商品类别id',
  `item_number` int(20) NOT NULL COMMENT '商品数量',
  `detail` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '商品描述',
  `createtime` datetime(6) DEFAULT NULL COMMENT '商品生产日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '笔', '1.0', '1', '75', null, null);
INSERT INTO `item` VALUES ('2', '桌子', '120.0', '1', '12', null, null);
INSERT INTO `item` VALUES ('3', '椅子', '30.0', '1', '10', null, null);
INSERT INTO `item` VALUES ('4', '篮球', '50.0', '2', '10', '', null);
INSERT INTO `item` VALUES ('5', '足球', '50.0', '2', '25', '', null);
INSERT INTO `item` VALUES ('6', '排球', '30.0', '2', '35', '', null);
INSERT INTO `item` VALUES ('7', '肥皂', '5.0', '3', '4', '', null);
INSERT INTO `item` VALUES ('8', '其他xx', '50.0', '4', '20', '', null);

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '办公用品');
INSERT INTO `type` VALUES ('2', '体育用品');
INSERT INTO `type` VALUES ('3', '生活用品');
INSERT INTO `type` VALUES ('4', '其他用品');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) COLLATE utf8_bin NOT NULL,
  `password` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', '123', '123');
INSERT INTO `user` VALUES ('3', '123456', '1234567');
INSERT INTO `user` VALUES ('4', '123456798', '132456');
