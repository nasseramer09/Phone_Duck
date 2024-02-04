package com.example.phone_duck;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.phone_duck.Repository", "com.example.phone_duck.Services","com.example.phone_duck.Model","com.example.phone_duck.Controller"})
public class PhoneDuckApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneDuckApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {};
    }
}
