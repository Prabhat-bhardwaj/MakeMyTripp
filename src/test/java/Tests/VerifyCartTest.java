package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dataproviders.jsonDataProvider;
import pages.productCart;
import pages.productDetails;

@Listeners(listeners.TestListener.class)
public class VerifyCartTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = jsonDataProvider.class)
    public void testVerifyCart(String username, String password)
            throws InterruptedException {   // ✅ ONLY THIS ADDED

        doLogin(username, password);

        productDetails pd = new productDetails(driver);
        productCart pc = new productCart(driver);

        pd.clickProduct();
        pd.clickViewProduct();
        pc.enterQuantity("2");
        pc.clickAddToCart();
        pc.viewCart();

        String actualQty = pc.verifyQuantity();
        Assert.assertEquals(actualQty, "45", "Quantity mismatch");

        String proceedBtn = "Proceed To Checkout";
        Assert.assertEquals(pc.verifyProceedButton().trim(), proceedBtn);
    }
}
