package com.i5market.ean;

import org.springframework.stereotype.Service;

@Service
public class ProdutoEanService {
    private final ProdutoEanRepository produtoEanRepository;

    public ProdutoEanService(ProdutoEanRepository produtoEanRepository) {
        this.produtoEanRepository = produtoEanRepository;
    }

    public ProdutoEanEntity addEan(ProdutoEanEntity ean) {
        return produtoEanRepository.save(ean);
    }
}
