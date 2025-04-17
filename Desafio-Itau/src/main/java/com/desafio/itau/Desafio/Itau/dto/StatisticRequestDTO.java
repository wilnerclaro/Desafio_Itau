package com.desafio.itau.Desafio.Itau.dto;

import java.math.BigDecimal;

public record StatisticRequestDTO(
        long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal min,
        BigDecimal max
) {
}
