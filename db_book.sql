/*
Navicat MySQL Data Transfer

Source Server         : JavaMySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : db_book

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2017-06-27 19:03:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` bigint(20) NOT NULL auto_increment,
  `bookName` varchar(20) default NULL,
  `author` varchar(20) default NULL,
  `sex` varchar(10) default NULL,
  `price` float default NULL,
  `bookTypeId` bigint(20) default NULL,
  `bookDesc` varchar(1000) default NULL,
  PRIMARY KEY  (`id`),
  KEY `bookTypeId` (`bookTypeId`),
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('2', 'Thinking in java', 'J.S', '男', '70', '1', 'Java编程思想的英文版本');
INSERT INTO `t_book` VALUES ('3', 'PHP和MySQL程序设计', 'W.Jason', '男', '75', '5', 'php开发者的圣经');
INSERT INTO `t_book` VALUES ('4', 'Java编程思想', 'JR', '男', '75', '3', 'Java编程的经典书籍');
INSERT INTO `t_book` VALUES ('5', 'PHP MVC编程', 'KR', '男', '70', '5', 'php面向对象高级特性');
INSERT INTO `t_book` VALUES ('6', '了不起的盖茨比', 'ZJ', '男', '25.5', '6', '一部国外的名著');
INSERT INTO `t_book` VALUES ('7', '明朝那些事儿', '当年明月', '男', '100', '6', '当年明月的明朝那些事儿');
INSERT INTO `t_book` VALUES ('8', 'C++编程思想', 'JK.R', '男', '80', '4', 'C++编程的经典之作，同时还有C++面向对象程序设计第七版');
INSERT INTO `t_book` VALUES ('9', '计算机英语', 'W.C', '男', '56.3', '2', '新编计算机英语');
INSERT INTO `t_book` VALUES ('10', 'Effective Python', 'Brett S', '男', '75.5', '7', '让你的Python编程更有效率！');

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
DROP TABLE IF EXISTS `t_booktype`;
CREATE TABLE `t_booktype` (
  `id` bigint(20) NOT NULL auto_increment,
  `bookTypeName` varchar(20) NOT NULL,
  `bookTypeDesc` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_booktype
-- ----------------------------
INSERT INTO `t_booktype` VALUES ('1', '计算机', '计算机相关书籍');
INSERT INTO `t_booktype` VALUES ('2', '外语类', '外语类书籍');
INSERT INTO `t_booktype` VALUES ('3', 'Java', 'Java编程书籍');
INSERT INTO `t_booktype` VALUES ('4', 'C++', 'C++编程书籍');
INSERT INTO `t_booktype` VALUES ('5', 'php', 'php是世界上最好的语言');
INSERT INTO `t_booktype` VALUES ('6', '文学类', '存放文学类的书籍');
INSERT INTO `t_booktype` VALUES ('7', 'Python', 'Python类别的书籍，例如有Effective Python等等');
INSERT INTO `t_booktype` VALUES ('8', '数据结构与算法', '北大数据结构与算法');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `userName` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'java', '123456');
INSERT INTO `t_user` VALUES ('2', 'lxy', 'lxy123');
