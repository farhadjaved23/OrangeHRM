package pages;

import actions.CustomDecorator;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static base.BaseTest.driver;

public class P04_WishListPage {


    private final By wishListBtn = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[2]/a[1]");
    private final WebElement wishList = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]"));

    public P04_WishListPage(WebDriver driver) {
        driver = BaseTest.getDriver();
    }

    public P04_WishListPage moveToWishList() {
        new CustomDecorator(driver,wishListBtn,2).mouseHover(wishList);
        return this;
    }

    public boolean isItemDisplayed() {
        return true;
    }
}