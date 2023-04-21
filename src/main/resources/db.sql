CREATE TABLE hw_spring_security.users
(
    `user_id`  int         NOT NULL AUTO_INCREMENT,
    `name`     varchar(45) NOT NULL,
    `username` varchar(45) NOT NULL,
    `password` varchar(64) NOT NULL,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE hw_spring_security.roles
(
    `role_id` int         NOT NULL AUTO_INCREMENT,
    `name`    varchar(45) NOT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE TABLE hw_spring_security.users_roles
(
    `user_id` int NOT NULL,
    `role_id` int NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `role_fk_idx` (`role_id`),
    CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);