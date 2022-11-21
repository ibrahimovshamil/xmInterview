package com.xm.xmInterview;

import com.xm.xmInterview.enums.CryptoType;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumTest {

    @Test
    void testCheckingCryptoMoreFiles() {
        assertEquals(2, CryptoType.BTC.getExtraFileNames().size(),
                "getExtraFileNames should return extra, but not the default file");
    }

    @Test
    void testCheckingCryptoOneFile() {
        assertEquals(0, CryptoType.DOGE.getExtraFileNames().size(),
                "getExtraFileNames should return empty for the default cryptos");
    }

    @Test
    void testFindingEnumByString() {
        assertEquals(CryptoType.BTC, CryptoType.findByName("BTC").get(),
                "findByName should return enum if exist");
    }

    @Test
    void testFindingEnumByStringEmpty() {
        assertEquals(Optional.empty(), CryptoType.findByName("BTT"),
                "findByName should return empty if not exist");
    }
}
