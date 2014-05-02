package com.vishal.stockmongodemo.service;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.stockmongodemo.entity.Investor;
import com.vishal.stockmongodemo.exception.StockApplicationException;
import com.vishal.stockmongodemo.repository.InvestorRepository;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Service
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    /**
     * Method addInvester.
     * 
     * @param newInvestor
     *            Investor
    
    
    
     * @return Investor * @throws StockApplicationException * @see com.vishal.stockmongodemo.service.InvestorService#addInvester(Investor) */
    @Transactional
    public Investor addInvester(final Investor newInvestor) throws StockApplicationException {
	try {
	    return investorRepository.save(newInvestor);
	} catch (RuntimeException e) {
	    throw new StockApplicationException("Database server down please try after sometime.", e);
	}
    }

   
}
