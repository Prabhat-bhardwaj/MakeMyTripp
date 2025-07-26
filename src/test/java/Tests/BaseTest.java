package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LoginPage;

public class BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(60));

		System.out.println("Navigating to site...");
		driver.get("https://automationexercise.com/");
		System.out.println("Page loaded.");
	}

	public void doLogin(String username, String password) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		Thread.sleep(2000);
		login.clickLogin();
		Thread.sleep(2000);
		login.enterEmail(username);
		login.enterPassword(password);
		login.clickSubmit();
		Thread.sleep(2000);
		String expText = "Logout";
		Assert.assertEquals(login.verifyLogoutText().trim(), expText, "❌ Login failed: Logout button not visible");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
