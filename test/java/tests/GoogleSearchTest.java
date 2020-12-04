package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class GoogleSearchTest extends BaseSeleniumTest {

    @Test
    public void googleSearch() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        Actions actions = new Actions(driver);
        driver.get("https://google.com");
        driver.switchTo().frame(0);
        googleSearchPage.clickAgreeButton();
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, "https://www.google.com/");
        googleSearchPage.fulfillSearchBar("data");
        actions.sendKeys(Keys.ENTER).build().perform();
        Assert.assertTrue(googleSearchPage.getCurrentDate().getText().contains("4 grudnia 2020"));
    }
}
