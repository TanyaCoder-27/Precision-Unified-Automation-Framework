package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class HomePage extends Basepage {

    private By logo = By.xpath("//img[@alt='Website for automation practice']");
    private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By productbtn=By.xpath("//a[@href='/products']");
    private By cartBtn = By.xpath("//a[@href='/view_cart']");
    public boolean isHomeVisible() {
        return WaitUtils.waitForElement(logo).isDisplayed();
    }

    public void clickSignupLogin() {
        try {
            // Wait for element to be clickable first
            WaitUtils.waitForElementToBeClickable(signupLoginBtn).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // If still intercepted, try JavaScript click
            WebElement signupLoginElement = WaitUtils.waitForElement(signupLoginBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signupLoginElement);
        }
    }
    public void clickOnProduct() {
        try {
            // Wait for element to be clickable first
            WaitUtils.waitForElementToBeClickable(productbtn).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // If still intercepted, try JavaScript click
            WebElement productElement = WaitUtils.waitForElement(productbtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productElement);
        }
    }
    public void clickCart() {
        try {
            // Wait for element to be clickable first
            WaitUtils.waitForElementToBeClickable(cartBtn).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // If still intercepted, try JavaScript click
            WebElement cartElement = WaitUtils.waitForElement(cartBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartElement);
        }
    }
}