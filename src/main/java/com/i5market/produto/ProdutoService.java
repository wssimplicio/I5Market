package com.i5market.produto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> getAll() {
        return produtoRepository.findAll().stream()
                .map(ProdutoDTO::new)
                .toList();
    }

    public ProdutoEntity create(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    public ProdutoEntity update(Integer id, ProdutoEntity produto) {
        return produtoRepository.findById(id).map(p -> {
            p.setDescricao(produto.getDescricao());
            p.setEstoque(produto.getEstoque());
            p.setPreco(produto.getPreco());
            p.setStatus(produto.getStatus());

            return produtoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public void delete(Integer id) {
        produtoRepository.findById(id).map(p -> {
            p.setStatus(false);

            return produtoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }
}
