package com.i5market.ean;

import com.i5market.response.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ean")
public class ProdutoEanController {

    private final ProdutoEanService produtoEanService;

    public ProdutoEanController(ProdutoEanService produtoEanService) {
        this.produtoEanService = produtoEanService;
    }

    @PostMapping
    public ResponseEntity<ResponseApi<ProdutoEanEntity>> addEan (@RequestBody ProdutoEanEntity ean) {
        ProdutoEanEntity newEan = produtoEanService.addEan(ean);
        ResponseApi<ProdutoEanEntity> response = new ResponseApi<>("Ean Inserido com sucesso", newEan);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
