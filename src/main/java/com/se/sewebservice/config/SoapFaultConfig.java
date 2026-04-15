package com.se.sewebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class SoapFaultConfig {

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        SoapFaultMappingExceptionResolver resolver = new SoapFaultMappingExceptionResolver();

        SoapFaultDefinition defaultFault = new SoapFaultDefinition();
        defaultFault.setFaultCode(SoapFaultDefinition.SERVER);
        resolver.setDefaultFault(defaultFault);

        Properties mappings = new Properties();
        mappings.setProperty(IllegalArgumentException.class.getName(), SoapFaultDefinition.CLIENT.toString());
        resolver.setExceptionMappings(mappings);

        resolver.setOrder(1);
        return resolver;
    }
}
