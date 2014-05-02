package com.vishal.stockmongodemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mongoapplicationContext.xml" })
public class Mongotest {
	@Autowired UserRepository repo;
	 
	  @Test public void setUp() {
		  User user =new User();
		  
		  user.setId("oneqwe");
		  user.setFullName("xcc");
	    repo.save(user);
	    
	  }
}
