package com.example.clinic;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Clinic project", description = "This system work for " +
        "only hospitals"))
public class ClinicProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicProjectApplication.class, args);
    }

}
