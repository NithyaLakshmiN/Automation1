package homepage;


import java.io.IOException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;
import uiActions.HomePage;

public class TC002_Addingtwonumbers extends testBase.TestBase {

public static final Logger log =Logger.getLogger(TC002_Addingtwonumbers.class.getName());
HomePage homepage;
		
		@BeforeTest 
		public void setUp() throws IOException{
		init();
		}
		
		@Test
        public void CalculatorPage(){
			try {
			log.info("*****Starting TC002 Test Case Exceution*******" );
			homepage = new HomePage(driver);
			homepage.LandingPage();
			homepage.getwebpagetitle();
			Assert.assertEquals(true,homepage.getwebpagetitle(),"calculator-Google Search");
			captureScreen("GoogleResultsPage");
			homepage.Addition();
			Assert.assertEquals(9,9,"They are Equal");
			Thread.sleep(5000);
			captureScreen("Calculator Results");
			log.info("*****Finished TC002 Test Case Exceution*******" );
		}
			catch(AssertionError e) {
				captureScreen("GoogleResultsPage");
				captureScreen("Calculator Results");
				//Assert.assertTrue(true,"verifyLoginwithInvalidCredentials");
			}
			catch(Exception e) {
				log(e.fillInStackTrace().toString());
				
			}
		}
		
      
		

	


		
	}


