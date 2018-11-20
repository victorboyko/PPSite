SET names 'utf8';

DROP TABLE IF EXISTS `pool`;
DROP TABLE IF EXISTS `currency`;
DROP TABLE IF EXISTS `algo`;
DROP TABLE IF EXISTS `user`;

source user.sql
source algo.sql
source currency.sql
source pool.sql

-- test data
source dummy_data_setup.sql