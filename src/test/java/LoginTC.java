import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTC extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage.clickLogin();
		Thread.sleep(2000);
		loginPage.enterEmail("prabhat9759@gmail.com");
		loginPage.enterPassword("Test@123");
		loginPage.clickSubmit();
		Thread.sleep(2000);
		String expText = "Logout";
		Assert.assertEquals(loginPage.verifyLogoutText().trim(), expText);
	}

}
