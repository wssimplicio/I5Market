package com.i5market.ean;

import com.i5market.produto.ProdutoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigInteger;

public record ProdutoEanDTO(
        Integer id,
        BigInteger codigobarras,
        String embalagem,
        Integer qtdembalagem
) {
    public ProdutoEanDTO(ProdutoEanEntity ean) {
        this (
                ean.getId(),
                ean.getCodigobarras(),
                ean.getEmbalagem(),
                ean.getQtdembalagem()
        );
    }
}
