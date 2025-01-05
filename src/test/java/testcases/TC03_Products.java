package testcases;

import base.BaseTest;
import config.URLConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P03_ProductsPage;

import java.util.ArrayList;

public class TC03_Products extends BaseTest {

    final String titleValue = "Tees - Tops - Men";
    final String windowTitleValue = "Strike";

    @Test (priority = 1)
    public void verifyProductsCount() throws Exception {
        driver.get(new URLConfig().getMenTeesUrl());
        new P01_LoginPage(driver).handleCookie();
        Assert.assertEquals(new P03_ProductsPage(driver).getTexts(),12);
    }

    @Test (priority = 1)
    public void verifyAscPrice() throws Exception {
        driver.get(new URLConfig().getMenTeesUrl());
        new P01_LoginPage(driver).handleCookie();
        new P03_ProductsPage(driver).getAscPrice();
        Assert.assertTrue(new P03_ProductsPage(driver).getPrice());
    }

    @Test (priority = 1)
    public void verifyClickingRandomItems() throws Exception {
        driver.navigate().to(new URLConfig().getMenTeesUrl());
        new P01_LoginPage(driver).handleCookie();
        new P03_ProductsPage(driver).clickRandomItem();
        driver.navigate().back();
        char[] charData = titleValue.toCharArray();
        ArrayList<String> arrData = new ArrayList<>();
        for(int i=0; i<charData.length;i++){
            System.out.println(charData[i]);
            if(charData[i]!=' ' && charData[i]!='-'){

                arrData.add(String.valueOf(charData[i]));
            }
            else {
                System.out.println("Removing =>" + charData[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String ch : arrData) {
            result.append(ch);
        }
        System.out.println(result);
    }

    @Test (priority = 1)
    public void verifyWindowOnNewTab() throws Exception {
        driver.navigate().to(new URLConfig().getMenTeesUrl());
        new P01_LoginPage(driver).handleCookie();
        new P03_ProductsPage(driver).clickRightBtn();
        new P03_ProductsPage(driver).moveToNewTab();
        String getTitle = driver.getTitle();
        String titleValue = getTitle.replace("Endurance Tee", "").trim();
        Assert.assertEquals(titleValue,windowTitleValue);
    }

    @Test (priority = 1)
    public void verifyItemColors() {
        driver.navigate().to(new URLConfig().getMenTeesUrl());
        new P01_LoginPage(driver).handleCookie();
        new P03_ProductsPage(driver).getRedShirts();
        Assert.assertTrue(new P03_ProductsPage(driver).getCheckedColor());
    }
}
