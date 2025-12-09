package pages;

import com.sun.source.tree.BreakTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public By radioButton = By.xpath("//div[@id='genterWrapper']/div[@class='col-md-9 col-sm-12']/div[@class='custom-control custom-radio custom-control-inline'][1]/label[@class='custom-control-label']");
    public By radioButtonLocator = By.xpath("//div[@id='genterWrapper']/div[@class='col-md-9 col-sm-12']/div[@class='custom-control custom-radio custom-control-inline'][1]/input[@value='Male']");
    public boolean a;
    public By fistNameLocator = By.xpath("//input[@id='firstName']");
    public void setFistName(String fistName){
        driver.findElement(fistNameLocator).sendKeys(fistName);
    };
    public boolean isGenderMaleSelected(){
        return driver.findElement(radioButtonLocator).isSelected();
    };

    public void setGenderMale(){
        driver.findElement(radioButton).click();
    };
}

