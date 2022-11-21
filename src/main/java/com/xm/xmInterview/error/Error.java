package com.xm.xmInterview.error;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Error {
    private LocalDateTime time;
    private String url;
    private String message;
    public Error(LocalDateTime time, String message, String url) {
        this.time = time;
        this.url = url;
        this.message = message;
    }

}
