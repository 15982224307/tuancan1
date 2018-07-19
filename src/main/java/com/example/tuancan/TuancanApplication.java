package com.example.tuancan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.tuancan.dao")
public class TuancanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuancanApplication.class, args);
	}
}
