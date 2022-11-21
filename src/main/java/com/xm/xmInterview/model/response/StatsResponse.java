package com.xm.xmInterview.model.response;

import com.xm.xmInterview.model.CryptoStats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatsResponse {

    private CryptoStats stats;

}
