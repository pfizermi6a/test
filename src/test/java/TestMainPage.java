import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import java.time.Duration;

import static browser.Config.START_URL;


public class TestMainPage {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        mainPage.openURL(START_URL);
    }

    @Test
    public void step_1(){
        mainPage.setTextInput("Михаил Глазов");
        mainPage.setTextArea("Михаил Глазов");
        mainPage.setPassword("qwerty1234");
    }

    @Test
    public void step_2(){
        mainPage.setCheckboxTrue();
        Assert.assertTrue(mainPage.isDefaultCBTrue());
        Assert.assertTrue(mainPage.isCheckedCBTrue());
    }

    @Test
    public void step_3(){
        mainPage.setRadioTrue();
        Assert.assertTrue(mainPage.isRadioTrue());
    }

    @Test
    public void step_4(){
        WebElement dropdownSelect = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][2]/label[@class='form-label w-100'][1]/select[@class='form-select']"));
        driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][2]/label[@class='form-label w-100'][2]/input[@class='form-control']")).sendKeys("Seattle");
        Select select = new Select(dropdownSelect);
        select.selectByVisibleText("Two");
    }

    @Test
    public void step_5(){
        mainPage.clickSubmit();

    }

    @Test
    public void step_6(){
        driver.navigate().back();
        WebElement submit = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/div[@class='row']/div[@class='col-12']/h1[@class='display-6']"));
        Assert.assertEquals(submit.getText(), "Web form");
    }
    @AfterTest
    public void afterTest(){
        /*driver.quit();*/
        //mimimimimi
    }
}
