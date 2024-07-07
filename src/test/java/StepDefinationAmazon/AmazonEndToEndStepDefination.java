package StepDefinationAmazon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonEndToEndStepDefination {
  
WebDriver driver = new ChromeDriver();
//hooks
@Before
public void setup() {
	System.out.println("Amazon System testing");
	
}
@After
public void tearDown() {
	System.out.println("Testing is done succesfully");
	
}
@BeforeStep
public void step() {
	System.out.println("Executing this step");
	
}
@AfterStep
public void exitstep() {
	System.out.println(" successfully execute this step");
	
}


	@Given("The user navigate to www.amazon.com")
	public void the_user_navigate_to_www_amazon_com() {
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		  driver.get("https://www.amazon.in/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@When("user enter valid username {string}")
	public void user_enter_valid_username(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions	
	   driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	   driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[1]/input[1]")).sendKeys(string,Keys.ENTER);
	  // driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[2]/span/span/input")).click();
	}

	@When("valid password {string}")
	public void valid_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		  driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password,Keys.ENTER);
		 
		  
	}

	@When("User tries to search for a product	and click on search")
	public void user_tries_to_search_for_a_product_and_click_on_search() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("caps men",Keys.ENTER);
		
		
		    
	}

	@Then("User will be navigate to the product page")
	public void user_will_be_navigate_to_the_product_page() throws InterruptedException {
		
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,500)");
		   Thread.sleep(2000);
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div[2]/div[2]/h2/a/span")).click();
		 Thread.sleep(5000);
		Set<String> windowhand=driver.getWindowHandles();
		 Iterator <String> it=windowhand.iterator();
		 Thread.sleep(2000);
		    String parent=it.next();
		    String child=it.next();
		 
		    driver.switchTo().window(child);
		    Thread.sleep(2000);
		   
	}

	@Then("select the fav product from the user end and add to the cart")
	public void select_the_fav_product_from_the_user_end_and_add_to_the_cart() throws InterruptedException {
		Thread.sleep(2000);

		Select s;
		 s= new Select(driver.findElement(By.xpath("//*[@id=\"quantity\"]")));
	      //step 2 select option
	      s.selectByIndex(1);  
	      driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
	      Thread.sleep(2000);
		
	}

	@Then("product should be added to cart")
	public void product_should_be_added_to_cart() throws IOException, InterruptedException {
		String Expectedtitle="Added to Cart";
		String  actualTittle= driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/h1")).getText();
		Assert.assertEquals(actualTittle, Expectedtitle,"text not matched");
		System.out.println("Cap is added on the card ");
		Thread.sleep(2000);
		TakesScreenshot ts = ((TakesScreenshot)driver);
	       File source = ts.getScreenshotAs(OutputType.FILE);
	       File destination = new File("./src/test/resources/saikat.png");
	       FileUtils.copyFile(source, destination);
	       
	}

	@Then("user will do checkout process with COD")
	public void user_will_do_checkout_process_with_cod() throws InterruptedException {
		
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
		
		}
	


	@Then("user will successfully checkout")
	public void user_will_successfully_checkout() throws InterruptedException, IOException {
	 driver.findElement(By.xpath("//*[@id=\"shipToThisAddressButton\"]/span/input")).click();
	 ;
	
	 Thread.sleep(5000);
		JavascriptExecutor js =(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,500)");
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));  
		 
    driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div[6]/div/div[3]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/div/div[2]/div[6]/div/div/div/div/div[1]/div/label/input")).click(); 
    Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")).click();
	Thread.sleep(5000);
	
    driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/div[2]/div/div/div/div/div[1]/span/span/span[1]/span/input")).click();
    
    
 
    Thread.sleep(5000);
    
	 TakesScreenshot ts = ((TakesScreenshot)driver);
     File source = ts.getScreenshotAs(OutputType.FILE);
     File destination = new File("./src/test/resources/saikat1.png");
     FileUtils.copyFile(source, destination); 
	}
	

	@Then("logout and  close the browser")
	public void logout_and_close_the_browser() throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(500,0)");
		 driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
		 Thread.sleep(5000)	;
		  WebElement element= driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[31]/a"));
		  js.executeScript("arguments[0].scrollIntoView()", element);
		  Thread.sleep(5000);
	      driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[32]/a")).click();
	      Thread.sleep(5000);
          driver.quit();
//          Set<String> windowhand=driver.getWindowHandles();
//    	 Iterator <String> it=windowhand.iterator();
//     	 Thread.sleep(2000); 
//     	    String parent=it.next();
//     	    String child=it.next();
//          driver.switchTo().window(parent);
//          Thread.sleep(5000);
//          driver.close();
	}
}
  

