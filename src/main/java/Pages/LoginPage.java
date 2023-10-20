package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{
    By loginPageBtn =new ByXPath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div/div[1]/div[1]/p");
    By popupCloseBtn = new ByXPath("/html/body/div[1]/div[3]/div[3]/div[2]/div/div/div/div/div[1]");
    By popup = new By.ById("gender-popup-modal");
    By loginEmail = new By.ById("login-email");
    By loginPassword = new By.ById("login-password-input");
    By loginBtn =new ByXPath("/html/body/div[1]/div[3]/div[3]/div[1]/form/button");
    By loginError = new ByXPath("/html/body/div[1]/div[3]/div[3]/div[1]/span[2]");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void mainPage(){
        drivers().get("https://www.trendyol.com/erkek-gunes-gozlugu-x-g2-c105");
        boolean isPopupVisible = isDisplay(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[1]/div[2]/div[4]/div[1]/div/div[4]/div[1]/a/div[2]"));
        if(isPopupVisible)
            click(By.xpath("/html/body/div[1]/div[5]/div/div/div/div[1]/div[2]/div[4]/div[1]/div/div[4]/div[1]/a/div[2]"));

        click(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/a"));
        boolean isInMainPage = isDisplay(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div/div/div/article[2]/div/div/div/div/a[1]"));
        Assert.assertTrue(isInMainPage);
    }
    public void login (){
        click(popup);
        click(popupCloseBtn);
        click(loginPageBtn);
        send(loginEmail,"muhammed.slmz@gmail.com");
        send(loginPassword,"172126Mm");
        click(loginBtn);

        boolean loginCheck =isDisplay(loginError);
        Assert.assertFalse(loginCheck);
    }
    public void invalidMailLogin(){
        click(popup);
        click(popupCloseBtn);
        click(loginPageBtn);
        send(loginEmail,"invalid_mail");
        send(loginPassword,"172126Mm");
        click(loginBtn);
        boolean error = isDisplay(loginError);
        Assert.assertTrue(error);

    }
    public void invalidPasswordlLogin(){
        click(popup);
        click(popupCloseBtn);
        click(loginPageBtn);
        send(loginEmail,"muhammed.slmz@gmail.com");
        send(loginPassword,"invalid_password");
        click(loginBtn);
        boolean error = isDisplay(loginError);
        Assert.assertTrue(error);

    }
    public void invalidInfolLogin(){
        click(popup);
        click(popupCloseBtn);
        click(loginPageBtn);
        send(loginEmail,"invalid_mail");
        send(loginPassword,"invalid_password");
        click(loginBtn);
        boolean error = isDisplay(loginError);
        Assert.assertTrue(error);

    }


}





