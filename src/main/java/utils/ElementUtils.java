package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ===================== WAITS =====================

    public void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForUrlContains(String value) {
        wait.until(ExpectedConditions.urlContains(value));
    }

    // ===================== ACTIONS =====================

    public void click(WebElement element) {
        try {
            waitForClickable(element);
            element.click();
        } catch (Exception e) {
            jsClick(element); // fallback for ads / overlays
        }
    }

    public void sendKeys(WebElement element, String value) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public String getText(WebElement element) {
        waitForVisible(element);
        return element.getText().trim();
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
