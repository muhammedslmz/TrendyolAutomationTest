package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Objects;

public class SearchBox extends BasePage{
    By popupCloseBtn = new By.ByXPath("/html/body/div[1]/div[3]/div[3]/div[2]/div/div/div/div/div[1]");
    By searchBoxArea = new By.ByXPath("//div[@id='sfx-discovery-search-suggestions']//div[@class='mOkuL__p']//div[@class='N4M8bfaJ']//input[@class='V8wbcUhU']");
    By popup = new By.ById("gender-popup-modal");
    By popAramalarHeader = new By.ByXPath("//h2[normalize-space()='Popüler Aramalar']");
    By sanaOzelHeader = new By.ByXPath("//h2[normalize-space()='Sana Özel Kategoriler']");
    By searchBtn = new By.ByXPath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div/i");
    public SearchBox(WebDriver driver) {
        super(driver);
    }
    public void isDisplaySearchBox(){
        click(popup);
        click(popupCloseBtn);
        Assert.assertTrue(isDisplay(searchBoxArea));
    }
    public void isDisplaySuggestions(){
        click(popup);
        click(popupCloseBtn);
        waitForSecond(1);
        click(searchBoxArea);
        Assert.assertTrue(isDisplay(popAramalarHeader)||isDisplay(sanaOzelHeader));
    }
    public void searchHistory(){
        click(popup);
        click(popupCloseBtn);
        String searchTxt ="Cep Telefonu";
        send(searchBoxArea,searchTxt);
        click(searchBtn);
        click(By.xpath("//img[@alt='Trendyol']"));
        click(searchBoxArea);
        WebElement lastSearch =drivers().findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div[2]"));
        String lastSearchTxt=lastSearch.getText();
        Assert.assertTrue(Objects.equals(searchTxt,lastSearchTxt));
    }
    public void clearSearchHistory(){
        click(popup);
        click(popupCloseBtn);
        send(searchBoxArea,"Pierre Cardin");
        click(searchBtn);
        waitForSecond(1);
        click(By.xpath("//img[@alt='Trendyol']"));
        waitForSecond(1);
        click(searchBoxArea);
        click(By.xpath("//button[normalize-space()='Temizle']"));
        Assert.assertFalse(isDisplay(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div[1]/h2")));
    }
}
