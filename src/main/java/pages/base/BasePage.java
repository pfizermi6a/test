package pages.base;

import org.openqa.selenium.WebDriver;

import static browser.Config.START_URL;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void openURL(String url){
        driver.get(url);
    }
}
