DROP DATABASE IF EXISTS proyecto_intermodular;
CREATE DATABASE proyecto_intermodular;
USE proyecto_intermodular;

CREATE TABLE continentes(
	id_continente int primary key auto_increment,
    nombre varchar(20),
    superficie varchar(20)
);

CREATE TABLE paises(
	id_pais int primary key auto_increment,
    nombre varchar(20),
    capital varchar(20),
    poblacion varchar(50),
    superficie varchar(20),
    id_continente int NOT NULL,
    foreign key (id_continente) references continentes (id_continente)
);

CREATE TABLE monumentos(
	id_monumentos int primary key auto_increment,
    nombre varchar(50),
    tipo varchar(50),
    descripcion varchar(200),
    patrimonio_unesco varchar(2),
    id_pais int NOT NULL,
    foreign key (id_pais) references paises (id_pais)
);

INSERT INTO continentes (nombre, superficie) VALUES
	('Europa', '10M km'),
    ('Asia', '44M km'),
    ('Africa', '30M km'),
    ('America', '42M km'),
    ('Oceania', '8M km');

INSERT INTO paises ( nombre, capital, poblacion, superficie, id_continente) VALUES
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

INSERT INTO monumentos (nombre, tipo, descripcion, patrimonio_unesco, id_pais) VALUES
	('Torre Eiffel', 'Torre', 'Símbolo emblemático de París y de Francia.', 'N', 1),
	('Palacio de Versalles', 'Palacio', 'Residencia real famosa por sus jardines y su historia.', 'S', 1),
	('Torre de Belém', 'Torre', 'Fortaleza costera portuguesa del siglo XVI.', 'S', 2),
	('Templo Senso-ji', 'Templo', 'Templo budista más antiguo de Tokio.', 'N', 3),
	('Gran Muralla China', 'Muralla', 'Estructura defensiva más larga del mundo.', 'S', 4),
	('Castillo de Elmina', 'Castillo', 'Fortaleza de origen portugués en Ghana, utilizada en el comercio de esclavos.', 'S', 5),
	('Mezquita de Hassan II', 'Mezquita', 'Una de las mezquitas más grandes del mundo, frente al mar.', 'N', 6),
	('Estatua de la Libertad', 'Escultura', 'Regalo de Francia, símbolo de libertad en Nueva York.', 'S', 7),
	('CN Tower', 'Torre', 'Una de las torres más altas del mundo, en Toronto.', 'N', 8),
	('Ópera de Sídney', 'Auditorio', 'Obra maestra arquitectónica a orillas del mar.', 'S', 9),
    ('Tongariro National Park', 'Parque Nacional', 'Primer parque nacional de Nueva Zelanda y uno de los más antiguos del mundo. Alberga volcanes activos y paisajes sagrados para los maoríes.', 'S', 10);
