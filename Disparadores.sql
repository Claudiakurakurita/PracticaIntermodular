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