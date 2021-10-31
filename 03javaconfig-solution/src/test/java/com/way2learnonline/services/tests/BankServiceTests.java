package com.way2learnonline.services.tests;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.way2learnonline.service.BankService;



public class BankServiceTests {	
	
	private BankService bankService;
	
	private AnnotationConfigApplicationContext context;
	
	@Before
	public void init() throws Exception{
		
//		 context= new AnnotationConfigApplicationContext(ApplicationConfig.class,InfrastructureConfig.class);		
//		 
//		 		bankService=context.getBean("bankService",BankService.class);
		
	}	

	@Test
	public void testTransfer() throws SQLException{
		
		Long transactionId=bankService.transfer(new Long(1), new Long(2), 5000);
		assertNotNull(transactionId);
	}
	
	@After
	public void destroy(){
		context.close();
	}
	

}
