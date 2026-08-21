package com.i5market.produto;

import com.i5market.exceptions.DadoNaoEncontradoException;
import com.i5market.exceptions.MessagesEnum;
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
        }).orElseThrow(() -> new DadoNaoEncontradoException(MessagesEnum.PRODUTO_NAO_ENCONTRADO.getDescricao()));
    }

    public void delete(Integer id) {
        if(!produtoRepository.existsById(id)) {
            throw new DadoNaoEncontradoException(MessagesEnum.PRODUTO_NAO_ENCONTRADO.getDescricao());
        }

        produtoRepository.findById(id).map(p -> {
            p.setStatus(false);
            return produtoRepository.save(p);
        });
    }
}
