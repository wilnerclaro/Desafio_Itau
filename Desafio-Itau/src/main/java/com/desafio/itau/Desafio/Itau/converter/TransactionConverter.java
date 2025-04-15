package com.desafio.itau.Desafio.Itau.converter;

import com.desafio.itau.Desafio.Itau.dto.TransactionRequestDTO;
import com.desafio.itau.Desafio.Itau.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter implements IConverter<TransactionRequestDTO, Transaction> {
    @Override
    public Transaction toEntity(TransactionRequestDTO dto) {
        return new Transaction(dto.amount(), dto.dateTime());
    }
}
