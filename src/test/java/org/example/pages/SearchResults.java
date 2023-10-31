package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends BasePage{

    @FindBy(id = "firstHeading")
    private WebElement pageTittle;

    public String getPageText(){
        this.isElementDisplayed(this.pageTittle);
        return this.pageTittle.getText();
    }

    public SearchResults(WebDriver driver) {
        super(driver);
    }


}
