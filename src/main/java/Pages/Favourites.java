package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Favourites extends BasePage{
    By popupCloseBtn = new By.ByXPath("/html/body/div[1]/div[3]/div[3]/div[2]/div/div/div/div/div[1]");
    By popup = new By.ById("gender-popup-modal");
    By favouritesBtn = new By.ByXPath("//p[normalize-space()='Favorilerim']");
    public Favourites(WebDriver driver) {
        super(driver);
    }
    public void isDisplayFavouritesBtn(){
        if(isDisplay(popup)){
            click(popup);
            click(popupCloseBtn);
        }
        boolean checkFavouritesBtn =isDisplay(favouritesBtn);
        Assert.assertTrue(checkFavouritesBtn);


    }
    public void accessFavourites(){
        click(favouritesBtn);
        boolean isInFavourites = isDisplay(By.xpath("//span[normalize-space()='Favorilerim']"));
        Assert.assertTrue(isInFavourites);
    }
    public void notAccessFavouritesWithoutLogin(){
        click(favouritesBtn);
        boolean isInFavourites = isDisplay(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/form/button"));
        Assert.assertTrue(isInFavourites);
    }
}
