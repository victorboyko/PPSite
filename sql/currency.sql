DROP TABLE IF EXISTS `currency`;
CREATE TABLE `currency` (
`id`  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`algo`  int NOT NULL,
`abr`  varchar(255) NOT NULL UNIQUE,
`name`  varchar(255) NOT NULL UNIQUE,
CONSTRAINT fk_cu_algo FOREIGN KEY (algo) REFERENCES algo(id));