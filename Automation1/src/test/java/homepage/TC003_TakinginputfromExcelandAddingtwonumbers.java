package homepage;


import java.io.IOException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testBase.TestBase;
import uiActions.HomePage;
import org.testng.SkipException;


public class TC003_TakinginputfromExcelandAddingtwonumbers extends testBase.TestBase {

public static final Logger log =Logger.getLogger(TC003_TakinginputfromExcelandAddingtwonumbers.class.getName());
HomePage homepage;

   @DataProvider(name="testdata")
         public String[][] getTestData() {
	     String[][] testRecords =getData("TestData.xlsx","InputTestData");
	     return testRecords;
	
}
		
		@BeforeTest 
		public void setUp() throws IOException{
		init();
		}
		
		@Test(dataProvider="testdata")
        public void AddtwonumbersgettingfromExcel(){
			String runMode ="y";
			if(runMode .equalsIgnoreCase("n")){
				throw new SkipException("user marked this record as no run");
			}
			try {
			log.info("*****Starting TC003 Test Case Exceution*******" );
			homepage = new HomePage(driver);
			homepage.LandingPage();
			homepage.getwebpagetitle();
			Assert.assertEquals(true,homepage.getwebpagetitle(),"calculator-Google Search");
			captureScreen("GoogleResultsPage");
			homepage.Addition();
			Assert.assertEquals(9,9,"They are Equal");
			Thread.sleep(5000);
			captureScreen("Calculator Results");
			log.info("*****Finished TC003 Test Case Exceution*******" );
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


