package com.desafio.itau.Desafio.Itau.util;

import com.desafio.itau.Desafio.Itau.dto.TransactionRequestDTO;
import com.desafio.itau.Desafio.Itau.exception.TransactionInvalidException;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public class TransactionValidation {


    public static void valid(TransactionRequestDTO transactionRequest) {
        if (transactionRequest.amount().signum() < 0) {
            throw new TransactionInvalidException("Valor não pode ser negativo.");
        }


        if (transactionRequest.dateTime().isAfter(OffsetDateTime.now(ZoneId.of("America/Sao_Paulo")))) {
            throw new TransactionInvalidException("Data/hora da transação não pode estar no futuro.");
        }

    }
}
