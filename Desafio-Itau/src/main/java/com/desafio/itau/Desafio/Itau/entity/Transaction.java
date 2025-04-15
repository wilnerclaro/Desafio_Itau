package com.desafio.itau.Desafio.Itau.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Getter
@Setter
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class Transaction {
    private BigDecimal amount;
    private OffsetDateTime dateTime;

    public Transaction(BigDecimal amount, OffsetDateTime dateTime) {
        this.amount = amount;
        this.dateTime = this.dateTime;
    }

}
