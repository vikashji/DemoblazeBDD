package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageDBze {
	WebDriver ldriver;

	public SignUpPageDBze(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "signin2")
	@CacheLookup
	WebElement Signup;

	@FindBy(id = "sign-username")
	@CacheLookup
	WebElement SignupEmail;

	@FindBy(id = "sign-password")
	@CacheLookup
	WebElement SignupPassword;

	@FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
	@CacheLookup
	WebElement SignUpButton;

	public void SignUp() {
		Signup.click();
	}

	public void Signmail(String mail) {
		SignupEmail.clear();
		SignupEmail.sendKeys(mail);
	}

	public void SignPass(String pass) {
		SignupPassword.clear();
		SignupPassword.sendKeys(pass);
	}

	public void ClickOnSignButton() {
		SignUpButton.click();
	}
}