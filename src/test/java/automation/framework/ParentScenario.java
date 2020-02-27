package automation.framework;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class ParentScenario extends AbstractTestNGCucumberTests {
    protected static RemoteWebDriver driver;

    @BeforeTest
    @Parameters({ "browser" })
    public void startBrowser(String browser){
        switch (browser){
            case "chrome":
                startChrome();
                break;
            case "Firefox":
                startFirefox();
                break;
        }
    }

    public RemoteWebDriver startChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximazed");
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            initPages(driver);
        }catch (Exception e){
            System.out.println("Exception at moment to generate the driver " + e );
        }
        return driver;
    }

    public RemoteWebDriver startFirefox(){
        try {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            initPages(driver);
        } catch (Exception e) {
            System.out.println("Exception at moment to generate the driver " + e );
        }
        return driver;
    }

    public abstract void initPages(RemoteWebDriver driver);

    public void navigateTo(String url){ driver.navigate().to(url);}
}
