DROP TABLE IF EXISTS asignado;
DROP TABLE IF EXISTS cientificos;
DROP TABLE IF EXISTS proyectos;

DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;

CREATE TABLE IF NOT EXISTS cientificos (
	idcientificos INT AUTO_INCREMENT,
	dni VARCHAR(8) DEFAULT NULL, 
	nom_apels VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(idcientificos)
);

CREATE TABLE IF NOT EXISTS proyectos (
	id INT AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	horas INT DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS asignado (
	id INT AUTO_INCREMENT,
	cientifico INT,
	proyecto INT,
	PRIMARY KEY(id),
	KEY(cientifico, proyecto),
	CONSTRAINT proyectos_fk FOREIGN KEY (proyecto) REFERENCES proyectos (id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT cientificos_fk FOREIGN KEY (cientifico) REFERENCES cientificos (idcientificos) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(120) NOT NULL,
    username VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE roles(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) DEFAULT NULL
);

CREATE TABLE user_roles(
	user_id INT(20) NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE, 
    FOREIGN KEY (role_id) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users (username, password, email) VALUES 	
	('testUser','$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS','testUser@test.com');
    
INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);


INSERT INTO cientificos (dni, nom_apels) VALUES ('77789886', 'Carlos Garcia');
INSERT INTO cientificos (dni, nom_apels) VALUES ('33346772', 'Juan Perez');
INSERT INTO cientificos (dni, nom_apels) VALUES ('22212339' , 'Jesus Fernandez');

INSERT INTO proyectos (nombre, horas) VALUES ('Proyecto 1', 250);
INSERT INTO proyectos (nombre, horas) VALUES ('Proyecto 2', 1120);
INSERT INTO proyectos (nombre, horas) VALUES ('Proyecto 3', 340);

INSERT INTO asignado (cientifico, proyecto) VALUES (1, 1);
INSERT INTO asignado (cientifico, proyecto) VALUES (2, 3);
INSERT INTO asignado (cientifico, proyecto) VALUES (3, 2);