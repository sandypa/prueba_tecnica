-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.8-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para prueba_tecnica
CREATE DATABASE IF NOT EXISTS `prueba_tecnica` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `prueba_tecnica`;

-- Volcando estructura para tabla prueba_tecnica.registro
CREATE TABLE IF NOT EXISTS `registro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `documento` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla prueba_tecnica.registro: 0 rows
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` (`id`, `documento`, `fecha`) VALUES
	(1, '234234', '2020-02-28 19:48:16'),
	(2, '74654', '2020-02-28 19:48:22'),
	(3, '54968416', '2020-02-28 01:47:54'),
	(4, '54968416', '2020-02-28 01:47:54'),
	(5, '54968416', '2020-02-28 01:47:54'),
	(6, '123412435', '2020-01-02 01:47:54'),
	(7, '898494151', '2020-02-02 01:47:54');
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
