package com.vishal.stockmongodemo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.stockmongodemo.entity.Investor;
import com.vishal.stockmongodemo.exception.StockApplicationException;
import com.vishal.stockmongodemo.service.InvestorService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class InvestorServiceTest {
    @Autowired
    private InvestorService investorService;
    
    /**
     * Method testAddInvestor.
     * 
     * 
     * @throws StockApplicationException
     */
    @Test
    public void testAddInvestor() throws StockApplicationException {
	Investor investor = investorService.addInvester(getInvestorBean());
	if (investor.getFirstName().equalsIgnoreCase("vishal")) {
	    assertTrue(true);
	}
    }
    
    /**
     * Method testAddInvestor2.
     * 
     * @throws StockApplicationException
     */
   // @Test(expected = StockApplicationException.class)
    public void testAddInvestor2() throws StockApplicationException {
	Investor investor = investorService.addInvester(null);
	
    }
    

    
   
    /**
     * Method getInvestorBean.
     * 
     * 
     * @return Investor
     */
    private Investor getInvestorBean() {
	
	Investor investor = new Investor();
	investor.setFirstName("vishal");
	investor.setLastName("kumar2");
	investor.setUsername("vishal");
	investor.setMobile("989380828");
	investor.setEmail("lakhmapurkarvishal@yahoo.com");
	investor.setPassword("vishal123");
	investor.setAddressLineOne("40 sai vihar");
	investor.setAddressLineTwo("post tilak nagar");
	investor.setCity("indore");
	investor.setState("MP");
	investor.setPostalcode("458990");
	investor.setPasswordSet(true);
	return investor;
	
    }
}
