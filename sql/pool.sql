DROP TABLE IF EXISTS `pool`;
CREATE TABLE `pool` (
`id`  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`user`  int NOT NULL,
`currency`  int NOT NULL,
`host`  varchar(255) NOT NULL UNIQUE,
`port`  int NOT NULL,
`login`  varchar(255) NOT NULL UNIQUE,
`password`  varchar(255) NOT NULL UNIQUE,
CONSTRAINT fk_po_user FOREIGN KEY (user) REFERENCES user(id),
CONSTRAINT fk_po_currency FOREIGN KEY (currency) REFERENCES currency(id));