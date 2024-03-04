
package Tests;
import BaseClass.baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

//import static org.bouncycastle.oer.its.template.etsi102941.EtsiTs102941TrustLists.Url;


public class Test_Scenario_1 extends baseclass{

//    public static ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
//    WebDriver driver;
    WebDriverWait wait;
    SoftAssert equals = new SoftAssert();

//    @BeforeClass
//    public void SetUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.lambdatest.com/selenium-playground/");
//    }



    @Test(priority = 1)
    public void waitForDOM()  {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    @Test(priority = 2)
    public void SoftAssert() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
//        Thread.sleep(2000);
//        System.out.println(title);
        equals.assertEquals("Selenium Grid Online | Run Selenium Test On Cloud",title,"Assert For Title validation");
        equals.assertAll();
    }

}
