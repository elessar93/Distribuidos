
use distribuidos;
create table producto(
id_producto int NOT NULL AUTO_INCREMENT ,
nb_producto int,
ds_producto int,
nu_existencia int,
nu_costo float, 
primary key(id_producto));

create table categoria(
id_categoria int,
id_padre int,
nb_categoria varchar(100),
ds_categoria varchar(250),
primary key(id_categoria),
foreign key(id_padre) references categoria (id_categoria));

create table categoria_producto(
id_categoria int,
id_producto int,
primary key(id_categoria,id_producto),
foreign key(id_categoria) references categoria (id_categoria),
foreign key(id_producto) references producto (id_producto));

create table estatus_compra(
id_estatus int,
nb_estatus varchar(50),
ds_estatus varchar(250),
primary key(id_estatus));

create table compra(
id_compra int,
id_estatus int,
fh_inicio int,
fh_fin int,
primary key(id_compra),
foreign key(id_estatus) references estatus_compra(id_estatus));

create table detalle(
id_compra int,
id_detalle int,
id_producto int,
nu_cantidad int,
primary key(id_compra,id_detalle),
foreign key(id_compra) references compra (id_compra),
foreign key(id_producto) references producto (id_producto));

create table tipo_valor(
id_tipo int,
nb_tipo varchar(50),
ds_tipo varchar(250),
primary key(id_tipo));

create table tipo_unidad(
id_tipo int,
nb_tipo varchar(50),
ds_tipo int,
primary key(id_tipo));

create table unidad(
id_unidad int,
id_tipo int,
nb_unidad varchar(50),
tx_siglas int,
primary key(id_unidad),
foreign key(id_tipo) references tipo_unidad(id_tipo));

create table atributo(
id_atributo int,
id_tipo_unidad int,
id_tipo_valor int,
nb_atributo varchar(50),
ds_atributo varchar(250),
primary key(id_atributo),
foreign key(id_tipo_valor) references tipo_valor(id_tipo),
foreign key(id_tipo_unidad) references tipo_unidad(id_tipo));

create table categoria_atributo(
id_categoria int,
id_atributo int,
id_tipo_unidad int,
primary key(id_categoria,id_atributo),
foreign key(id_categoria) references categoria(id_categoria),
foreign key(id_atributo) references atributo(id_atributo));
create table producto_atributo(
id_categoria int,
id_producto int,
id_atributo int,
tx_valor varchar(50),
primary key(id_categoria,id_producto,id_atributo),
foreign key(id_categoria) references categoria_producto(id_categoria),
foreign key(id_producto) references  categoria_producto(id_producto),
foreign key(id_atributo) references  categoria_atributo(id_atributo));

