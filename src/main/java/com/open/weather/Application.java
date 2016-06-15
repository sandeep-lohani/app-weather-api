package com.open.weather;

import java.util.Arrays;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;


/**
 * Created by sandeep on 15/06/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.open.weather"})
@EnableSwagger2
public class Application extends SpringBootServletInitializer{
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * The entry point, starts the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate template = new RestTemplate();
    	template.setMessageConverters(Arrays.<HttpMessageConverter<?>>asList( jacksonConverter()));
        return template;
    }
    
    /**
     * Configures Joda message converter
     * @return
     */
    private MappingJackson2HttpMessageConverter jacksonConverter() {
        MappingJackson2HttpMessageConverter converter
                = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        converter.setObjectMapper(mapper);
        return converter;
    }
    

}
