/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : oadb

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 02/08/2022 14:38:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_logs
-- ----------------------------
DROP TABLE IF EXISTS `tb_logs`;
CREATE TABLE `tb_logs`  (
  `operid` int(0) NOT NULL AUTO_INCREMENT COMMENT '日志ip',
  `opertime` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '访问时间',
  `opername` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '访问名称',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '访问ip',
  `methods` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '访问方法',
  `ddesc` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '访问内容',
  PRIMARY KEY (`operid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '名称',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `images` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '头像',
  `stat` int(0) DEFAULT 0 COMMENT '状态 0启用 1禁用',
  `createtime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改时间',
  `modifytime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建时间',
  `deleted` int(0) DEFAULT 0 COMMENT '删除标记 0未删除 1 已删除',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, '张三', '小张', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (2, '李四', '小李', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (3, '王五', '小王', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (4, '赵六', '小赵', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (5, '孙七', '小孙', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (6, '周八', '小周', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (7, '吴九', '小吴', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);
INSERT INTO `tb_user` VALUES (8, '郑十', '小郑', '123456', 'https://sc.chinaz.com/tupian/220727208582.htm', 0, '2022-08-02', '2022-08-03', 0);

SET FOREIGN_KEY_CHECKS = 1;
