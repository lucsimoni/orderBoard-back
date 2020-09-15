CREATE TABLE `orderboard`.`user` (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	firstname VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	lastconnection DATE NOT NULL
);

INSERT INTO `orderboard`.`user` (`id`, `name`, `firstname`, `role`, `lastconnection`) VALUES (UUID(), 'simoni', 'luc', 'admin', '2020-05-01');
INSERT INTO `orderboard`.`user` (`id`, `name`, `firstname`, `role`, `lastconnection`) VALUES (UUID(), 'bechini', 'léa', 'user', '2020-06-01');


CREATE TABLE `orderboard`.`product` (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description VARCHAR(9000) NOT NULL,
	price BIGINT(255) NOT NULL,
	quantity BIGINT(255) NOT NULL
);

INSERT INTO `orderboard`.`product` (`id`, `name`, `description`, `price`, `quantity`) VALUES (UUID(), 'table', 'En teck', '350', '30');
INSERT INTO `orderboard`.`product` (`id`, `name`, `description`, `price`, `quantity`) VALUES (UUID(), 'chaise', 'En peuplier', '40', '60');
