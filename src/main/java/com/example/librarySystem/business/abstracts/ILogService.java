package com.example.librarySystem.business.abstracts;

import com.example.librarySystem.dto.request.CreateLogRequest;

public interface ILogService {

    void createLog(CreateLogRequest request);

}
