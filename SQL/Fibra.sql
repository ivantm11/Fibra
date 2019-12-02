create database fibra;
use fibra;

drop database fibra;
drop table amplificadores;

create table amplificadores( /*check*/
	IdAmplificador  int (10),
	nombre varchar(60) not null,
    PinMin int(20) not null,
    PinMax int(20) not null,
    PoutMin int(20) not null,
    PoutMax int(20) not null,
    Ganancia int(20) not null,
    costo float not null
);

insert into amplificadores values
	('1','EDFA banda C',-25,0,0,0,24,37734),
    ('2','EDFA HY-21',-3,10,13,27,0,10169.2),
    ('3','Optico V8616Y',0,10,16,22,0,23200.5),
    ('4','Optico WDM',0,10,8,16,0,35800),
    ('5','Optico 16Ports',0,10,16,19,0,41500),
    ('6','Optico 16WDM',0,10,16,22,0,39800.5);

drop table atenuadores;

create table atenuadores( /*chjeck*/
	IdAtenuadores int(10),
	nombre varchar(50) not null,
    precio float not null,
    atenuacion int(10) not null
);

insert into atenuadores values 
	('1','Atenuadores Variables',201,30),
    ('2','Atenuado fijado',217,7),
    ('3','Atenuador fijado LC',55,1),
    ('4','Atenuador Fijo N',582.1,10),
    ('5','Atenuador Fijado LC',55,3),
    ('6','Atenuador Fijado SC',77,10),
    ('7','Atenuador Fijado SC',86,2);

drop table conectores;

create table conectores( /*check*/
	idConector int (10),
	conector varchar(75) not null,
    precio int(11) not null,
    descripcion varchar(1000) not null,
    tipo varchar(100) not null,
    PInsercion float not null
);

insert into conectores values
	('1','FC',10,'se usa en la transmisión de datos y en las telecomunicaciones','Monomodo/multimodo',0.3),
    ('2','FDDI',74,'se usa en la transmisión de datos y en las telecomunicaciones','Monomodo/multimodo',0.13),
    ('3','LC',45,'se utilizan en transmisiones de alta densidad de datos','Monomodo/multimodo',0.1),
    ('4','MT-Array',50,'se utilizan en transmisiones de alta densidad de datos','Monomodo/multimodo',0.22),
    ('5','SC',59,'se utilizan para la transmisión de datos.','Monomodo/multimodo',0.25),
    ('6','SC-Duplex',56,'se utilizan para la transmisión de datos (incluye cable 7m)','Monomodo/multimodo',0.25),
    ('7','ST',59,'se usa en redes de edificios y en sistemas de seguridad.','Monomodo/multimodo',0.25),
    ('8','MPO',2741,'Alta velocidad de telecom y redes de comunicación de datos','multimodo',0.25),
    ('9','MTX',1548,'Alta velocidad y densidad de datos y redes de comunicación de datos','multimodo',0.25);

drop table empalmes;

create table empalmes( /*check*/
	IdEmpalmes int (10),
	nombre varchar(40) not null,
    precio float not null,
    perdidas float not null
);

insert into empalmes values
	('1','Alineacion por nucleo',43500,0.04),
    ('2','Icoptiks V9MINI',83246,0.05),
    ('3','OP6481',68640.5,0.04),
    ('4','OP64816-M',74361.5,0.03),
    ('5','Fujikura Empalmadora',218620,0.02),
    ('6','RY-F600',40500,0.04),
    ('7','Sumitomo',139569,0.05);

drop table producto;

create table producto( /*check*/
	IdProducto int (10),
	Fabricante varchar(100) not null,
    Tipo varchar(100) not null,
    WL int(50) not null,
    atenuacion float not null,
    BW int(75) not null,
    LC int(75) not null,
    costo float not null,
    exterior bool not null,
    interior bool not null
);

insert into producto values
	('1','OFS3-200','unimodo',1310,3,200,900,16,1,1),
    ('2','OFS2-200','unimodo',1310,2,200,900,16,1,1),
    ('3','OFS0-200','monomodo',1550,0.3,200,500,13,0,1),
    ('4','OFS2-950','unimodo',1310,2,950,90,18,1,0),
    ('5','OFS0-200','monomodo',1550,0,200,500,13,0,1),
    ('6','Sumitomo Electric 1310','monomodo',1310,0.3,250,110,1.25,1,0),
    ('7','Sumitomo Electric 1550','monomodo',1550,0.3,250,110,1.25,1,0),
    ('8','Corning 1310','unimodo',1310,2,500,40,2.7,1,1),
    ('9','Corning 1310','monomodo',1550,0.3,500,11,3,1,1);

drop table rx;

create table rx(  /*check receptores*/
	IdReceptor int (10),
	Nombre varchar(50) not null,
    precio float not null,
    PinMin float not null,
    PinMax float not null,
    WL float not null
);

insert into rx values
	('1','AFBR',611.52,-22,2,1550),
    ('2','S10',304.79,-12,-5,1550),
    ('3','AFBR-1555ARZ',489.26,-20,-1,1550),
    ('4','AFBR-2624ARZ',445.27,-4.5,2,1310),
    ('5','HFBR-2406z',483.44,-21.8,-16.8,1310),
    ('6','AFBR-2409z',522.2,-30,0,1310);


drop table txoptic;

create table txoptic( /*TransmisorOptico*/
	IdTxoptic int (10),
	Nombre varchar(70) not null,
    WL int(25) not null,
    Potencia int(25) not null,
    costo float not null
);

insert into txoptic values
	('1','MFT1310-15AG',1310,15,35000),
    ('2','MFT1550-EM-210',1550,10,20000),
    ('3','CATV',1310,10,20100),
    ('4','Modulación Directa',1530,6,30000),
    ('5','Modulación Externa',1550,10,37000),
    ('6','MFT1310-08AG',1310,14,18500),
    ('7','RAYVERT FOT1310',1310,15,12000),
    ('8','MFT1310-10AG',1310,10,25000),
    ('9','MFT1310-12AG',1310,12,27300),
    ('10','MFT1310-14AG',1310,14,30000);

select * from producto where WL=1310;
select * from producto where WL=1550;

select * from rx where WL=1310;
select * from rx where WL=1550;

select * from txoptic where WL=1310;
select * from txoptic where WL=1550;


select * from amplificadores order by costo;/*-- ivan*/
select * from atenuadores order by precio;/*----ivan */
select * from conectores order by precio;/*  --ivan*/

select * from empalmes order by precio; /* yo*/
select precio * .05  as Precio_percent from empalmes;

select * from producto order by costo;
select * from rx order by precio 
select * from txoptic order by costo;


select * from producto where WL=1310 order by costo;
select * from producto where WL=1550 order by costo;

select * from rx where WL=1310 order by precio;
select * from rx where WL=1550 order by precio;

select * from txoptic where WL=1310 order by costo;
select * from txoptic where WL=1550 order by costo;



