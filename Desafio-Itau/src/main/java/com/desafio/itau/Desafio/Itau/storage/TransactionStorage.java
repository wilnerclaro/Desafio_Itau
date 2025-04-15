package com.desafio.itau.Desafio.Itau.storage;

import com.desafio.itau.Desafio.Itau.entity.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
@RequiredArgsConstructor
public class TransactionStorage {
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void create(Transaction transaction) {
        transactions.add(transaction);
    }

    public Queue<Transaction> getAllTransactions() {
        return transactions;
    }

    public void clearTransactions() {
        transactions.clear();
    }

}
