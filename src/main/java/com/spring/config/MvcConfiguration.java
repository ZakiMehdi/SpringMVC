package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

@Configuration
@ComponentScan(basePackages = "com")
@EnableWebMvc
@PropertySource("classpath:database.properties")
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	
	@Autowired
	Environment environment;
	//private final String URL = "jdbc:sqlserver://DESKTOP-N1ONR3Q:1433;databaseName=GL;user=sa;password=pwd@123";
	private final String USER = "dbuser";
	private final String SERVERNAME = "servername";
	private final String PASSWORD = "dbpassword";
	private final String PORTNUMBER = "portnumber";
	private final String DBNAME = "dbname";

	@Bean
	DataSource dataSource() {
		
		
		   SQLServerDataSource ds =
			  new SQLServerDataSource(); ds.setUser(environment.getProperty(USER)); ds.setPassword(environment.getProperty(PASSWORD));
			 
			  ds.setServerName(environment.getProperty(SERVERNAME)); ds.setPortNumber(Integer.parseInt(environment.getProperty(PORTNUMBER)));
			  ds.setDatabaseName(environment.getProperty(DBNAME));

		return ds;
	}
	

	
	  @Bean public ViewResolver getViewResolver(){ InternalResourceViewResolver
	  resolver = new InternalResourceViewResolver();
	  resolver.setPrefix("/WEB-INF/views/"); resolver.setSuffix(".jsp"); return
	  resolver; }
	  
	  @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**").addResourceLocations(
	  "/resources/"); }
	 


}
