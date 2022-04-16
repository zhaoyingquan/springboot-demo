-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grants` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) unique COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员', '123456', 'admin');
INSERT INTO `user` VALUES (6, '管理员',  '123456', 'srpihot');
INSERT INTO `user` VALUES (7, '普通会员', '123456', 'guest');
INSERT INTO `user` VALUES (8, '普通会员', '123456', 'zhangsan');
INSERT INTO `user` VALUES (9, '普通会员',  'lisi', 'lisi');
INSERT INTO `user` VALUES (10, '管理员', 'okok', 'okok');
INSERT INTO `user` VALUES (11, '管理员', 'some', 'some');
INSERT INTO `user` VALUES (12, '普通会员', 'where', 'where');
INSERT INTO `user` VALUES (13, '普通会员',  'kkk', 'kkk');
INSERT INTO `user` VALUES (14, '普通会员', 'sph', 'sph');
INSERT INTO `user` VALUES (15, '管理员', 'why', 'why');

