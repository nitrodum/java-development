package com.pluralsight.beanDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BeanDemoApplication.class, args);
		for(String nameBean : ac.getBeanDefinitionNames()) {
			System.out.println(nameBean);
		}
	}

}
