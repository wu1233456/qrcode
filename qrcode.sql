/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : qrcode

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 14/01/2021 16:20:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1, '吴春霖', '武汉', '北海市海滨公园', '19994582420');
INSERT INTO `info` VALUES (2, '吴春春', '北京', '广西壮族自治区北海市银海区桥港镇港口路', '19994582420');
INSERT INTO `info` VALUES (3, '吴霖霖', '北京', '\r\n北海大道13号\r\n', '19994582420');
INSERT INTO `info` VALUES (4, '小高', '上海', '上海市浦东新区东胜路229号', '19994582420');
INSERT INTO `info` VALUES (5, '大高', '上海', '上海市闵行区吴中路2019号', '19994582420');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin` int(255) NULL DEFAULT 0,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wcl', '223345', 1, '啦啦啦');
INSERT INTO `user` VALUES (2, '吴春霖', '223345', 0, '北京');
INSERT INTO `user` VALUES (3, '吴春春', '223345', 0, '上海');
INSERT INTO `user` VALUES (4, 'wcll', '223345', 0, '上海');
INSERT INTO `user` VALUES (5, 'gjh', '223345', 0, '北京');
INSERT INTO `user` VALUES (6, 'gjhl', '223345', 0, '');
INSERT INTO `user` VALUES (9, 'lalala', '223345', 0, '武汉');

SET FOREIGN_KEY_CHECKS = 1;
