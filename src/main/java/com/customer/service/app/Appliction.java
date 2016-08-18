package com.customer.service.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;



@Configuration
@EnableAutoConfiguration
@ComponentScan("com.customer.service")
public class Appliction {
	
	public static void main(String... args) throws Exception {
		SpringApplication.run(Appliction.class, args);
	}
	
	@Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("bundles/Messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
