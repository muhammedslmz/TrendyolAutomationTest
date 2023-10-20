package TestCases;

import Drivers.BaseTest;
import Pages.Favourites;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Case004 extends BaseTest {
    public void loginAgain(){
        LoginPage login =new LoginPage(driver);
        login.login();
    }
    @Test(priority = 1)
    public void isDisplayFavouritesBtnTest(){
        Favourites favouritesControl = new Favourites(driver);
        favouritesControl.isDisplayFavouritesBtn();
    }
    @Test(priority = 2)
    public void accessFavouritesTest(){
        loginAgain();
        Favourites accessFavouritesControl = new Favourites(driver);
        accessFavouritesControl.accessFavourites();
    }
    @Test(priority = 3)
    public void notAccessFavouritesWithoutLoginTest(){
        Favourites accessFavouritesWithoutLogin = new Favourites(driver);
        accessFavouritesWithoutLogin.notAccessFavouritesWithoutLogin();
    }
}
