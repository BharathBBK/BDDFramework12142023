package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepsDefinition {
	
	static WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
	    
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@And("enter valid username and password")
	public void enter_valid_username_and_password() {
	    
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
	    
	}

	@And("click on login Button")
	public void click_on_login_button() {
	    
		driver.findElement(By.id("login-button")).click();
	    
	}

	@Then("user is navigated to home screen")
	public void user_is_navigated_to_home_screen() {
	    
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Products')]"));
		
		String label = ele.getText();
		
		Assert.assertEquals(label, "Products");
		
	    
	}

	@And("close the browser")
	public void close_the_browser() {
	    
		driver.close();
		
	    
	}


}
