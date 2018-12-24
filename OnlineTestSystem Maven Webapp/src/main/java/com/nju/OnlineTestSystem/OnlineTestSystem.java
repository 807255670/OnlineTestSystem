package com.nju.OnlineTestSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan("com.nju.OnlineTestSystem.mapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class OnlineTestSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(OnlineTestSystem.class, args);
	}
}
