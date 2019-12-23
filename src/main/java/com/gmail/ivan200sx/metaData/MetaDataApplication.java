package com.gmail.ivan200sx.metaData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gmail.ivan200sx.metaData.ui.web"})
public class MetaDataApplication {

  public static void main(String[] args) {
    SpringApplication.run(MetaDataApplication.class, args);
  }

}
