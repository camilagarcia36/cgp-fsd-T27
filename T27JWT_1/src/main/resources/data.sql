DROP TABLE IF EXISTS suministra;

DROP TABLE IF EXISTS piezas;

DROP TABLE IF EXISTS proveedores;

DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;


CREATE TABLE IF NOT EXISTS piezas (
	codigo INT AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS proveedores (
	id INT AUTO_INCREMENT,
	nombre VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS suministra (
	id INT AUTO_INCREMENT,
	codigopieza INT,
	idproveedor INT,
	precio INT DEFAULT NULL,
	PRIMARY KEY(id),
	KEY(codigopieza, idproveedor),
	CONSTRAINT piezas_fk FOREIGN KEY (codigopieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT proveedores_fk FOREIGN KEY (idproveedor) REFERENCES proveedores (id) ON DELETE CASCADE ON UPDATE CASCADE
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



INSERT INTO piezas (nombre) VALUES ('Valvula');
INSERT INTO piezas (nombre) VALUES ('Filtro');
INSERT INTO piezas (nombre) VALUES ('Bomba');

INSERT INTO proveedores (nombre) VALUES ('Proveedor 1');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 2');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 3');

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (1, 1, 10);

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (2, 2, 15);

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (3, 3, 5);