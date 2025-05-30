package com.desafio.itau.Desafio.Itau.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


public class Transaction {
    private BigDecimal amount;
    private OffsetDateTime dateTime;

    public Transaction(BigDecimal amount, OffsetDateTime dateTime) {
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
