-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 28, 2019 at 05:59 PM
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
(1, 'Bulova Precisionist GRAMMYs ', '473', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100010327/main/xlarge/98b293-1486137091-2795.jpg', ''),
(2, 'Raymond Weil Maestro Beatles', '796', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100012355/main/medium/rw_maestro_2237-st-beat2_pkt_white_rvb_300dpi_forweb-1493898486-4507.jpg', ''),
(3, 'Hamilton Ventura H24595331', '1,800', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100032426/main/xlarge/H24595331_VenturaSkeleton_Soldier.jpg', ''),
(4, 'Ingersoll The New Haven Disney ', '350', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100004136/main/xlarge/id01101-1472569259-7418.jpg', ''),
(5, 'Davosa Argonautic Bronze ', '1,095', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100029908/main/xlarge/16158155-bronze-RGB1.jpg', ''),
(6, 'Police Justice League', '230', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100018720/main/xlarge/14536jq02p-1506079722-3267.jpg', ''),
(7, 'Festina Watch F20453/1', '386', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100033046/main/xlarge/f20453_1.jpg', ''),
(8, 'Raymond Weil Freelancer Bowie', '1,116', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100017949/main/xlarge/rw_freelancer_2731-stc-bow01_pkt_white_rvb_72dpi_forweb-1507814211-8289.jpg', ''),
(9, 'Davosa Pontus 16050066', '895', 'https://d1rkccsb0jf1bk.cloudfront.net/products/100004742/main/xlarge/pontus-16050066-rgb-1472811372-3322.jpg', '');

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
