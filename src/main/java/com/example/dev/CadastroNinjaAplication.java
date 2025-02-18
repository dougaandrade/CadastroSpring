package com.example.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CadastroNinjaAplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroNinjaAplication.class, args);
		System.getProperty("DATA_BASE_URL");
		System.getProperty("DATA_BASE_USERNAME");
		System.getProperty("DATA_BASE_PASSWORD");

	}
}