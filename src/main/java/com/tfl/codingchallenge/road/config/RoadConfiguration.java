package com.tfl.codingchallenge.road.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static com.tfl.codingchallenge.road.constant.RoadConstants.TIMEOUT_DURATION;

/**
 * This is configuration class to configure rest template used to call Unifiled API.
 */
@Configuration
public class RoadConfiguration {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.setConnectTimeout(TIMEOUT_DURATION).setReadTimeout(TIMEOUT_DURATION).build();
    }
}
