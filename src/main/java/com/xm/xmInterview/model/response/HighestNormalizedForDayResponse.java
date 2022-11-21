package com.xm.xmInterview.model.response;

import com.xm.xmInterview.enums.CryptoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HighestNormalizedForDayResponse {

    private CryptoType crypto;

}
