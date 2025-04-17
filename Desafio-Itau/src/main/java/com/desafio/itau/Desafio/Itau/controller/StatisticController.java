package com.desafio.itau.Desafio.Itau.controller;

import com.desafio.itau.Desafio.Itau.dto.StatisticResponseDTO;
import com.desafio.itau.Desafio.Itau.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @GetMapping()
    @Operation(summary = "Retorna estatísticas das transações dos últimos N segundos")
    @ApiResponse(responseCode = "200", description = "Estatísticas geradas com sucesso")
    public ResponseEntity<StatisticResponseDTO> getStatistics() {
        return ResponseEntity.ok(statisticService.calculateLastSeconds());
    }
}
