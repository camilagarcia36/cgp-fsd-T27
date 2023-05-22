
DROP table IF EXISTS reserva;
DROP table IF EXISTS investigadores;
DROP table IF EXISTS equipos;
DROP table IF EXISTS facultad;

DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;

create table facultad(
    id int auto_increment,
    nombre nvarchar(100),
    PRIMARY KEY (id)
);

create table investigadores(
    id int auto_increment,
    dni varchar(9),
    nom_apels nvarchar(255),
    facultad int,
    PRIMARY KEY (id, dni),
    KEY (dni),
    KEY facultadInv_idx (facultad),
    CONSTRAINT facultadInv_idx FOREIGN KEY (facultad) REFERENCES facultad (id)
);

create table equipos(
    id int auto_increment,
    numserie char(4),
    nombre nvarchar(100),
    facultad int,
    PRIMARY KEY (id, numserie),
	KEY (numserie),
    KEY facultadEq_idx (facultad),
    CONSTRAINT facultadEq_idx FOREIGN KEY (facultad) REFERENCES facultad (id)
);

create table reserva(
    id int auto_increment,
    investigador varchar(9),
    equipo char(4),
    comienzo datetime,
    fin datetime,
    PRIMARY KEY (id),
    KEY equipo_idx (equipo),
    CONSTRAINT equipo_idx FOREIGN KEY (equipo) REFERENCES equipos (numserie),
    KEY investigador_idx (investigador),
    CONSTRAINT investigador_idx FOREIGN KEY (investigador) REFERENCES investigadores (dni)
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

INSERT INTO facultad (nombre) VALUES ('Nombre de la Facultad');
INSERT INTO investigadores (dni, nom_apels, facultad)
VALUES ('12345678A', 'Nombre y apellidos del investigador', 1);
INSERT INTO equipos (numserie, nombre, facultad)
VALUES ('001', 'Nombre del equipo', 1);
INSERT INTO reserva (investigador, equipo, comienzo, fin)
VALUES ('12345678A', '001', '2023-05-02 10:00:00', '2023-05-02 12:00:00');
