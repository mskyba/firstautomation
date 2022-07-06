package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {


    protected static WebDriver driver;
    protected static String pageUrl;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public String getPageUrl(){
        return pageUrl;
    }



}
