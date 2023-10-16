package Pages;

import javafx.scene.control.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void login (){
        click(popup);
        click(popupCloseBtn);
        click(loginPageBtn);
        send(loginEmail,"muhammed.slmz@gmail.com");
        send(loginPassword,"172126Mm");
        click(loginBtn);


    }
    public void invalidLogin(){
        click(popup);
        click(popupCloseBtn);
        click(loginPageBtn);
        send(loginEmail,"muhammed.slmz@gmail.com");
        send(loginPassword,"172126Mm");
        click(loginBtn);
        isDisplay(loginError);
    }

}





