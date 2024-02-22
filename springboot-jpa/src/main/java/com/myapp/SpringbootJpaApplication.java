package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableFeignClients
//@EnableEurekaClient
//@EnableHystrix
//@EnableHystrixDashboard


@ComponentScan({"com.myapp"})
@EntityScan("com.myapp.entity")
//@EnableJpaRepositories(basePackages="com.myapp.repository")
@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

}
