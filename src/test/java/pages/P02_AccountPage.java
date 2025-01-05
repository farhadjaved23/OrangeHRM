package pages;

import actions.CustomDecorator;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static base.BaseTest.driver;

public class P02_AccountPage {


    private final By managerAddressLink = By.linkText("Manage Addresses");
    private final By billingAddressLink = By.partialLinkText("Billing");
    private final By countryDD = By.id("country");
    private final By regionDD = By.id("region_id");
    private final By countryDropDown = By.xpath("//*[@id=\"country\"]");

    public P02_AccountPage(WebDriver driver) {
        driver = BaseTest.getDriver();
    }

    public P02_AccountPage managerLinkClick(){
        new CustomDecorator(driver,managerAddressLink,2000).click();
        return this;
    }

    public P02_AccountPage billingLinkClick(){
        new CustomDecorator(driver,billingAddressLink,2000).click();
        return this;
    }

    public P02_AccountPage getcountryDDClick(){
        Select countryDDText = new Select(driver.findElement(countryDD));
        List<WebElement> dropdownText = countryDDText.getOptions();
        int dropdownSizedropdown = dropdownText.size();
        for(int i=0; i<dropdownSizedropdown; i++){
            if(dropdownText.get(i).getText().equalsIgnoreCase("Australia")){
                dropdownText.get(i).click();
            }
        }
        return this;
    }

    public P02_AccountPage getcountryWithoutDDClick(){
        WebElement dropdown = driver.findElement(countryDD);
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        int dropdownSizedropdown = options.size();
        System.out.println("Size "+dropdownSizedropdown);
        for(int i=0; i<dropdownSizedropdown; i++){
            System.out.println(options.get(i).getText());
            if(options.get(i).getText().equalsIgnoreCase("Australia")){
                options.get(i).click();
                break;
            }
        }
        return this;
    }

    public String getDDText(){
        Select countryDDText = new Select(driver.findElement(countryDD));
        WebElement data=countryDDText.getFirstSelectedOption();
        return data.getText();
    }

    public boolean getState(){
        boolean isTrue=false;
        HashMap<String,List<String>> state = new HashMap<>();
        List<String> stateName = List.of("Please select a region, state or province.","Australian Capital Territory","New South Wales","Northern Territory","Queensland","South Australia","Tasmania","Victoria","Western Australia");
        state.put("Australia",stateName);

        Select regionDDText = new Select(driver.findElement(regionDD));
        List<WebElement> dropdownText = regionDDText.getOptions();
        int dropdownSizedropdown = dropdownText.size();
        ArrayList<String> regionList = new ArrayList<>();
        for(int i=0; i<dropdownSizedropdown; i++){
            regionList.add(dropdownText.get(i).getText());
        }
        if(regionList.equals(state.get("Australia"))){
           isTrue = true;
           return isTrue;
        }

        return isTrue;
    }

}
