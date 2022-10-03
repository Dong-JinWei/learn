-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.36


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mydb
--

CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;

--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cno` varchar(20) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `ctecher` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`cno`,`cname`,`ctecher`) VALUES 
 ('1001','JavaWeb','张峰'),
 ('1002','MySQL','李瑞华'),
 ('1003','Java','王伯槐');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `score`
--

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `scid` varchar(20) NOT NULL,
  `scno` varchar(20) NOT NULL,
  `score` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `score`
--

/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` (`scid`,`scno`,`score`) VALUES 
 ('1','1001','99'),
 ('1','1002','99'),
 ('1','1003','99'),
 ('2','1001','97'),
 ('2','1002','98'),
 ('2','1003','97'),
 ('3','1001','89'),
 ('3','1002','79'),
 ('3','1003','76'),
 ('4','1001','89'),
 ('4','1002','78'),
 ('4','1003','76'),
 ('14','1001','89'),
 ('14','1002','78'),
 ('14','1003','67');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;


--
-- Definition of table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `sid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sname` varchar(45) NOT NULL,
  `sclass` varchar(45) NOT NULL,
  `ssex` varchar(45) NOT NULL,
  `spec` varchar(45) NOT NULL,
  `sdept` varchar(45) NOT NULL,
  `sage` char(3) NOT NULL,
  `sphone` varchar(45) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`sid`,`sname`,`sclass`,`ssex`,`spec`,`sdept`,`sage`,`sphone`) VALUES 
 (1,'admin','admin','男','admin','admin','20','12312312345'),
 (2,'dowei','计19本2','男','计算机科学与技术','信息工程学院','20','15353169794'),
 (3,'YangSir','计19本2','男','计算机科学与技术','信息工程学院','21','1101201300'),
 (4,'LeiSir','计19本2','男','计算机科学与技术','信息工程学院','21','12312312311'),
 (5,'Jolyne','石之海','女','计算机科学与技术','信息工程学院','18','12312345455'),
 (6,'JOJO','星辰远征军','男','计算机科学与技术','信息工程学院','18','15353269794'),
 (7,'DIO','BOOS','男','计算机科学与技术','信息工程学院','200','15353269794'),
 (8,'YangSir','计19本2','男','计算机科学与技术','信息工程学院','22','15353269794'),
 (9,'Johnny','石之海','女','计算机科学与技术','信息工程学院','18','15353269794'),
 (10,'Jotaro','石之海','男','海洋生物学','海洋生物学院','35','15353269794'),
 (11,'Kujo','疯狂钻石','男','海洋生物学','海洋生物学院','39','15353269794'),
 (12,'Joestar','战斗潮流','男','波纹战士','齐贝林学院','18','15353269794'),
 (13,'Zeppeli','SBR','男','黄金回旋','黄金回旋学院','24','15353269794'),
 (14,'ff','BOOS','女','计算机科学与技术','信息工程学院','20','15353269794');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;


--
-- Definition of table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `t_user`
--

/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`,`username`,`password`,`sex`,`age`,`phone`,`mail`) VALUES 
 (1,'admin','admin','admin','admin','admin','admin'),
 (2,'dowei','dowei','男','20','12341234123','1234@qq.com'),
 (3,'YangSir','1234','男','20','12345678910','YangSir@qq.com'),
 (4,'LeiSir','1234','男','24','1231231231','LeiSir@qq.com'),
 (5,'Jolyne','1234','女','18','15353269794','Jolne@qq.com'),
 (6,'JOJO','1234','男','23','15353269794','JOJO@qq.com'),
 (10,'Jotaro','123','男','16','15353269794','Jotaro@qq.com'),
 (12,'Joestar','123','男','37','15353269794','Joestar@qq.com'),
 (13,'Zeppeli','123','男','25','15353269794','Zeppeli@qq.com');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
