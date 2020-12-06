import org.testng.annotations.Test;
import testSite.pages.Home.HomePage;
import testSite.pages.MainPage.MainPage;

public class MainFlow extends BaseTestClass {

    HomePage home = HomePage.getHomePage();
    MainPage mainP = MainPage.getMainPage();

    @Test
    public void testMethod() {
       home.login();
       mainP.buttonsCheck();
       mainP.textResizeCheck();
       mainP.ChangeColorCheck();
    }

}

