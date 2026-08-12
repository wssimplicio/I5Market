package com.i5market.produto;

import com.i5market.response.ResponseApi;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public ResponseEntity<ResponseApi<List<ProdutoEntity>>> getAll() {
        List<ProdutoEntity> produtos = produtoService.getAll();
        ResponseApi<List<ProdutoEntity>> response = new ResponseApi<>("Lista de Produtos", produtos);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping()
    public ResponseEntity<ResponseApi<ProdutoEntity>> create(@RequestBody ProdutoEntity produto) {
        ProdutoEntity newProduto = produtoService.create(produto);

        ResponseApi<ProdutoEntity> response = new ResponseApi<>("Produto Inserido com sucesso!", newProduto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseApi<ProdutoEntity>> update(@PathVariable Integer id, @RequestBody ProdutoEntity produto) {
        ProdutoEntity newProduto = produtoService.update(id, produto);

        ResponseApi<ProdutoEntity> response = new ResponseApi<>("Produto Atualizado com sucesso!", newProduto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
