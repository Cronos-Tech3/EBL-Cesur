create database startrek;
use startrek;

create TABLE Actores(
Codigo integer,
Nombre varchar(50) NOT NULL,
Fecha DATE NOT NULL,
Nacionalidad varchar(20) 
);

CREATE TABLE Personajes(
Codigo integer,
Nombre varchar(50) NOT NULL,
Raza varchar(20) NOT NULL,
Grado varchar(20) NOT NULL,
CodigoActor integer NOT NULL,
CodigoSuperior integer NULL
);

CREATE TABLE Planetas(
Codigo integer,
Galaxia varchar(50) NULL,
Nombre varchar(50) NOT NULL
);

CREATE TABLE Capitulos(
Temporada integer,
Orden integer,
Titulo varchar(50) NOT NULL,
Fecha date NOT NULL
);

CREATE TABLE Peliculas(
Codigo integer,
Titulo varchar(50) NOT NULL,
Director varchar(50) NOT NULL,
Anyo Date NOT NULL
);

CREATE TABLE PersonajesCapitulos(
CodigoPersonaje integer,
Temporada integer NOT NULL,
Orden integer NOT NULL
);

CREATE TABLE PersonajesPeliculas(
CodigoPersonaje integer,
CodigoPelicula integer 
);

CREATE TABLE Naves(
Codigo integer,
NTripulantes integer NULL,
Nombre varchar(50) NOT NULL
);

CREATE TABLE Visitas(
CodigoNave integer,
CodigoPlaneta integer,
Temporada integer NOT NULL,
Orden integer NOT NULL
);

-- -----------------------------

alter table actores modify codigo int auto_increment primary key;
alter table personajes modify codigo int auto_increment primary key;
alter table planetas modify codigo int auto_increment primary key;
alter table peliculas modify codigo int auto_increment primary key;
alter table naves modify codigo int auto_increment primary key;

alter table actores modify nacionalidad varchar(20) default "EEUU"; 

alter table peliculas modify anyo date null;

alter table naves modify nTripulantes int unsigned;
ALTER TABLE naves ADD CONSTRAINT CHnave CHECK (nTripulantes < 80);

alter table planetas modify galaxia enum ('Via Láctea','Andrómeda','Sombrero');

alter table personajes add constraint FKpersAct foreign key (CodigoActor) REFERENCES Actores(Codigo);
alter table personajes add constraint FKpersPer foreign key  (CodigoSuperior) REFERENCES Personajes(Codigo);

alter table capitulos add constraint PKcapitulos primary key (Temporada, Orden);

alter table PersonajesCapitulos add constraint PKpersCap primary key (CodigoPersonaje);
alter table PersonajesCapitulos add constraint FKpersCap foreign key (Temporada,Orden) REFERENCES Capitulos(Temporada,Orden);

alter table PersonajesPeliculas add constraint FKpersPel1 foreign key (CodigoPersonaje) REFERENCES Personajes(Codigo);
alter table PersonajesPeliculas add constraint FKpersPel2 foreign key (CodigoPelicula) REFERENCES Peliculas(Codigo);

alter table Visitas add constraint FKvisita1 foreign key (CodigoNave) REFERENCES Naves(Codigo);
alter table Visitas add constraint FKvisita2 foreign key (CodigoPlaneta) REFERENCES Planetas(Codigo);
alter table Visitas add constraint FKvisita3 foreign key (Temporada,Orden) REFERENCES Capitulos(Temporada,Orden);


ALTER TABLE Personajes ADD Ciudad varchar(50);
ALTER TABLE Personajes ADD FNacim date;
ALTER TABLE Personajes ADD Planeta integer REFERENCES Planetas(Codigo);
ALTER TABLE Personajes ADD FUltCombate date;
ALTER TABLE Personajes ADD Mentor varchar(50);
ALTER TABLE Personajes ADD FechaGrado date;


CREATE TABLE Lanzaderas(
CodigoNave integer,
Numero integer,
Personas integer,
PRIMARY KEY(CodigoNave,Numero),
FOREIGN KEY(CodigoNave) REFERENCES Naves(Codigo)
)









