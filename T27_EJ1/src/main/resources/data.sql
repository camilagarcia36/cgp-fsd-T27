DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS suministra;
DROP TABLE IF EXISTS piezas;

DROP TABLE IF EXISTS proveedores;

CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO usuario (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

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


INSERT INTO piezas (nombre) VALUES ('Valvula');
INSERT INTO piezas (nombre) VALUES ('Filtro');
INSERT INTO piezas (nombre) VALUES ('Bomba');

INSERT INTO proveedores (nombre) VALUES ('Proveedor 1');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 2');
INSERT INTO proveedores (nombre) VALUES ('Proveedor 3');

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (1, 1, 10);

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (2, 2, 15);

INSERT INTO suministra (codigopieza, idproveedor, precio) VALUES (3, 3, 5);