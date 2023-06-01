package com.example.mobilelele.config;

import com.example.mobilelele.util.StringToModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private final StringToModelConverter stringToModelConverter;

    @Autowired
    public WebConfiguration(StringToModelConverter stringToModelConverter) {
        this.stringToModelConverter = stringToModelConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(this.stringToModelConverter);
    }
}
