package com.example.librarySystem.core.mapper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
