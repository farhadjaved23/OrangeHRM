package pages;

import actions.CustomDecorator;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.RandomGenerator;

import java.awt.*;
import java.util.*;
import java.util.List;

import static base.BaseTest.driver;

public class P03_ProductsPage {


    private final By productCards = By.xpath("//ol[@class=\"products list items product-items\"]");
    private final By sortDD = By.xpath("//*[@id=\"sorter\"]");
    private final WebElement productText = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]"));
    private final By proText = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]");
    private final By itemColor =
            By.xpath("//div[@aria-label=\"Red\"]");
    private final By selectColor =
            By.xpath("(//div[@class=\"product details product-item-details\"]//div[@class=\"swatch-attribute color\"]/div/div[@aria-checked=\"true\"])[1]");
    private  final By cartBtn = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button");
    private final By warningMsg = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div");

    public P03_ProductsPage(WebDriver driver) {
        driver = BaseTest.getDriver();
    }

    public int getTexts(){
        int itemsCount = 0;
        WebElement web = driver.findElement(productCards);
        List<WebElement> text = web.findElements(By.xpath("//a[@class=\"product-item-link\"]"));
        ArrayList<WebElement> getItemNames = new ArrayList<>();
        for(int i=0; i< text.size(); i++){
            getItemNames.add(text.get(i));
            if(getItemNames.get(i).getText().contains("Tee")){
                itemsCount = getItemNames.size();
        }
        }
        return itemsCount;
    }

    public P03_ProductsPage getAscPrice(){
        Select sortValue = new Select(driver.findElement(sortDD));
        sortValue.selectByIndex(2);
        return this;
    }

    public boolean getPrice() {
        boolean isTrue = false;
        ArrayList<Double> itemPrices = new ArrayList<>();
        WebElement web = driver.findElement(productCards);
        List<WebElement> priceElements = web.findElements(By.xpath(".//div[@class='price-box price-final_price']"));
        for (WebElement priceElement : priceElements) {
            double priceText = Double.parseDouble(priceElement.getText().substring(11));
            itemPrices.add(priceText);
        }
        for(int i=0; i<itemPrices.size()-1;i++)
        {
            if(itemPrices.get(i)<=itemPrices.get(i+1))
            {
                isTrue = true;
            }
            else {
                isTrue = false;
            }
        }
        return isTrue;
    }

    public void clickRandomItem() {
        WebElement web = driver.findElement(productCards);
        List<WebElement> text = web.findElements(By.xpath("//a[@class=\"product-item-link\"]"));
        text.get(RandomGenerator.generateRandomInt(1,text.size())).click();
    }

    public P03_ProductsPage clickRightBtn() throws AWTException {
      new CustomDecorator(driver,proText,2000)
              .rightClick(productText);
      new CustomDecorator(driver, proText, 2000)
              .mouseAction();
      return this;
    }

    public P03_ProductsPage moveToProduct() {
        new CustomDecorator(driver,proText,2000)
                .mouseHover(productText);
        new CustomDecorator(driver,proText, 5).isDisplayed();
        return this;
    }

    public P03_ProductsPage clickAddToCart() {
        new CustomDecorator(driver,cartBtn,2000)
                .click();
        return this;
    }

    public boolean isWarningDisplayed() {
        new CustomDecorator(driver,cartBtn,2000).isDisplayed();
        return true;
    }

    public P03_ProductsPage moveToNewTab() {
        Set<String> windowOptions = driver.getWindowHandles();
        System.out.println("Window Options are => "+ windowOptions);//We put the windowOptions in Arraylist because set can not maintain the index
        ArrayList<String> getWindowValues = new ArrayList<>(windowOptions);
        driver.switchTo().window(getWindowValues.get(1));
        return this;
    }

    public void getRedShirts() {
        int randValue = 0;
        String attributeValue = new CustomDecorator(driver, itemColor, 2).getAttribute("option-label");
        if (attributeValue != null) {
            for(int i=0; i<attributeValue.length(); i++){
                randValue = RandomGenerator.generateRandomInt(1,attributeValue.length());
            }
            driver.findElement(By.xpath("(//div[@class=\"product details product-item-details\"]//div[@class=\"swatch-attribute color\"]/div/div[@option-label=\"Red\"])["+randValue+"]")).click();

        } else {
            System.out.println("The attribute 'aria-label' is not present or has no value.");
        }
    }

    public boolean getCheckedColor() {
        boolean isTrue = false;
        String attributeValue = new CustomDecorator(driver, selectColor, 2).getAttribute("aria-checked");

        if (attributeValue.equalsIgnoreCase("true")) {
            isTrue = true;
            System.out.println(attributeValue);
        } else {
            System.out.println("The attribute 'aria-checked' is not true");
        }
        return isTrue;
    }
}
