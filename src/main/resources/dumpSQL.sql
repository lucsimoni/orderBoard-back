CREATE TABLE `orderboard`.`user` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	firstname VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	login VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	lastconnection DATE NOT NULL
);

INSERT INTO `orderboard`.`user` (`id`, `name`, `firstname`, `role`, `login`, `password`, `lastconnection`) VALUES (1, 'simoni', 'luc', 'admin', 'lsimoni', 'lsimoni123!', '2020-05-01');
INSERT INTO `orderboard`.`user` (`id`, `name`, `firstname`, `role`, `login`, `password`, `lastconnection`) VALUES (2, 'gardet', 'romain', 'user', 'rgardet', 'rgardet123!', '2020-06-01');