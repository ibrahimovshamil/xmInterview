package com.xm.xmInterview.model;

import com.xm.xmInterview.enums.CryptoType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DailyHighestNormalized {

    private CryptoType cryptoType;

    private double normalizedRange;

}
