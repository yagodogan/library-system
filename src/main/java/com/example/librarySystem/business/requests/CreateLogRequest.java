package com.example.librarySystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CreateLogRequest {
    private LocalDateTime localDateTime;
    private Long execTime;
    private String methodName;
}
