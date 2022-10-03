/*
SQLyog Ultimate v9.10 
MySQL - 8.0.22 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `book`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` int NOT NULL AUTO_INCREMENT,
  `cateid` int DEFAULT NULL,
  `bnum` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `bname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `price` int DEFAULT NULL,
  `author` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ddesc` text COLLATE utf8_bin,
  `quantity` int DEFAULT NULL,
  `deleted` int DEFAULT '0',
  `createtime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `modifytime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `book` */

insert  into `book`(`bid`,`cateid`,`bnum`,`bname`,`price`,`author`,`ddesc`,`quantity`,`deleted`,`createtime`,`modifytime`) values (1,2,'1001','红楼梦',100,'曹雪芹','《红楼梦》，中国古代章回体长篇小说，中国古典四大名著之一，一般认为是清代作家曹雪芹所著。小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，以贾宝玉与林黛玉、薛宝钗的爱情婚姻悲剧为主线，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美，可以说是一部从各个角度展现女性美以及中国古代社会世态百相的史诗性著作。',999,0,NULL,NULL),(2,1,'1002','我这一辈子',100,'老舍','《我这一辈子》是老舍先生创作于1937年抗战前夕的一部著名的中篇小说。描写了一个旧时代普通巡警的坎坷一生。1937年7月1日载于《文学》第9卷第1号。《我这一辈子》是老舍第一个创作黄金时期的压轴作品，格外具有挺拔于时代的进步气息',998,0,NULL,NULL),(3,1,'1003','平凡的世界',100,'路遥','《平凡的世界》是中国作家路遥创作的一部全景式地表现中国当代城乡社会生活的百万字长篇小说。全书共三部。1986年12月首次出版。\n该书以中国70年代中期到80年代中期十年间为背景，通过复杂的矛盾纠葛，以孙少安和孙少平两兄弟为中心，刻画了当时社会各阶层众多普通人的形象；劳动与爱情、挫折与追求、痛苦与欢乐、日常生活与巨大社会冲突纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路',10,0,NULL,NULL),(4,1,NULL,'梦里花落知多少',99,'郭敬明','《梦里花落知多少》是当代作家郭敬明创作的一部长篇小说。小说以北京、上海等大都市为背景，讲述了几个年轻人的爱情故事，故事情节曲折，语言幽默生动，大量的引入口语与通俗幽默的比喻。 [1] \n主人公是一些即将走出校门的大学生，在成长的过程中，友情、爱情都在经历着蜕变。小说一经出版便在市场上取得重大成功，销量上成为2004年全国文学类畅销书第一名。',8,0,'2021-06-25 11:15:37','2021-06-25 11:19:43');

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `boid` int NOT NULL AUTO_INCREMENT,
  `sid` int DEFAULT NULL,
  `bid` int DEFAULT NULL,
  `otime` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `itime` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `deleted` int DEFAULT '0',
  `uid` int DEFAULT NULL,
  `stat` int DEFAULT '0' COMMENT '0已借出、1已归还',
  PRIMARY KEY (`boid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `borrow` */

insert  into `borrow`(`boid`,`sid`,`bid`,`otime`,`itime`,`quantity`,`deleted`,`uid`,`stat`) values (2,1,1,'2021-06-25 09:10:59',NULL,1,0,1,0),(3,2,2,'2021-06-25 09:23:39',NULL,2,0,2,0),(4,2,4,'2021-06-25 11:19:43',NULL,2,0,5,0);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cateid` int NOT NULL AUTO_INCREMENT,
  `catename` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `deleted` int DEFAULT '0',
  `createtime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `modifytime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`cateid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `category` */

insert  into `category`(`cateid`,`catename`,`deleted`,`createtime`,`modifytime`) values (1,'近代小说类',0,NULL,NULL),(2,'古典小说类',0,NULL,NULL),(3,'计算机类',0,NULL,NULL),(4,'考研类',0,'2021-06-25 10:55:42','2021-06-25 10:56:49');

/*Table structure for table `logs` */

DROP TABLE IF EXISTS `logs`;

CREATE TABLE `logs` (
  `operid` int NOT NULL AUTO_INCREMENT,
  `sid` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `opertime` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `opername` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `ip` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `methods` text COLLATE utf8_bin,
  `ddesc` text COLLATE utf8_bin,
  PRIMARY KEY (`operid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `logs` */

insert  into `logs`(`operid`,`sid`,`uid`,`opertime`,`opername`,`ip`,`methods`,`ddesc`) values (1,NULL,NULL,'2021-06-24 14:47:15','admin','127.0.0.1','com.xls.app.controller.UsersController.changeStats','更改用户状态'),(2,NULL,NULL,'2021-06-24 14:47:18','admin','127.0.0.1','com.xls.app.controller.UsersController.changeStats','更改用户状态'),(3,NULL,NULL,'2021-06-24 14:48:53','admin','127.0.0.1','com.xls.app.controller.UsersController.save','添加用户信息'),(4,NULL,NULL,'2021-06-24 14:56:38','张飞','127.0.0.1','com.xls.app.controller.UsersController.changeStats','更改用户状态'),(5,NULL,NULL,'2021-06-24 14:56:49','张飞','127.0.0.1','com.xls.app.controller.UsersController.changeStats','更改用户状态'),(6,NULL,NULL,'2021-06-25 09:08:08','张飞','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(7,NULL,NULL,'2021-06-25 09:13:45','张飞','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(8,NULL,NULL,'2021-06-25 09:15:50','张飞','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(9,NULL,NULL,'2021-06-25 09:16:43','张飞','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(10,NULL,NULL,'2021-06-25 09:17:20','张飞','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(11,NULL,NULL,'2021-06-25 09:18:59','张飞','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(12,NULL,NULL,'2021-06-25 09:22:43','admin','127.0.0.1','com.xls.app.controller.UsersController.changeStats','更改用户状态'),(13,NULL,NULL,'2021-06-25 09:23:01','李逵','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(14,NULL,NULL,'2021-06-25 09:23:39','李逵','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','添加借书信息'),(15,NULL,NULL,'2021-06-25 09:56:43','admin','127.0.0.1','com.xls.app.controller.UsersController.update','更新用户信息'),(16,NULL,NULL,'2021-06-25 09:57:25','admin','127.0.0.1','com.xls.app.controller.UsersController.update','更新用户信息'),(17,NULL,NULL,'2021-06-25 10:51:03','张飞','127.0.0.1','com.xls.app.controller.CategoryController.save','图书类别信息添加操作'),(18,NULL,NULL,'2021-06-25 10:54:20','张飞','127.0.0.1','com.xls.app.controller.CategoryController.save','图书类别信息添加操作'),(19,NULL,NULL,'2021-06-25 10:55:42','张飞','127.0.0.1','com.xls.app.controller.CategoryController.save','图书类别信息添加操作'),(20,NULL,NULL,'2021-06-25 10:56:49','张飞','127.0.0.1','com.xls.app.controller.CategoryController.update','图书类别信息更新操作'),(21,NULL,NULL,'2021-06-25 11:07:04','张飞','127.0.0.1','com.xls.app.controller.BookController.update','图书更新操作'),(22,NULL,NULL,'2021-06-25 11:08:32','张飞','127.0.0.1','com.xls.app.controller.BookController.update','图书更新操作'),(23,NULL,NULL,'2021-06-25 11:09:01','张飞','127.0.0.1','com.xls.app.controller.BookController.update','图书更新操作'),(24,NULL,NULL,'2021-06-25 11:09:53','张飞','127.0.0.1','com.xls.app.controller.BookController.remove','图书批量删除操作'),(25,NULL,NULL,'2021-06-25 11:10:09','张飞','127.0.0.1','com.xls.app.controller.BookController.remove','图书批量删除操作'),(26,NULL,NULL,'2021-06-25 11:13:26','张飞','127.0.0.1','com.xls.app.controller.BookController.remove','图书批量删除操作'),(27,NULL,NULL,'2021-06-25 11:15:37','张飞','127.0.0.1','com.xls.app.controller.BookController.save','图书添加操作'),(28,NULL,NULL,'2021-06-25 11:19:43','嬴政','127.0.0.1','com.xls.app.controller.BorrowController.borrowBook','借阅信息添加');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `snum` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `specialty` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `deleted` int DEFAULT '0',
  `createtime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `modifytime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `student` */

insert  into `student`(`sid`,`snum`,`sname`,`specialty`,`sex`,`tel`,`deleted`,`createtime`,`modifytime`) values (1,'20181001','曹雪芹',NULL,NULL,NULL,0,NULL,NULL),(2,'20181003','林黛玉',NULL,NULL,NULL,0,NULL,NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '000000',
  `uname` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `images` text COLLATE utf8_bin,
  `stats` int DEFAULT '0' COMMENT '0表示启用、1禁用状态',
  `deleted` int DEFAULT '0',
  `createtime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `modifytime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `users` */

insert  into `users`(`uid`,`password`,`uname`,`images`,`stats`,`deleted`,`createtime`,`modifytime`) values (1,'000000','张飞','https://img1.baidu.com/it/u=3960132582,584653904&fm=15&fmt=auto&gp=0.jpg',0,0,NULL,NULL),(2,'000000','李逵','https://img2.baidu.com/it/u=661539886,3900694712&fm=26&fmt=auto&gp=0.jpg',0,0,NULL,'2021-06-25 09:57:25'),(3,'000000','admin','https://img1.baidu.com/it/u=3960132582,584653904&fm=15&fmt=auto&gp=0.jpg',0,0,NULL,NULL),(4,'123456','刘备','https://img1.baidu.com/it/u=3960132582,584653904&fm=15&fmt=auto&gp=0.jpg',0,0,'2021-06-24 09:27:02','2021-06-24 09:38:04'),(5,'111111','嬴政','https://img1.baidu.com/it/u=2179921797,2025214210&fm=26&fmt=auto&gp=0.jpg',0,0,'2021-06-24 14:48:53','2021-06-25 09:56:43');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
