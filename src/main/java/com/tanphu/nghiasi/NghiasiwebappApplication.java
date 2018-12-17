package com.tanphu.nghiasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing
public class NghiasiwebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(NghiasiwebappApplication.class, args);
    }
}
