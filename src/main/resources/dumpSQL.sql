CREATE TABLE `orderboard`.`user` (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	firstname VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	lastconnection DATE,
	login VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	firstconnection BOOLEAN NOT NULL
);

INSERT INTO `orderboard`.`user` (`id`, `name`, `firstname`, `role`, `lastconnection`, `login`, `password`, `firstconnection`) VALUES ('4028aa8a749c89a401749c89fa5c0000', 'simoni', 'luc', 'admin', '2020-05-01', 'lsimoni', 'root', false);
INSERT INTO `orderboard`.`user` (`id`, `name`, `firstname`, `role`, `lastconnection`, `login`, `password`, `firstconnection`) VALUES (UUID(), 'bechini', 'léa', 'user', '2020-06-01', 'lbechini', 'root', false);


CREATE TABLE `orderboard`.`product` (
	id VARCHAR(255) PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description VARCHAR(9000) NOT NULL,
	price BIGINT(255) NOT NULL,
	quantity BIGINT(255) NOT NULL
);

INSERT INTO `orderboard`.`product` (`id`, `name`, `description`, `price`, `quantity`) VALUES (UUID(), 'table', 'En teck', '350', '30');
INSERT INTO `orderboard`.`product` (`id`, `name`, `description`, `price`, `quantity`) VALUES (UUID(), 'chaise', 'En peuplier', '40', '60');


CREATE TABLE `orderboard`.`purchaseorder` (
	id VARCHAR(255) PRIMARY KEY,
	ordergroup VARCHAR(255) NOT NULL,
	quantity BIGINT(255) NOT NULL,
	dateorder DATE NOT NULL,
	state VARCHAR(255) NOT NULL,
	salerid VARCHAR(255) NOT NULL,
	FOREIGN KEY (salerid) REFERENCES user(id)
);

INSERT INTO `orderboard`.`purchaseorder` (`id`, `ordergroup`, `quantity`, `dateorder`, `state`, `salerid`) VALUES (UUID(), UUID(), 1, '2020-09-21', 'En attente de paiement', '4028aa8a749c89a401749c89fa5c0000');
