package com.sypialnia;

import com.sypialnia.domain.entities.Address;
import com.sypialnia.domain.repositories.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SypialniaApplication {
  @Autowired private AddressRepository repository;
  private static final Logger logger = LoggerFactory.getLogger(SypialniaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SypialniaApplication.class, args);
    logger.info("Hello!");
  }

  @Bean
  CommandLineRunner runner() {
    return args -> {
      // Save demo data to database
    };
  }
}
