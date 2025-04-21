package com.desafio.itau.Desafio.Itau.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@Schema(description = "DTO para criação de transações")
public record TransactionRequestDTO(
        @Schema(example = "150.75", description = "Valor da transação, deve ser positivo")
        @NotNull(message = "O valor da transação não pode ser nulo")
        @PositiveOrZero(message = "O valor da transação deve ser maior ou igual a zero")
        BigDecimal amount,

        @Schema(example = "2025-04-15T10:30:00-03:00", description = "Data e hora da transação no formato ISO 8601")
        @NotNull(message = "A data da transação não pode ser nula")
        OffsetDateTime dateTime
) {
}


