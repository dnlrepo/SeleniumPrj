package testSite.pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static testSite.DriverFactory.*;


public class HomePage {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();
    WebElement element;


    private HomePage(){
        //hide it
    }

    public static HomePage getHomePage(){
        return new HomePage();
    }

    public void login(){

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "Login page example", "Title assertion failed!");



        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();







    }

}
