package Pages;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productDetails {

	WebDriver driver;

	@FindBy(xpath = "//a[@href='/products']")
	private WebElement products;

	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement allProducts;

	@FindBy(xpath = "//div[@class='brands-name']")
	private WebElement brandsName;

	@FindBy(xpath = "//a[@href='/product_details/1']")
	private WebElement viewProduct;

	@FindBy(xpath = "//h2[text()='Blue Top']")
	private WebElement name;

	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	private WebElement category;

	@FindBy(xpath = "//span[text()='Rs. 500']")
	private WebElement price;

	@FindBy(xpath = "//p[text()=' In Stock']")
	private WebElement availability;

	@FindBy(xpath = "//p[text()=' New']")
	private WebElement condition;

	@FindBy(xpath = "//p[text()=' Polo']")
	private WebElement brand;

	public productDetails(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickProduct() {

		products.click();
	}

	public Map<String, String> verifyAllProductsAndBrandList() {
		Map<String, String> productsAndBrandList = new HashMap<>();
		productsAndBrandList.put("All Products", allProducts.getText().trim());
		System.out.println(productsAndBrandList.put("BrandList", brandsName.getText().trim()));
		productsAndBrandList.put("BrandList", brandsName.getText().trim());
		return productsAndBrandList;
	}

	public void clickViewProduct() {

		viewProduct.click();
	}

	public Map<String, String> verifyProductDetails() {
		Map<String, String> details = new HashMap<>();
		String nameText = name.getText().trim();
		String categoryText = category.getText().trim();
		String priceText = price.getText().trim();
		String availabilityText = availability.getText().trim();
		String conditionText = condition.getText().trim();
		String brandText = brand.getText().trim();
		
		System.out.println("Name: " + nameText);
		System.out.println("Category: " + categoryText);
		System.out.println("Price: " + priceText);
		System.out.println("Availability: " + availabilityText);
		System.out.println("Condition: " + conditionText);
		System.out.println("Brand: " + brandText);
		
		details.put("Name", name.getText().trim());
		details.put("Category", category.getText().trim());
		details.put("Price", price.getText().trim());
		details.put("Availability", availability.getText().trim());
		details.put("Condition", condition.getText().trim());
		details.put("Brand", brand.getText().trim());
		return details;

	}

}
