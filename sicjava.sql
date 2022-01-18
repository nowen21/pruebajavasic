-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 18-01-2022 a las 04:47:38
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sicjava`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dependencias`
--

DROP TABLE IF EXISTS `dependencias`;
CREATE TABLE IF NOT EXISTS `dependencias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='dependencias';

--
-- Volcado de datos para la tabla `dependencias`
--

INSERT INTO `dependencias` (`id`, `nombre`) VALUES
(1, 'Sistemas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador de la tabla',
  `docuemento` varchar(15) NOT NULL COMMENT 'documento de indentidad',
  `tipodocu_id` int(11) NOT NULL COMMENT 'tipo de decumento',
  `nombres` varchar(50) NOT NULL COMMENT 'nombres del empleado',
  `apellidos` varchar(50) NOT NULL COMMENT 'apellidos del emppleado',
  `emali` varchar(50) NOT NULL COMMENT 'correo electronico del empleado',
  `dependencia_id` int(11) NOT NULL COMMENT 'dependencia en la que labora el empleado',
  `fechingr` date NOT NULL COMMENT 'fecha de ingreso del empleado',
  PRIMARY KEY (`id`),
  KEY `tipodocu_id` (`tipodocu_id`),
  KEY `dependencia_id` (`dependencia_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='tabla que almecen los datos del empleado';

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `docuemento`, `tipodocu_id`, `nombres`, `apellidos`, `emali`, `dependencia_id`, `fechingr`) VALUES
(1, '17493705', 1, 'jose dumar', 'jimenez ruiz', 'nowen21@gmail.com', 1, '2022-01-17');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador de la tabla',
  `tipodocu_id` int(11) NOT NULL COMMENT 'tipo de identificacion',
  `document` int(11) NOT NULL COMMENT 'docuento de identidad',
  `nombres` varchar(50) NOT NULL COMMENT 'nombres',
  `apellidos` varchar(50) NOT NULL COMMENT 'apellidos',
  `telefono` int(15) NOT NULL COMMENT 'telefono',
  `dicreccion` varchar(100) NOT NULL COMMENT 'direccion',
  `email` varchar(50) NOT NULL COMMENT 'correo electronico',
  PRIMARY KEY (`id`),
  KEY `tipodocu_id` (`tipodocu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='talbla de las personas que realizan el trátramite';

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `tipodocu_id`, `document`, `nombres`, `apellidos`, `telefono`, `dicreccion`, `email`) VALUES
(1, 1, 17496705, 'jose dumar', 'jimenez ruiz', 31738099, 'casa', 'nowen21@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocus`
--

DROP TABLE IF EXISTS `tipodocus`;
CREATE TABLE IF NOT EXISTS `tipodocus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tipo` varchar(20) NOT NULL COMMENT 'tipo documento',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='tabla para administrar los tipos de documento';

--
-- Volcado de datos para la tabla `tipodocus`
--

INSERT INTO `tipodocus` (`id`, `tipo`) VALUES
(1, 'cc');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tramites`
--

DROP TABLE IF EXISTS `tramites`;
CREATE TABLE IF NOT EXISTS `tramites` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de la talba',
  `numecons` int(10) NOT NULL COMMENT 'numero de consecutivo',
  `fechredi` date NOT NULL COMMENT 'feche de redicacion',
  `nombtram` varchar(500) NOT NULL COMMENT 'nombre del tramite',
  `descripc` varchar(2000) NOT NULL COMMENT 'descripcion del tramite',
  `persona_id` int(11) NOT NULL COMMENT 'persona que radica',
  `empleado_id` int(11) NOT NULL COMMENT 'funcionario que recibe el tramite',
  PRIMARY KEY (`id`),
  KEY `persona_id` (`persona_id`),
  KEY `empleado_id` (`empleado_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='tabla que almacen los trámites de la entidad';

--
-- Volcado de datos para la tabla `tramites`
--

INSERT INTO `tramites` (`id`, `numecons`, `fechredi`, `nombtram`, `descripc`, `persona_id`, `empleado_id`) VALUES
(1, 1, '2022-01-17', 'tramite', 'tramite', 1, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`tipodocu_id`) REFERENCES `tipodocus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `empleados_ibfk_2` FOREIGN KEY (`dependencia_id`) REFERENCES `dependencias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`tipodocu_id`) REFERENCES `tipodocus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tramites`
--
ALTER TABLE `tramites`
  ADD CONSTRAINT `tramites_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `personas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `tramites_ibfk_2` FOREIGN KEY (`empleado_id`) REFERENCES `empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
