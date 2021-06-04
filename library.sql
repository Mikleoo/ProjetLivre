-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 04 juin 2021 à 16:22
-- Version du serveur :  5.7.17
-- Version de PHP :  7.1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `auteur`
--

CREATE TABLE `auteur` (
  `id_auteur` int(11) NOT NULL,
  `nom_auteur` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `auteur`
--

INSERT INTO `auteur` (`id_auteur`, `nom_auteur`) VALUES
(1, 'Michel'),
(2, 'zz'),
(23, 'zz'),
(24, 'ddd'),
(25, 'gvgjut'),
(26, 'ftcftuft');

-- --------------------------------------------------------

--
-- Structure de la table `editeur`
--

CREATE TABLE `editeur` (
  `id_editeur` int(11) NOT NULL,
  `nom_editeur` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `editeur`
--

INSERT INTO `editeur` (`id_editeur`, `nom_editeur`) VALUES
(1, 'LaFonte'),
(2, 'ee'),
(26, 'fftft'),
(25, 'yybhj'),
(24, 'dddd'),
(23, 'dd');

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

CREATE TABLE `lieu` (
  `id_lieu` int(11) NOT NULL,
  `nom_lieu` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`id_lieu`, `nom_lieu`) VALUES
(1, 'Commode'),
(2, 'rr'),
(26, 'fyvrvfyv'),
(25, 'ghvgjvgj'),
(24, 'sssse'),
(23, 'ff');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id_isbn` int(11) NOT NULL,
  `nom_livre` varchar(45) NOT NULL,
  `date_de_fin` varchar(20) DEFAULT NULL,
  `est_supprime` tinyint(1) NOT NULL DEFAULT '0',
  `id_auteur` int(11) DEFAULT NULL,
  `id_editeur` int(11) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL,
  `id_lieu` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id_isbn`, `nom_livre`, `date_de_fin`, `est_supprime`, `id_auteur`, `id_editeur`, `id_personne`, `id_lieu`) VALUES
(1, 'Lance pierre', NULL, 0, 1, 1, 1, 1),
(2, 'aa', 'tt', 0, 2, 2, 2, 2),
(9, 'aa', 'bb', 0, 23, 23, 23, 23),
(10, 'ddd', 'dfdf', 0, 24, 24, 24, 24),
(11, 'rgre', 'hjhjvhj ', 0, 25, 25, 25, 25),
(12, 'ftcfyvcft', 'rvyvtv', 0, 26, 26, 26, 26);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id_personne` int(11) NOT NULL,
  `nom_personne` varchar(45) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id_personne`, `nom_personne`) VALUES
(1, 'Pierre'),
(2, 'yy'),
(16, 'd'),
(17, 'G'),
(15, 'f'),
(14, 'nn'),
(18, 'g'),
(19, 'f'),
(20, 'FG'),
(21, 'fg'),
(22, 'tyyt'),
(23, 'gg'),
(24, 'fgfgf'),
(25, 'hjvhjv'),
(26, 'rtvty_');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `auteur`
--
ALTER TABLE `auteur`
  ADD PRIMARY KEY (`id_auteur`),
  ADD UNIQUE KEY `id_auteur_UNIQUE` (`id_auteur`);

--
-- Index pour la table `editeur`
--
ALTER TABLE `editeur`
  ADD PRIMARY KEY (`id_editeur`),
  ADD UNIQUE KEY `id_editeur_UNIQUE` (`id_editeur`);

--
-- Index pour la table `lieu`
--
ALTER TABLE `lieu`
  ADD PRIMARY KEY (`id_lieu`),
  ADD UNIQUE KEY `id_lieu_UNIQUE` (`id_lieu`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id_isbn`),
  ADD UNIQUE KEY `id_isbn_UNIQUE` (`id_isbn`),
  ADD KEY `id_auteur_idx` (`id_auteur`),
  ADD KEY `id_editeur_idx` (`id_editeur`),
  ADD KEY `id_personne_idx` (`id_personne`),
  ADD KEY `id_lieu_idx` (`id_lieu`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id_personne`),
  ADD UNIQUE KEY `id_personne_UNIQUE` (`id_personne`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `auteur`
--
ALTER TABLE `auteur`
  MODIFY `id_auteur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT pour la table `editeur`
--
ALTER TABLE `editeur`
  MODIFY `id_editeur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT pour la table `lieu`
--
ALTER TABLE `lieu`
  MODIFY `id_lieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id_isbn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id_personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
