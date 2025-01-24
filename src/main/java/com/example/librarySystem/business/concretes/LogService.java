package com.example.librarySystem.business.concretes;

import com.example.librarySystem.business.abstracts.ILogService;
import com.example.librarySystem.business.requests.CreateLogRequest;
import com.example.librarySystem.core.utilities.mappers.IModelMapperService;
import com.example.librarySystem.entities.Log;
import com.example.librarySystem.repositories.ILogRepositories;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogService implements ILogService {

    private ILogRepositories logRepositories;
    private IModelMapperService modelMapperService;

    @Async
    @Override
    public void createLog(CreateLogRequest request) {
        Log log = this.modelMapperService.forRequest().map(request,Log.class);
        this.logRepositories.save(log);
    }
}
