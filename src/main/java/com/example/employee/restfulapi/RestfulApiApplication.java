package com.example.employee.restfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.flywaydb.core.Flyway;

@SpringBootApplication
public class RestfulApiApplication {

	public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/employee_db?useSSL=false","root","root");
        flyway.clean();
        flyway.migrate();
		SpringApplication.run(RestfulApiApplication.class, args);
	}

}
