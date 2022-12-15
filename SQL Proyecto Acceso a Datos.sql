use bd_artistas_canciones;

CREATE TABLE  ARTISTAS(
    ID int PRIMARY KEY AUTO_INCREMENT,
    Nombre Varchar(40) Not Null,
    Edad Int,
    Discografica Varchar(40),
    Nacionalidad Varchar(40),
    NExitos Int
);

CREATE TABLE  Canciones(
	ID int PRIMARY KEY AUTO_INCREMENT,
    Nombre Varchar(40) Not Null,
    Genero Varchar(40),
    Exito boolean,
    Colaboracion boolean,
    id_artista INT,
    
    FOREIGN KEY (id_artista) REFERENCES artistas(id)
);

SELECT id_artista FROM canciones WHERE id = 1;