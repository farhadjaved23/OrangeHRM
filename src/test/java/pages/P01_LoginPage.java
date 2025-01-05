package pages;

import actions.CustomDecorator;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static base.BaseTest.driver;

public class P01_LoginPage {


    private final By cookieBtn = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");
    private final By userNameField = By.xpath("//div[@class=\"control\"]//following-sibling::input[@title=\"Email\"]");
    private final By passwordField = By.xpath("//div[@class=\"control\"]//following-sibling::input[@title=\"Password\"]");
    private final By loginBtn = By.xpath("//button[@class=\"action login primary\"]//span[normalize-space(text())='Sign In']");
    private final By errorMsgText = By.className("messages");

    public P01_LoginPage(WebDriver driver) {
        driver = BaseTest.getDriver();
    }

    public P01_LoginPage handleCookie(){
        new CustomDecorator(driver,cookieBtn,2000).click();
        return this;
    }

    public P01_LoginPage inputUserName(String userName) {
        new CustomDecorator(driver, userNameField, 2000).sendKeys(userName);
        return this;
    }

    public P01_LoginPage inputPassword(String password) {
        new CustomDecorator(driver, passwordField, 2000).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickBtnLogin() {
        new CustomDecorator(driver, loginBtn, 2000).click();
        return this;
    }

    public boolean getErrorMsg(){
        boolean isDisplayed = new CustomDecorator(driver,errorMsgText,5).isDisplayed();
        System.out.println(isDisplayed);
        return isDisplayed;
    }
}
