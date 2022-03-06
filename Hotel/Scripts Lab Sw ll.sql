drop table HOTELHABT;
drop table HABITACION;
drop table HOTEL;
drop table ADMINISTRADOR;

CREATE TABLE ADMINISTRADOR(
	adm_usuario varchar(50),
    adm_clave varchar(50),
    constraint primary key(adm_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE HOTEL(
	hotel_id int not null auto_increment,
    hotel_nombre varchar(50),
    hotel_direccion varchar(50),
    hotel_ciudad varchar(50),
    hotel_telefono varchar(15),
    hotel_foto varchar(100),
    adm_usuario varchar(50),
    constraint primary key(hotel_id),
    constraint foreign key(adm_usuario) references administrador(adm_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE HABITACION(
    habt_id int not null auto_increment,
    habt_descripcion varchar(50) not null,
    habt_precio int not null,
    habt_tipo varchar(15) not null,
    habt_foto varchar(100),
    hotel_id int,
    
    constraint primary key(habt_id,hotel_id),
    constraint check(habt_tipo in ('INDIVIDUAL','MATRIMONIAL','GRUPAL')),
    constraint foreign key(hotel_id) references hotel(hotel_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE HOTELHABT(
	hotel_id int,
    habt_id int,
    dia varchar(9),
    constraint primary key(hotel_id,habt_id,dia),
    constraint foreign key(hotel_id) references hotel(hotel_id),
    constraint foreign key(habt_id) references habitacion(habt_id),
    constraint check(dia in ('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO','DOMINGO'))
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into administrador values ('customer',123456);
insert into hotel values (null,'Crouse','carrera 11','Popayan',6025984454,'d:\\Users\\AIM\\Documents\\proyectos\\Hotel\\recursos\\H1.jpg','customer');
insert into hotel values (null,'Narnia','carrera 15','Popayan',602854210,'d:\\Users\\AIM\\Documents\\proyectos\\Hotel\\recursos\\H2.jpg','customer');
insert into hotel values (null,'Cesar','carrera 22','Popayan',602365814,'d:\Users\\AIM\\Documents\\proyectos\\Hotel\\recursos\\H3.jpg','customer');
insert into hotel values (null,'Colonia','carrera 32','Popayan',602987452,'d:\Users\\AIM\\Documents\\proyectos\\Hotel\\recursos\\H4.jpg','customer');
insert into habitacion values(null,'habitacion individual normal',35000,'INDIVIDUAL','C:\Users\AIM\Documents\RoomReserve\Hotel\recursos\HB1',1);
insert into habitacion values(null,'habitacion matrimonial normal',45000,'MATRIMONIAL','C:\Users\AIM\Documents\RoomReserve\Hotel\recursos\HB1',2);
insert into habitacion values(null,'habitacion individual junior',40000,'INDIVIDUAL','C:\Users\AIM\Documents\RoomReserve\Hotel\recursos\HB1',1);
insert into habitacion values(null,'habitacion matrimonial premium',75000,'MATRIMONIAL','C:\Users\AIM\Documents\RoomReserve\Hotel\recursos\HB1',2);
insert into habitacion values(null,'habitacion matrimonial junior',55000,'MATRIMONIAL','C:\Users\AIM\Documents\RoomReserve\Hotel\recursos\HB1',2);
insert into habitacion values(null,'habitacion grupal normal',150000,'GRUPAL','d:\\Users\\AIM\Documents\\proyectos\\Hotel\\recursos\\HB5.jpg',1);
insert into habitacion values(null,'habitacion matrimonial normal',35000,'MATRIMONIAL','d:\\Users\\AIM\\Documents\\proyectos\\Hotel\\recursos\\HB6.jpg',1);
insert into habitacion values(null,'habitacion individual normal',35000,'INDIVIDUAL','d:\\Users\\AIM\\Documents\\proyectos\\Hotel\\recursos\\HB7.jpg',1);
insert into hotelhabt values(1,1,'LUNES');
insert into hotelhabt values(1,3,'MARTES');
insert into hotelhabt values(1,3,'LUNES');
insert into hotelhabt values(1,1,'MIERCOLES');
insert into hotelhabt values(1,6,'LUNES');
insert into hotelhabt values(1,7,'LUNES');
insert into hotelhabt values(1,8,'LUNES');
insert into hotelhabt values(2,6,'LUNES');
insert into hotelhabt values(2,2,'LUNES');
insert into hotelhabt values(2,4,'LUNES');
insert into hotelhabt values(2,5,'LUNES');
insert into hotelhabt values(2,2,'MARTES');
insert into hotelhabt values(2,4,'MARTES');
insert into hotelhabt values(2,5,'MIERCOLES');

