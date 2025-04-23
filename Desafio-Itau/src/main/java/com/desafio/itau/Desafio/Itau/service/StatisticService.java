package com.desafio.itau.Desafio.Itau.service;

import com.desafio.itau.Desafio.Itau.dto.StatisticResponseDTO;
import com.desafio.itau.Desafio.Itau.entity.Transaction;
import com.desafio.itau.Desafio.Itau.storage.TransactionStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class StatisticService {
    private final TransactionStorage storage;
    @Value("${statistics.interval.seconds}")
    private long statisticsIntervalSeconds;
    private static final BigDecimal ZERO = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    @Value("${app.timezone}")
    private String timeZone;

    public StatisticService(TransactionStorage storage) {
        this.storage = storage;
    }

    public StatisticResponseDTO calculateLastSeconds() {
        ZoneId zoneId = ZoneId.of(timeZone);
        OffsetDateTime now = OffsetDateTime.now(zoneId);
        OffsetDateTime limit = now.minusSeconds(statisticsIntervalSeconds);


        System.out.println("⏰ NOW: " + now);
        System.out.println("⏳ LIMIT: " + limit);

        for (Transaction t : storage.getAllTransactions()) {
            System.out.println("🔄 Transação armazenada: " + t.getDateTime());
        }


        List<Transaction> lasts = storage.getAllTransactions().stream()
                .filter(t -> {
                    OffsetDateTime storedDate = t.getDateTime().atZoneSameInstant(zoneId).toOffsetDateTime();
                    return storedDate.isAfter(limit) && !storedDate.isAfter(now);
                })
                .toList();

        if (lasts.isEmpty()) {
            return new StatisticResponseDTO(0, ZERO, ZERO, ZERO, ZERO);
        }
        BigDecimal sum = lasts.stream()
                .map(Transaction::getAmount)
                .reduce(ZERO, BigDecimal::add);

        BigDecimal avg = sum.divide(BigDecimal.valueOf(lasts.size()), 2, RoundingMode.HALF_UP);

        BigDecimal min = lasts.stream()
                .map(Transaction::getAmount)
                .min(BigDecimal::compareTo)
                .orElse(ZERO);

        BigDecimal max = lasts.stream()
                .map(Transaction::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(ZERO);

        return new StatisticResponseDTO(lasts.size(), sum, avg, min, max);
    }
}
