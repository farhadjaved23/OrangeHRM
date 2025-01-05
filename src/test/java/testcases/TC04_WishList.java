package testcases;

import base.BaseTest;
import config.URLConfig;
import config.UserConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P03_ProductsPage;
import pages.P04_WishListPage;
import utility.PasswordEncrypt;

public class TC04_WishList extends BaseTest {

    @Test (priority = 1)
    public void verifyWishlist() throws Exception {
        driver.get(new URLConfig().getAccountUrl());
        System.out.println(PasswordEncrypt.decrypt("sLuYtt1lufwDHdIkDXF1jg==","9KeMQYj2zuTb7locbQ06yg=="));
        new P01_LoginPage(driver).handleCookie().inputUserName(new UserConfig().getUsername())
                .inputPassword(PasswordEncrypt.decrypt(new UserConfig().getPassword(),new UserConfig().getSecretKey()))
                .clickBtnLogin();
        driver.get(new URLConfig().getMenTeesUrl());
        new P04_WishListPage(driver).moveToWishList();
        Assert.assertTrue(new P04_WishListPage(driver).isItemDisplayed(),"Item is not visible");
    }
}
