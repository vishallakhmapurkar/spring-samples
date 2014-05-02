package com.vishal.stockmongodemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.GenericValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vishal.stockmongodemo.entity.Investor;
import com.vishal.stockmongodemo.exception.StockApplicationException;
import com.vishal.stockmongodemo.mailutil.MailService;
import com.vishal.stockmongodemo.service.InvestorService;

/**
 * @author vishal.lakhmapurkar
 * @version $Revision: 1.0 $
 */
@Controller
public class RegistrationController {
    @Autowired
    private InvestorService investorService;

    @Autowired
    private MailService     mailService;
    private static Logger   LOGGER = Logger.getLogger(RegistrationController.class);

    /**
     * Method showForm.
     * 
     * @param invester
     *            Investor
     * 
     * @return ModelAndView
     */
    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public ModelAndView showForm(@ModelAttribute("invester") Investor invester) {
	ModelAndView mav = new ModelAndView("registration");
	if (invester == null) {
	    invester = new Investor();
	}
	mav.addObject("invester", invester);
	return mav;
    }

    /**
     * Method submitForm.
     * 
     * @param invester
     *            Investor
     * 
     * @return String
     */
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public String submitForm(@ModelAttribute("invester") final Investor invester) {
	if (invester != null) {
	    invester.setPassword(generatePassword());
	    invester.setPasswordSet(false);
	    Investor investerDetails;
	    try {
		investerDetails = investorService.addInvester(invester);
		if (investerDetails == null) {
		    LOGGER.debug("No invester Added");
		    return "fail";
		} else {
		    LOGGER.debug("Added invester in DB" + invester.toString());
		    String subject = "Stock-moneytracker-Registration Details";
		    String body = "Hi," + investerDetails.getFirstName() + "\n Your Username is : - "
			    + investerDetails.getUsername() + "\n Password is :" + investerDetails.getPassword();
		    LOGGER.debug("Sending mail after successfully registration");
		    mailService.sendMail("no-reply@yahoo.com", investerDetails.getEmail(), subject, body);
		    return investerDetails.getEmail();
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

   

    /**
     * Method changepassword.
     * 
     * @param invester
     *            Investor
     * @param req
     *            HttpServletRequest
     * 
     * @return String
     */
    @RequestMapping(value = "/changepassword.do", method = RequestMethod.POST)
    @ResponseBody
    public String changepassword(@ModelAttribute("invester") final Investor invester, final HttpServletRequest req) {
	if ((invester != null) && !GenericValidator.isBlankOrNull(invester.getPassword())) {
	    Investor oldInvestor = (Investor) (req.getSession().getAttribute("invster"));
	    oldInvestor.setPassword(invester.getPassword());
	    oldInvestor.setPasswordSet(true);
	    Investor investerDetails;
	    try {
		investerDetails = investorService.addInvester(oldInvestor);
		if (investerDetails == null) {
		    LOGGER.debug("Password has not been changed");
		    return "fail";
		} else {
		    LOGGER.debug("Password has been changed");
		    return "success";
		}
	    } catch (StockApplicationException e) {
		LOGGER.error(e.getMessage(), e);
	    }

	}
	return "fail";

    }

   

    public String generatePassword() {
	int len = 8;
	char[] pwd = new char[len];
	int c = 'A';
	int rand = 0;
	for (int i = 0; i < 8; i++) {
	    rand = (int) (Math.random() * 3);
	    switch (rand) {
		case 0:
		    c = '0' + (int) (Math.random() * 10);
		    break;
		case 1:
		    c = 'a' + (int) (Math.random() * 26);
		    break;
		case 2:
		    c = 'A' + (int) (Math.random() * 26);
		    break;
	    }
	    pwd[i] = (char) c;
	}
	return new String(pwd);
    }
}
