package TestCases;

import Drivers.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Case001 extends BaseTest {




    @Test(priority = 1)
    public void mainPageTest(){
        LoginPage mainPageControl = new LoginPage(driver);
        mainPageControl.mainPage();
    }
    @Test(priority = 2)
    public void loginTest(){
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login();
    }
    @Test(priority = 3)
    public void invalidMailLoginTest(){
        LoginPage invalidMail = new LoginPage(driver);
        invalidMail.invalidMailLogin();
    }
    @Test(priority = 4)
    public void invalidPasswordLoginTest(){
        LoginPage invalidPassword=new LoginPage(driver);
        invalidPassword.invalidPasswordlLogin();
    }
    @Test(priority = 5)
    public void invalidInfoLoginTest(){
        LoginPage invalidInfo=new LoginPage(driver);
        invalidInfo.invalidInfolLogin();
    }

}
