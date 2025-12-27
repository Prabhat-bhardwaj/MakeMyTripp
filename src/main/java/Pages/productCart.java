package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class productCart {

	WebDriver driver;
	ElementUtils utils;

	@FindBy(xpath = "//button[@type='button']")
	WebElement addToCart;
	// button[@type='button']

	@FindBy(xpath = "")
	WebElement increment;

	@FindBy(xpath = "//u[text()='View Cart']")
	WebElement viewCart;

	@FindBy(xpath = "//input[@id='quantity']")
	WebElement inputQuantity;

//	@FindBy(xpath ="//p[text()='Your product has been added to cart.']")
//	WebElement verifyCartMessage;

	@FindBy(xpath = "//tr[@id='product-1']//td[@class='cart_quantity']//button")
	WebElement verifyQuantity;

	@FindBy(xpath = "//a[text()='Proceed To Checkout']")
	WebElement verifyProceedToCheckout;

//	@FindBy(xpath ="//button[@class='btn btn-default cart']")
//	WebElement addToCart;

	public productCart(WebDriver driver) {

		this.driver = driver;
		this.utils = new ElementUtils(driver);
		PageFactory.initElements(driver, this);

	}

	public WebElement getViewCart() {

		return viewCart;
	}

	public void enterQuantity(String qty) {
		inputQuantity.clear();
//		inputQuantity.sendKeys(n);
		utils.sendKeys(inputQuantity, qty);
	}

	public void clickAddToCart() {
//		addToCart.click();
		utils.click(addToCart);
	}

	public String verifyViewCartBtn() {

		return viewCart.getText();
	}

	public WebElement getProceedBtn() {

		return verifyProceedToCheckout;
	}

	public void viewCart() {
		utils.click(viewCart);
//		viewCart.click();
	}

	public String verifyQuantity() {
		return utils.getText(verifyQuantity);
//		return verifyQuantity.getText();
	}

	public String verifyProceedButton() {
		return utils.getText(verifyProceedToCheckout);
//		return verifyProceedToCheckout.getText();
	}

}
