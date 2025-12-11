import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @Test
    public void step_7(){
        WebElement element = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][1]/label[@class='form-label w-100'][4]/input[@class='form-control']"));
        boolean isDisabled = element.getAttribute("disabled") != null;
        Assert.assertTrue(isDisabled);
        WebElement element2 = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][1]/label[@class='form-label w-100'][5]/input[@class='form-control']"));
        boolean isReadonly = element2.getAttribute("readonly") != null;
        Assert.assertTrue(isReadonly);
    }

    @Test
    public void step_8(){
        WebElement dateInput = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][3]/label[@class='form-label w-100'][2]/input[@class='form-control']"));
        dateInput.sendKeys("09/11/2022");
    }

    @Test
    public void step_9(){
        WebElement colorPickerInput = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][3]/label[@class='form-label w-100'][1]/input[@class='form-control form-control-color']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String hexColor = "#FFFFFF";
        js.executeScript("arguments[0].value = arguments[1];", colorPickerInput, hexColor);
    }

    @Test
    public void step_10(){
        WebElement slider = driver.findElement(By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][3]/label[@class='form-label w-100'][3]/input[@class='form-range']"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 250, 0).perform();
    }
    @AfterTest
    public void afterTest(){
        /*driver.quit();*/
        //mimimimimi
    }
}
