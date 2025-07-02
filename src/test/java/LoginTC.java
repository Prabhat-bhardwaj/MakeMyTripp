import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTC extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.enterEmail("prabhat");
		loginPage.enterPassword("Test@123");
		loginPage.clickSubmit();
		Thread.sleep(2000);
		String expText = "Welcome Prabhat Bhardwaj";
		Assert.assertEquals(loginPage.verifyWelcomeText().trim(), expText);
	}

}
