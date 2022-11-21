package com.xm.xmInterview.helper.csv;

import com.xm.xmInterview.model.Crypto;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class CryptoReader {
    private String fileName;

    public CryptoReader(String fileName) {
        this.fileName = fileName;
    }

    public abstract List<Crypto> readCryptos() throws FileNotFoundException;

    public String getFileName() {
        return fileName;
    }

}
