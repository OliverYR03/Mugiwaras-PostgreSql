
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--
CREATE DATABASE mugiwaras2;

USE mugiwaras2;

CREATE TABLE platos(
idplato INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(70) NOT NULL,
descripcion VARCHAR(70),
precio INT(5),
tipoplato varchar(10),
imagen varchar(130)
);

CREATE TABLE clientes(
idclientes INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(70),
direccion VARCHAR(70),
numero INT(9),
correo VARCHAR(100),
tipopago VARCHAR(30)
);


CREATE TABLE ordenes(
idorden INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
idcliente INT NOT NULL,
fecha VARCHAR(15) NOT NULL,
platos VARCHAR(100),
total INT(10)
);


CREATE TABLE opiniones(
idopinion INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
idplato INT NOT NULL,
idcliente INT NOT NULL,
calificacion INT(1),
comentario VARCHAR(160),
fecha VARCHAR(15)
);

CREATE TABLE metodopago(
idmetodo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(70)
);

CREATE TABLE pago (
idpago INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
idcliente INT NOT NULL,
idorden INT NOT NULL,
metodo INT NOT NULL,
fecha INT NOT NULL
);

CREATE TABLE tipo_comprobante(
idtipocomp INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion varchar(70)
);

CREATE TABLE comprobante(
idcomprobante INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
idpago INT NOT NULL,
idcliente INT NOT NULL,
fecha VARCHAR(100) NOT NULL,
tipo_comprobante INT NOT NULL,
monto varchar(15)
);

CREATE TABLE personal (
idpersonal INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(40),
dni INT(9),
cargo VARCHAR(20),
imagen VARCHAR(100)
);


ALTER TABLE ordenes ADD FOREIGN KEY (idcliente) REFERENCES clientes (idclientes);
ALTER TABLE opiniones ADD FOREIGN KEY (idcliente) REFERENCES clientes (idclientes);
ALTER TABLE opiniones ADD FOREIGN KEY (idplato) REFERENCES platos (idplato);
ALTER TABLE pago ADD FOREIGN KEY (idcliente) REFERENCES clientes (idclientes);
ALTER TABLE pago ADD FOREIGN KEY (idorden) REFERENCES ordenes (idorden);
ALTER TABLE pago ADD FOREIGN KEY (metodo) REFERENCES metodopago (idmetodo);
ALTER TABLE comprobante ADD FOREIGN KEY (idpago) REFERENCES pago (idpago);
ALTER TABLE comprobante ADD FOREIGN KEY (idcliente) REFERENCES clientes (idclientes);
ALTER TABLE comprobante ADD FOREIGN KEY (tipo_comprobante) REFERENCES tipo_comprobante (idtipocomp);

INSERT INTO personal (idpersonal, nombre, dni, cargo) VALUES 
(1, 'Juan', 12345678, 'Chef'),
(2, 'Maria', 87654321, 'Asistente'),
(3, 'Pedro', 13579024, 'Cajero'),
(4, 'Lucia', 24680135, 'Mesera'),
(5, 'Carlos', 36985214, 'Marketing'),
(6, 'Oliver', 76868182, 'Tik toker');

INSERT INTO clientes (nombre, direccion, numero, correo, tipopago) VALUES
('Juan Perez', 'Jirón Los Plateros 123, Rimac', 993456789, 'jperez@gmail.com', 'En efectivo'),
('Maria Rios', 'Av. El Sol 456, Cusco', 994567890, 'mrios@hotmail.com', 'Con tarjeta'),
('Pedro Alvarado', 'Calle Las Flores 789, Miraflores', 977654321, 'palvarado@gmail.com', 'Transferencia bancaria'),
('Luisa Gonzales', 'Jr. Lima 234, Trujillo', 998765432, 'lgonzales@yahoo.com', 'Con cheque'),
('Omar Sosa', 'Av. 28 de Julio 567, Lima', 966123456, 'ososa@hotmail.com', 'Con tarjeta');

INSERT INTO platos (nombre, descripcion, precio, tipoplato, imagen) VALUES
 ('Nigiri Sushi','Nigiris','25','sushi','https://acortar.link/gu3DFC'),
 ('Maki sushi','Makis','25','sushi','https://acortar.link/3wHGXp'),
 ('Uramaki sushi','Naruto','25','sushi','https://acortar.link/kVuVEf'),
 ('Temaki sushi','Sanji sushi','25','sushi','https://acortar.link/JRj28p'),
 ('Sashimi','Luffy sushi','25','sushi','https://acortar.link/Ou1JDe');
	
 INSERT INTO opiniones (idplato, idcliente, calificacion, comentario, fecha) VALUES
 ('3','1','5','Esta buenisima','25/04/03'),
 ('1','2','5','Feliz cum al tiktoker','27/04/03'),
 ('4','3','1','Nah Ramen goku está mejor','03/05/03'),
 ('2','4','3','Masomenos','01/05/03'),
 ('5','5','5','Esta buenisima','02/05/03');
 
 SELECT * FROM clientes;
 
 INSERT INTO ordenes (idcliente, fecha, platos, total) VALUES
 ('1','25/04/03','Sushi, Maki, Luffy, Sanji, Nigiri, Urumaki', '150'),
 ('2','25/04/03','Luffy, Sanji, Nigiri, Urumaki', '125'),
 ('3','26/04/03','Sushi, Maki, Nigiri, Urumaki', '130'),
 ('4','26/04/03','Sushi, Maki, Luffy', '75'),
 ('5','26/04/03','Sushi, Sanji, Nigiri, Urumaki', '100');