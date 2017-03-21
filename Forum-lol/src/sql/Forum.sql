-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 21/03/2017 às 13:37
-- Versão do servidor: 5.7.17-0ubuntu0.16.04.1
-- Versão do PHP: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `Forum`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `dataUltimoPost` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `categoria`
--

INSERT INTO `categoria` (`id`, `titulo`, `descricao`, `dataUltimoPost`) VALUES
(1, 'jogos de luta 2d', 'aqui ficarÃ?Â£o todos os jogos de luta 2d', NULL),
(2, 'jogos de luta 3d', 'aqui ficarÃ?Â£o todos os jogos de luta 3d', NULL),
(3, 'jogos de rpg', 'jogos de rpg', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `criadorDoPost` int(11) NOT NULL,
  `conteudo` text NOT NULL,
  `data` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `topico`
--

CREATE TABLE `topico` (
  `id` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `criadorDoTopico` int(11) NOT NULL,
  `categoriaDoTopico` int(11) NOT NULL,
  `dataCriacaoDoTopico` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `visualizacoes` int(10) UNSIGNED DEFAULT NULL,
  `conteudo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `imagem` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `login`, `senha`, `dataNascimento`, `imagem`) VALUES
(1, 'eduardo', 'eduardo@algumacoisa', 'eduardo', '12@senha', '1993-06-19', NULL),
(2, 'fulano', 'fulano@hotmail.com', 'fulaninhpo', '12@senha', '1910-10-10', NULL);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_post` (`criadorDoPost`);

--
-- Índices de tabela `topico`
--
ALTER TABLE `topico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario` (`criadorDoTopico`),
  ADD KEY `fk_categoria` (`categoriaDoTopico`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `topico`
--
ALTER TABLE `topico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `fk_post` FOREIGN KEY (`criadorDoPost`) REFERENCES `usuario` (`id`);

--
-- Restrições para tabelas `topico`
--
ALTER TABLE `topico`
  ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`categoriaDoTopico`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`criadorDoTopico`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
