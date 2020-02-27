package automation.pages;

import automation.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectFlyPage extends BasePage {
    public SelectFlyPage(WebDriver driver) { super(driver);}

    By flyContainer = By.cssSelector("div.with-filters>div>ul.offers");

    public boolean verifyFlightsAreDisplayed(){
         waitforElementDisplayed(flyContainer);
        return driver.findElement(flyContainer).isDisplayed();
    }
}
