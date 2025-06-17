use animales;
describe perro2;
select * from perro2;

insert into perro2 
values (200, "goofy",4, 23.2,'2025-1-9');

insert into perro2 
values (200, "goofy",4, 23.2,'2025-1-9');

insert into perro2 (id, nombre, edad, peso, fechaConsulta)
values (201, "goofy",4, 23.2,'2025-1-9');

insert into perro2 (nombre, edad, peso, fechaConsulta)
values ("goofy",4, 23.2,'2025-1-9');

insert into perro2 (fechaConsulta, peso, nombre, edad)
values (			'2025-1-9',		23.2,"goofy2",3);

insert into perro2 
values (null, "goofysin",4, 23.2,'2025-1-9');

insert into perro2 
values (default, "goofyDEF",4, 23.2,'2025-1-9');

insert into perro2 
values (default, "goofySOLO",NULL, NULL,null); 

insert into perro2 (nombre)
values ("goofySOLO2"); 

insert into perro2 (nombre, id)
values ("goofySOLO2", 300); 

insert into perro2 (peso)
values (56.561897),
		(45.325); 
        
set sql_safe_updates=0;

update perro2
set fechaConsulta="2026-1-1";

update perro2
set edad = 5
where nombre="ghd";

update perro2
set edad = 10
where peso < 10;

update perro2
set edad = 15, nombre = "perrito"
where peso > 20
	and edad =4 ;

update perro2
set edad = edad+1;

delete from perro2
where id >250;

delete from perro2;
select * from perro2;