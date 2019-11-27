create database fibra;
use fibra;

drop database fibra;

create table amplificadores(
	nombre varchar(60) not null,
    PinMin int(20) not null,
    PinMax int(20) not null,
    PoutMin int(20) not null,
    PoutMax int(20) not null,
    Ganancia int(20) not null,
    costo float not null
);

insert into amplificadores values
	('EDFA banda C',-25,0,0,0,24,37734),
    ('EDFA HY-21',-3,10,13,27,0,10169.2),
    ('Optico V8616Y',0,10,16,22,0,23200.5),
    ('Optico WDM',0,10,8,16,0,35800),
    ('Optico 16Ports',0,10,16,19,0,41500),
    ('Optico 16WDM',0,10,16,22,0,39800.5);

create table atenuadores(
	nombre varchar(50) not null,
    precio float not null,
    atenuacion int(10) not null
);

insert into atenuadores values 
	('Atenuadores Variables',201,30),
    ('Atenuado fijado',217,7),
    ('Atenuador fijado LC',55,1),
    ('Atenuador Fijo N',582.1,10),
    ('Atenuador Fijado LC',55,3),
    ('Atenuador Fijado SC',77,10),
    ('Atenuador Fijado SC',86,2);

create table conectores(
	conector varchar(75) not null,
    precio int(11) not null,
    descripcion varchar(1000) not null,
    tipo varchar(100) not null,
    PInsercion float not null
);

insert into conectores values
	('FC',10,'se usa en la transmisión de datos y en las telecomunicaciones','Monomodo/multimodo',0.3),
    ('FDDI',74,'se usa en la transmisión de datos y en las telecomunicaciones','Monomodo/multimodo',0.13),
    ('LC',45,'se utilizan en transmisiones de alta densidad de datos','Monomodo/multimodo',0.1),
    ('MT-Array',50,'se utilizan en transmisiones de alta densidad de datos','Monomodo/multimodo',0.22),
    ('SC',59,'se utilizan para la transmisión de datos.','Monomodo/multimodo',0.25),
    ('SC-Duplex',56,'se utilizan para la transmisión de datos (incluye cable 7m)','Monomodo/multimodo',0.25),
    ('ST',59,'se usa en redes de edificios y en sistemas de seguridad.','Monomodo/multimodo',0.25),
    ('MPO',2741,'Alta velocidad de telecom y redes de comunicación de datos','multimodo',0.25),
    ('MTX',1548,'Alta velocidad y densidad de datos y redes de comunicación de datos','multimodo',0.25);

create table empalmes(
	nombre varchar(40) not null,
    precio float not null,
    perdidas float not null
);

insert into empalmes values
	('Alineacion por nucleo',43500,0.04),
    ('Icoptiks V9MINI',83246,0.05),
    ('OP6481',68640.5,0.04),
    ('OP64816-M',74361.5,0.03),
    ('Fujikura Empalmadora',218620,0.02),
    ('RY-F600',40500,0.04),
    ('Sumitomo',139569,0.05);

create table producto(
	Fabricante varchar(100) not null,
    Tipo varchar(100) not null,
    WL int(50) not null,
    atenuacion int(75) not null,
    BW int(75) not null,
    LC int(75) not null,
    costo float not null,
    exterior bool not null,
    interior bool not null
);

insert into producto values
	('OFS','unimodo',1310,3,200,9,16,1,1),
    ('OFS','unimodo',1310,2,200,9,16,1,1),
    ('OFS','monomodo',1550,0,200,50,13,0,1),
    ('OFS','unimodo',1310,2,950,9,18,1,0),
    ('OFS','monomodo',1550,0,200,50,13,0,1),
    ('Sumitomo Electric','monomodo',1310,0,250,11,1.25,1,0),
    ('Sumitomo Electric','monomodo',1550,0,250,11,1.25,1,0),
    ('Corning','unimodo',1310,2,500,40,2.7,1,1),
    ('Corning','monomodo',1550,0,500,11,3,1,1);

create table rx(
	Nombre varchar(50) not null,
    precio float not null,
    PinMin float not null,
    PinMax float not null,
    WL float not null
);

insert into rx values
	('AFBR',611.52,-22,2,1550),
    ('S10',304.79,-5,-12,1550),
    ('AFBR-1555ARZ',489.26,-20,-1,1550),
    ('AFBR-2624ARZ',445.27,-4.5,2,1310),
    ('HFBR-2406z',483.44,-21.8,-16.8,1310),
    ('AFBR-2409z',522.2,-30,0,1310);

create table txoptic(
	Nombre varchar(70) not null,
    WL int(25) not null,
    Potencia int(25) not null,
    costo float not null
);

insert into txoptic values
	('MFT1310-15AG',1310,15,35000),
    ('MFT1550-EM-210',1550,10,20000),
    ('CATV',1310,10,20100),
    ('Modulación Directa',1530,6,30000),
    ('Modulación Externa',1550,10,37000),
    ('MFT1310-08AG',1310,14,18500),
    ('RAYVERT FOT1310',1310,15,12000),
    ('MFT1310-10AG',1310,10,25000),
    ('MFT1310-12AG',1310,12,27300),
    ('MFT1310-14AG',1310,14,30000);

select * from producto;