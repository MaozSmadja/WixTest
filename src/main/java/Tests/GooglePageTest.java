package Tests;

import Utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GooglePageTest extends TestBase {

    @Test(priority = 1)
    public  void GoogleSearchWix() throws InterruptedException {

        getDriver().get("https://www.google.com/");
        googlePage.insertToSearchField("wix");
        googlePage.clickSearchBtn();
        googlePage.clickFirstResult();
        Assert.assertEquals(getDriver().getTitle(),"Free Website Builder | Create a Free Website | Wix.com");
    }



}
