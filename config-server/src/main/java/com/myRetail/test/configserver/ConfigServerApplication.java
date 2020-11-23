package com.myRetail.test.configserver;

import com.myRetail.test.configserver.service.EnvironmentRepositoryConfiguration;
import com.myRetail.test.configserver.service.MongoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigServer
//@EnableWebMvc
@Import({
		EnvironmentRepositoryConfiguration.class,
		MongoConfiguration.class})
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
