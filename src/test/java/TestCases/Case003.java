package TestCases;

import Drivers.BaseTest;
import Pages.Categories;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Case003 extends BaseTest {
    public void loginAgain(){
        LoginPage login = new LoginPage(driver);
        login.login();
    }

    @Test(priority = 1)
    public void brandCategorizationTest(){
        Categories brandCategorizationControl = new Categories(driver)    ;
        brandCategorizationControl.brandCategorization();
    }
    @Test(priority = 2)
    public void priceCategorizationTest(){
        Categories priceCategorizationControl = new Categories(driver);
        priceCategorizationControl.priceCategorization();
    }
    @Test(priority = 3)
    public void productPathTest(){
        Categories productPathControl = new Categories(driver);
        productPathControl.productPath();
    }

}
