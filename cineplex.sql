﻿# Host: localhost  (Version: 5.5.38)
# Date: 2015-03-30 20:17:48
# Generator: MySQL-Front 5.3  (Build 4.120)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "activity"
#

DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer_id` int(11) NOT NULL DEFAULT '0',
  `member_id` int(7) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Data for table "activity"
#

INSERT INTO `activity` VALUES (1,52,1500002),(2,45,1500002),(3,51,1500002),(4,91,1500002),(5,88,1500002),(6,138,1500004),(7,141,1500004),(8,90,1500004),(9,92,1500004),(10,115,1500004),(11,101,1500005),(12,208,1500005),(13,187,1500006),(14,186,1500006),(15,225,1500006),(16,131,1500006),(17,103,1500006),(18,88,1500006),(19,93,1500006),(20,81,1500006),(21,77,1500006),(22,160,1500001),(23,164,1500001);

#
# Structure for table "answer"
#

DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL DEFAULT '0',
  `answer` varchar(255) NOT NULL DEFAULT '',
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=286 DEFAULT CHARSET=utf8;

#
# Data for table "answer"
#

INSERT INTO `answer` VALUES (1,1,'选项A',0),(2,1,'选项B',0),(3,1,'选项C',0),(4,2,'选项C',0),(5,2,'选项A',0),(6,2,'选项B',0),(7,3,'选项C',0),(8,3,'选项A',0),(9,3,'选项B',0),(10,4,'选项A',0),(11,4,'选项B',0),(12,4,'选项C',0),(13,5,'选项C',0),(14,5,'选项A',0),(15,5,'选项B',0),(16,6,'选项C',0),(17,6,'选项A',0),(18,6,'选项B',0),(19,7,'选项A',0),(20,7,'选项B',0),(21,7,'选项C',0),(22,8,'选项C',0),(23,8,'选项A',0),(24,8,'选项B',0),(25,9,'选项C',0),(26,9,'选项A',0),(27,9,'选项B',0),(28,10,'选项A',0),(29,10,'选项B',0),(30,10,'选项C',0),(31,11,'选项C',0),(32,11,'选项A',0),(33,11,'选项B',0),(34,12,'选项C',0),(35,12,'选项A',0),(36,12,'选项B',0),(37,13,'选项A',0),(38,13,'选项B',0),(39,13,'选项C',0),(40,14,'选项C',0),(41,14,'选项A',0),(42,14,'选项B',0),(43,15,'选项C',0),(44,15,'选项A',0),(45,15,'选项B',0),(46,16,'选项A',2),(47,16,'选项B',0),(48,16,'选项C',0),(49,17,'选项C',0),(50,17,'选项A',0),(51,17,'选项B',2),(52,18,'选项C',1),(53,18,'选项A',1),(54,18,'选项B',0),(55,19,'选项A',0),(56,19,'选项B',0),(57,19,'选项C',0),(58,20,'选项C',0),(59,20,'选项A',0),(60,20,'选项B',0),(61,21,'选项C',0),(62,21,'选项A',0),(63,21,'选项B',0),(64,22,'好',0),(65,22,'差',0),(66,22,'中',0),(67,23,'好',0),(68,23,'中',0),(69,23,'差',0),(70,24,'好',0),(71,24,'差',0),(72,24,'中',0),(73,25,'好',0),(74,25,'中',0),(75,25,'差',0),(76,26,'好',0),(77,26,'差',1),(78,26,'中',0),(79,27,'好',0),(80,27,'中',0),(81,27,'差',1),(82,28,'好',0),(83,28,'差',0),(84,28,'中',0),(85,29,'好',0),(86,29,'中',0),(87,29,'差',0),(88,30,'好',2),(89,30,'差',0),(90,30,'中',1),(91,31,'好',1),(92,31,'中',1),(93,31,'差',1),(94,32,'好',0),(95,32,'差',0),(96,32,'中',0),(97,33,'好',0),(98,33,'中',0),(99,33,'差',0),(100,34,'好',0),(101,34,'中',1),(102,34,'差',0),(103,35,'好',1),(104,35,'中',0),(105,35,'差',0),(106,36,'好',0),(107,36,'中',0),(108,36,'差',0),(109,37,'好',0),(110,37,'中',0),(111,37,'差',0),(112,38,'好',0),(113,38,'中',0),(114,38,'差',0),(115,39,'好',1),(116,39,'中',0),(117,39,'差',0),(118,40,'好',0),(119,40,'差',0),(120,40,'中',0),(121,41,'好',0),(122,41,'差',0),(123,41,'中',0),(124,42,'好',0),(125,42,'差',0),(126,42,'中',0),(127,43,'好',0),(128,43,'差',0),(129,43,'中',0),(130,44,'好',0),(131,44,'差',1),(132,44,'中',0),(133,45,'好',0),(134,45,'差',0),(135,45,'中',0),(136,46,'差',0),(137,46,'中',0),(138,46,'好',1),(139,47,'(●—●)',0),(140,47,'萌萌哒',0),(141,47,'嗯嗯嗯',1),(142,48,'差',0),(143,48,'中',0),(144,48,'好',0),(145,49,'(●—●)',0),(146,49,'萌萌哒',0),(147,49,'嗯嗯嗯',0),(148,50,'差',0),(149,50,'中',0),(150,50,'好',0),(151,51,'(●—●)',0),(152,51,'萌萌哒',0),(153,51,'嗯嗯嗯',0),(154,52,'差',0),(155,52,'中',0),(156,52,'好',0),(157,53,'(●—●)',0),(158,53,'萌萌哒',0),(159,53,'嗯嗯嗯',0),(160,54,'差',1),(161,54,'中',0),(162,54,'好',0),(163,55,'(●—●)',0),(164,55,'萌萌哒',1),(165,55,'嗯嗯嗯',0),(166,56,'差',0),(167,56,'中',0),(168,56,'好',0),(169,57,'(●—●)',0),(170,57,'萌萌哒',0),(171,57,'嗯嗯嗯',0),(172,58,'差',0),(173,58,'中',0),(174,58,'好',0),(175,59,'(●—●)',0),(176,59,'萌萌哒',0),(177,59,'嗯嗯嗯',0),(178,60,'差',0),(179,60,'中',0),(180,60,'好',0),(181,61,'(●—●)',0),(182,61,'萌萌哒',0),(183,61,'嗯嗯嗯',0),(184,62,'差',0),(185,62,'中',0),(186,62,'好',1),(187,63,'(●—●)',1),(188,63,'萌萌哒',0),(189,63,'嗯嗯嗯',0),(190,64,'差',0),(191,64,'中',0),(192,64,'好',0),(193,65,'(●—●)',0),(194,65,'萌萌哒',0),(195,65,'嗯嗯嗯',0),(196,66,'差',0),(197,66,'中',0),(198,66,'好',0),(199,67,'(●—●)',0),(200,67,'萌萌哒',0),(201,67,'嗯嗯嗯',0),(202,68,'选项C',0),(203,68,'选项A',0),(204,68,'选项B',0),(205,69,'选项C',0),(206,69,'选项A',0),(207,69,'选项B',0),(208,70,'选项C',1),(209,70,'选项A',0),(210,70,'选项B',0),(211,71,'选项C',0),(212,71,'选项A',0),(213,71,'选项B',0),(214,72,'选项C',0),(215,72,'选项A',0),(216,72,'选项B',0),(217,73,'选项C',0),(218,73,'选项A',0),(219,73,'选项B',0),(220,74,'选项C',0),(221,74,'选项A',0),(222,74,'选项B',0),(223,75,'选项C',0),(224,75,'选项A',0),(225,75,'选项B',1),(226,76,'选项C',0),(227,76,'选项A',0),(228,76,'选项B',0),(229,77,'选项C',0),(230,77,'选项A',0),(231,77,'选项B',0),(232,78,'选项C',0),(233,78,'选项A',0),(234,78,'选项B',0),(235,79,'选项C',0),(236,79,'选项A',0),(237,79,'选项B',0),(238,80,'a',0),(239,80,'b',0),(240,80,'c',0),(241,81,'a',0),(242,81,'b',0),(243,81,'c',0),(244,82,'a',0),(245,82,'b',0),(246,82,'c',0),(247,83,'a',0),(248,83,'b',0),(249,83,'c',0),(250,84,'a',0),(251,84,'b',0),(252,84,'c',0),(253,85,'a',0),(254,85,'b',0),(255,85,'c',0),(256,86,'a',0),(257,86,'b',0),(258,86,'c',0),(259,87,'a',0),(260,87,'b',0),(261,87,'c',0),(262,88,'a',0),(263,88,'a',0),(264,88,'a',0),(265,89,'a',0),(266,89,'a',0),(267,89,'a',0),(268,90,'a',0),(269,90,'a',0),(270,90,'a',0),(271,91,'a',0),(272,91,'a',0),(273,91,'a',0),(274,92,'a',0),(275,92,'a',0),(276,92,'a',0),(277,93,'a',0),(278,93,'a',0),(279,93,'a',0),(280,94,'a',0),(281,94,'a',0),(282,94,'a',0),(283,95,'a',0),(284,95,'a',0),(285,95,'a',0);

#
# Structure for table "bank"
#

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `balance` decimal(12,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "bank"
#

INSERT INTO `bank` VALUES (1,'1234567890','123',18499.00),(2,'1212121212','123',18600.00),(3,'aaaaaa','123',999800.00),(4,'bbbbbb','123',0.00),(5,'cccccc','123',100.00),(6,'dddddd','123',0.00);

#
# Structure for table "employee"
#

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(30) NOT NULL DEFAULT '123456789',
  `name` varchar(20) NOT NULL DEFAULT '',
  `gender` enum('男','女') NOT NULL DEFAULT '男',
  `position` enum('waiter','manager') NOT NULL DEFAULT 'waiter',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150002 DEFAULT CHARSET=utf8;

#
# Data for table "employee"
#

INSERT INTO `employee` VALUES (1,'123456789','admin','男','waiter'),(150000,'123','manager','男','manager'),(150001,'123','waiter','男','waiter');

#
# Structure for table "film"
#

DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `duration` int(3) NOT NULL DEFAULT '0',
  `director` varchar(50) DEFAULT NULL,
  `staring` varchar(150) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `online_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  `offline_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  `state` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Data for table "film"
#

INSERT INTO `film` VALUES (1,'电影1',123,'editor','staring','描述','2015-03-01 00:00:00','2015-03-06 00:00:00',1),(2,'电影2',123,'editor','staring','描述','2000-01-01 00:00:00','2000-01-01 00:00:00',1),(3,'电影3',100,'editor','staring','描述','2015-01-01 00:00:00','2015-04-01 00:00:00',0),(4,'电影4',100,'editor','staring','描述','2000-01-01 00:00:00','2000-01-01 00:00:00',1),(5,'灰姑娘',112,'editor','staring','在母亲离世后，艾拉的父亲再娶了一位继母。为了支持深爱的父亲，艾拉热情欢迎继母和她的两位女儿进入自己的家庭。然而当父亲也意外去世后，她才发现自己身陷嫉妒和折磨。艾拉被继母一家当作女仆对待，还被恶意称作“灰姑娘”。尽管遭受残忍的折磨，艾拉还是决心坚持母亲的遗言，“勇敢而善良地活下去”，因此她不向绝望投降，也不仇恨虐待她的人。后来，艾拉在树林里遇见了潇洒迷人的陌生人基特，她以为他是王宫的随从，却不知他竟是王子。随着王宫向全国少...','2015-03-13 00:00:00','2015-03-31 00:00:00',1),(6,'超能陆战队',112,'唐·豪尔   克里斯·威廉姆斯','(●—●)大白','迪士尼动画工作室继全球票房爆棚、获誉无数的《冰雪奇缘》和《无敌破坏王》后，再度推出动作冒险喜剧大作《超能陆战队》！影片故事聚焦于一名精通机器人的天才神童小宏与充气机器人大白之间的深厚情谊，在他们无意间发现自己生活的城市旧金山遭遇犯罪危机后，小宏必须联合大白向好友“超疾快递”神行御姐、“飞刀厨神”芥末无疆、“化学女巫”哈妮柠檬以及“怪兽宅男”弗雷德寻求帮助。小宏下定决心要解开层层谜团、拯救全城，于是他将这队从未打击过犯罪...','2015-03-03 00:00:00','2015-03-31 00:00:00',1),(7,'王牌特工：特工学院',125,'马修·沃恩','科林·费斯','17年前，英国秘密特工组织金士曼（Kingsman）的一位特工在任务中为保护同伴而牺牲，他的牺牲保护了所有同伴，金士曼成员之一的哈 利·哈特（科林·费尔斯 饰）找到其家属并且赠予了其子一枚属于金士曼特有的项链徽章。','2015-03-27 00:00:00','2015-04-20 00:00:00',0),(8,'失孤',108,'彭三源','刘德华','1998年，雷泽宽两岁的儿子雷达丢了，雷泽宽开始了长达十四年的寻子之路。一路上雷泽宽历经艰辛，还认识了四岁时被拐修车小伙曾帅。雷泽宽帮曾帅找到了失散多年的亲人，带着曾帅送他的导航仪继续自己的寻子之路','2015-03-20 00:00:00','2015-04-15 00:00:00',0);

#
# Structure for table "member"
#

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `password` varchar(32) NOT NULL DEFAULT '666666',
  `name` varchar(20) NOT NULL DEFAULT '',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00',
  `bank_account` varchar(20) DEFAULT '',
  `state` int(1) NOT NULL DEFAULT '0',
  `start_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `pause_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `stop_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',
  `level` int(2) NOT NULL DEFAULT '0',
  `credit` int(11) NOT NULL DEFAULT '0',
  `birthday` varchar(10) NOT NULL DEFAULT '1970-01-01',
  `gender` enum('男','女') NOT NULL DEFAULT '男',
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1500011 DEFAULT CHARSET=utf8;

