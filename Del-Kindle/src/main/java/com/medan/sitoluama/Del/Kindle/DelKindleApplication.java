package com.medan.sitoluama.Del.Kindle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DelKindleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelKindleApplication.class, args);
	}

}
