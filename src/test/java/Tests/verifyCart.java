package Tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import CartPages.productCart;
import Pages.productDetails;
import dataproviders.jsonDataProvider;

@Listeners(listeners.TestListener.class)
public class verifyCart extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = jsonDataProvider.class)

	public void testVerifyCart(String username, String password) throws InterruptedException {
		doLogin(username, password);
		productDetails pd = new productDetails(driver);
		productCart pc = new productCart(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pd.getProductElement()));

		pd.clickProduct();
		pd.clickViewProduct();
		pc.enterQuantity("2");
		pc.clickAddToCart();

		wait.until(ExpectedConditions.elementToBeClickable(pc.getViewCart()));
		pc.viewCart();

		String actualQty = pc.verifyQuantity();
		Assert.assertEquals(actualQty, "25", "Entered quantity is incorrect");

		wait.until(ExpectedConditions.elementToBeClickable(pc.getProceedBtn()));
		String proceedBtn = "Proceed To Checkout";
		Assert.assertEquals(pc.verifyProceedButton().trim(), proceedBtn);
	}
}
