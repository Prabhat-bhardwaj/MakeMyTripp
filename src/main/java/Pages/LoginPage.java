package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//a[text()=' Signup / Login']")
	private WebElement signup;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement email;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement password;

	@FindBy(xpath = "//button[@data-qa='login-button']")
	private WebElement submit;

	@FindBy(xpath = "//a[text()=' Logout']")
	private WebElement actualText;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickLogin() {

		signup.click();
	}

	public void enterEmail(String Email) {
		email.click();
		email.sendKeys(Email);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickSubmit() {
		submit.click();
	}

	public String verifyLogoutText() {
		return actualText.getText();
	}
}
