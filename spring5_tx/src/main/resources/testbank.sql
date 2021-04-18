/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : testbank

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2021-04-17 17:08:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `accountid` int(11) NOT NULL AUTO_INCREMENT,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for oprecord
-- ----------------------------
DROP TABLE IF EXISTS `oprecord`;
CREATE TABLE `oprecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) DEFAULT NULL,
  `opmoney` decimal(10,2) DEFAULT NULL,
  `optime` datetime DEFAULT NULL,
  `optype` enum('deposite','withdraw','transfer') NOT NULL,
  `transferid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
DROP TRIGGER IF EXISTS `after_balance_update`;
DELIMITER ;;
CREATE TRIGGER `after_balance_update` AFTER UPDATE ON `accounts` FOR EACH ROW BEGIN
    IF (NEW.balance < 0) THEN
        update accounts set balance=OLD.balance where accountid = OLD.accountid;
    END IF;
END
;;
DELIMITER ;
