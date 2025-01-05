package testcases;

import base.BaseTest;
import config.URLConfig;
import config.UserConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import utility.PasswordEncrypt;

public class TC01_Login extends BaseTest {

    final String title = "Hoodies & Sweatshirts - Tops - Women";

    @Test (priority = 1)
    public void LoginValidCredentials() throws Exception {
        driver.get(new URLConfig().getAccountUrl());
        System.out.println(PasswordEncrypt.decrypt("sLuYtt1lufwDHdIkDXF1jg==","9KeMQYj2zuTb7locbQ06yg=="));
        new P01_LoginPage(driver).handleCookie().inputUserName(new UserConfig().getUsername())
                .inputPassword(PasswordEncrypt.decrypt(new UserConfig().getPassword(),new UserConfig().getSecretKey()))
                .clickBtnLogin();
        Assert.assertEquals(title,driver.getTitle());

    }

    @Test (priority = -5)
    public void LoginInValidCredentials() throws Exception {
        driver.get(new URLConfig().getAccountUrl());
        new P01_LoginPage(driver).handleCookie().inputUserName(new UserConfig().getUsername())
                .inputPassword(PasswordEncrypt.decrypt(new UserConfig().getInvalidPassword(),new UserConfig().getInvalidSecretKey()))
                .clickBtnLogin();
        if(new P01_LoginPage(driver).getErrorMsg()){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(new P01_LoginPage(driver).getErrorMsg());
        }
    }
}
