package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"introAgreeButton\"]/span/span")
    public WebElement introAgreeButton;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement googleSearchInput;

    @FindBy(xpath = "//div[@class='vk_bk dDoNo XcVN5d']//span")
    private WebElement currentDate;


    public GoogleSearchPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAgreeButton() {
        introAgreeButton.click();
    }

    public void setGoogleSearchInput(String strGoogleSearchInput) {

        googleSearchInput.sendKeys(strGoogleSearchInput);
    }

    public void fulfillSearchBar(String strGoogleSearchInput) {

        this.setGoogleSearchInput(strGoogleSearchInput);
    }

    public WebElement getCurrentDate() {
        return currentDate;
    }
}