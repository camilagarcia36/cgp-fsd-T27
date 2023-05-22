DROP TABLE IF EXISTS venta;
DROP TABLE IF EXISTS cajeros;
DROP TABLE IF EXISTS productos;
DROP TABLE IF EXISTS maquinas_registradoras;


DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;

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


CREATE TABLE IF NOT EXISTS cajeros (
  id INT AUTO_INCREMENT,
  nombre VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS productos (
  codigoproducto INT AUTO_INCREMENT,
  nombre VARCHAR(100) DEFAULT NULL,
  precio INT DEFAULT NULL, 
  PRIMARY KEY(codigoproducto)
);

CREATE TABLE IF NOT EXISTS maquinas_registradoras (
  codigocaja INT AUTO_INCREMENT,
  piso INT DEFAULT NULL, 
  PRIMARY KEY(codigocaja)
);

CREATE TABLE IF NOT EXISTS venta (
  id INT AUTO_INCREMENT,
  cajero INT,
  maquina INT,
  producto INT,
  PRIMARY KEY (id),
  KEY(cajero, maquina, producto),
  CONSTRAINT cajero_fk FOREIGN KEY (cajero) REFERENCES cajeros (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT maquina_fk FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigocaja) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT productos_fk FOREIGN KEY (producto) REFERENCES productos (codigoproducto) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cajeros (nombre) VALUES ('Juan');
INSERT INTO cajeros (nombre) VALUES ('Maria Rodriguez');
INSERT INTO cajeros (nombre) VALUES ('Carlos Garcia');

INSERT INTO productos (nombre, precio) VALUES ('Coca-Cola', 50);
INSERT INTO productos (nombre, precio) VALUES ('Pepsi', 45);
INSERT INTO productos (nombre, precio) VALUES ('Agua mineral', 20);

INSERT INTO maquinas_registradoras (piso) VALUES (1);
INSERT INTO maquinas_registradoras (piso) VALUES (2);
INSERT INTO maquinas_registradoras (piso) VALUES (3);

INSERT INTO venta (cajero, maquina, producto) VALUES (1, 1, 1);
INSERT INTO venta (cajero, maquina, producto) VALUES (2, 1, 2);
INSERT INTO venta (cajero, maquina, producto) VALUES (3, 2, 3);
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