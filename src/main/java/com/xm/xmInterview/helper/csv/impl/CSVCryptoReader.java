package com.xm.xmInterview.helper.csv.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xm.xmInterview.model.Crypto;
import com.xm.xmInterview.helper.csv.CryptoReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVCryptoReader extends CryptoReader {
    private static final String FILE_EXTENSION = ".csv";
    public CSVCryptoReader(String fileName) {
        super(fileName);
    }

    @Override
    public List<Crypto> readCryptos() throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(super.getFileName() + FILE_EXTENSION))
                .withType(Crypto.class)
                .build()
                .parse();
    }
}
