package TestCases;

import Drivers.BaseTest;
import Pages.LoginPage;
import Pages.ProductBasket;
import org.testng.annotations.Test;

public class Case002 extends BaseTest {
    public void loginAgain(){
        LoginPage login = new LoginPage(driver);
        login.login();
    }

    @Test(priority = 1)
    public void addBasketTest(){
        loginAgain();
        ProductBasket addBasket = new ProductBasket(driver);
        addBasket.addBasket();
    }
    @Test(priority = 2)
    public void isInBasketTest(){
        loginAgain();
        ProductBasket basketControl = new ProductBasket(driver);
        basketControl.isInBasket();
    }
    @Test(priority = 3)
    public void numOfProductsTest(){
        loginAgain();
        ProductBasket numProductsControl = new ProductBasket(driver);
        numProductsControl.basketIconNum();
    }
    @Test(priority = 4)
    public void changeProductAmountTest(){
        loginAgain();
        ProductBasket amountControl = new ProductBasket(driver);
        amountControl.changeProductAmount();
    }
    @Test(priority = 5)
    public void deleteProductTest(){
        loginAgain();
        ProductBasket deleteControl = new ProductBasket(driver);
        deleteControl.deleteProduct();
    }
}
