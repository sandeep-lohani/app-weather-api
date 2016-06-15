package com.open.weather;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.open.weather.Application;

public class ApplicationTest {
	
	private Application application = new Application();

	@Test
	public void testRestTemplate() {
		RestTemplate template = application.restTemplate();
		assertNotNull(template);
		assertEquals(template.getMessageConverters().size(), 1);
		assertTrue(template.getMessageConverters().get(0) instanceof MappingJackson2HttpMessageConverter);
		
	}

}
