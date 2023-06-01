package com.example.mobilelele.services.impl;

import com.example.mobilelele.models.entities.Model;
import com.example.mobilelele.repositories.ModelRepository;
import com.example.mobilelele.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model findById(String id) {
        return this.modelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Model with Id = %s not found.", id)));
    }
}
