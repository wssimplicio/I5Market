create table produto_ean (
id serial primary key not null,
id_produto int not null,
codigobarras bigint not null,
embalagem char(4),
qtd_embalagem numeric(10,4),
constraint fk_id_produto foreign key (id_produto) references produto(id),
CONSTRAINT uk_produto_ean_codigobarras
        UNIQUE (codigobarras)
);