package com.i5market.exceptions;

import com.i5market.response.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DadoNaoEncontradoException.class)
    public ResponseEntity<ResponseApi<Object>> handlerDadoNaoEncontrado(DadoNaoEncontradoException dex){
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", MessagesEnum.DADO_NAO_ENCONTRADO.getDescricao());
        body.put("message", dex.getMessage());

        ResponseApi<Object> response = new ResponseApi<>("", body);

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
