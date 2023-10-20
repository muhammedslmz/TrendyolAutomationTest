package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ProductBasket extends BasePage{
    By lambaderProduct =new By.ByXPath("(//span[@title='Oda Aydınlatma Sistemi Full Rgb - Full Renk - Çok Özellik KUMANDALI -ORJİNAL'])[1]");
    By lambaderBtn = new By.ByXPath("/html/body/div[1]/div[2]/div/div/div[1]/nav/ul/li[4]/div/div/div/div[3]/div[1]/ul/li[2]/a");
    By addBasketBtn = new By.ByXPath("/html/body/div[1]/div[5]/main/div/div[2]/div/div[2]/div[2]/div/div[1]/div[6]/button/div[1]");
    By basketBtnVisibility =new By.ByXPath("//div[@class='basket-preview-container visible']");
    By basketBtn = new By.ByXPath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/a/p");
    By basketProduct = new By.ByXPath("/html/body/div[1]/div[3]/div/div[1]/div/div[3]/div[3]/div/div[3]/a/p[1]");
    By productFeatures = new By.ByXPath("/html/body/div[1]/div[5]/main/div/section/div/ul");
    By increaseAmountBtn =new By.ByXPath("/html/body/div[1]/div[3]/div/div/div/div[3]/div[3]/div/div[4]/div/div[1]/div/div/button[2]");
    By decreaseAmountBtn = new By.ByXPath("/html/body/div[1]/div[3]/div/div[1]/div/div[3]/div[3]/div/div[4]/div/div[1]/div/div/button[1]");
    By deleteBtn =new By.ByXPath("//div[@class='pb-basket-item-actions']//i[@class='i-trash']");

    WebElement x,z,y,numOfProducts;
    String feature="";

    public ProductBasket(WebDriver driver) {
        super(driver);
    }
    public void addBasket(){
        WebElement evMobilyaBtnArea =drivers().findElement(By.xpath("//a[normalize-space()='Ev & Mobilya']"));
        Actions action =new Actions(drivers());
        action.moveToElement(evMobilyaBtnArea).perform();
        waitForSecond(2);
        click(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/nav/ul/li[4]/div/div"));
        click(lambaderBtn);
        scrollPageElement(drivers().findElement(lambaderProduct));
        waitForSecond(1);
        click(By.xpath("/html"));
        click(lambaderProduct);
        String originalWindow = drivers().getWindowHandle();
        for(String windowHandle  : drivers().getWindowHandles()){
            if(!originalWindow.contentEquals(windowHandle)){
                drivers().switchTo().window(windowHandle);
                click(By.xpath("//div[@class='onboarding']//div[@class='shadow']"));
                scrollPageElement(drivers().findElement(productFeatures));
                x = drivers().findElement(By.xpath("/html/body/div[1]/div[5]/main/div/section/div/ul/li[6]/span[2]/b"));
                feature =x.getText();

                scrollPageElement(drivers().findElement(addBasketBtn));
                click(addBasketBtn);
            }
        }
        boolean basketControl = isDisplay(basketBtnVisibility);
        Assert.assertTrue(basketControl);
    }

    public void isInBasket(){
        click(basketBtn);
        click(basketProduct);
        click(By.xpath("/html"));
        scrollPageElement(drivers().findElement(productFeatures));
        y = drivers().findElement(By.xpath("/html/body/div[1]/div[5]/main/div/section/div/ul/li[6]/span[2]/b"));
        String featureControl = y.getText();
        boolean check = feature==featureControl;
        Assert.assertFalse(check);

    }
    public void basketIconNum (){
        numOfProducts = drivers().findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div/div[2]/a/div[2]"));
        String numOfBasketProducts = numOfProducts.getText();
        click(basketBtn);
        System.out.println("1: "+numOfBasketProducts);
        z = drivers().findElement(By.xpath("//div[@class='ty-display-flex ty-numeric-counter']//input[@class='counter-content']"));
        String numOfProductsInBasket=z.getAttribute("value");
        System.out.println( "2: "+ numOfProductsInBasket    );
        //boolean numOfProductsControl = numOfProductsInBasket==numOfBasketProducts;
        //Assert.assertTrue(numOfProductsControl);
        Assert.assertEquals(numOfBasketProducts,numOfProductsInBasket);
    }
    public void changeProductAmount(){
        click(basketBtn);
        z = drivers().findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/aside/div/div[2]/ul/li[1]/strong"));
        String totalPrice=z.getText();
        click(increaseAmountBtn);
        waitForSecond(2);
        x= drivers().findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/aside/div/div[2]/ul/li[1]/strong"));
        String increasedTotalPrice= x.getText();
        boolean priceControl =totalPrice!=increasedTotalPrice;
        Assert.assertTrue(priceControl);

        click(decreaseAmountBtn);
        waitForSecond(2);
        y= drivers().findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/aside/div/div[2]/ul/li[1]/strong"));
        String decreasedTotalPrice= x.getText();
        boolean priceControl2 =decreasedTotalPrice!=increasedTotalPrice;
        Assert.assertTrue(priceControl2);
    }
    public void deleteProduct(){
        click(basketBtn);
        click(deleteBtn);
        waitForSecond(2);
        boolean isDeleted =isDisplay(By.xpath("//div[@class='pb-basket-item-details']//p[@class='pb-item']"));
        Assert.assertFalse(isDeleted);
    }

}

