package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.openAccountPage;

public class OpenAccountTest extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException {

		doLogin("prabhat", "Test@123");

		openAccountPage oac = new openAccountPage(driver);

		Thread.sleep(2000);
		oac.clickOpenNewAcc();
		oac.clickAccTypeDropdown();
		oac.clickAccIdDropdown();
		oac.clickSubmit();
		Thread.sleep(2000);
		String expText2 = "Congratulations, your account is now open.";

		Assert.assertEquals(oac.verifyNewOpenedAcc().trim(), expText2);
	}

}
