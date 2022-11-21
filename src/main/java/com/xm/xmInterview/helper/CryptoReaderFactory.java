package com.xm.xmInterview.helper;

import com.xm.xmInterview.enums.CryptoType;
import com.xm.xmInterview.helper.csv.CryptoReader;
import com.xm.xmInterview.helper.csv.impl.CSVCryptoReader;
import com.xm.xmInterview.helper.csv.impl.MultipleCSVFileCryptoReader;

public class CryptoReaderFactory {

    public static CryptoReader getCryptoReader(CryptoType cryptoType) {
        if(cryptoType.getNumberOfMonths() > 1) {
            return new MultipleCSVFileCryptoReader(cryptoType.getFileName(), cryptoType.getExtraFileNames());
        } else {
            return new CSVCryptoReader(cryptoType.getFileName());
        }
    }

}
