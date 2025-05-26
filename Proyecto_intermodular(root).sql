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
    foreign key (id_continente) references continentes (id_continente)
);

CREATE TABLE monumentos(
	id_monumentos int primary key auto_increment,
    nombre varchar(50),
    tipo varchar(50),
    descripcion varchar(200),
    patrimonio_unesco varchar(2),
    foreign key (id_pais) references paises (id_pais)
);

INSERT INTO continentes (nombre, superficie) VALUES
	('Europa', '10M km'),
    ('Asia', '44M km'),
    ('Africa', '30M km'),
    ('America', '42M km'),
    ('Oceania', '8M km');

INSERT INTO paises ( nombre, capital, poblacion, superficie) VALUES
	('Francia', 'París', '68M', '551M km'),
	('Portugal', 'Lisboa', '10M', '92M km'),
	('Japón', 'Tokio', '128M', '378M km'),
	('China', 'Pekín', '1411M', '9597M km'),
	('Ghana', 'Accra', '34M', '239M km'),
	('Marruecos', 'Rabat', '37M', '447M km'),
	('Estados Unidos', 'Washington D.C.', '331M', '9834M km'),
	('Canadá', 'Ottawa', '38M', '9985M km'),
	('Australia', 'Canberra', '26M', '7692M km'),
	('Nueva Zelanda', 'Wellington', '5M', '268M km');



