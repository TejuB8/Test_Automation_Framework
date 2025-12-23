package com.ui.tests;
import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({com.ui.listeners.TestListener.class})
public class InvalidLoginTest extends TestBase{
	  Logger logger=LoggerUtility.getLogger(this.getClass());
	  private static final String INVALID_EMAIL_ADRESS="tejubbborakanavar@gmail.com";
	  private static final String INVALID_PASSWORD="Qwerty1234!";
	  
   
	 @Test(description="Verifies the error message when logged in using invalid credentials", groups= {"e2e","sanity","smoke"})
   public void loginTest() {
	    assertEquals(homePage.goToLoginPage().doLoginWithInvalidCreds(INVALID_EMAIL_ADRESS, INVALID_PASSWORD).getErrorMsg(),"Authentication failed.");
	   
	}
   
   
  
}
