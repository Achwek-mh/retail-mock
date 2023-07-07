package com.fsi.cbs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author med-amine.Dahmen
 * Date 05/07/2023
 */
@Component
public class AppBeansInitializer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
