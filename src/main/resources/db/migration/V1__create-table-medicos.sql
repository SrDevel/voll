create table medicos (
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    mail varchar(100) not null unique,
    especialidade varchar(100) not null,
    distrito varchar(100) not null,
    ciudad varchar(100) not null,
    numero varchar(100),
    complemento varchar(100),
    
    primary key (id)
);