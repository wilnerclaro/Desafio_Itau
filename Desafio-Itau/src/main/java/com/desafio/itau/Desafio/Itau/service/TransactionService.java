package com.desafio.itau.Desafio.Itau.service;

import com.desafio.itau.Desafio.Itau.converter.TransactionConverter;
import com.desafio.itau.Desafio.Itau.dto.TransactionRequestDTO;
import com.desafio.itau.Desafio.Itau.entity.Transaction;
import com.desafio.itau.Desafio.Itau.storage.TransactionStorage;
import com.desafio.itau.Desafio.Itau.util.TransactionValidation;
import org.springframework.stereotype.Service;

@Service

public class TransactionService {

    private final TransactionStorage transactionStorage;
    private final TransactionConverter converter;

    public TransactionService(TransactionStorage transactionStorage, TransactionConverter converter) {
        this.transactionStorage = transactionStorage;
        this.converter = converter;
    }


    public void createTransaction(TransactionRequestDTO transactionRequest) {
        TransactionValidation.valid(transactionRequest);
        Transaction transaction = converter.toEntity(transactionRequest);
        transactionStorage.create(transaction);

    }
}
