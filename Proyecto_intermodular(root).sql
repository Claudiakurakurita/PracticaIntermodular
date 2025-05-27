-- Eliminar y crear base de datos
DROP DATABASE IF EXISTS proyecto_intermodular;
CREATE DATABASE proyecto_intermodular;
USE proyecto_intermodular;

-- Crear tabla de continentes
CREATE TABLE continentes (
    id_continente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    superficie VARCHAR(20)
);

-- Crear tabla de países (con id_continente correctamente definido)
CREATE TABLE paises (
    id_pais INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    capital VARCHAR(20),
    poblacion VARCHAR(50),
    superficie VARCHAR(20),
    id_continente INT,
    FOREIGN KEY (id_continente) REFERENCES continentes(id_continente)
);

-- Crear tabla de monumentos (con id_pais correctamente definido)
CREATE TABLE monumentos (
    id_monumentos INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    tipo VARCHAR(50),
    descripcion VARCHAR(200),
    patrimonio_unesco VARCHAR(2),
    id_pais INT,
    FOREIGN KEY (id_pais) REFERENCES paises(id_pais)
);

-- Insertar continentes
INSERT INTO continentes (nombre, superficie) VALUES
('Europa', '10M km'),
('Asia', '44M km'),
('Africa', '30M km'),
('America', '42M km'),
('Oceania', '8M km');

-- Insertar países (con ID de continente)
INSERT INTO paises (nombre, capital, poblacion, superficie, id_continente) VALUES
	('Francia', 'París', '68M', '551M km', 1),
	('Portugal', 'Lisboa', '10M', '92M km', 1),
	('Japón', 'Tokio', '128M', '378M km', 2),
	('China', 'Pekín', '1411M', '9597M km', 2),
	('Ghana', 'Accra', '34M', '239M km', 3),
	('Marruecos', 'Rabat', '37M', '447M km', 3),
	('Estados Unidos', 'Washington D.C.', '331M', '9834M km', 4),
	('Canadá', 'Ottawa', '38M', '9985M km', 4),
	('Australia', 'Canberra', '26M', '7692M km', 5),
	('Nueva Zelanda', 'Wellington', '5M', '268M km', 5);

-- Insertar monumentos
INSERT INTO monumentos (nombre, tipo, descripcion, patrimonio_unesco, id_pais) VALUES
	('Torre Eiffel', 'Torre', 'Símbolo emblemático de París y de Francia.', 'N', 1),
	('Palacio de Versalles', 'Palacio', 'Residencia real famosa por sus jardines y su historia.', 'S', 1),
	('Torre de Belém', 'Torre', 'Fortaleza costera portuguesa del siglo XVI.', 'S', 2),
	('Templo Senso-ji', 'Templo', 'Templo budista más antiguo de Tokio.', 'N', 3),
	('Gran Muralla China', 'Muralla', 'Estructura defensiva más larga del mundo.', 'S', 4),
	('Castillo de Elmina', 'Castillo', 'Fortaleza portuguesa, utilizada en el comercio de esclavos.', 'S', 5),
	('Mezquita de Hassan II', 'Mezquita', 'Una de las mezquitas más grandes del mundo, frente al mar.', 'N', 6),
	('Estatua de la Libertad', 'Escultura', 'Regalo de Francia, símbolo de libertad en Nueva York.', 'S', 7),
	('CN Tower', 'Torre', 'Una de las torres más altas del mundo, en Toronto.', 'N', 8),
	('Ópera de Sídney', 'Auditorio', 'Obra maestra arquitectónica a orillas del mar.', 'S', 9),
	('Tongariro National Park', 'Parque Nacional', 'Parque natural y sagrado para los maoríes, patrimonio mundial.', 'S', 10);
    
    ALTER TABLE continentes ADD fecha_creacion DATETIME;
ALTER TABLE paises ADD fecha_creacion DATETIME;
ALTER TABLE monumentos ADD fecha_creacion DATETIME;

/*Disparador para poner fecha de creación al insertar continentes*/
DELIMITER //
CREATE TRIGGER insertar_continentes 
BEFORE INSERT ON continentes
FOR EACH ROW 
BEGIN 
	SET NEW.fecha_creacion = NOW();
END;
//
DELIMITER ;

/*Disparador para poner fecha de creación al insertar paises*/
DELIMITER //
CREATE TRIGGER insertar_paises 
BEFORE INSERT ON paises
FOR EACH ROW 
BEGIN 
	SET NEW.fecha_creacion = NOW();
END;
//
DELIMITER ;

/*Disparador para poner fecha de creación al insertar monumentos*/
DELIMITER //
CREATE TRIGGER insertar_monumentos 
BEFORE INSERT ON monumentos
FOR EACH ROW 
BEGIN 
	SET NEW.fecha_creacion = NOW();
END;
//
DELIMITER ;

/*Añadimos el campo número de monumentos asociados a un país*/
ALTER TABLE paises ADD num_monumentos INT DEFAULT 0;

/*Disparador que incrementa el número de monumentos asociados a un país*/

DELIMITER //
CREATE TRIGGER incrementar_monumentos
AFTER INSERT ON monumentos
FOR EACH ROW 
BEGIN 
	UPDATE paises 
	SET num_monumentos = num_monumentos + 1
    WHERE id_pais = NEW.id_pais;   
END;
//
DELIMITER ;

/*Disparador que decrementa el número de monumentos asociados a un país*/

DELIMITER //
CREATE TRIGGER restar_monumentos
AFTER DELETE ON monumentos
FOR EACH ROW 
BEGIN 
	UPDATE paises 
	SET num_monumentos = num_monumentos - 1
    WHERE id_pais = OLD.id_pais;   
END;
//
DELIMITER ;