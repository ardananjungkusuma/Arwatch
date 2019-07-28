-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 28, 2019 at 07:15 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arwatch_service`
--

-- --------------------------------------------------------

--
-- Table structure for table `apaya`
--

CREATE TABLE `apaya` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `desc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apaya`
--

INSERT INTO `apaya` (`id`, `name`, `price`, `imgUrl`, `desc`) VALUES
(1, 'Casio G-Shock Mudmaster Master GG-1000-1A3ER', '210.00', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100019778/main/medium/gg-1000-1a3er-1509976747-7817.jpg', 'Casio G-Shock Mudmaster Master Of G GG-1000-1A3ER is an amazing and special Gents watch. Material of the case is Stainless Steel and Resin while the dial colour is LCD. In regards to the water resistance, the watch has got a resistancy up to 200 metres. This means it can be used for professional marine activity, skin diving and high impact water sports, but not deep sea or mixed gas diving. The watch is shipped with an original box and a guarantee from the manufacturer'),
(2, 'asdasddas', '2', 'sdsaads', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apaya`
--
ALTER TABLE `apaya`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
