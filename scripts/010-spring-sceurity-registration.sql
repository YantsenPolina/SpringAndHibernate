DROP DATABASE IF EXISTS `spring_security_registration`;
CREATE DATABASE IF NOT EXISTS `spring_security_registration`;
USE `spring_security_registration`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(50) NOT NULL,
    `password` char(80) NOT NULL,
    `first_name` varchar(50) NOT NULL,
    `last_name` varchar(50) NOT NULL,
    `email` varchar(50) NOT NULL,
    `enabled` bool NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
INSERT INTO `users` (username, password, first_name, last_name, email, enabled)
VALUES
       ('amy','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Amy','Yantsen','amy.yantsen@gmail.com', true);
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
INSERT INTO `roles` (name)
VALUES
       ('ROLE_EMPLOYEE'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN');
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
    `users_id` int(11) NOT NULL,
    `roles_id` int(11) NOT NULL,
    PRIMARY KEY (`users_id`,`roles_id`),
    KEY `FK_ROLE_idx` (`roles_id`),
    CONSTRAINT `FK_USER_05` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_ROLE` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `users_roles` (users_id,roles_id)
VALUES
       (1, 1)