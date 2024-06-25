package com.sds.cafeadmin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Value("$(save.path)")
	private String savePath;

	@Bean
	public String savePath() {
		return savePath;
	}

//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//		return null;
//	}

}
