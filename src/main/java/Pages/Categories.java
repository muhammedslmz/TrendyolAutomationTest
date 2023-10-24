package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Objects;

public class Categories extends BasePage{

    By searchBoxArea = new By.ByXPath("//div[@id='sfx-discovery-search-suggestions']//div[@class='mOkuL__p']//div[@class='N4M8bfaJ']//input[@class='V8wbcUhU']");
    By popupCloseBtn = new By.ByXPath("/html/body/div[1]/div[3]/div[3]/div[2]/div/div/div/div/div[1]");
    By popup = new By.ById("gender-popup-modal");
    By searchBtn = new By.ByXPath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div/i");
    By boschCheckBox = new By.ByXPath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[2]/div[3]/div/div/div[1]/div/a/div[1]");
    By arçelikCheckBox = new By.ByXPath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[2]/div[3]/div/div/div[2]/div/a/div[1]");
    By product = new By.ByXPath("//div[@data-id='442952583']//div[@class='image-overlay-body']");
    By cepTelefonuCategories = new By.ByXPath("//div[@id='sub-nav-5']//a[contains(text(),'Cep Telefonu')]");
    WebElement x;
    String arcelik ="Arçelik", bosch ="Bosch";
    public Categories(WebDriver driver) {
        super(driver);
    }

    public void brandCategorization(){
        click(popup);
        click(popupCloseBtn);
        send(searchBoxArea,"buzdolabı");
        click(searchBtn);
        click(boschCheckBox);
        waitForSecond(1);
        click(arçelikCheckBox);
        click(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/div/div"));
        click(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[1]/div[2]/div/ul/li[3]/span"));
        click(product);

        String originalWindow = drivers().getWindowHandle();
        for(String windowHandle  : drivers().getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                drivers().switchTo().window(windowHandle);
                x= drivers().findElement(By.xpath("//h1[@class='pr-new-br']//a[@class='product-brand-name-with-link']"));
                String brand =x.getText();
                Assert.assertTrue(Objects.equals(brand, arcelik) || Objects.equals(brand, bosch));
                drivers().switchTo().window(originalWindow);
            }
        }
        scrollPageElement(drivers().findElement(By.xpath("//span[@title='KDN76AIF0N A++ Çift Kapılı No Frost Buzdolabı']")));
        click(By.xpath("//span[@title='KDN76AIF0N A++ Çift Kapılı No Frost Buzdolabı']"));
        for(String windowHandle  : drivers().getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                drivers().switchTo().window(windowHandle);
                x= drivers().findElement(By.xpath("//h1[@class='pr-new-br']//a[@class='product-brand-name-with-link']"));
                String brand =x.getText();
                Assert.assertTrue(Objects.equals(brand, arcelik) || Objects.equals(brand, bosch));
                drivers().switchTo().window(originalWindow);
            }
        }
    }
    public void priceCategorization(){
        click(popup);
        click(popupCloseBtn);
        click(searchBoxArea);
        send(searchBoxArea,"buzdolabı");
        click(searchBtn);
        click(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[7]/div[1]"));
        click(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[7]/div[3]/a[6]/div[1]"));
        waitForSecond(1);

        WebElement y = drivers().findElement(By.xpath("//div[@class='fltrs-wrppr hide-fltrs']//input[@placeholder='En Az']"));
        int lowerLimit = Integer.parseInt(y.getAttribute("value"));
        WebElement z = drivers().findElement(By.xpath("//div[@class='fltrs-wrppr hide-fltrs']//input[@placeholder='En Çok']"));
        int upperLimit =Integer.parseInt(z.getAttribute("value"));

        scrollPageElement(drivers().findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[4]/div[1]/div/div[8]/div[1]/a/div[2]/div[1]/div/h3/span[1]")));
        x=drivers().findElement(By.xpath("//div[@class='prc-box-dscntd'][normalize-space()='119.899 TL']"));
        String stringPrice =x.getText();

        StringBuilder stringBuilder = new StringBuilder(stringPrice);
        stringBuilder.delete(stringBuilder.length() - 3,stringBuilder.length());
        String newPrice=stringBuilder.toString();
        String deleteDot= ".";
        String insteadOfDot= "";
        String clearPrice =newPrice.replace(deleteDot,insteadOfDot);
        int price = Integer.parseInt(clearPrice);

        if(price>=lowerLimit && price<=upperLimit){
            Assert.assertTrue(true);
        }
    }
    public void productPath(){
        click(popup);
        click(popupCloseBtn);
        WebElement elektronikBtnArea=drivers().findElement(By.xpath("//a[@class='category-header navbar-first-cap'][normalize-space()='Elektronik']"));
        Actions action = new Actions(drivers());
        action.moveToElement(elektronikBtnArea).perform();
        click(By.xpath("//div[@id='sub-nav-5']//div[@class='sub-nav-outer']"));
        click(cepTelefonuCategories);
        Assert.assertTrue(isDisplay(By.xpath("//div[@class='breadcrumb']")));


    }
}
