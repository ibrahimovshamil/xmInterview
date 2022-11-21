package com.xm.xmInterview.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum CryptoType {
    BTC("BTC_values", 3),
    DOGE("DOGE_values", 1),
    ETH("ETH_values", 1),
    LTC("LTC_values", 1);

    final String fileName;
    final int numberOfMonths;
    CryptoType(String fileName, int numberOfMonths) {
        this.fileName = fileName;
        this.numberOfMonths = numberOfMonths;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public List<String> getExtraFileNames() {
        List<String> fileNames = new ArrayList<>();
        if(numberOfMonths > 1) {
            for(int i = 1; i < numberOfMonths; i++) {
                fileNames.add(fileName + i);
            }
        }
        return fileNames;
    }

    public static Optional<CryptoType> findByName(String name) {
        for (CryptoType type : values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }
}
