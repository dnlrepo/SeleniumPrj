
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static testSite.DriverFactory.*;

public class BaseTestClass{

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver and wait variable
    public WebDriver driver;
    public WebDriverWait wait;
    WebElement element;

    //Declare a test URL variable
    public String testURL = "https://practis.co.il/automation/";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeSuite
    public void setupTest() {
        driver = getChromeDriver();
        wait = getWebDriverWait();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goToPage(){
        //driver.manage().window().setSize(new Dimension(411, 731)); //Pixel2 format, in case I test on mobile
        driver.get(testURL);
    }


    @AfterSuite
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}
