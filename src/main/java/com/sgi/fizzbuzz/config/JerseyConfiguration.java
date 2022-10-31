package com.sgi.fizzbuzz.config;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.sgi.fizzbuzz.controller.FizzbuzzController;
import com.sgi.fizzbuzz.exception.FizzBuzzExceptionMapper;


@Configuration
public class JerseyConfiguration extends ResourceConfig {

	@PostConstruct
    public void init() {
        register(FizzbuzzController.class);
        register(FizzBuzzExceptionMapper.class);
    }
	
}
