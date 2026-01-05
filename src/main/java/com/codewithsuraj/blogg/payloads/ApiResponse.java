package com.codewithsuraj.blogg.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
   
    private String message;
    private boolean success;
}
