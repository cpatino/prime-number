package com.developer.prime;

import com.developer.prime.configuration.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class PrimeNumberApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(PrimeNumberApplication.class, args);
  }
  
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");
  }
}
