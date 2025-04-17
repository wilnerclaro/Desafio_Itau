package com.desafio.itau.Desafio.Itau.dto;

import java.math.BigDecimal;

public record StatisticResponseDTO(
        long count,
        BigDecimal sum,
        BigDecimal avg,
        BigDecimal min,
        BigDecimal max
) {
}
