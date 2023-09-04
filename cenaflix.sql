-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25/08/2023 às 03:42
-- Versão do servidor: 10.4.27-MariaDB
-- Versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cenaflix`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `movie`
--

INSERT INTO `movie` (`id`, `name`, `date`, `category`) VALUES
(1, 'Filme1', '2006-07-25', 'Terror'),
(2, 'Filme2', '2006-07-25', 'Terror'),
(3, 'Filme3', '2008-07-25', 'Suspense'),
(5, 'Filme5', '2006-07-25', 'Suspense'),
(6, 'Filme6', '2006-07-25', 'Suspense');

-- --------------------------------------------------------

--
-- Estrutura para tabela `podcast_episode`
--

CREATE TABLE `podcast_episode` (
  `id` int(11) NOT NULL,
  `production` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `URL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `podcast_episode`
--

INSERT INTO `podcast_episode` (`id`, `production`, `name`, `number`, `duration`, `URL`) VALUES
(3, 'tarantino', 'tarantino01', 1, 1000, 'https://podcast/tarantino/1'),
(4, 'tarantino', 'tarantino02', 2, 1000, 'https://podcast/tarantino/2'),
(5, 'eric', 'eric01', 1, 1000, 'https://podcast/eric/1'),
(6, 'eric', 'eric02', 2, 1000, 'https://podcast/eric/2');

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(24) DEFAULT NULL,
  `password` varchar(24) DEFAULT NULL,
  `permission` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `permission`) VALUES
(1, 'admin', 'admin123', 1),
(2, 'operador', 'operador123', 2),
(3, 'usuario', 'usuario123', 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `podcast_episode`
--
ALTER TABLE `podcast_episode`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `podcast_episode`
--
ALTER TABLE `podcast_episode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
