package stepDefination;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.SignUpPageDBze;

public class StepDefDemo {
	public WebDriver driver;
	public SignUpPageDBze l;

	@Given("user Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		l = new SignUpPageDBze(driver);
	}

	@And("User opens url {string}")
	public void open_url(String url) throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		l.SignUp();
		Thread.sleep(3000);
	}

	@When("User enter New Username as {string} and Password as {string}")
	public void Enter_signup_details(String mail, String pass) throws InterruptedException {
		l.Signmail(mail);
		l.SignPass(pass);
		l.ClickOnSignButton();
		Thread.sleep(3000);
	}
	@When("User enter existing Username as {string} and Password as {string}")
	public void Enter_existing_credential(String mail, String pass) throws InterruptedException
	{l.Signmail(mail);
	l.SignPass(pass);
	l.ClickOnSignButton();
	Thread.sleep(3000);}

	@Then("Alert message should be {string}")
	public void Validate_Signup(String msg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText().trim(); // Get and trim the alert text
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, msg);
		alert.accept();
		driver.close();
	}
	@Then("With Invalid credential Alert message should be {string}")
	public void Validate_invalid_Signup(String msg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		String alertMessage1 = alert1.getText().trim(); // Get and trim the alert text
		System.out.println(alertMessage1);
		Assert.assertEquals(alertMessage1, msg);
		alert1.accept();
		driver.close();
	}
	
}
