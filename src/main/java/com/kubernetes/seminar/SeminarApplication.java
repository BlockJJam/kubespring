package com.kubernetes.seminar;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeminarApplication.class, args);
	}
}
