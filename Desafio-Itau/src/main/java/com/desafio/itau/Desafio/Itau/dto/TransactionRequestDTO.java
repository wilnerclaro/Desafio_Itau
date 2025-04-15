package com.desafio.itau.Desafio.Itau.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nonnull;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@Schema(description = "DTO para criação de transações")
public record TransactionRequestDTO(
        @Schema(example = "150.75", description = "Valor da transação, deve ser positivo")
        @Nonnull BigDecimal amount,

        @Schema(example = "2024-04-15T10:30:00-03:00", description = "Data e hora da transação no formato ISO 8601")
        @Nonnull OffsetDateTime dateTime
) {
}

