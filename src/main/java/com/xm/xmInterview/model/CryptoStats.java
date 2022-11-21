package com.xm.xmInterview.model;

import com.xm.xmInterview.enums.CryptoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoStats {

    private CryptoType cryptoName;
    // todo maybe put into another stats class
    private Crypto oldest;
    private Crypto newest;
    private Crypto min;
    private Crypto max;

}
