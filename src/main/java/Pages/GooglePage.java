package Pages;

import PageObject.GooglePageObject;
import Utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends PageBase {

    private GooglePageObject googlePageObject = new GooglePageObject();

    public GooglePage(WebDriver  driver) {
        super(driver);
        PageFactory.initElements(driver,googlePageObject);
    }

    public void insertToSearchField(String keys){
        googlePageObject.searchField.sendKeys(keys);
    }

    public void clickSearchBtn(){
        googlePageObject.searchButton.click();
    }

    public void clickFirstResult(){
        googlePageObject.GoogleFirstResult.click();
    }
}
