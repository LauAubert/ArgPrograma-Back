USE
ArgPrograma;

CREATE TABLE Experience
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    Titulo      VARCHAR(50),
    Imagen      VARCHAR(255),
    ano         VARCHAR(4),
    descripcion TEXT
);

CREATE TABLE Skill
(
    id     INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    Nivel  INTEGER,
    Tipo   VARCHAR(50)
);

CREATE TABLE Contacto
(
    id    INTEGER PRIMARY KEY AUTO_INCREMENT,
    icono VARCHAR(255),
    texto VARCHAR(100)
);

CREATE TABLE Aboutme
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    texto    TEXT,
    lenguaje VARCHAR(50)
);

CREATE TABLE Educacion
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    logo        VARCHAR(255),
    carrera     VARCHAR(100),
    ano         VARCHAR(4),
    descripcion TEXT
);
