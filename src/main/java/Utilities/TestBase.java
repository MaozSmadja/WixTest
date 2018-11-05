package Utilities;

import Pages.GooglePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    protected GooglePage googlePage;

    private  WebDriverWait wait;
    //    public  GooglePage dashboardPage;
    static Logger log = LogManager.getLogger(Log.class);


    protected    WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void createInstance(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Smadja\\Desktop\\Maoz\\selenium\\geckodriver.exe");
                caps.setCapability("browserName", browser);
//                log.info("Executing on firefox");
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
                System.out.println("firefox started in session id " + Thread.currentThread().getId());
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Smadja\\Desktop\\Maoz\\selenium\\chromedriver.exe");
                caps.setCapability("browserName", browser);
//                log.info("Executing on chrome");
//                System.setProperty("webdriver.chrome.verboseLogging", "true");
                driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
                System.out.println("Chrome started in session id " + Thread.currentThread().getId());
                break;
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(getDriver(), 180);
        googlePage = new GooglePage(getDriver());

    }

    @AfterMethod
    public  void tearDown() throws Exception {
        getDriver().quit();
//        driver.remove();
    }

    @AfterSuite
    public void teart(){
        driver.remove();
    }
//

}

