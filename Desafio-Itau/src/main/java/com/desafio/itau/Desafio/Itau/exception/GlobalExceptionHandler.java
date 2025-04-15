package com.desafio.itau.Desafio.Itau.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TransactionInvalidException.class)
    public ResponseEntity<Void> handleTransacaoInvalida() {
        return ResponseEntity.unprocessableEntity().build(); // 422
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleBadRequest() {
        return ResponseEntity.badRequest().build(); // 400
    }
}
