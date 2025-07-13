import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import Pages.productDetails;

public class ProductDetailsTC extends BaseTest {

	@Test
	public void BaseTest() throws InterruptedException {
		
		doLogin("prabhat9759@gmail.com", "Test@123");
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
		
//		Assert.assertEquals(pd.verifyProductDetails(), null);
	}
	
}
