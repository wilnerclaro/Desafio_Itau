package com.desafio.itau.Desafio.Itau.util;

import com.desafio.itau.Desafio.Itau.dto.TransactionRequestDTO;
import com.desafio.itau.Desafio.Itau.exception.TransactionInvalidException;

import java.time.OffsetDateTime;
import java.time.ZoneId;

public class TransactionValidation {


    public static void valid(TransactionRequestDTO transactionRequest) {
        if (transactionRequest.amount().signum() < 0) {
            throw new TransactionInvalidException("Valor não pode ser negativo.");
        }
        if (transactionRequest.amount().equals(null)) {
            throw new TransactionInvalidException("Valor não pode ser vazio.");
        }

        if (transactionRequest.dateTime().isAfter(OffsetDateTime.now(ZoneId.of("America/Sao_Paulo")))) {
            throw new TransactionInvalidException("Data/hora da transação não pode estar no futuro.");
        }
        if (transactionRequest.dateTime().equals(null)) {
            throw new TransactionInvalidException("Data/Hora não pode ser vazio.");
        }
    }
}
