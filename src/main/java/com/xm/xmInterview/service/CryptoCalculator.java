package com.xm.xmInterview.service;

import com.xm.xmInterview.model.Crypto;
import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.model.DailyHighestNormalized;
import com.xm.xmInterview.helper.csv.CryptoReader;

import java.io.FileNotFoundException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * All the methods are implemented in the abstract class
 * since it looks like default, expected behaviour.
 * Any other classes can override them for their specific needs.
 * */
public abstract class CryptoCalculator {

    protected List<Crypto> cryptos;
    protected CryptoReader cryptoReader;

    protected CryptoCalculator(CryptoReader cryptoReader) throws FileNotFoundException {
        this.cryptoReader = cryptoReader;
        readPrices();
    }


    public Optional<Crypto> getOldest() {
        if(Objects.nonNull(cryptos) && cryptos.size() > 0) {
            return cryptos.stream().min(Comparator.comparing(Crypto::getTimestamp));
        }
        return Optional.empty();
    }


    public Optional<Crypto> getNewest() {
        if(Objects.nonNull(cryptos) && cryptos.size() > 0) {
            return cryptos.stream().max(Comparator.comparing(Crypto::getTimestamp));
        }
        return Optional.empty();
    }


    public Optional<Crypto> getMin() {
        if(Objects.nonNull(cryptos) && cryptos.size() > 0) {
            return cryptos.stream().min(Comparator.comparing(Crypto::getPrice));
        }
        return Optional.empty();
    }

    public Optional<Crypto> getMax() {
        if(Objects.nonNull(cryptos) && cryptos.size() > 0) {
            return cryptos.stream().max(Comparator.comparing(Crypto::getPrice));
        }
        return Optional.empty();
    }

    private List<Crypto> getDailyCryptos(LocalDate date) {
        return cryptos.stream()
                .filter(crypto -> LocalDate.ofInstant(Instant.ofEpochMilli(crypto.getTimestamp()), TimeZone.getDefault().toZoneId()).isEqual(date))
                .collect(Collectors.toList());
    }

    public DailyHighestNormalized getDailyHighestNormalizedCrypto(LocalDate date) {
         DoubleSummaryStatistics summaryStatistics = getDailyCryptos(date)
                 .stream()
                 .mapToDouble(Crypto::getPrice)
                 .summaryStatistics();

         double minVal = summaryStatistics.getMin();
         if(minVal == 0.0) {
             throw new NoSuchElementException("There is no min value to calculate normalized range");
         }
         double normalizedRange = (summaryStatistics.getMax() - minVal)/minVal;
         return DailyHighestNormalized.builder()
                 .cryptoType(CryptoType.valueOf(cryptos.get(0).getSymbol()))
                 .normalizedRange(normalizedRange)
                 .build();
    }

    //Read prices behaviour should not be changed.
    public final void readPrices() throws FileNotFoundException {
        this.cryptos = cryptoReader.readCryptos();
    }

    /* Reading new values after setting the new Reader is crucial.
       That is why there is a small template code by the help of final keyword. */
    public final void setCryptoReader(CryptoReader cryptoReader) throws FileNotFoundException {
        this.cryptoReader = cryptoReader;
        readPrices();
    }
}
