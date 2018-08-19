package com.example.tuancan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(value = "com.example.tuancan.dao")
public class TuancanApplication {

	/*哈哈哈哈哈哈*/
	public static void main(String[] args) {
		SpringApplication.run(TuancanApplication.class, args);
	}
}
