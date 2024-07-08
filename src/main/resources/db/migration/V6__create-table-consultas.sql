create table pacientes (
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    telefono varchar(100) not null,
    documento varchar(100) not null unique,
    calle varchar(100) not null,
    distrito varchar(100) not null,
    ciudad varchar(100) not null,
    numero varchar(100),
    complemento varchar(100),
    activo tinyint(1) not null default 1,

    primary key (id)
);