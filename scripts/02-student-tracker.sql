CREATE DATABASE IF NOT EXISTS `hb_student_tracker`;
USE `hb_student_tracker`;
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    `date_of_birth` DATETIME NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

