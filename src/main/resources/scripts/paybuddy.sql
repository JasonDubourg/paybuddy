-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 21 avr. 2021 à 16:36
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `paybuddy`
--
CREATE DATABASE IF NOT EXISTS `paybuddy` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `paybuddy`;

-- --------------------------------------------------------

--
-- Structure de la table `connection`
--

DROP TABLE IF EXISTS `connection`;
CREATE TABLE IF NOT EXISTS `connection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) NOT NULL,
  `buddy_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `owner` (`owner_id`),
  KEY `buddy` (`buddy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `connection`
--

INSERT INTO `connection` (`id`, `owner_id`, `buddy_id`) VALUES
(1, 1, 5),
(2, 5, 1),
(3, 2, 4),
(4, 4, 2),
(5, 3, 5),
(6, 5, 3),
(7, 5, 6),
(8, 6, 5),
(9, 1, 3),
(10, 4, 6),
(12, 4, 5);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(55) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `fare` decimal(10,2) NOT NULL,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `receiver_id` (`receiver_id`),
  KEY `sender_id` (`sender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id`, `description`, `amount`, `fare`, `sender_id`, `receiver_id`) VALUES
(1, 'Restaurant', '10.00', '0.05', 1, 5),
(2, 'Ticket cinéma', '20.00', '0.10', 2, 4),
(3, 'Voyage à Bayonne', '50.00', '0.25', 3, 5),
(4, 'Sortie Bar', '15.00', '0.08', 6, 5),
(7, 'TestTransaction2', '10.00', '0.05', 4, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `mail` varchar(55) DEFAULT NULL,
  `password` varchar(150) NOT NULL,
  `iban` int(34) DEFAULT NULL,
  `balance` decimal(10,2) NOT NULL,
  `social_media` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `mail`, `password`, `iban`, `balance`, `social_media`) VALUES
(1, 'John', 'Doe', 'john@gmail.com', '@Test1', 11, '99.95', NULL),
(2, 'Thomas', 'Pesquet', 'thomas@gmail.com', '@Test2', 22, '66.94', 'Facebook'),
(3, 'Elon', 'Musk', 'elon@gmail.com', '@Test3', 33, '200.00', NULL),
(4, 'Nikola', 'Tesla', 'nikola@gmail.com', '@Test4', NULL, '42.95', 'Facebook'),
(5, 'Steve', 'Jobs', 'steve@gmail.com', '@Test5', NULL, '10.00', 'Instagram'),
(6, 'Sheldon', 'Cooper', 'sheldon@gmail.com', '@Test6', 44, '80.00', 'Instagram');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `connection`
--
ALTER TABLE `connection`
  ADD CONSTRAINT `FK_buddy_id` FOREIGN KEY (`buddy_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_owner_id` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FK_receiver_id` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_sender_id` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
