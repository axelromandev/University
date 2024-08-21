-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql5027.site4now.net
-- Tiempo de generación: 25-05-2020 a las 15:25:01
-- Versión del servidor: 5.6.26-log
-- Versión de PHP: 5.6.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car`
--

CREATE TABLE `car` (
  `id` int(11) NOT NULL,
  `company` varchar(25) DEFAULT NULL,
  `model` varchar(25) DEFAULT NULL,
  `serial_number` int(12) DEFAULT NULL,
  `color` int(12) DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  `price` int(20) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `horsepower` int(20) DEFAULT NULL,
  `car_registration` varchar(20) DEFAULT NULL,
  `mileage` int(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `car`
--

INSERT INTO `car` (`id`, `company`, `model`, `serial_number`, `color`, `state`, `price`, `country`, `horsepower`, `car_registration`, `mileage`) VALUES
(2, 'VOLKSWAGEN', 'VIRTUS', 19752, 2, 0, 300000, 'ESPAÑA', 110, 'QRT-25-90', 0),
(3, 'VOLKSWAGEN', 'VIRTUS', 15687, 3, 0, 350000, 'USA', 110, 'STW-92-01', 0),
(4, 'VOLKSWAGEN', 'VIRTUS', 15877, 4, 0, 325000, 'USA', 110, 'TRP-85-01', 0),
(5, 'VOLKSWAGEN', 'VIRTUS', 15481, 5, 0, 300000, 'USA', 110, 'MLS-15-98', 0),
(6, 'VOLKSWAGEN', 'VIRTUS', 16858, 6, 0, 300000, 'USA', 110, 'MPS-20-55', 0),
(7, 'VOLKSWAGEN', 'VIRTUS', 16574, 7, 0, 300000, 'USA', 110, 'MLS-01-07', 0),
(8, 'VOLKSWAGEN', 'VIRTUS', 16783, 3, 1, 250000, 'USA', 110, 'SDE-14-76', 81000),
(9, 'AUDI', 'TTS TFSI MY 20', 25784, 1, 0, 1099900, 'USA', 250, 'OPS-47-05', 0),
(10, 'AUDI', 'TTS TFSI MY 20', 26975, 2, 0, 1099908, 'USA', 250, 'OPS-75-02', 0),
(11, 'AUDI', 'TTS TFSI MY 20', 29754, 3, 0, 1100000, 'USA', 250, 'MLP-91-45', 0),
(12, 'AUDI', 'TTS TFSI MY 20', 28945, 4, 0, 1100500, 'USA', 250, 'SDP-47-98', 0),
(13, 'AUDI', 'TTS TFSI MY 20', 34284, 5, 0, 1200000, 'ESPAÑA', 250, 'LMN-24-11', 0),
(14, 'AUDI', 'TTS TFSI MY 20', 25746, 6, 0, 1150000, 'USA', 250, 'FDA-34-14', 0),
(15, 'AUDI', 'TTS TFSI MY 20', 29750, 7, 0, 1050000, 'USA', 250, 'OTP-24-39', 0),
(16, 'AUDI', 'TTS TFSI MY 20', 21234, 4, 2, 800000, 'USA', 250, 'AAB-12-95', 200000),
(17, 'NISSAN', 'VERSA PLATINUM CVT 20', 18975, 1, 0, 326200, 'USA', 118, 'NPS-45-32', 0),
(18, 'NISSAN', 'VERSA EXCLUSIVE CVT 20', 19465, 2, 0, 309000, 'USA', 118, 'LTY-12-54', 0),
(19, 'NISSAN', 'VERSA EXCLUSIVE CVT 20', 15462, 3, 0, 309000, 'USA', 118, 'RTV-10-63', 0),
(20, 'NISSAN', 'VERSA ADVANCE CVT 20', 14297, 4, 0, 289800, 'USA', 118, 'WMP-85-01', 0),
(21, 'NISSAN', 'VERSA ADVANCE CVT 20', 18740, 5, 0, 289800, 'USA', 118, 'WMP-85-01', 0),
(22, 'NISSAN', 'VERSA ADVANCE TM 20', 14513, 6, 0, 273200, 'USA', 118, 'SDT-41-32', 0),
(23, 'NISSAN', 'VERSA SENSE CVT 20', 12142, 7, 0, 260600, 'USA', 118, 'WPS-85-98', 0),
(24, 'NISSAN', 'VERSA SENSE TM 20', 12142, 2, 1, 195000, 'USA', 118, 'JPL-10-02', 74359),
(25, 'NISSAN', 'ALTIMA SR20', 14621, 1, 0, 478800, 'USA', 140, 'JPL-10-02', 0),
(26, 'NISSAN', 'ALTIMA SR20', 18745, 2, 0, 478800, 'USA', 140, 'TYU-14-20', 0),
(27, 'NISSAN', 'ALTIMA ADVANCE 20', 19746, 3, 0, 547600, 'USA', 140, 'KLP-85-21', 0),
(28, 'NISSAN', 'ALTIMA ADVANCE 20', 15471, 4, 0, 547600, 'USA', 140, 'POK-12-55', 0),
(29, 'NISSAN', 'ALTIMA ADVANCE 20', 16487, 5, 0, 548000, 'USA', 140, 'LPO-57-84', 0),
(30, 'NISSAN', 'ALTIMA ADVANCE 20', 18746, 6, 0, 550000, 'USA', 140, 'TVC-54-30', 0),
(31, 'NISSAN', 'ALTIMA ADVANCE 20', 19514, 7, 1, 450000, 'USA', 140, 'BNV-54-21', 90000),
(32, 'NISSAN', 'ALTIMA ADVANCE 20', 19754, 3, 2, 375000, 'ESPAÑA', 140, 'BNA-12-98', 154321),
(33, 'NISSAN', '370Z TOURING AT 20', 26451, 1, 0, 685800, 'USA', 350, 'TRG-54-21', 0),
(34, 'NISSAN', '370Z TOURING AT 20', 28745, 2, 0, 685800, 'USA', 350, 'TRP-98-55', 0),
(35, 'NISSAN', '370Z TOURING AT 20', 23462, 3, 0, 686000, 'USA', 350, 'LTR-10-24', 0),
(36, 'NISSAN', '370Z TOURING AT 20', 26412, 4, 0, 689000, 'ESPAÑA', 350, 'ETG-95-66', 0),
(37, 'NISSAN', '370Z TOURING AT 20', 29462, 5, 0, 689000, 'ESPAÑA', 350, 'ETG-25-01', 0),
(38, 'NISSAN', '370Z TOURING AT 20', 29548, 6, 0, 684000, 'USA', 350, 'LPT-24-10', 0),
(39, 'NISSAN', '370Z TOURING AT 20', 26458, 3, 1, 595000, 'USA', 350, 'RTG-12-94', 93465),
(40, 'NISSAN', 'LEAF S 19', 26412, 1, 0, 702000, 'USA', 241, 'TRF-51-21', 0),
(41, 'NISSAN', 'LEAF S 19', 25412, 2, 0, 702000, 'USA', 241, 'TWN-54-87', 0),
(42, 'NISSAN', 'LEAF SL 19', 22146, 3, 0, 775600, 'USA', 241, 'WLP-51-45', 0),
(43, 'NISSAN', 'LEAF SL 19', 21952, 4, 0, 775600, 'USA', 241, 'TVP-10-20', 0),
(44, 'NISSAN', 'LEAF SL BI-TONO 19', 23214, 5, 0, 780200, 'USA', 241, 'LST-54-45', 0),
(45, 'NISSAN', 'LEAF SL BI-TONO 19', 23648, 6, 0, 780200, 'USA', 241, 'RTS-04-29', 0),
(46, 'NISSAN', 'LEAF SL BI-TONO 19', 29589, 7, 0, 785000, 'USA', 241, 'TSL-01-95', 0),
(47, 'NISSAN', 'LEAF SL BI-TONO 19', 28954, 5, 1, 700000, 'CANADA', 241, 'TLC-20-60', 75910),
(48, 'NISSAN', 'LEAF SL BI-TONO 19', 28784, 1, 2, 650000, 'CANADA', 241, 'LTC-10-01', 395411);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sales`
--

