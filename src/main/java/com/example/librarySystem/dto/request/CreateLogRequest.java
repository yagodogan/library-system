package com.example.librarySystem.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateLogRequest {

    private Date localDateTime;

    private Long execTime;

    private String methodName;
}
