package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.ILogService;
import com.example.librarySystem.dto.request.CreateLogRequest;
import com.example.librarySystem.core.mapper.IModelMapperService;
import com.example.librarySystem.entity.Log;
import com.example.librarySystem.repository.ILogRepositories;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogService implements ILogService {

    private final ILogRepositories logRepositories;
    private final IModelMapperService modelMapperService;

    @Async
    @Override
    public void createLog(CreateLogRequest request) {
        Log log = this.modelMapperService.forRequest().map(request,Log.class);
        this.logRepositories.save(log);
    }
}
