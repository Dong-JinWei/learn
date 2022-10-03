/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 8.0.26 : Database - mydb0324
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb0324` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mydb0324`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `did` int NOT NULL,
  `dname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `dept` */

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `eid` int NOT NULL AUTO_INCREMENT COMMENT '工号',
  `ename` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `hiredate` datetime DEFAULT NULL COMMENT '入职日期',
  `salary` decimal(9,2) DEFAULT NULL COMMENT '工资',
  `did` int DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `fk_emp_dept` (`did`),
  CONSTRAINT `fk_emp_dept` FOREIGN KEY (`did`) REFERENCES `dept` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `emp` */

/*Table structure for table `man` */

DROP TABLE IF EXISTS `man`;

CREATE TABLE `man` (
  `mid` int NOT NULL,
  `mname` varchar(255) NOT NULL,
  PRIMARY KEY (`mid`),
  CONSTRAINT `fk_man_woman` FOREIGN KEY (`mid`) REFERENCES `woman` (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `man` */

/*Table structure for table `r_teacher_student` */

DROP TABLE IF EXISTS `r_teacher_student`;

CREATE TABLE `r_teacher_student` (
  `tid` int DEFAULT NULL,
  `sid` int DEFAULT NULL,
  KEY `r_student` (`sid`),
  KEY `r_teacher` (`tid`),
  CONSTRAINT `r_student` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `r_teacher` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `r_teacher_student` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `teacher` */

/*Table structure for table `woman` */

DROP TABLE IF EXISTS `woman`;

CREATE TABLE `woman` (
  `wid` int NOT NULL,
  `wname` varchar(255) NOT NULL,
  PRIMARY KEY (`wid`),
  CONSTRAINT `fk_woman_man` FOREIGN KEY (`wid`) REFERENCES `man` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `woman` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
