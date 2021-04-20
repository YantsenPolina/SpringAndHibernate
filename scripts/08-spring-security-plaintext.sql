DROP DATABASE IF EXISTS `spring_security_plaintext`;
CREATE DATABASE IF NOT EXISTS `spring_security_plaintext`;
USE `spring_security_plaintext`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `users` VALUES
                           ('svetlana','{noop}test123',1),
                           ('amy','{noop}test123',1),
                           ('asya','{noop}test123',1);
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
