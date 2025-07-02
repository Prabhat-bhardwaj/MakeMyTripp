package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement actualText;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

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

	public String verifyWelcomeText() {
		return actualText.getText();
	}
}
