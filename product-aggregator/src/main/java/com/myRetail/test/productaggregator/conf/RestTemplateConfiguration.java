package com.myRetail.test.productaggregator.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate getProductDetailsRestTemplate() {
        return new RestTemplate();
    }

}
