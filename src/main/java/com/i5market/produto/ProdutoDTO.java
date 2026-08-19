package com.i5market.produto;


import com.i5market.ean.ProdutoEanDTO;
import com.i5market.ean.ProdutoEanEntity;

import java.util.ArrayList;
import java.util.List;

public record ProdutoDTO(
         Integer id,
         String descricao,
         Double preco,
         Double estoque,
         Boolean status,
         List<ProdutoEanDTO> ean
) {

    public ProdutoDTO(ProdutoEntity produto) {
        this(
                produto.getId(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getEstoque(),
                produto.getStatus(),
                produto.getEan().stream().map(ProdutoEanDTO::new).toList()
        );
    }
}
