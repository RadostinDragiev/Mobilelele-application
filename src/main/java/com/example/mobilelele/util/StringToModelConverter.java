package com.example.mobilelele.util;

import com.example.mobilelele.models.entities.Model;
import com.example.mobilelele.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToModelConverter implements Converter<String, Model> {
    private final ModelService modelService;

    @Autowired
    public StringToModelConverter(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public Model convert(String modelId) {
        if (modelId.trim().length() > 0) {
            return this.modelService.findById(modelId);
        } else {
            return null;
        }
    }
}
