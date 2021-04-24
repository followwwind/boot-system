/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : study

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/04/2021 07:30:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '选项，A，B，C，D',
  `issue_id` int(11) NOT NULL COMMENT '题目id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '答案选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'java');
INSERT INTO `category` VALUES (2, 'c++');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `know_id` int(11) NOT NULL COMMENT '知识点id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '知识点收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for issue
-- ----------------------------
DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目内容',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '题目选项答案',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '题目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of issue
-- ----------------------------

-- ----------------------------
-- Table structure for know_comment
-- ----------------------------
DROP TABLE IF EXISTS `know_comment`;
CREATE TABLE `know_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `know_id` int(11) NOT NULL COMMENT '知识点id',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime(0) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '知识点评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of know_comment
-- ----------------------------

-- ----------------------------
-- Table structure for know_record
-- ----------------------------
DROP TABLE IF EXISTS `know_record`;
CREATE TABLE `know_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `know_id` int(11) NOT NULL COMMENT '知识点id',
  `user_id` int(11) NOT NULL COMMENT '用户id，游客则为0',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '知识点浏览' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of know_record
-- ----------------------------

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `category_id` int(11) NOT NULL COMMENT '知识点类别',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '知识点内容',
  `is_share` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否分享，0：否，1：是',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '知识点' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of knowledge
-- ----------------------------

-- ----------------------------
-- Table structure for learn
-- ----------------------------
DROP TABLE IF EXISTS `learn`;
CREATE TABLE `learn`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '简介',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '超链接',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学习' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of learn
-- ----------------------------
INSERT INTO `learn` VALUES (1, '知乎', '知乎', 'https://www.zhihu.com/', '2021-04-18 20:46:15');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '试卷名称',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关键词搜索',
  `count` int(11) NOT NULL COMMENT '题目数量',
  `create_time` datetime(0) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '试卷' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper
-- ----------------------------

-- ----------------------------
-- Table structure for paper_issue
-- ----------------------------
DROP TABLE IF EXISTS `paper_issue`;
CREATE TABLE `paper_issue`  (
  `id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL COMMENT '试卷id',
  `issue_id` int(11) NOT NULL COMMENT '题目id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '试卷问题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_issue
-- ----------------------------

-- ----------------------------
-- Table structure for paper_record
-- ----------------------------
DROP TABLE IF EXISTS `paper_record`;
CREATE TABLE `paper_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `paper_id` int(11) NOT NULL COMMENT '试卷id',
  `issue_id` int(11) NOT NULL COMMENT '题目id',
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '答案，A,B,C,D',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '试卷小测记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_record
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '问题内容',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问答' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for question_comment
-- ----------------------------
DROP TABLE IF EXISTS `question_comment`;
CREATE TABLE `question_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `question_id` int(11) NOT NULL COMMENT '知识点id',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime(0) NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问答评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_comment
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `type` tinyint(1) NOT NULL COMMENT '用户类型，1：超级管理员，2:管理员, 3用户',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态，0：正常，1：禁止评论，2：禁止发表知识点，3：用户永久封号',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70', NULL, NULL, 1, 0, '2021-04-18 19:33:10');
INSERT INTO `user` VALUES (2, '123', '123', '1', '123', 2, 0, '2021-04-18 20:26:24');
INSERT INTO `user` VALUES (3, '111', '111', '2', '111', 3, 0, '2021-04-18 20:30:00');

-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_permission`;
CREATE TABLE `user_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '管理员id',
  `type` tinyint(1) NOT NULL COMMENT '类型，1：用户管理，2：内容管理，3：学习管理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '管理员权限分配' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_permission
-- ----------------------------
INSERT INTO `user_permission` VALUES (1, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
