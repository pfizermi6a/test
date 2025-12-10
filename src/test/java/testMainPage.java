import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;

import static browser.Config.START_URL;


public class testMainPage {
    private WebDriver driver;
    private WebElement element;
    private MainPage mainPage;

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        mainPage.openURL(START_URL);
    }
    @Test
    public void step_1(){
        mainPage.setFistName("виталик");
        mainPage.setGenderMale();
        Assert.assertTrue(mainPage.isGenderMaleSelected());
    }
    @AfterTest
    public void afterTest(){
        /*driver.quit();*/
        //mimimimimi
    }
}
