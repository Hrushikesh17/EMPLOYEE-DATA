package com.Jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.Jsp")
public class Configure {
	
	@Bean
     public EntityManager getEntityManager() {
    	 EntityManagerFactory f = Persistence.createEntityManagerFactory("dev");
    	 return f.createEntityManager();
     }
	@Bean
	public EntityTransaction getTransaction() {
		EntityManager m = getEntityManager();
		return m.getTransaction();
	}
	
}
