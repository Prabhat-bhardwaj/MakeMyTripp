package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;

import Pages.contactPage;
import Utilities.ConfigReader;

public class ContactsPageTC {

	static WebDriver driver;

	@BeforeClass
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver = new ChromeDriver();

	}

	@Test
	public void Contacts() throws InterruptedException {
		ConfigReader config = new ConfigReader();
		LoginPage loginPage = new LoginPage(driver);
		contactPage contactP = new contactPage(driver);

//		driver.get("http://www.freecrm.com/");
		driver.get(config.getProperty("baseUrl"));
		driver.manage().window().maximize();
		loginPage.clickLogin();
		loginPage.enterEmail("prabhat9759@gmail.com");
		loginPage.enterPassword("Test@123");
		loginPage.clickSubmit();

		Thread.sleep(5000);

		contactP.clickContact();
		contactP.enterNameAndCompany("Bunty", "Kumar", "Singh", "Innefu Labs");
		contactP.selectAccessAndUser();
		contactP.enterTags("No Tags Available To Enter");
		contactP.enterEmail("bunty.kumar@innefu.com");
		Thread.sleep(2000);
		contactP.selectCategory();
		Thread.sleep(5000);
		contactP.selectStatus();
		Thread.sleep(5000);
		contactP.clickSave();

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
