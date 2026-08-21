package com.i5market.exceptions;

import lombok.Getter;

@Getter
public enum MessagesEnum {
    DADO_NAO_ENCONTRADO("Dado não encontrado"),
    PRODUTO_NAO_ENCONTRADO("Produto não encontrado");

    private final String descricao;

    MessagesEnum(String descricao) {
        this.descricao = descricao;
    }
}
