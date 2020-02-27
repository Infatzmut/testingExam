package automation;

import automation.framework.ParentScenario;
import automation.pages.BookingPage;
import automation.pages.SelectFlyPage;
import cucumber.api.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

@CucumberOptions(features = {"src/test/resources/features/"})
public class AppTestRun extends ParentScenario {

    protected static BookingPage bookingPage;
    protected static SelectFlyPage selectFlyPage;
    //@BeforeTest
    //public void start(){
    //    navigateTo("https://www.edestinos.com.pe/?gclid=EAIaIQobChMIleq30Lvq5wIVygeRCh17-QpbEAAYAiAAEgLUzPD_BwE");
    //}

    @Override
    public void initPages(RemoteWebDriver driver) {
        bookingPage = new BookingPage(driver);
        selectFlyPage = new SelectFlyPage(driver);
    }
}
