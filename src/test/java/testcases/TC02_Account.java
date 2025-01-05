package testcases;

import base.BaseTest;
import config.URLConfig;
import config.UserConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_AccountPage;
import utility.PasswordEncrypt;

public class TC02_Account extends BaseTest {

    final String countryDropDown = "Australia";

    @Test (priority = 1)
    public void verifyCountryWithDD() throws Exception {
        driver.get(new URLConfig().getAddressUrl());
        System.out.println(PasswordEncrypt.decrypt("sLuYtt1lufwDHdIkDXF1jg==","9KeMQYj2zuTb7locbQ06yg=="));
        new P01_LoginPage(driver).handleCookie().inputUserName(new UserConfig().getUsername())
                .inputPassword(PasswordEncrypt.decrypt(new UserConfig().getPassword(),new UserConfig().getSecretKey()))
                .clickBtnLogin();
        new P02_AccountPage(driver).managerLinkClick().billingLinkClick().getcountryDDClick();
        Assert.assertEquals(new P02_AccountPage(driver).getDDText(), countryDropDown);

    }

    @Test (priority = 1)
    public void verifyStates() throws Exception {
        driver.get(new URLConfig().getAddressUrl());
        System.out.println(PasswordEncrypt.decrypt("sLuYtt1lufwDHdIkDXF1jg==","9KeMQYj2zuTb7locbQ06yg=="));
        new P01_LoginPage(driver).handleCookie().inputUserName(new UserConfig().getUsername())
                .inputPassword(PasswordEncrypt.decrypt(new UserConfig().getPassword(),new UserConfig().getSecretKey()))
                .clickBtnLogin();
        new P02_AccountPage(driver).managerLinkClick().billingLinkClick().getcountryDDClick();
        Assert.assertTrue(new P02_AccountPage(driver).getState());
    }

    @Test (priority = 1)
    public void verifyCountryWithoutDD() throws Exception {
        driver.get(new URLConfig().getAddressUrl());
        System.out.println(PasswordEncrypt.decrypt("sLuYtt1lufwDHdIkDXF1jg==","9KeMQYj2zuTb7locbQ06yg=="));
        new P01_LoginPage(driver).handleCookie().inputUserName(new UserConfig().getUsername())
                .inputPassword(PasswordEncrypt.decrypt(new UserConfig().getPassword(),new UserConfig().getSecretKey()))
                .clickBtnLogin();
        new P02_AccountPage(driver).managerLinkClick().billingLinkClick().getcountryWithoutDDClick();
        Assert.assertEquals(new P02_AccountPage(driver).getDDText(), countryDropDown);
    }
}
