package com.xm.xmInterview.service.impl;

import com.xm.xmInterview.service.CryptoCalculator;
import com.xm.xmInterview.helper.csv.CryptoReader;

import java.io.FileNotFoundException;

public class CryptoCalculatorImpl extends CryptoCalculator {

    public CryptoCalculatorImpl(CryptoReader cryptoReader) throws FileNotFoundException {
        super(cryptoReader);
    }
}
