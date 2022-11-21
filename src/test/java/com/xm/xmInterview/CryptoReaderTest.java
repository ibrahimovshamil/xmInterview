package com.xm.xmInterview;

import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.helper.CryptoReaderFactory;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CryptoReaderTest {

    @Test
    void testCheckingCryptoMoreFiles() throws FileNotFoundException {
        assertEquals(300, CryptoReaderFactory.getCryptoReader(CryptoType.BTC).readCryptos().size());
    }

    @Test
    void testCheckingCryptoOneFile() throws FileNotFoundException {
        assertEquals(90, CryptoReaderFactory.getCryptoReader(CryptoType.DOGE).readCryptos().size());
    }
}
