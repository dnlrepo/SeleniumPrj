package testSite.pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static testSite.DriverFactory.*;

public class MainPage {

    private MainPage(){
        //hide it
    }

    public static MainPage getMainPage(){
        return new MainPage();
    }

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();
    WebElement element;
    List<WebElement> elements;

    public void buttonsCheck() {
        elements = driver.findElements(By.xpath("//button"));
        Assert.assertFalse(elements.get(1).isEnabled());
        elements.get(0).click();
        Assert.assertFalse(elements.get(0).isEnabled());
        elements.get(1).click();




    }

    public void textResizeCheck(){
       element =  driver.findElement(By.id("textFontSize"));

        Assert.assertEquals(element.getCssValue("font-size"), "20px", "Base font size is not 20");
        elements.get(2).click();
        Assert.assertEquals(element.getCssValue("font-size"), "23px", "Font resize +3px failed");
        elements.get(3).click();
        Assert.assertEquals(element.getCssValue("font-size"), "20px", "Font resize -3px failed");
        elements.get(3).click();
        Assert.assertEquals(element.getCssValue("font-size"), "17px", "Font resize -3px failed");
    }

    public void ChangeColorCheck()  {

        String[] bgColor = {"black", "white", "blue", "red"};
        int i;
        for (i = 0; i < bgColor.length; i++) {

            driver.findElement(By.id("bgColor")).sendKeys(bgColor[i]);
            elements.get(4).click();
            element = driver.findElement(By.id("formToColorize"));
            Assert.assertEquals(element.getAttribute("style"), "background: " + bgColor[i] + ";", "Background color mismatch");
            driver.findElement(By.id("bgColor")).clear();
        }


    }
}


