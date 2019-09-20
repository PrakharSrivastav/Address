package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        final SpringApplication s = new SpringApplication(Application.class);
        s.setBannerMode(Banner.Mode.OFF);
        s.run(args);
    }
}
