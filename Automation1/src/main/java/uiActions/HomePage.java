package uiActions;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class HomePage extends TestBase{
	

	
	public static final Logger log =Logger.getLogger(HomePage.class.getName());
	WebDriver driver ;
	
	int ActualResult;
	int ExpectedResult;
	
	
	//Locators
	
	@FindBy(id="lst-ib")
	WebElement SearchBox;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/form/div[2]/div[3]/center/input[1]")
	WebElement SearchButton;
	
	@FindBy(css="#cwbt23 > div.cwbtpl.cwlgb-tpl > span.cwbts")
	WebElement input1;
	
	@FindBy(css="#cwbt24 > div.cwbtpl.cwlgb-tpl > span.cwbts")
	WebElement input2;
	
	@FindBy(css="#cwbt46 .cwbts")
	WebElement plussymbol;
	
	@FindBy(css=".cwbb-tpl > .cwbts")
	WebElement equalssymbol;
	
	@FindBy(css="div.cwtlotc")
	WebElement result;
	
	
	
	
	
	
	
	
	
	//Creating Constructor to intiate all WebElements
	public HomePage(WebDriver driver) {
		//inside constructor we r intialising Driver
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void LandingPage() {
		
		SearchBox.sendKeys("Calculator");
		log("Entered Calculator in Search Box");
		SearchButton.click();
		log("Clicked on Search Button");
		
		

}
	
	public boolean getwebpagetitle() {
		String title =driver.getTitle();
		return true;
		
	}
	
public void Addition()  {
		
		input1.click();
		log("First Input Entered on Calculator");
		plussymbol.click();
		log("Addition Clicked on Calculator");
		input2.click();
		log("Second Input Entered on Calculator");
		equalssymbol.click();
		String VerifyResult = result.getText();
		
		int ActualResult=Integer.parseInt(VerifyResult);
		int ExpectedResult = 9;
		System.out.println("The sum of Numbers is "+ActualResult);
		
		
		

}
	
	}

