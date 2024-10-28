package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDBze {
	WebDriver ldriver;

	public LoginPageDBze(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "login2")
	@CacheLookup
	WebElement Login;

	@FindBy(id = "loginusername")
	@CacheLookup
	WebElement LoginEmail;

	@FindBy(id = "loginpassword")
	@CacheLookup
	WebElement LoginPassword;

	@FindBy(className = "btn btn-primary")
	@CacheLookup
	WebElement LoginButton;

	public void ClickLogin() {
		Login.click();
	}

	public void Entermail(String mail) {
		LoginEmail.clear();
		LoginEmail.sendKeys(mail);
	}

	public void EnterPass(String pass) {
		LoginPassword.clear();
		LoginPassword.sendKeys(pass);
	}

	public void LoginButton() {
		LoginButton.click();
	}
}
