package automation.pages;

import automation.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BookingPage extends BasePage {
    public BookingPage (WebDriver driver){ super(driver);}

    By originSearch = By.name("tr[0][d]");
    By arrivalSearch = By.name("tr[0][a]");
    By originDate = By.name("tr[0][dd]");
    By arrivalDate = By.name("tr[1][dd]");
    By passengerSeatsPicker = By.className("pax-widget");
    By searcherButton = By.xpath("//button[contains(@class,'qsf-search')]");


    public void chooseDestination  (String origin , String destination) {
        waitforElementDisplayed(originSearch);
        fillElementWithValue(originSearch, origin);
        fillElementWithValue(arrivalSearch, destination);
    }

    public void chooseDates(String oDate, String aDate){
        chooseFromCalendar(originDate, oDate);
        chooseFromCalendar(arrivalDate, aDate);
    }

    private void chooseFromCalendar(By locator, String date){
        driver.findElement(locator).click();
        driver.findElement(By.xpath("//a[text()="+date+" and contains(@class,'ui-state-default')]")).click();
    }

    public void doSearch(){
        driver.findElement(searcherButton).click();
    }

}
