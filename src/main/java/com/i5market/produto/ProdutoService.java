package com.i5market.produto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoEntity> getAll() {
        return produtoRepository.findAll().stream().toList();
    }

    public ProdutoEntity create(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    public ProdutoEntity update(Integer id, ProdutoEntity produto) {
        return produtoRepository.findById(id).map(p -> {
            p.setDescricao(produto.getDescricao());
            p.setEstoque(produto.getEstoque());
            p.setPreco(produto.getPreco());

            return produtoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }
}
