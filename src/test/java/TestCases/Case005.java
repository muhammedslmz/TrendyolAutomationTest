package TestCases;

import Drivers.BaseTest;
import Pages.SearchBox;
import org.testng.annotations.Test;

public class Case005 extends BaseTest {
    @Test(priority = 1)
    public void searchBoxTest(){
        SearchBox searchBoxControl = new SearchBox(driver);
        searchBoxControl.isDisplaySearchBox();
    }
    @Test(priority = 2)
    public void isDisplaySuggestionTest(){
        SearchBox suggestionControl = new SearchBox(driver);
        suggestionControl.isDisplaySuggestions();
    }
    @Test(priority = 3)
    public void searchHistoryTest(){
        SearchBox historyControl = new SearchBox(driver);
        historyControl.searchHistory();
    }
    @Test(priority = 4)
    public void clearSearchHistortTest(){

        SearchBox clearHistoryControl = new SearchBox(driver);
        clearHistoryControl.clearSearchHistory();
    }

}
