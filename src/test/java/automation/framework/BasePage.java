package automation.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver) { this.driver = driver;}

    public void waitforElementDisplayed(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void fillElementWithValue(By locator, String sentence){
        driver.findElement(locator).click();
        driver.findElement(locator).sendKeys(sentence);
    }
}
