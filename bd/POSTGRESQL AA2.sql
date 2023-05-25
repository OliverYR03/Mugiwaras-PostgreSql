
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


CREATE TABLE platos(
idPlato SERIAL NOT NULL ,
nombre VARCHAR(70) NOT NULL,
descripcion VARCHAR(70),
precio SMALLINT,
tipoPlato varchar(10),
imagen varchar(130)
	CONSTRAINT check_precio_length CHECK (precio >= 0 AND precio <= 999999999)
);

CREATE TABLE clientes(
idClientes SERIAL NOT NULL,
nombre VARCHAR(70),
direccion VARCHAR(70),
numero INTEGER,
correo VARCHAR(100),
tipoPago VARCHAR(30),
	CONSTRAINT check_numero_length CHECK (numero >= 0 AND numero <= 999999999)
);


CREATE TABLE ordenes(
idOrden SERIAL NOT NULL ,
idCliente INT NOT NULL,
fecha VARCHAR(15) NOT NULL,
platos VARCHAR(100),
total INT
);

CREATE TABLE opiniones(
idOpinion SERIAL NOT NULL ,
idPlato INT NOT NULL,
idCliente INT NOT NULL,
calificacion SMALLINT,
comentario VARCHAR(160),
fecha VARCHAR(15),
	CONSTRAINT check_calificacion_length CHECK (calificacion >= 0 AND calificacion <= 10)
);

CREATE TABLE metodopago(
idMetodo SERIAL NOT NULL ,
descripcion VARCHAR(70)
);

CREATE TABLE pago (
idPago SERIAL NOT NULL ,
idCliente INT NOT NULL,
idOrden INT NOT NULL,
metodo INT NOT NULL,
fecha INT NOT NULL
);

CREATE TABLE tipo_comprobante(
idTipoComp SERIAL NOT NULL ,
descripcion varchar(70)
);

CREATE TABLE comprobante(
idComprobante SERIAL NOT NULL ,
idPago INT NOT NULL,
idCliente INT NOT NULL,
fecha VARCHAR(100) NOT NULL,
tipo_comprobante INT NOT NULL,
monto varchar(15)
);

CREATE TABLE personal (
idPersonal SERIAL NOT NULL ,
nombre VARCHAR(40),
dni BIGINT,
cargo VARCHAR(20),
imagen VARCHAR(100),
	CONSTRAINT check_dni_length CHECK (dni >= 0 AND dni <= 999999999)
);



ALTER TABLE platos ADD CONSTRAINT idPlato PRIMARY KEY (idPlato);
ALTER TABLE clientes ADD CONSTRAINT idClientes PRIMARY KEY (idClientes);
ALTER TABLE ordenes ADD CONSTRAINT idOrden PRIMARY KEY (idOrden);
ALTER TABLE opiniones ADD CONSTRAINT idOpinion PRIMARY KEY (idOpinion);
ALTER TABLE metodopago ADD CONSTRAINT idMetodo PRIMARY KEY (idMetodo);
ALTER TABLE pago ADD CONSTRAINT idPago PRIMARY KEY(idPago);
ALTER TABLE tipo_comprobante ADD CONSTRAINT idTipoComp PRIMARY KEY (idTipoComp);
ALTER TABLE comprobante ADD CONSTRAINT idComprobante PRIMARY KEY (idComprobante);
ALTER TABLE personal ADD CONSTRAINT idPersonal PRIMARY KEY (idPersonal);




ALTER TABLE ordenes ADD FOREIGN KEY (idCliente) REFERENCES clientes (idClientes);
ALTER TABLE opiniones ADD FOREIGN KEY (idCliente) REFERENCES clientes (idClientes);
ALTER TABLE opiniones ADD FOREIGN KEY (idPlato) REFERENCES platos (idPlato);
ALTER TABLE pago ADD FOREIGN KEY (idCliente) REFERENCES clientes (idClientes);
ALTER TABLE pago ADD FOREIGN KEY (idOrden) REFERENCES ordenes (idOrden);
ALTER TABLE pago ADD FOREIGN KEY (metodo) REFERENCES metodopago (idMetodo);
ALTER TABLE comprobante ADD FOREIGN KEY (idPago) REFERENCES pago (idPago);
ALTER TABLE comprobante ADD FOREIGN KEY (idCliente) REFERENCES clientes (idClientes);
ALTER TABLE comprobante ADD FOREIGN KEY (tipo_comprobante) REFERENCES tipo_comprobante (idTipoComp);

INSERT INTO personal (idPersonal, nombre, dni, cargo) VALUES 
(1, 'Juan', 12345678, 'Chef'),
(2, 'Maria', 87654321, 'Asistente'),
(3, 'Pedro', 13579024, 'Cajero'),
(4, 'Lucia', 24680135, 'Mesera'),
(5, 'Carlos', 36985214, 'Marketing'),
(6, 'Oliver', 76868182, 'Tik toker');

INSERT INTO clientes (nombre, direccion, numero, correo, tipoPago) VALUES
('Juan Perez', 'Jirón Los Plateros 123, Rimac', 993456789, 'jperez@gmail.com', 'En efectivo'),
('Maria Rios', 'Av. El Sol 456, Cusco', 994567890, 'mrios@hotmail.com', 'Con tarjeta'),
('Pedro Alvarado', 'Calle Las Flores 789, Miraflores', 977654321, 'palvarado@gmail.com', 'Transferencia bancaria'),
('Luisa Gonzales', 'Jr. Lima 234, Trujillo', 998765432, 'lgonzales@yahoo.com', 'Con cheque'),
('Omar Sosa', 'Av. 28 de Julio 567, Lima', 966123456, 'ososa@hotmail.com', 'Con tarjeta');

INSERT INTO platos (nombre, descripcion, precio, tipoPlato, imagen) VALUES
 ('Nigiri Sushi','Nigiris','25','sushi','https://acortar.link/gu3DFC'),
 ('Maki sushi','Makis','25','sushi','https://acortar.link/3wHGXp'),
 ('Uramaki sushi','Naruto','25','sushi','https://acortar.link/kVuVEf'),
 ('Temaki sushi','Sanji sushi','25','sushi','https://acortar.link/JRj28p'),
 ('Sashimi','Luffy sushi','25','sushi','https://acortar.link/Ou1JDe');
	
 INSERT INTO opiniones (idPlato, idCliente, calificacion, comentario, fecha) VALUES
 ('3','1','5','Esta buenisima','25/04/03'),
 ('1','2','5','Feliz cum al tiktoker','27/04/03'),
 ('4','3','1','Nah Ramen goku está mejor','03/05/03'),
 ('2','4','3','Masomenos','01/05/03'),
 ('5','5','5','Esta buenisima','02/05/03');
 
 SELECT * FROM clientes;
 
 INSERT INTO ordenes (idCliente, fecha, platos, total) VALUES
 ('1','25/04/03','Sushi, Maki, Luffy, Sanji, Nigiri, Urumaki', '150'),
 ('2','25/04/03','Luffy, Sanji, Nigiri, Urumaki', '125'),
 ('3','26/04/03','Sushi, Maki, Nigiri, Urumaki', '130'),
 ('4','26/04/03','Sushi, Maki, Luffy', '75'),
 ('5','26/04/03','Sushi, Sanji, Nigiri, Urumaki', '100');