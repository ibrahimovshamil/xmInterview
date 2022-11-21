package com.xm.xmInterview.model.response;

import com.xm.xmInterview.enums.CryptoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NormalizedRangeCryptosDescResponse {

    private List<CryptoType> cryptos;

}
