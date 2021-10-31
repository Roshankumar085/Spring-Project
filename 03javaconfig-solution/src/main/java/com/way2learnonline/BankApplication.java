package com.way2learnonline;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.way2learnonline.service.BankService;

@Configuration
@ComponentScan
@PropertySource("classpath:db.properties")

  public class BankApplication {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
         
		ConfigurableApplicationContext context=SpringApplication.run(BankApplication.class); 
		BankService service = context.getBean(BankService.class);
		service.transfer(1L ,2L , 5000);
	}
	@Value("classpath:dbscripts.sql")private Resource dbscript;
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource(){		  
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driverclassname"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;		
	}
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource){
		DataSourceInitializer initializer= new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		return initializer;
	}
	
	private DatabasePopulator databasePopulator() {
	     ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(dbscript);		   
	    return populator;
	}

}
