package com.desafio.itau.Desafio.Itau.exception;

public class TransactionInvalidException extends RuntimeException {
    public TransactionInvalidException(String menssage) {
        super(menssage);
    }
}
