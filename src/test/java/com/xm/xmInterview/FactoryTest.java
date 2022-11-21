package com.xm.xmInterview;

import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.helper.CryptoReaderFactory;
import com.xm.xmInterview.helper.csv.impl.CSVCryptoReader;
import com.xm.xmInterview.helper.csv.impl.MultipleCSVFileCryptoReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryTest {

    @Test
    void testCheckingCryptoMoreFiles() {
        assertEquals(MultipleCSVFileCryptoReader.class, CryptoReaderFactory.getCryptoReader(CryptoType.BTC).getClass(),
                "Crypto with more than 1 file, needs to be handled by MultipleCSVFileCryptoReader");
    }

    @Test
    void testCheckingCryptoOneFile() {
        assertEquals(CSVCryptoReader.class, CryptoReaderFactory.getCryptoReader(CryptoType.DOGE).getClass(),
                "Crypto with 1 file, needs to be handled by CSVCryptoReader");
    }

}
