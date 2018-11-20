DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name`  varchar(255) NOT NULL UNIQUE,
`password`  varchar(255) NOT NULL,
`email`  varchar(255) NOT NULL);
