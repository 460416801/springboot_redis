package com.lzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lzx")
@MapperScan("com.lzx")
public class SpringBootRedisApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootRedisApplication.class, args);
	}
}
