package com.gmail.ivan200sx.metaData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gmail.ivan200sx.metaData.ui.web", "com.gmail.ivan200sx.metaData"})
@EnableScheduling
public class MetaDataApplication {

  public static void main(String[] args) {
    SpringApplication.run(MetaDataApplication.class, args);
  }

}
