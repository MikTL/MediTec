create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    clave varchar(300) not null,

    primary key(id)
);