-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2016 at 03:18 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop_manager`
--
CREATE DATABASE IF NOT EXISTS `shop_manager` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `shop_manager`;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `idEmployee` int(11) NOT NULL,
  `Username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Role` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Sex` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DateOfBirth` date NOT NULL,
  `Image` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`idEmployee`, `Username`, `Password`, `Name`, `Role`, `Email`, `Sex`, `Phone`, `DateOfBirth`, `Image`) VALUES
(1, 'lechinguyen', '123456', 'Lê Chí Nguyên', 'quanly', 'endlesslovefor123@gmail.com', 'Nam', '01687491748', '1993-06-18', NULL),
(2, 'nguyenchipu', '123456', 'Nguyễn Chi Pu', 'thungan', 'cristineronaldo@gmail.com', 'Nữ', '01687491748', '1993-11-23', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`idEmployee`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `idEmployee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
