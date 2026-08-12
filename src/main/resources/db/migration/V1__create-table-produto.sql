create table produto (
id serial primary key not null,
descricao varchar(150) not null,
preco numeric(10,4) not null,
estoque numeric(10,4) not null
);