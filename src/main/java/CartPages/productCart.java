package CartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productCart {

	WebDriver driver;
	
	@FindBy(xpath ="//button[@type='button']")
	WebElement addToCart;
	//button[@type='button']
	
	
	
	@FindBy(xpath ="")
	WebElement increment;
	
	@FindBy(xpath ="//p[@class='text-center'][2]")
	WebElement viewCart;
	
	@FindBy(xpath ="")
	WebElement b;
	
	@FindBy(xpath ="")
	WebElement c;
}
