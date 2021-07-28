/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 03/07/2021 11:55:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grants` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '管理员', 'srpihot', '123456', 'admin');
INSERT INTO `user` VALUES (6, '管理员', 'sph', '123456', 'srpihot');
INSERT INTO `user` VALUES (7, '普通会员', 'user', '123456', 'guest');
INSERT INTO `user` VALUES (8, '普通会员', 'zhangsan', '123456', 'zhangsan');
INSERT INTO `user` VALUES (9, '普通会员', 'lisi', 'lisi', 'lisi');
INSERT INTO `user` VALUES (10, '管理员', 'okok', 'okok', 'okok');
INSERT INTO `user` VALUES (11, '管理员', 'some', 'some', 'some');
INSERT INTO `user` VALUES (12, '普通会员', 'where', 'where', 'where');
INSERT INTO `user` VALUES (13, '普通会员', 'kkk', 'kkk', 'kkk');
INSERT INTO `user` VALUES (14, '普通会员', 'sph', 'sph', 'sph');
INSERT INTO `user` VALUES (15, '管理员', 'why', 'why', 'why');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
