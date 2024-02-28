import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Scenario_3 {


    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }
    @Test
    public void javascriptAlerts(){
        driver.findElement(By.linkText("Javascript Alerts")).click();
        driver.findElement(By.xpath("(//*[text()='Click Me'])[1]")).click();
        String alerttext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals("I am an alert box!",alerttext,"The alert Meassage Is Diffrent ");
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
