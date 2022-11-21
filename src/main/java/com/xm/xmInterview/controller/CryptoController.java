package com.xm.xmInterview.controller;

import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.model.response.HighestNormalizedForDayResponse;
import com.xm.xmInterview.model.response.NormalizedRangeCryptosDescResponse;
import com.xm.xmInterview.model.response.StatsResponse;
import com.xm.xmInterview.service.CryptoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping(value = "/normalizedRangeDesc", produces = "application/json")
    NormalizedRangeCryptosDescResponse getCryptosDesc() {
        return NormalizedRangeCryptosDescResponse
                .builder()
                .cryptos(cryptoService.getCryptosDesc())
                .build();
    }


    @GetMapping(value = "/stats/{type}", produces = "application/json")
    StatsResponse getStats(@PathVariable("type") String cryptoType) {
        CryptoType type = CryptoType.findByName(cryptoType)
                .orElseThrow(() -> new NoSuchElementException("Not supported Crypto"));

        return StatsResponse.builder()
                .stats(cryptoService.getStats(type)
                            .orElseThrow(() -> new NoSuchElementException("No Stats found for the :" + cryptoType)))
                .build();
    }

    @PostMapping(value = "/highestNormalizedForDay", produces = "application/json")
    HighestNormalizedForDayResponse getHighestNormalizedForDay(@RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return HighestNormalizedForDayResponse.builder()
                .crypto(cryptoService.getHighestNormalizedForDay(date))
                .build();
    }
}