CREATE TABLE `sales` (
  `id` int(11) DEFAULT NULL,
  `folio` int(11) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `model` varchar(25) DEFAULT NULL,
  `serial_number` int(12) DEFAULT NULL,
  `price_car` int(20) DEFAULT NULL,
  `additional` varchar(20) DEFAULT NULL,
  `price_additional` int(20) DEFAULT NULL,
  `price_total` int(20) DEFAULT NULL,
  `type_payment` int(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sales`
--

INSERT INTO `sales` (`id`, `folio`, `name`, `model`, `serial_number`, `price_car`, `additional`, `price_additional`, `price_total`, `type_payment`) VALUES
(1, 1111, 'Axel Roman', 'VIRTUS', 15482, 300000, NULL, NULL, 300000, 1),
(1003, 1477, 'bot', 'VERSA SENSE TM 20', 12142, 260600, 'NOT', 0, 260600, 1),
(1003, 1850, 'bot', 'VERSA SENSE TM 20', 12142, 260600, 'NOT', 10000, 270600, 2),
(1003, 2301, 'bot', 'VIRTUS', 14587, 299990, 'YES', 10000, 309990, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `rfc` varchar(13) DEFAULT NULL,
  `user` varchar(12) DEFAULT NULL,
  `pass` varchar(12) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
