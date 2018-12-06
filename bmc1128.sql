/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : bmc1128

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-12-06 17:41:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bmc_goods`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_goods`;
CREATE TABLE `bmc_goods` (
  `g_id` bigint(20) NOT NULL COMMENT '商品id',
  `g_price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `s_id` int(10) DEFAULT NULL COMMENT '店铺id',
  `uptime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `bmc_result`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_result`;
CREATE TABLE `bmc_result` (
  `g_id` int(11) NOT NULL COMMENT '商品id',
  `g_name` varchar(50) NOT NULL COMMENT '商品名称',
  `s_id` int(11) DEFAULT NULL COMMENT '店铺id',
  `s_name` varchar(255) NOT NULL COMMENT '店铺名称',
  `res_upprice` decimal(10,2) NOT NULL COMMENT '上传价格',
  `res_plaprice` decimal(10,2) NOT NULL COMMENT '平台价格',
  `result` int(2) NOT NULL COMMENT '1,高，2等，3低',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_result
-- ----------------------------

-- ----------------------------
-- Table structure for `bmc_rgoods`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_rgoods`;
CREATE TABLE `bmc_rgoods` (
  `r_id` bigint(20) NOT NULL COMMENT '在线商品id',
  `r_name` varchar(255) NOT NULL COMMENT '在线商品名称',
  `r_price` decimal(10,2) NOT NULL COMMENT '在线商品价格',
  `shop_id` int(10) NOT NULL COMMENT '在线店铺id',
  `r_uptime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_rgoods
-- ----------------------------

-- ----------------------------
-- Table structure for `bmc_shops`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_shops`;
CREATE TABLE `bmc_shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) NOT NULL,
  `shop_url` varchar(50) NOT NULL,
  `shop_table` varchar(50) NOT NULL COMMENT '店铺对应的表名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_shops
-- ----------------------------
INSERT INTO `bmc_shops` VALUES ('1', '店铺1', 'http://www.123', 'bmc_rgoods');
INSERT INTO `bmc_shops` VALUES ('2', '欢乐逛', 'http://www/', 'bmc_rgoods');
INSERT INTO `bmc_shops` VALUES ('3', '店铺3', 'http://www.baidu.com', 'bmc_rgoods');

-- ----------------------------
-- Table structure for `bmc_uploads`
-- ----------------------------
DROP TABLE IF EXISTS `bmc_uploads`;
CREATE TABLE `bmc_uploads` (
  `up_id` int(11) NOT NULL AUTO_INCREMENT,
  `up_path` varchar(255) DEFAULT NULL,
  `up_time` datetime DEFAULT NULL,
  PRIMARY KEY (`up_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmc_uploads
-- ----------------------------
INSERT INTO `bmc_uploads` VALUES ('82', 'D:/workspace/20181204113951欢乐逛-1130-12月日常价.xlsx', '2018-12-04 11:39:51');
INSERT INTO `bmc_uploads` VALUES ('83', 'D:/workspace/20181204151500欢乐逛-1130-12月日常价.xlsx', '2018-12-04 15:15:00');
INSERT INTO `bmc_uploads` VALUES ('84', 'D:/workspace/20181204174905欢乐逛-1130-12月日常价.xlsx', '2018-12-04 17:49:05');
INSERT INTO `bmc_uploads` VALUES ('85', 'D:/workspace/20181205170128欢乐逛-1130-12月日常价.xlsx', '2018-12-05 17:01:28');
INSERT INTO `bmc_uploads` VALUES ('86', 'D:/workspace/20181205170249欢乐逛-1130-12月日常价.xlsx', '2018-12-05 17:02:49');
