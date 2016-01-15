DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` char(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `client` WRITE;

INSERT INTO `client` (`id`, `name`, `address`, `phone`)
VALUES
	(1,'Zygmunt Kowalski','Bytom',504899355),
	(2,'Karolina Slominska','Gdynia',506733450),
	(3,'Adam Trojanski','elblag',504765991),
	(4,'Wladyslaw Koziej','Gorzyce',502288560),
	(100,'Zara','Ali',18),
	(101,'Zara','Ali',18),
	(102,'Zara','Ali',18);

UNLOCK TABLES;

DROP TABLE IF EXISTS `demand`;

CREATE TABLE `demand` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned DEFAULT NULL,
  `amount` float(6,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `demands_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `demand` WRITE;

INSERT INTO `demand` (`id`, `client_id`, `amount`, `date`)
VALUES
	(1,4,250.50,'2013-12-09'),
	(2,1,4500.00,'2015-06-16'),
	(3,4,3350.50,'2015-03-18'),
	(4,3,1105.30,'2014-06-10');

UNLOCK TABLES;