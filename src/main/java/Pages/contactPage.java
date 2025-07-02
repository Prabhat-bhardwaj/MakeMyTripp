package Pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactPage {

	private WebDriver driver;
	private WebElement dropdownElement;
	private Select dropdown;
	private WebElement actionElement;
	private Actions action;
	private WebElement waitElement;
	private WebDriverWait wait;
//	Select select = new Select(dropdownElement);

	@FindBy(xpath = "//i[@class='home icon']")
	WebElement hover;

	// @FindBy(xpath ="//span[text()='Contacts']")
	@FindBy(xpath = "//div[3]//button[1]//i[1]")
	WebElement contact;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement middleName;

//	@FindBy(xpath ="//input[@class='search']//parent::div[@name='company']")
	@FindBy(xpath = "//div[@name='company']")
	WebElement company;

	@FindBy(xpath = "//i[@class='unlock icon']")
	WebElement publicAccess;

	@FindBy(xpath = "//i[@class='lock icon']")
	WebElement privateAccess;

	@FindBy(xpath = "//i[@class='dropdown icon']//parent::div[@class='ui active visible fluid multiple selection dropdown']")
	WebElement accessDropdown;

	@FindBy(xpath = "//i[@class='delete icon']")
	WebElement removeUser;

	@FindBy(xpath = "//div[@class='ui fluid multiple search selection dropdown']")
	WebElement tags;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement email;

	@FindBy(xpath = "//i[@class='remove icon']")
	WebElement removeEmail;

	@FindBy(xpath = "//i[@class='lock icon']")
	WebElement personalEmail;

	@FindBy(xpath = "(//i[@class='add icon'])[1]")
	WebElement addEmail;

//	@FindBy(xpath ="//i[@class='dropdown icon']//parent:@name='category']")
	@FindBy(xpath = "(//i[@class='dropdown icon'])[2]")
	WebElement categoryDropdown;

	@FindBy(xpath = "//span[text()='Customer']")
	WebElement customer;

	@FindBy(xpath = "//i[@class='dropdown icon']//parent::div[@name='status']")
	WebElement statusDropdown;

	@FindBy(xpath = "//span[text()='Active']")
	WebElement activeStatus;

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;

	@FindBy(xpath = "//div[@name='channel_type']")
	WebElement channelDropdown;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;

	public contactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickContact() throws InterruptedException {
		this.actionElement = hover;
		this.action = new Actions(driver);
		action.moveToElement(hover).perform();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@id='dashboard-toolbar']")).click();
		contact.click();
		driver.findElement(By.xpath("//div[@id='dashboard-toolbar']")).click();
		Thread.sleep(2000);
	}

	public void enterNameAndCompany(String first, String middle, String last, String Company)
			throws InterruptedException {
		firstName.sendKeys(first);
		middleName.sendKeys(middle);
		lastName.sendKeys(last);

		this.waitElement = company;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		company = wait.until(ExpectedConditions.elementToBeClickable(company));
		company.click();
		Thread.sleep(2000);
//		company.click();
		company.sendKeys(Company);
	}

	public void selectAccessAndUser() throws InterruptedException {
		if (publicAccess.isDisplayed()) {
			System.out.println(publicAccess.isDisplayed() + "Display Method");
			System.out.println(publicAccess.isEnabled() + "Enable Method");
			Thread.sleep(2000);
			publicAccess.click();
//			publicAccess.click();
			Thread.sleep(2000);
		}
	}

	public void enterTags(String tag) {
//		tags.sendKeys(tag);
	}

	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}

	public void selectCategory() throws InterruptedException {
		categoryDropdown.click();
		Thread.sleep(2000);
		customer.click();

//		this.dropdownElement = categoryDropdown;
//		this.dropdown = new Select(dropdownElement);
//		dropdown.selectByIndex(2);

	}

	public void selectStatus() throws InterruptedException {
//		this.dropdownElement = statusDropdown;
//		this.dropdown = new Select(dropdownElement);
		statusDropdown.click();
//		dropdown.selectByIndex(2);
		Thread.sleep(2000);
		activeStatus.click();

	}

	public void enterDescription(String descriptiion) {
		description.sendKeys(descriptiion);
	}

	public void clickSave() {
		saveButton.click();
	}

}
