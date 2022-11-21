package com.xm.xmInterview.helper.csv.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.xm.xmInterview.helper.csv.CryptoReader;
import com.xm.xmInterview.model.Crypto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleCSVFileCryptoReader extends CryptoReader {

    private static final String FILE_EXTENSION = ".csv";
    List<String> extraFileNames;

    public MultipleCSVFileCryptoReader(String fileName, List<String> extraFileNames) {
        super(fileName);
        this.extraFileNames = extraFileNames;
    }


    @Override
    public List<Crypto> readCryptos() {
        List<Crypto> allCryptos = new ArrayList<>();
        extraFileNames.add(super.getFileName());
        extraFileNames.forEach(f -> {
            try {
                allCryptos.addAll(
                        new CsvToBeanBuilder(new FileReader(f + FILE_EXTENSION))
                                .withType(Crypto.class)
                                .build()
                                .parse());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return allCryptos;
    }
}
