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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`id`, `description`, `amount`, `fare`, `sender_id`, `receiver_id`) VALUES
(1, 'Restaurant', '10.00', '0.05', 1, 5),
(2, 'Ticket cinéma', '20.00', '0.10', 2, 4),
(3, 'Voyage à Bayonne', '50.00', '0.25', 3, 5),
(4, 'Sortie Bar', '15.00', '0.08', 6, 5);

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
  `iban` int(34) DEFAULT NULL,
  `balance` decimal(10,2) NOT NULL,
  `social_media` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `mail`, `iban`, `balance`, `social_media`) VALUES
(1, 'Jean', 'Minvielle', 'jean@gmail.com', 11, '100.00', NULL),
(2, 'Simon', 'Dubourg', 'simon@gmail.com', 22, '60.00', 'Facebook'),
(3, 'Didier', 'Dubourg', 'didier@gmail.com', 33, '200.00', NULL),
(4, 'Marin', 'Dubourg', 'marin@gmail.com', NULL, '40.00', 'Facebook'),
(5, 'Jason', 'Dubourg', 'jason@gmail.com', NULL, '10.00', 'Instagram'),
(6, 'Tim', 'Dubourg', 'tim@gmail.com', 44, '80.00', 'Instagram');

--
-- Contraintes pour les tables déchargées
--

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
