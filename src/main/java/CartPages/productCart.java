package CartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productCart {

	WebDriver driver;
	
	@FindBy(xpath ="//button[@type='button']")
	WebElement addToCart;
	//button[@type='button']
	
	
	
	@FindBy(xpath ="")
	WebElement increment;
	
	@FindBy(xpath ="//u[text()='View Cart']")
	WebElement viewCart;
	
	@FindBy(xpath ="//input[@id='quantity']")
	WebElement inputQuantity;
	
//	@FindBy(xpath ="//p[text()='Your product has been added to cart.']")
//	WebElement verifyCartMessage;
	
	@FindBy(xpath ="//tr[@id='product-1']//td[@class='cart_quantity']//button")
	WebElement verifyQuantity;
	
	@FindBy(xpath ="//a[text()='Proceed To Checkout']")
	WebElement verifyProceedToCheckout;
	
//	@FindBy(xpath ="//button[@class='btn btn-default cart']")
//	WebElement addToCart;
	
	public productCart(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterQuantity(String n) {
		inputQuantity.clear();        
	    inputQuantity.sendKeys(n);
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public String verifyViewCartBtn() {
		
		return viewCart.getText();
	}
	
	public void viewCart() {
		viewCart.click();
	}
	
	public String verifyQuantity() {
		
		return verifyQuantity.getText(); 
	}
	
	public String verifyProceedButton() {
		
		return verifyProceedToCheckout.getText();
	}

}
