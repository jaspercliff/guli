/*
 Navicat Premium Data Transfer

 Source Server         : master
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : 192.168.236.134:3307
 Source Schema         : guli

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 20/05/2023 01:05:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for edu_chapter
-- ----------------------------
DROP TABLE IF EXISTS `edu_chapter`;
CREATE TABLE `edu_chapter`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_chapter
-- ----------------------------
INSERT INTO `edu_chapter` VALUES ('1', '14', '第一章：HTML', 0, '2019-01-01 12:27:40', '2019-01-01 12:55:30');
INSERT INTO `edu_chapter` VALUES ('1181729226915577857', '18', '第七章：I/O流', 70, '2019-10-09 08:32:58', '2019-10-09 08:33:20');
INSERT INTO `edu_chapter` VALUES ('1192252428399751169', '1192252213659774977', '第一章节', 0, '2019-11-07 09:28:25', '2019-11-07 09:28:25');
INSERT INTO `edu_chapter` VALUES ('15', '18', '第一章：Java入门', 0, '2019-01-01 12:27:40', '2019-10-09 09:13:19');
INSERT INTO `edu_chapter` VALUES ('3', '14', '第二章：CSS', 0, '2019-01-01 12:55:35', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('32', '18', '第二章：控制台输入和输出', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('44', '18', '第三章：控制流', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('48', '18', '第四章：类的定义', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('63', '18', '第五章：数组', 0, '2019-01-01 12:27:40', '2019-01-01 12:27:40');
INSERT INTO `edu_chapter` VALUES ('64', '18', '第六章：继承', 61, '2019-01-01 12:27:40', '2019-10-09 08:32:47');

-- ----------------------------
-- Table structure for edu_comment
-- ----------------------------
DROP TABLE IF EXISTS `edu_comment`;
CREATE TABLE `edu_comment`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师ID',
  `course_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id` ASC) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id` ASC) USING BTREE,
  INDEX `idx_member_id`(`member_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_comment
-- ----------------------------
INSERT INTO `edu_comment` VALUES ('1194499162790211585', '1192252213659774977', '1189389726308478977', '1', '小三123', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '课程很好', 0, '2019-11-13 14:16:08', '2019-11-13 14:16:08');
INSERT INTO `edu_comment` VALUES ('1194898406466420738', '1192252213659774977', '1189389726308478977', '1', '小三123', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '11', 0, '2019-11-14 16:42:35', '2019-11-14 16:42:35');
INSERT INTO `edu_comment` VALUES ('1194898484388200450', '1192252213659774977', '1189389726308478977', '1', '小三123', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '111', 0, '2019-11-14 16:42:53', '2019-11-14 16:42:53');
INSERT INTO `edu_comment` VALUES ('1195251020861317122', '1192252213659774977', '1189389726308478977', '1', NULL, NULL, '2233', 0, '2019-11-15 16:03:45', '2019-11-15 16:03:45');
INSERT INTO `edu_comment` VALUES ('1195251382720700418', '1192252213659774977', '1189389726308478977', '1', NULL, NULL, '4455', 0, '2019-11-15 16:05:11', '2019-11-15 16:05:11');
INSERT INTO `edu_comment` VALUES ('1195252819177570306', '1192252213659774977', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '55', 0, '2019-11-15 16:10:53', '2019-11-15 16:10:53');
INSERT INTO `edu_comment` VALUES ('1195252899448160258', '1192252213659774977', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '55', 0, '2019-11-15 16:11:13', '2019-11-15 16:11:13');
INSERT INTO `edu_comment` VALUES ('1195252920587452417', '1192252213659774977', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '223344', 0, '2019-11-15 16:11:18', '2019-11-15 16:11:18');
INSERT INTO `edu_comment` VALUES ('1195262128095559681', '14', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '11', 0, '2019-11-15 16:47:53', '2019-11-15 16:47:53');
INSERT INTO `edu_comment` VALUES ('1196264505170767874', '1192252213659774977', '1189389726308478977', '1', '小三1231', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132', '666666', 0, '2019-11-18 11:10:58', '2019-11-18 11:10:58');

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程专业父级ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程标题',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '销售数量',
  `view_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览数量',
  `version` bigint UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint NULL DEFAULT NULL COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title` ASC) USING BTREE,
  INDEX `idx_subject_id`(`subject_id` ASC) USING BTREE,
  INDEX `idx_teacher_id`(`teacher_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_course
-- ----------------------------
INSERT INTO `edu_course` VALUES ('1192252213659774977', '1189389726308478977', '1178214681139539969', '1178214681118568449', 'java基础课程：test', 0.01, 2, 'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/cover/default.gif', 4, 387, 1, 'Normal', 0, '2019-11-07 09:27:33', '2019-11-18 13:35:03');
INSERT INTO `edu_course` VALUES ('14', '1189389726308478977', '1101348944971091969', '1101348944920760321', 'XHTML CSS2 JS整站制作教程课程学习', 0.00, 3, 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/d0086eb0-f2dc-45f7-bba1-744d95e5be0f.jpg', 3, 44, 15, 'Normal', 0, '2018-04-02 18:33:34', '2019-11-16 21:21:45');
INSERT INTO `edu_course` VALUES ('15', '1189389726308478977', '1101348944971091969', '1101348944920760321', 'HTML5入门课程学习', 0.00, 23, 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/13/22997b8e-3606-4d2e-9b4f-09f48418b6e4.jpg', 0, 51, 17, 'Normal', 0, '2018-04-02 18:34:32', '2019-11-12 10:19:20');
INSERT INTO `edu_course` VALUES ('18', '1189389726308478977', '1178214681139539969', '1178214681118568449', 'Java精品课程', 0.01, 20, 'http://guli-file.oss-cn-beijing.aliyuncs.com/cover/2019/03/06/866e9aca-b530-4f71-a690-72d4a4bfd1e7.jpg', 151, 737, 6, 'Normal', 0, '2018-04-02 21:28:46', '2019-11-18 11:14:52');

-- ----------------------------
-- Table structure for edu_course_collect
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_collect`;
CREATE TABLE `edu_course_collect`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `is_deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程收藏' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_course_collect
-- ----------------------------
INSERT INTO `edu_course_collect` VALUES ('1196269345666019330', '1192252213659774977', '1', 1, '2019-11-18 11:30:12', '2019-11-18 11:30:12');

-- ----------------------------
-- Table structure for edu_course_description
-- ----------------------------
DROP TABLE IF EXISTS `edu_course_description`;
CREATE TABLE `edu_course_description`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程简介' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_course_description
-- ----------------------------
INSERT INTO `edu_course_description` VALUES ('1104870479077879809', '<p>11</p>', '2019-03-11 06:23:44', '2019-03-11 06:23:44');
INSERT INTO `edu_course_description` VALUES ('1192252213659774977', '<p>测试</p>', '2019-11-07 09:27:33', '2019-11-13 16:21:28');
INSERT INTO `edu_course_description` VALUES ('14', '', '2019-03-13 06:04:43', '2019-03-13 06:05:33');
INSERT INTO `edu_course_description` VALUES ('15', '', '2019-03-13 06:03:33', '2019-03-13 06:04:22');
INSERT INTO `edu_course_description` VALUES ('18', '<p>本套Java视频完全针对零基础学员，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。同时，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。</p>\n<p>------------------------------------</p>\n<p>视频特点：</p>\n<p>通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握\"源码级\"的Javase核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。<br /><br />1.通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题<br />2.具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习<br />3.深入：源码分析，更有 Java 反射、动态代理的实际应用等<br />4.登录尚硅谷官网，技术讲师免费在线答疑</p>', '2019-03-06 18:06:36', '2019-10-30 19:58:36');

-- ----------------------------
-- Table structure for edu_subject
-- ----------------------------
DROP TABLE IF EXISTS `edu_subject`;
CREATE TABLE `edu_subject`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程类别ID',
  `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别名称',
  `parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程科目' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_subject
-- ----------------------------
INSERT INTO `edu_subject` VALUES ('1658270945117896706', '前端开发', '0', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945247920129', '后端开发', '0', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945315028994', '数据库开发', '0', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945377943554', 'vue', '1658270945117896706', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945440858114', 'javascript', '1658270945117896706', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945507966978', 'jquery', '1658270945117896706', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945633796097', 'java', '1658270945247920129', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945696710658', 'c++', '1658270945247920129', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945759625217', 'mysql', '1658270945315028994', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');
INSERT INTO `edu_subject` VALUES ('1658270945826734082', 'oracle', '1658270945315028994', 0, '2023-05-16 08:39:37', '2023-05-16 08:39:37');

-- ----------------------------
-- Table structure for edu_teacher
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher`;
CREATE TABLE `edu_teacher`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师ID',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int UNSIGNED NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师头像',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序',
  `is_deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '讲师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of edu_teacher
-- ----------------------------
INSERT INTO `edu_teacher` VALUES ('1', 'Fukuda Yota', 'qGGRYowif3', 'V0yHlYoa1B', 1, '5SVbOSxN78', 736, 0, '2016-01-10 15:42:34', '2007-06-27 21:30:47');
INSERT INTO `edu_teacher` VALUES ('10', 'Lok Wai Man', 'ZWXCVt1xu7', '2kys91mhYb', 2, 'ENNz15HFEu', 166, 0, '2010-05-05 20:33:42', '2023-05-13 16:23:57');
INSERT INTO `edu_teacher` VALUES ('11', 'Ku Wai Man', 'EhuR2d1hys', 'fi19HAygkZ', 1, '85PFiJ2YWI', 830, 0, '2004-05-20 08:38:29', '2016-10-18 23:47:56');
INSERT INTO `edu_teacher` VALUES ('1189389726308478977', '晴天', '高级讲师简介', '首席讲师', 2, 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/de47ee9b-7fec-43c5-8173-13c5f7f689b2.png', 1, 0, '2019-10-30 11:53:03', '2019-10-30 11:53:03');
INSERT INTO `edu_teacher` VALUES ('1189390295668469762', '李刚', '高级讲师简介', '首席讲师', 2, 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/b8aa36a2-db50-4eca-a6e3-cc6e608355e0.png', 2, 0, '2019-10-30 11:55:19', '2019-11-12 13:37:52');
INSERT INTO `edu_teacher` VALUES ('1189426437876985857', '王二', '高级讲师简介', '高级讲师', 1, 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/08/e44a2e92-2421-4ea3-bb49-46f2ec96ef88.png', 0, 0, '2019-10-30 14:18:56', '2019-11-12 13:37:35');
INSERT INTO `edu_teacher` VALUES ('1189426464967995393', '王五', '高级讲师简介', '高级讲师', 1, 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/65423f14-49a9-4092-baf5-6d0ef9686a85.png', 0, 0, '2019-10-30 14:19:02', '2019-11-12 13:37:18');
INSERT INTO `edu_teacher` VALUES ('1192249914833055746', 'jasper cliff', '高级讲师简介', '高级讲师', 1, 'https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/07/91871e25-fd83-4af6-845f-ea8d471d825d.png', 0, 0, '2019-11-07 09:18:25', '2019-11-12 13:37:01');
INSERT INTO `edu_teacher` VALUES ('1195337453429129218', 'test', 'sdfsdf', 'sdfdf', 1, 'https://guli-file-190513.oss-cn-beijing.aliyuncs.com/avatar/default.jpg', 0, 1, '2019-11-15 21:47:12', '2023-05-13 19:51:20');
INSERT INTO `edu_teacher` VALUES ('12', 'Wong Suk Yee', 'JLMITRRxBM', 'McUe7JVqE0', 2, 'STBIzoQoMW', 164, 0, '2011-07-08 03:19:36', '2016-06-17 13:36:11');
INSERT INTO `edu_teacher` VALUES ('13', 'Hou Xiuying', '0okf2J7lS0', 'V5dBCui4LI', 2, 'uhbkB0mgCk', 671, 0, '2014-07-29 23:18:56', '2023-05-13 16:24:08');
INSERT INTO `edu_teacher` VALUES ('14', 'Tammy Graham', 'FE3K9BDlv5', 'nL7RgBlc0g', 1, 'LPAfTGJloU', 882, 0, '2017-12-29 06:45:29', '2009-07-07 06:03:41');
INSERT INTO `edu_teacher` VALUES ('15', 'Hayashi Daisuke', 'ryWqTlEz5M', 'QhjBvCQLi1', 2, 'sWo1ToSk2i', 883, 0, '2011-09-25 11:51:57', '2013-09-18 16:34:46');
INSERT INTO `edu_teacher` VALUES ('16', 'Yao Anqi', 'M6OgBxMFdP', 'u4mMPr36hH', 1, 'vpe39E9sO9', 885, 0, '2005-01-21 16:36:26', '2023-05-13 16:24:23');
INSERT INTO `edu_teacher` VALUES ('1657322414862823425', 'jasper', 'fucking handsome', 'asda', 1, '', 3, 0, '2023-05-13 17:50:30', '2023-05-13 17:50:30');
INSERT INTO `edu_teacher` VALUES ('1657323333276987393', 'jasperc', 'fucking handsome', 'asda', 1, '', 1, 0, '2023-05-13 17:54:09', '2023-05-13 19:48:22');
INSERT INTO `edu_teacher` VALUES ('1657324060875423746', 'hzq', 'aasdasd', 'asdassd', 1, '', 1, 0, '2023-05-13 17:57:02', '2023-05-13 17:57:02');
INSERT INTO `edu_teacher` VALUES ('1657349972195016705', 'aaaasdasd', 'aaaaaaaa', 'aaaaaa', 1, '', 1, 0, '2023-05-13 19:40:00', '2023-05-13 19:46:23');
INSERT INTO `edu_teacher` VALUES ('1657351446807445506', 'asfasfasfsajidsaas', 'fasfsafsdgartshtr', 'asdfasfas', 2, '', 1, 0, '2023-05-13 19:45:52', '2023-05-13 19:46:14');
INSERT INTO `edu_teacher` VALUES ('1657351780313333761', 'asdasaaaaaa', 'sadas', 'asdas', 2, '', 1, 1, '2023-05-13 19:47:11', '2023-05-13 19:51:25');
INSERT INTO `edu_teacher` VALUES ('1657352123902328833', 'aa', 'aa', 'aa', 1, '', 0, 0, '2023-05-13 19:48:33', '2023-05-13 19:48:46');
INSERT INTO `edu_teacher` VALUES ('1657352278546317314', 'aaaa', 'aa', 'aa', 1, '', 0, 1, '2023-05-13 19:49:10', '2023-05-13 19:51:28');
INSERT INTO `edu_teacher` VALUES ('1657353767075446785', 'jasa', 'aa', 'aa', 1, '', 0, 1, '2023-05-13 19:55:05', '2023-05-13 19:55:08');
INSERT INTO `edu_teacher` VALUES ('1657353828811407361', 'hhzqqqq', 'asa', 'ss', 1, '', 0, 1, '2023-05-13 19:55:20', '2023-05-13 19:55:32');
INSERT INTO `edu_teacher` VALUES ('1657353962060251137', 'ASSA', 'ASDAS', 'ASDAS', 1, '', 0, 1, '2023-05-13 19:55:51', '2023-05-13 19:55:55');
INSERT INTO `edu_teacher` VALUES ('1657354006175940609', 'asdASe', 'ASDA', 'ADSA', 1, '', 0, 1, '2023-05-13 19:56:02', '2023-05-13 19:56:11');
INSERT INTO `edu_teacher` VALUES ('1658020923048042498', '哈哈哈哈', '啊实打实打算发生飞洒发', '啊实打实的', 2, 'blob:http://localhost:9528/759c573d-f056-4f79-a87b-05bbbc7c6e79', 2, 1, '2023-05-15 16:06:07', '2023-05-15 16:10:37');
INSERT INTO `edu_teacher` VALUES ('1658022171759452162', '啊实打实打算', '阿斯顿阿斯顿阿三', '啊实打实打算', 2, 'blob:http://localhost:9528/c4f8c0a0-5c56-4b88-9a80-cd9efe2b685f', 2, 0, '2023-05-15 16:11:05', '2023-05-15 16:11:43');
INSERT INTO `edu_teacher` VALUES ('1659228976523055106', 'hahahah', 'asdasdada', 'asdasd', 1, 'blob:http://localhost:9528/7fbcc5df-8f31-4a0f-b8e6-6fa083da4321', 1, 0, '2023-05-19 00:06:30', '2023-05-19 00:06:30');
INSERT INTO `edu_teacher` VALUES ('17', 'Pan Jiehong', 'tLcNgPLzcI', 'vXg9iuRaGj', 1, 'RlQR8Ir1mA', 155, 0, '2011-09-27 03:08:16', '2023-05-13 16:25:07');
INSERT INTO `edu_teacher` VALUES ('18', 'Jack Patel', 'so6oUVtnfx', 'FxwGOAT9PW', 2, 'WpgTUkKs5D', 959, 0, '2006-09-06 15:34:48', '2007-06-05 18:58:13');
INSERT INTO `edu_teacher` VALUES ('19', 'Loui Ka Fai', 'dfkF6stqSJ', 'KfQ9wXAknU', 2, 'a3OtL3uurk', 370, 0, '2002-05-05 23:13:20', '2016-10-07 09:56:05');
INSERT INTO `edu_teacher` VALUES ('2', 'Wang Zhennan', 'JMEA68thMi', 'FyMaZ47146', 2, 'TK3JiHuTPO', 399, 0, '2010-11-24 17:04:56', '2002-03-03 08:33:45');
INSERT INTO `edu_teacher` VALUES ('20', 'Ye Shihan', 'Wid2ovobPv', 'NP5o5BYPVF', 1, 'UQL6JGUSEu', 250, 0, '2015-06-06 04:44:32', '2000-03-27 11:29:28');
INSERT INTO `edu_teacher` VALUES ('3', 'Miguel Alexander', 'dOAIWGVkqX', 'z1vy8NyGl0', 2, 'lE1hjUmohm', 546, 0, '2018-05-29 13:10:46', '2002-12-06 22:21:10');
INSERT INTO `edu_teacher` VALUES ('4', 'Tang Yuning', 'yQ6C8q8U3j', '7PLAhnApGS', 1, 'BQA4TYfbeb', 872, 0, '2023-01-23 05:53:42', '2006-06-22 04:56:13');
INSERT INTO `edu_teacher` VALUES ('5', 'Troy Brown', 'k5LQ43keIm', 'xyhUUCfkFT', 1, 'jWukyAwJIa', 110, 0, '2020-02-13 20:52:31', '2006-03-16 18:21:36');
INSERT INTO `edu_teacher` VALUES ('6', 'Chin Sum Wing', 'YVSpSU38SM', 'Om7dxzt1kV', 1, 'cy2YdTq0I2', 800, 0, '2016-04-03 06:40:19', '2021-10-27 05:27:00');
INSERT INTO `edu_teacher` VALUES ('7', 'Julia Perez', 'l0lZy4SPS6', 'lLsYnZfVrv', 1, 'OrJ3n42TGu', 373, 0, '2019-11-09 09:47:24', '2011-01-11 15:52:15');
INSERT INTO `edu_teacher` VALUES ('8', 'Masuda Kazuma', 'lbGXdyWsxJ', 'EyL7uIjE9o', 1, 'd32rcaA3WS', 788, 0, '2006-11-25 18:20:58', '2010-08-30 23:04:41');
INSERT INTO `edu_teacher` VALUES ('9', 'Chan Kar Yan', '7MYsnwz6bc', 'g2W4enfbxM', 1, 'pRrABALNqH', 732, 0, '2021-09-01 22:44:20', '2005-05-17 09:32:54');

-- ----------------------------
-- Table structure for edu_video
-- ----------------------------
DROP TABLE IF EXISTS `edu_video`;
CREATE TABLE `edu_video`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '视频ID',
  `course_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '章节ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '原始文件名称',
  `sort` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序字段',
  `play_count` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '播放次数',
  `is_free` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT 0 COMMENT '视频时长（秒）',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Empty' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '视频源文件大小（字节）',
  `version` bigint UNSIGNED NOT NULL DEFAULT 1 COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_course_id`(`course_id` ASC) USING BTREE,
  INDEX `idx_chapter_id`(`chapter_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程视频' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of edu_video
-- ----------------------------
INSERT INTO `edu_video` VALUES ('1182499307429339137', '18', '32', '第一节', '', '', 0, 0, 0, 0, '', 0, 1, '2019-10-11 11:32:59', '2019-10-11 11:57:38');
INSERT INTO `edu_video` VALUES ('1185312444399071234', '14', '1', '12', '', '', 0, 0, 0, 0, 'Empty', 0, 1, '2019-10-19 05:51:23', '2019-10-19 05:51:33');
INSERT INTO `edu_video` VALUES ('1189434737808990210', '18', '44', '测试', '', '', 1, 0, 0, 0, 'Empty', 0, 1, '2019-10-30 14:51:55', '2019-10-30 14:51:55');
INSERT INTO `edu_video` VALUES ('1189471423678939138', '18', '1181729226915577857', 'test', '2b887dc9584d4dc68908780ec57cd3b9', '视频', 1, 0, 0, 0, 'Empty', 0, 1, '2019-10-30 17:17:41', '2019-10-30 17:17:41');
INSERT INTO `edu_video` VALUES ('1189476403626409986', '18', '1181729226915577857', '22', '5155c73dc112475cbbddccf4723f7cef', '视频.mp4', 0, 0, 0, 0, 'Empty', 0, 1, '2019-10-30 17:37:29', '2019-10-30 17:37:29');
INSERT INTO `edu_video` VALUES ('1192252824606289921', '1192252213659774977', '1192252428399751169', '第一课时', '756cf06db9cb4f30be85a9758b19c645', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 0, 0, 'Empty', 0, 1, '2019-11-07 09:29:59', '2019-11-07 09:29:59');
INSERT INTO `edu_video` VALUES ('1192628092797730818', '1192252213659774977', '1192252428399751169', '第二课时', '2a02d726622f4c7089d44cb993c531e1', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 1, 0, 'Empty', 0, 1, '2019-11-08 10:21:10', '2019-11-08 10:21:22');
INSERT INTO `edu_video` VALUES ('1192632495013380097', '1192252213659774977', '1192252428399751169', '第三课时', '4e560c892fdf4fa2b42e0671aa42fa9d', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 1, 0, 'Empty', 0, 1, '2019-11-08 10:38:40', '2019-11-08 10:38:40');
INSERT INTO `edu_video` VALUES ('1194117638832111617', '1192252213659774977', '1192252428399751169', '第四课时', '4e560c892fdf4fa2b42e0671aa42fa9d', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 0, 0, 0, 0, 'Empty', 0, 1, '2019-11-12 13:00:05', '2019-11-12 13:00:05');
INSERT INTO `edu_video` VALUES ('1196263770832023554', '1192252213659774977', '1192252428399751169', '第五课时', '27d21158b0834cb5a8d50710937de330', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 5, 0, 0, 0, 'Empty', 0, 1, '2019-11-18 11:08:03', '2019-11-18 11:08:03');
INSERT INTO `edu_video` VALUES ('17', '18', '15', '第一节：Java简介', '196116a6fee742e1ba9f6c18f65bd8c1', '1', 1, 1000, 1, 100, 'Draft', 0, 1, '2019-01-01 13:08:57', '2019-10-11 11:26:39');
INSERT INTO `edu_video` VALUES ('18', '18', '15', '第二节：表达式和赋值语句', '2d99b08ca0214909899910c9ba042d47', '7 - How Do I Find Time for My ', 2, 999, 1, 100, 'Draft', 0, 1, '2019-01-01 13:09:02', '2019-03-08 03:30:27');
INSERT INTO `edu_video` VALUES ('19', '18', '15', '第三节：String类', '51120d59ddfd424cb5ab08b44fc8b23a', 'eae2b847ef8503b81f5d5593d769dde2.mp4', 3, 888, 0, 100, 'Draft', 0, 1, '2019-01-01 13:09:05', '2019-11-12 12:50:45');
INSERT INTO `edu_video` VALUES ('20', '18', '15', '第四节：程序风格', '2a38988892d84df598752226c50f3fa3', '00-day10总结.avi', 4, 666, 0, 100, 'Draft', 0, 1, '2019-01-01 13:09:05', '2019-10-11 09:20:09');

SET FOREIGN_KEY_CHECKS = 1;
