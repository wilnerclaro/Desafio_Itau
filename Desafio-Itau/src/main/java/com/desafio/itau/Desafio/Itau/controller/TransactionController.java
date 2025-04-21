package com.desafio.itau.Desafio.Itau.controller;

import com.desafio.itau.Desafio.Itau.dto.TransactionRequestDTO;
import com.desafio.itau.Desafio.Itau.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary = "Cria uma nova transação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao  criar transação")
    })
    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequest) {
        transactionService.createTransaction(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Deleta todas as transações registradas", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas as informações foram apagadas com sucesso"),
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions() {
        transactionService.deleteTransactions();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
