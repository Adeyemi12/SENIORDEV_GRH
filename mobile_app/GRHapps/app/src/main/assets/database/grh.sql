-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 09 nov. 2023 à 12:38
-- Version du serveur : 8.1.0
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `grh`
--

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

DROP TABLE IF EXISTS `doctrine_migration_versions`;
CREATE TABLE IF NOT EXISTS `doctrine_migration_versions` (
  `version` varchar(191) COLLATE utf8mb3_unicode_ci NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int DEFAULT NULL,
  PRIMARY KEY (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20231019060925', '2023-10-19 06:10:23', 315);

-- --------------------------------------------------------

--
-- Structure de la table `formations`
--

DROP TABLE IF EXISTS `formations`;
CREATE TABLE IF NOT EXISTS `formations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utilisateurs_id` int NOT NULL,
  `nom_formations` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `ending_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_409021371E969C5` (`utilisateurs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `messenger_messages`
--

DROP TABLE IF EXISTS `messenger_messages`;
CREATE TABLE IF NOT EXISTS `messenger_messages` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `body` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `headers` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue_name` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `available_at` datetime NOT NULL,
  `delivered_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_75EA56E0FB7336F0` (`queue_name`),
  KEY `IDX_75EA56E0E3BD61CE` (`available_at`),
  KEY `IDX_75EA56E016BA31DB` (`delivered_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `projets`
--

DROP TABLE IF EXISTS `projets`;
CREATE TABLE IF NOT EXISTS `projets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom_projet` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description_projet` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `started_at` datetime NOT NULL,
  `ending_at` datetime NOT NULL,
  `statut` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `ponderation` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `projets`
--

INSERT INTO `projets` (`id`, `nom_projet`, `description_projet`, `started_at`, `ending_at`, `statut`, `created_at`, `ponderation`) VALUES
(1, 'Application de ventre', 'Une application qui permet de ventre tous les articles que l\'utilisateur desire vendre', '2023-05-02 00:00:00', '2024-09-04 00:00:00', 'A faire', '2023-05-01 00:00:00', 75),
(2, 'TEST', 'test', '2023-10-20 00:00:00', '2023-10-31 00:00:00', 'A faire', '2023-10-17 00:00:00', 50),
(3, 'Application de rencontre', 'Une application qui mets en contacts plusieurs  personnes à la recherche de nouvelle connaissance, de nouveax partenaires de businesse ou de l\'amour', '2023-10-20 00:00:00', '2023-10-31 00:00:00', 'En cours', '2023-10-12 00:00:00', 45);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
  `id` int NOT NULL AUTO_INCREMENT,
  `projets_id` int NOT NULL,
  `utilisateurs_id` int NOT NULL,
  `description_tache` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `ending_at` datetime NOT NULL,
  `statut` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ponderation` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_93872075597A6CB7` (`projets_id`),
  KEY `IDX_938720751E969C5` (`utilisateurs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` json NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `poste_occupe` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `departement` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `competences` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_d_embauche` date NOT NULL,
  `salaire` int NOT NULL,
  `duree_du_contrat` int NOT NULL,
  `profil` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `log_time` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  `logout_time` datetime NOT NULL COMMENT '(DC2Type:datetime_immutable)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_497B315EE7927C74` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `email`, `roles`, `password`, `nom`, `prenom`, `photo`, `adresse`, `numero`, `poste_occupe`, `departement`, `competences`, `date_d_embauche`, `salaire`, `duree_du_contrat`, `profil`, `log_time`, `logout_time`) VALUES
(1, 'fawazemouni@gmail.com', '[]', '$2y$13$JA19xO4zcKm45fPZJW4ar.mpl7M8z2k99VCvfGbborkWsNHJ2U/62', 'MOUNIROU', 'Adeyemi', 'test', 'ABOMEY-CALAVI', '67758757', 'Developpeur web', 'Informatique', 'BAC +3', '2023-10-05', 500000, 6, 'admin', '2023-10-19 11:00:00', '2023-10-19 12:00:00'),
(4, 'naruto@gmail.com', '[]', '$2y$13$j5to2UQTyDvXAqaCuzD.euAE.110uSR0D6h30LfWumBEQ6wxyPX3W', 'KOUCHOELO', 'Naruto', 'null', 'porot)novo', '+229 65748565', '789458125468', 'littoral', 'null', '2018-01-01', 1500, 4578, 'Developpeur', '2018-01-01 08:00:00', '2018-01-01 18:00:00');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `formations`
--
ALTER TABLE `formations`
  ADD CONSTRAINT `FK_409021371E969C5` FOREIGN KEY (`utilisateurs_id`) REFERENCES `utilisateurs` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `FK_938720751E969C5` FOREIGN KEY (`utilisateurs_id`) REFERENCES `utilisateurs` (`id`),
  ADD CONSTRAINT `FK_93872075597A6CB7` FOREIGN KEY (`projets_id`) REFERENCES `projets` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
