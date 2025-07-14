import java.util.Map;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.productDetails;

@Listeners(TestListener.class)
public class ProductDetailsTC extends BaseTest {
	@Test(dataProvider = "loginData", dataProviderClass = dataproviders.ExcelDataProviders.class)

	public void BaseTest(String email, String pwd) throws InterruptedException {

		doLogin(email, pwd);
		productDetails pd = new productDetails(driver);
		Thread.sleep(2000);
		pd.clickProduct();
//		String allPro = "All Products";
//		Assert.assertEquals(pd.verifyAllProductsAndBrandList(), allPro);

		pd.clickViewProduct();
		Thread.sleep(2000);

		Map<String, String> actualDetails = pd.verifyProductDetails();
		Assert.assertEquals(actualDetails.get("Name"), "Blue Top");
		Assert.assertEquals(actualDetails.get("Category"), "Category: Women > Tops");
		Assert.assertEquals(actualDetails.get("Price"), "Rs. 500");
		Assert.assertEquals(actualDetails.get("Availability"), "Availability: In Stock");
		Assert.assertEquals(actualDetails.get("Condition"), "Condition: New");
		Assert.assertEquals(actualDetails.get("Brand"), "Brand: Polo");

	}

}
