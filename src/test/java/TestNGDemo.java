import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestNGDemo {

    private String baseURL = "http://www.leafground.com/pages/checkbox.html";

    private By languagesYouKnowLocator =
            By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input[1]");
    private By checkedSeleniumLocator =
            By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input[1]");
    private By deselectCheckedLocator =
            By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[2]");
    private By selectAllLocator = By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input");

    private WebDriver driver;
    private WebElement languagesYouKnow;
    private WebElement checkedSelenium;
    private WebElement delesectChecked;
//    private WebElement allChecks;


    @BeforeClass
    public void setUp() {

        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);

        languagesYouKnow = driver.findElement(languagesYouKnowLocator);
        checkedSelenium = driver.findElement(checkedSeleniumLocator);
        delesectChecked = driver.findElement(deselectCheckedLocator);
//        selectAll = driver.findElement(selectAllLocator);


    }


    @Test
    public void checkboxClick() {
        languagesYouKnow.click();
        Assert.assertTrue(checkedSelenium.isSelected());

    }

    @Test
    public void confirmingIsCheckByDefault() {
        Assert.assertTrue(checkedSelenium.isSelected());
    }

    @Test
    public void isNotCheckedMore() {
        delesectChecked.click();
        Assert.assertFalse(delesectChecked.isSelected());
        System.out.println((delesectChecked.isSelected()));

    }

    @Test
    public void selectingAllCheckboxes() {
        List<WebElement> allchecks = driver.findElements(selectAllLocator);

        allchecks.forEach(webElement -> {
            webElement.click();
            Assert.assertTrue(webElement.isSelected());
        });


    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

