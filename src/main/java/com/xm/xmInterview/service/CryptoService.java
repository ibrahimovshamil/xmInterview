package com.xm.xmInterview.service;

import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.model.CryptoStats;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CryptoService {

    void readAll();
    List<CryptoStats> getStatsForAll();
    List<CryptoType> getCryptosDesc();
    Optional<CryptoStats> getStats(CryptoType cryptoName);
    CryptoType getHighestNormalizedForDay(LocalDate date);

}