#
# Data for table "member"
#

INSERT INTO `member` VALUES (1,'00000000000000000000000000000000','no-member',0.00,'',6,'1970-01-01 00:00:00','1970-01-01 00:00:00','1970-01-01 00:00:00',0,0,'1940-01-01','男','鼓楼区'),(1500001,'123','hanyilu',760.00,'1234567890',1,'2015-03-30 12:03:49','2016-03-29 12:03:49','2017-03-29 12:03:49',2,740,'1993-01-01','女','鼓楼区'),(1500002,'123','shinhwa',306.00,'1212121212',1,'2015-03-24 22:04:24','2016-03-23 22:04:24','2017-03-23 22:04:24',4,1144,'1998-03-24','男','鼓楼区'),(1500003,'123','aaa',200.00,'aaaaaa',1,'2015-03-27 15:18:42','2016-03-26 15:18:42','2017-03-26 15:18:42',1,0,'1990-01-01','女','鼓楼区'),(1500004,'123','bbb',14.95,'bbbbbb',1,'2015-03-27 16:26:27','2016-03-26 16:26:27','2017-03-26 16:26:27',3,196,'1978-01-01','男','白下区'),(1500005,'123','ccc',11.00,'cccccc',1,'2015-03-27 16:41:35','2016-03-26 16:41:35','2017-03-26 16:41:35',1,189,'1993-01-01','男','玄武区'),(1500006,'123','ddd',425.00,'dddddd',1,'2015-03-30 10:56:03','2016-03-29 10:56:03','2017-03-29 10:56:03',1,1575,'1980-01-01','女','其他地区'),(1500007,'123','eee',0.00,'eeeeee',0,'1970-01-01 00:00:00','1970-01-01 00:00:00','1970-01-01 00:00:00',0,0,'1970-01-01','男','栖霞区'),(1500008,'fff','fff',0.00,'ffffff',2,'2014-03-24 22:04:24','2015-03-24 22:04:24','2016-03-24 22:04:24',0,0,'1993-01-01','女','雨花台区'),(1500009,'123','test',0.00,'1234567890',3,'2013-03-24 22:04:24','2014-03-24 22:04:24','2015-03-24 22:04:24',0,0,'2010-02-01','女','其他地区'),(1500010,'aa','aa',0.00,'1234567890',0,'1970-01-01 00:00:00','1970-01-01 00:00:00','1970-01-01 00:00:00',0,0,'2010-01-04','男','鼓楼区');

