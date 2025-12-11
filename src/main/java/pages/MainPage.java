package pages;

import com.sun.source.tree.BreakTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public By textInput = By.xpath("//input[@id='my-text-id']");
    public By passWord = By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][1]/label[@class='form-label w-100'][2]/input[@class='form-control']");
    public By textArea = By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][1]/label[@class='form-label w-100'][3]/textarea[@class='form-control']");
    public By checkedCB = By.xpath("//input[@id='my-check-1']");
    public By defaultCB = By.xpath("//input[@id='my-check-2']");
    public By defaultRadio = By.xpath("//input[@id='my-radio-2']");
    public By submit = By.xpath("/html[@class='h-100']/body[@class='d-flex flex-column h-100']/main[@class='flex-shrink-2']/div[@class='container']/form/div[@class='row']/div[@class='col-md-4 py-2'][2]/button[@class='btn btn-outline-primary mt-3']");
    //1
    public void setTextInput(String textinput){
        driver.findElement(textInput).sendKeys(textinput);
    };
    public void setTextArea(String textarea){
        driver.findElement(textArea).sendKeys(textarea);
    };
    public void setPassword(String password){
        driver.findElement(passWord).sendKeys(password);
    };

    //2
    public void setCheckboxTrue(){
        if (!isCheckedCBTrue()) {
            driver.findElement(checkedCB).click();
        }
        if (!isDefaultCBTrue()) {
            driver.findElement(defaultCB).click();
        }
    };
    public boolean isCheckedCBTrue(){
        return driver.findElement(checkedCB).isSelected();
    }
    public boolean isDefaultCBTrue(){
        return driver.findElement(defaultCB).isSelected();
    }

    //3
    public void setRadioTrue(){
        driver.findElement(defaultRadio).click();
    }
    public boolean isRadioTrue(){
        return driver.findElement(defaultRadio).isSelected();
    }

    //4
    public void clickSubmit(){
        driver.findElement(submit).click();
    }

    //5
    /*public boolean isGenderMaleSelected(){
        return driver.findElement(radioButtonLocator).isSelected();
    };

    public void setGenderMale(){
        driver.findElement(radioButton).click();
    };*/
}

