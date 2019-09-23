package com.example.elimicaogauss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ElimicaoGaussApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElimicaoGaussApplication.class, args);
	}

}