#
# Structure for table "plan"
#

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `submit_time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  `waiter_id` int(11) NOT NULL DEFAULT '0',
  `manager_id` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `date` varchar(10) NOT NULL DEFAULT '2000-01-01',
  `room_id` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "plan"
#

INSERT INTO `plan` VALUES (1,'2015-03-18 15:21:15',150001,150000,1,'2015-03-26',1),(2,'2015-03-18 15:25:32',150001,150000,-1,'2015-03-18',1),(4,'2015-03-27 15:05:51',150001,150000,1,'2015-03-27',1),(5,'2015-03-27 15:07:06',150001,150000,1,'2015-03-30',2),(6,'2015-03-27 15:08:47',150001,150000,1,'2015-03-30',3),(7,'2015-03-27 15:10:33',150001,150000,1,'2015-03-30',4),(8,'2015-03-27 15:11:59',150001,150000,1,'2015-03-30',5),(9,'2015-03-27 16:18:05',150001,150000,1,'2015-03-28',1),(10,'2015-03-27 16:18:49',150001,150000,0,'2015-03-31',3),(11,'2015-03-17 15:25:32',150001,150000,1,'2015-03-25',3),(12,'2015-03-30 10:17:11',150001,150000,1,'2015-03-30',1),(13,'2015-03-30 10:18:20',150001,150000,1,'2015-03-29',2),(14,'2015-03-30 12:05:37',150001,150000,1,'2015-03-31',4);

#
# Structure for table "plan_item"
#

DROP TABLE IF EXISTS `plan_item`;
CREATE TABLE `plan_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_id` int(11) NOT NULL DEFAULT '0',
  `duration` varchar(5) NOT NULL DEFAULT '00:00',
  `film_id` int(11) NOT NULL DEFAULT '0',
  `price` decimal(5,2) NOT NULL DEFAULT '0.00',
  `sold_seats_id` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

#
# Data for table "plan_item"
#

INSERT INTO `plan_item` VALUES (1,1,'23:00',3,30.00,''),(2,1,'23:00',3,30.00,''),(3,1,'23:00',3,40.00,''),(4,1,'23:00',3,40.00,'25,26,35,36,'),(5,1,'23:00',3,50.00,''),(6,1,'23:00',3,50.00,''),(7,2,'23:00',6,90.00,''),(9,4,'10:00',5,50.00,''),(10,4,'12:30',5,50.00,''),(11,4,'15:00',5,50.00,''),(12,4,'17:30',5,50.00,'51,52,53,54,55,56,57,58,'),(13,4,'20:00',5,80.00,'44,54,'),(14,4,'22:30',5,80.00,'45,46,55,56,57,53,54,16,26,27,32,42,34,44,'),(15,5,'10:00',6,120.00,''),(16,5,'12:30',6,120.00,'126,134,135,136,144,'),(17,5,'15:00',6,120.00,''),(18,5,'17:30',6,120.00,'124,125,134,135,'),(19,5,'20:00',6,120.00,'104,124,125,'),(20,5,'22:30',6,120.00,'114,115,124,125,134,135,144,145,126,127,'),(21,6,'09:30',8,30.00,''),(22,6,'12:00',8,50.00,''),(23,6,'14:30',8,50.00,''),(24,6,'17:00',8,50.00,'236,'),(25,6,'19:30',8,60.00,'234,235,236,237,'),(26,6,'22:00',8,60.00,'234,235,236,237,224,213,222,'),(27,7,'09:30',7,90.00,''),(28,7,'12:00',7,90.00,''),(29,7,'14:30',7,90.00,''),(30,7,'17:00',7,90.00,''),(31,7,'19:30',7,90.00,''),(32,7,'22:00',7,90.00,'324,293,'),(33,8,'09:30',3,40.00,''),(34,8,'12:00',3,40.00,''),(35,8,'14:30',3,40.00,'393,394,'),(36,8,'17:00',3,40.00,'393,394,395,396,404,405,406,416,'),(37,8,'19:30',3,40.00,''),(38,8,'22:00',3,40.00,'415,416,417,418,383,414,411,412,413,'),(39,9,'09:00',5,50.00,''),(40,9,'11:30',5,50.00,''),(41,9,'14:30',5,50.00,''),(42,10,'11:00',6,120.00,''),(43,10,'14:00',6,120.00,''),(44,10,'17:00',6,120.00,''),(45,10,'20:05',6,120.00,''),(46,11,'14:00',6,120.00,'234,235,236,237,224,213,222,'),(47,12,'10:00',7,60.00,''),(48,12,'12:30',7,60.00,''),(49,12,'15:00',7,60.00,''),(50,12,'19:00',8,30.00,'44,34,35,45,'),(51,13,'10:15',8,50.00,''),(52,13,'14:15',7,60.00,''),(53,13,'17:15',7,60.00,''),(54,14,'13:00',6,100.00,'');

#
# Structure for table "question"
#

DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `plan_item_id` int(11) NOT NULL DEFAULT '0',
  `content` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

#
# Data for table "question"
#

INSERT INTO `question` VALUES (1,8,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(2,8,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(3,8,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(4,2,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(5,2,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(6,2,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(7,1,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(8,1,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(9,1,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(10,3,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(11,3,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(12,3,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(13,5,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(14,5,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(15,5,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(16,4,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(17,4,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(18,4,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(19,6,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(20,6,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(21,6,'问题问题问题问题问题问题问题问题问题问题问题问题问题问题问题'),(22,12,'对《灰姑娘》剧情的评价'),(23,12,'对《灰姑娘》演员的评价'),(24,10,'对《灰姑娘》剧情的评价'),(25,10,'对《灰姑娘》演员的评价'),(26,13,'对《灰姑娘》剧情的评价'),(27,13,'对《灰姑娘》演员的评价'),(28,9,'对《灰姑娘》剧情的评价'),(29,9,'对《灰姑娘》演员的评价'),(30,14,'对《灰姑娘》剧情的评价'),(31,14,'对《灰姑娘》演员的评价'),(32,11,'对《灰姑娘》剧情的评价'),(33,11,'对《灰姑娘》演员的评价'),(34,24,'对该电影总体评价'),(35,26,'对该电影总体评价'),(36,23,'对该电影总体评价'),(37,21,'对该电影总体评价'),(38,22,'对该电影总体评价'),(39,25,'对该电影总体评价'),(40,28,'对该电影的总体评价'),(41,32,'对该电影的总体评价'),(42,29,'对该电影的总体评价'),(43,27,'对该电影的总体评价'),(44,31,'对该电影的总体评价'),(45,30,'对该电影的总体评价'),(46,20,'对该电影的总体评价'),(47,20,'大白萌萌哒(●—●)'),(48,17,'对该电影的总体评价'),(49,17,'大白萌萌哒(●—●)'),(50,42,'对该电影的总体评价'),(51,42,'大白萌萌哒(●—●)'),(52,43,'对该电影的总体评价'),(53,43,'大白萌萌哒(●—●)'),(54,18,'对该电影的总体评价'),(55,18,'大白萌萌哒(●—●)'),(56,7,'对该电影的总体评价'),(57,7,'大白萌萌哒(●—●)'),(58,15,'对该电影的总体评价'),(59,15,'大白萌萌哒(●—●)'),(60,16,'对该电影的总体评价'),(61,16,'大白萌萌哒(●—●)'),(62,19,'对该电影的总体评价'),(63,19,'大白萌萌哒(●—●)'),(64,44,'对该电影的总体评价'),(65,44,'大白萌萌哒(●—●)'),(66,45,'对该电影的总体评价'),(67,45,'大白萌萌哒(●—●)'),(68,35,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(69,3,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(70,37,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(71,33,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(72,6,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(73,34,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(74,2,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(75,38,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(76,4,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(77,5,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(78,1,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(79,36,'问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1问题1'),(80,26,'11'),(81,21,'11'),(82,23,'11'),(83,25,'11'),(84,22,'11'),(85,50,'11'),(86,24,'11'),(87,51,'11'),(88,32,'a'),(89,32,'a'),(90,47,'a'),(91,47,'a'),(92,52,'a'),(93,52,'a'),(94,49,'a'),(95,49,'a');

#
# Structure for table "recharge_record"
#

DROP TABLE IF EXISTS `recharge_record`;
CREATE TABLE `recharge_record` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(7) NOT NULL DEFAULT '0',
  `amount` int(4) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "recharge_record"
#

INSERT INTO `recharge_record` VALUES (1,1500002,200,'2015-03-18 16:05:52'),(2,1500002,200,'2015-03-24 22:04:09'),(3,1500002,1000,'2015-03-24 22:04:24'),(4,1500001,1000,'2015-03-27 15:16:20'),(5,1500003,200,'2015-03-27 15:18:42'),(6,1500004,800,'2015-03-27 16:26:27'),(7,1500005,200,'2015-03-27 16:41:35'),(8,1500006,500,'2015-03-27 16:47:44'),(9,1500006,1000,'2015-03-27 16:49:29'),(10,1500006,200,'2015-03-30 10:56:03'),(11,1500001,500,'2015-03-30 12:03:49');

#
# Structure for table "sales"
#

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(7) NOT NULL DEFAULT '0',
  `plan_item_id` int(11) NOT NULL DEFAULT '0',
  `payment` decimal(10,2) NOT NULL DEFAULT '0.00',
  `pay_type` int(1) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `seats_ids` varchar(255) NOT NULL DEFAULT '0',
  `waiter_id` int(11) NOT NULL DEFAULT '1',
  `seat_count` int(3) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

#
# Data for table "sales"
#

INSERT INTO `sales` VALUES (1,1500002,4,144.00,0,'2015-03-18 16:06:12','25,26,35,36,',1,4),(2,1500001,12,500.00,0,'2015-03-27 15:16:54','51,52,53,54,55,56,57,58,',1,20),(3,1500002,14,320.00,0,'2015-03-27 16:04:29','45,46,55,56,',1,8),(7,1500004,36,192.00,0,'2015-03-27 16:26:46','393,394,395,396,404,405,406,416,',1,8),(8,1500004,25,432.00,0,'2015-03-27 16:27:04','234,235,236,237,',1,12),(10,1500004,14,96.00,0,'2015-03-27 16:28:20','57,',1,2),(12,1500005,24,45.00,0,'2015-03-27 16:41:59','236,',1,1),(13,1500006,38,360.00,0,'2015-03-27 16:48:02','415,416,417,418,',1,12),(15,1500006,26,240.00,0,'2015-03-27 16:49:42','234,235,236,237,',1,8),(16,1500006,14,160.00,0,'2015-03-27 16:49:51','53,54,',1,4),(19,1500006,13,80.00,0,'2015-03-27 18:27:33','44,54,',1,2),(20,1500006,19,60.00,0,'2015-03-27 18:43:20','104,',1,1),(21,1,14,240.00,1,'2015-03-27 19:56:54','16,26,27,',150001,3),(22,1,20,960.00,1,'2015-03-27 20:00:02','114,115,124,125,134,135,144,145,',150001,8),(23,1,14,160.00,1,'2015-03-27 20:00:48','32,42,',150001,2),(24,1,14,160.00,1,'2015-03-27 20:01:04','34,44,',150001,2),(25,1,38,40.00,1,'2015-03-27 20:02:43','383,',150001,1),(26,1,32,90.00,1,'2015-03-27 20:02:54','324,',150001,1),(27,1,26,60.00,1,'2015-03-27 20:03:05','224,',150001,1),(28,1,32,90.00,1,'2015-03-27 20:04:03','293,',150001,1),(29,1,38,40.00,1,'2015-03-27 20:04:13','414,',150001,1),(30,1,38,120.00,1,'2015-03-27 20:05:09','411,412,413,',150001,3),(31,1500002,26,60.00,0,'2015-03-27 20:32:43','213,222,',150001,2),(32,1,46,840.00,1,'2015-03-25 12:00:09','234,235,236,237,224,213,222,',150001,7),(33,1500006,50,15.00,0,'2015-03-30 10:28:01','44,',1,1),(34,1,35,80.00,1,'2015-03-30 11:44:11','393,394,',150001,2),(35,1,50,90.00,1,'2015-03-30 11:44:59','34,35,45,',150001,3),(36,1,16,600.00,1,'2015-03-30 11:45:08','126,134,135,136,144,',150001,5),(37,1,20,240.00,1,'2015-03-30 11:45:18','126,127,',150001,2),(38,1500001,18,240.00,0,'2015-03-30 12:03:02','124,125,134,135,',1,4),(39,1,19,240.00,1,'2015-03-30 12:04:33','124,125,',150001,2);

#
# Structure for table "seat"
#

DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(2) NOT NULL DEFAULT '0',
  `row_num` int(2) NOT NULL DEFAULT '0',
  `column_num` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=453 DEFAULT CHARSET=utf8;

#
# Data for table "seat"
#

/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,1,4),(5,1,1,5),(6,1,1,6),(7,1,1,7),(8,1,1,8),(11,1,2,1),(12,1,2,2),(13,1,2,3),(14,1,2,4),(15,1,2,5),(16,1,2,6),(17,1,2,7),(18,1,2,8),(21,1,3,1),(22,1,3,2),(23,1,3,3),(24,1,3,4),(25,1,3,5),(26,1,3,6),(27,1,3,7),(28,1,3,8),(31,1,4,1),(32,1,4,2),(33,1,4,3),(34,1,4,4),(35,1,4,5),(36,1,4,6),(37,1,4,7),(38,1,4,8),(41,1,5,1),(42,1,5,2),(43,1,5,3),(44,1,5,4),(45,1,5,5),(46,1,5,6),(47,1,5,7),(48,1,5,8),(51,1,6,1),(52,1,6,2),(53,1,6,3),(54,1,6,4),(55,1,6,5),(56,1,6,6),(57,1,6,7),(58,1,6,8),(91,2,1,1),(92,2,1,2),(93,2,1,3),(94,2,1,4),(95,2,1,5),(96,2,1,6),(97,2,1,7),(98,2,1,8),(101,2,2,1),(102,2,2,2),(103,2,2,3),(104,2,2,4),(105,2,2,5),(106,2,2,6),(107,2,2,7),(108,2,2,8),(111,2,3,1),(112,2,3,2),(113,2,3,3),(114,2,3,4),(115,2,3,5),(116,2,3,6),(117,2,3,7),(118,2,3,8),(121,2,4,1),(122,2,4,2),(123,2,4,3),(124,2,4,4),(125,2,4,5),(126,2,4,6),(127,2,4,7),(128,2,4,8),(131,2,5,1),(132,2,5,2),(133,2,5,3),(134,2,5,4),(135,2,5,5),(136,2,5,6),(137,2,5,7),(138,2,5,8),(141,2,6,1),(142,2,6,2),(143,2,6,3),(144,2,6,4),(145,2,6,5),(146,2,6,6),(147,2,6,7),(148,2,6,8),(181,3,1,1),(182,3,1,2),(183,3,1,3),(184,3,1,4),(185,3,1,5),(186,3,1,6),(187,3,1,7),(188,3,1,8),(191,3,2,1),(192,3,2,2),(193,3,2,3),(194,3,2,4),(195,3,2,5),(196,3,2,6),(197,3,2,7),(198,3,2,8),(201,3,3,1),(202,3,3,2),(203,3,3,3),(204,3,3,4),(205,3,3,5),(206,3,3,6),(207,3,3,7),(208,3,3,8),(211,3,4,1),(212,3,4,2),(213,3,4,3),(214,3,4,4),(215,3,4,5),(216,3,4,6),(217,3,4,7),(218,3,4,8),(221,3,5,1),(222,3,5,2),(223,3,5,3),(224,3,5,4),(225,3,5,5),(226,3,5,6),(227,3,5,7),(228,3,5,8),(231,3,6,1),(232,3,6,2),(233,3,6,3),(234,3,6,4),(235,3,6,5),(236,3,6,6),(237,3,6,7),(238,3,6,8),(271,4,1,1),(272,4,1,2),(273,4,1,3),(274,4,1,4),(275,4,1,5),(276,4,1,6),(277,4,1,7),(278,4,1,8),(281,4,2,1),(282,4,2,2),(283,4,2,3),(284,4,2,4),(285,4,2,5),(286,4,2,6),(287,4,2,7),(288,4,2,8),(291,4,3,1),(292,4,3,2),(293,4,3,3),(294,4,3,4),(295,4,3,5),(296,4,3,6),(297,4,3,7),(298,4,3,8),(301,4,4,1),(302,4,4,2),(303,4,4,3),(304,4,4,4),(305,4,4,5),(306,4,4,6),(307,4,4,7),(308,4,4,8),(311,4,5,1),(312,4,5,2),(313,4,5,3),(314,4,5,4),(315,4,5,5),(316,4,5,6),(317,4,5,7),(318,4,5,8),(321,4,6,1),(322,4,6,2),(323,4,6,3),(324,4,6,4),(325,4,6,5),(326,4,6,6),(327,4,6,7),(328,4,6,8),(361,5,1,1),(362,5,1,2),(363,5,1,3),(364,5,1,4),(365,5,1,5),(366,5,1,6),(367,5,1,7),(368,5,1,8),(371,5,2,1),(372,5,2,2),(373,5,2,3),(374,5,2,4),(375,5,2,5),(376,5,2,6),(377,5,2,7),(378,5,2,8),(381,5,3,1),(382,5,3,2),(383,5,3,3),(384,5,3,4),(385,5,3,5),(386,5,3,6),(387,5,3,7),(388,5,3,8),(391,5,4,1),(392,5,4,2),(393,5,4,3),(394,5,4,4),(395,5,4,5),(396,5,4,6),(397,5,4,7),(398,5,4,8),(401,5,5,1),(402,5,5,2),(403,5,5,3),(404,5,5,4),(405,5,5,5),(406,5,5,6),(407,5,5,7),(408,5,5,8),(411,5,6,1),(412,5,6,2),(413,5,6,3),(414,5,6,4),(415,5,6,5),(416,5,6,6),(417,5,6,7),(418,5,6,8);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
