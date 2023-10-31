package Test;

import org.example.pages.HomePage;
import org.example.pages.SearchResults;
import org.testng.annotations.Test;

import java.util.List;
import org.testng.asserts.SoftAssert;

public class FirstTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWiki () {

        HomePage homePage = getHomePage();

        homePage.setBarText("Selenium");

        //softAssert.assertEquals(homePage.getFooterText(), "You can support our work with a donation.");

        SearchResults searchResults = homePage.clickOnSearch();
        softAssert.assertEquals(searchResults.getPageText(), "Selenium");

        softAssert.assertAll();

    }
}
