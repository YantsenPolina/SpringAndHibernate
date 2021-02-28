CREATE DATABASE  IF NOT EXISTS `customer_tracker`;
USE `customer_tracker`;
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
LOCK TABLES `customer` WRITE;
INSERT INTO `customer` VALUES
                              (1,'Arya','Stark','arya.stark@gmail.com'),
                              (2,'John','Snow','john.snow@gmail.com'),
                              (3,'Daenerys','Targaryen','daenerys.targaryen@gmail.com'),
                              (4,'Yara','Greyjoy','yara.greyjoy@gmail.com'),
                              (5,'Bart','Simpson','bart.simpson@gmail.com');
UNLOCK TABLES;