/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : sshmysql

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2015-01-11 10:43:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbscomment
-- ----------------------------
DROP TABLE IF EXISTS `bbscomment`;
CREATE TABLE `bbscomment` (
  `uuid` varchar(36) NOT NULL,
  `messageid` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `content` varchar(512) NOT NULL,
  `touser` varchar(32) default NULL,
  `agree` int(8) default NULL,
  `disagree` int(8) default NULL,
  `date` varchar(40) NOT NULL,
  `top` int(8) default NULL,
  `Reserve1` varchar(128) default NULL,
  `Reserve2` varchar(128) default NULL,
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bbsmessage
-- ----------------------------
DROP TABLE IF EXISTS `bbsmessage`;
CREATE TABLE `bbsmessage` (
  `uuid` varchar(36) NOT NULL,
  `username` varchar(32) NOT NULL,
  `content` varchar(512) NOT NULL,
  `imageheadurl` varchar(256) default NULL,
  `agree` int(8) default NULL,
  `disagree` int(8) default NULL,
  `share` int(8) default NULL,
  `address` varchar(40) default NULL,
  `date` varchar(40) NOT NULL,
  `top` int(8) default NULL,
  `phonemodel` varchar(32) default NULL,
  `Reserve1` varchar(128) default NULL,
  `Reserve2` varchar(128) default NULL,
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(36) NOT NULL,
  `name` varchar(32) NOT NULL,
  `course` varchar(64) NOT NULL,
  `score` int(11) NOT NULL,
  `remarks` varchar(512) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `uuid` varchar(36) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(16) NOT NULL,
  `imageheadurl` varchar(256) default NULL,
  `level` int(8) NOT NULL,
  `registertime` varchar(40) NOT NULL,
  `Reserve1` varchar(128) default NULL,
  `Reserve2` varchar(128) default NULL,
  PRIMARY KEY  (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
