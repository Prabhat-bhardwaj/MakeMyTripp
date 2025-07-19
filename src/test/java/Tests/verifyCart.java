package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CartPages.productCart;
import Pages.productDetails;
import listeners.TestListener;

@Listeners(TestListener.class)
public class verifyCart extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = dataproviders.ExcelDataProviders.class)
	public void BaseTest(String email, String pwd) throws InterruptedException {

		doLogin(email, pwd);
		productDetails pd = new productDetails(driver);
		productCart pc = new productCart(driver);
		Thread.sleep(2000);
		pd.clickProduct();
		pd.clickViewProduct();
		Thread.sleep(2000);
		pc.enterQuantity("4");
		Thread.sleep(2000);
		pc.clickAddToCart();
		String cartMesg = "View Cart";
//		Assert.assertEquals(pc.verifyViewCartBtn().trim(), cartMesg);
		Thread.sleep(2000);
		pc.viewCart();
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pc.verifyQuantity())));
		Thread.sleep(4000);
		String actualQty = pc.verifyQuantity();
		Assert.assertEquals(actualQty, "44", "❌ Entered quantity is incorrect");
		
//		String quantity = "4";
//		Assert.assertEquals(pc.verifyQuantity().trim(), quantity);

		String proceedBtn = "Proceed To Checkout";
		Assert.assertEquals(pc.verifyProceedButton().trim(), proceedBtn);
	}
}
