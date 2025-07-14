import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;

	@BeforeClass
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
		Assert.assertEquals(login.verifyLogoutText().trim(), expText);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
