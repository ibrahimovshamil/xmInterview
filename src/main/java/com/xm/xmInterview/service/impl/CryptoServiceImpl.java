package com.xm.xmInterview.service.impl;

import com.xm.xmInterview.helper.CryptoReaderFactory;
import com.xm.xmInterview.model.Crypto;
import com.xm.xmInterview.service.CryptoCalculator;
import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.model.DailyHighestNormalized;
import com.xm.xmInterview.model.CryptoStats;
import com.xm.xmInterview.service.CryptoService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService {

    Map<CryptoType, CryptoCalculator> cryptoCalculatorMap = new HashMap<>();

    @PostConstruct
    private void init() {
        readAll();
    }

    public void readAll() {
        Arrays.stream(CryptoType.values())
                .forEach(cryptoType -> cryptoCalculatorMap.computeIfAbsent(cryptoType, c -> {
                    try {
                        return new CryptoCalculatorImpl(CryptoReaderFactory.getCryptoReader(cryptoType));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }));

    }

    public List<CryptoStats> getStatsForAll() {
        List<CryptoStats> stats = new ArrayList<>();
        Arrays.stream(CryptoType.values())
                .forEach(cryptoType -> {
                            CryptoCalculator cryptoCalculator =  cryptoCalculatorMap.get(cryptoType);
                            stats.add(CryptoStats.builder()
                                    .cryptoName(cryptoType)
                                    .oldest(cryptoCalculator.getOldest().orElseGet(Crypto::new))
                                    .newest(cryptoCalculator.getNewest().orElseGet(Crypto::new))
                                    .max(cryptoCalculator.getMax().orElseGet(Crypto::new))
                                    .min(cryptoCalculator.getMin().orElseThrow(() -> new NoSuchElementException("No min found for" + cryptoType)))
                                    .build());
                });
        return stats;
    }

    public List<CryptoType> getCryptosDesc() {
        List<CryptoStats> cryptoStats = getStatsForAll();
        cryptoStats.sort(Comparator.comparingDouble(c -> (c.getMax().getPrice() - c.getMin().getPrice())/c.getMin().getPrice()));
        return cryptoStats.stream()
                .map(CryptoStats::getCryptoName)
                .collect(Collectors.toList());
    }

    public Optional<CryptoStats> getStats(CryptoType cryptoName) {
        return getStatsForAll().stream()
                .filter(c -> c.getCryptoName() == cryptoName)
                .findAny();
    }

    public CryptoType getHighestNormalizedForDay(LocalDate date) {
        return cryptoCalculatorMap.values().stream()
                        .map(c-> c.getDailyHighestNormalizedCrypto(date))
                        .max(Comparator.comparingDouble(DailyHighestNormalized::getNormalizedRange))
                        .orElseThrow(() -> new NoSuchElementException("No max found for Highest Normalized For Day"))
                        .getCryptoType();
    }
}