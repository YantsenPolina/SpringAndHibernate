DROP DATABASE IF EXISTS `spring_security_bcript`;
CREATE DATABASE IF NOT EXISTS `spring_security_bcript`;
USE `spring_security_bcript`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `username` varchar(50) NOT NULL,
    `password` char(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `users` VALUES
                           ('svetlana','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
                           ('amy','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
                           ('asya','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
    `username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `authorities` VALUES
                                 ('svetlana','ROLE_EMPLOYEE'),
                                 ('asya','ROLE_EMPLOYEE'),
                                 ('asya','ROLE_MANAGER'),
                                 ('amy','ROLE_EMPLOYEE'),
                                 ('amy','ROLE_ADMIN');
