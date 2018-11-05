
package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePageObject {


    @FindBy(id = "lst-ib")
    public WebElement searchField;

    @FindBy(name = "btnK")
    public WebElement searchButton;

    @FindBy(xpath = " //*[@id=\"rso\"]/div[2]//a[1]/h3/span")
    public WebElement GoogleFirstResult;

}