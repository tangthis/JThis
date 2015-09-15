/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.21-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `pwd` varchar(36) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`uname`,`phone`,`birthday`,`pwd`,`status`,`create_date`) values (1,'admin','18607198919','1989-09-01','123456',0,'2013-09-14 15:43:05'),(2,'test','18607198918','1988-09-02','123456',0,'2013-09-14 15:43:08'),(3,'sys','18607198917','1987-08-01','123456',0,'2013-09-14 15:43:09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
