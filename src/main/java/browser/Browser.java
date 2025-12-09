package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static browser.Config.BROWSER_TYPE;

public class Browser {
    public static WebDriver driver;

    public static WebDriver createDriver(){
        switch (BROWSER_TYPE){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("не то имя браузера");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
