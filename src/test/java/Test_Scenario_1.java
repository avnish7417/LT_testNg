import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Test_Scenario_1 {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert equals = new SoftAssert();


    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test(priority = 0)
    public void waitForDOM(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedCondition<Boolean>) driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    @Test(priority = 1)
    public void SoftAssert(){
        String title = driver.getTitle();

        System.out.println(title);
        equals.assertEquals("Selenium Grid Online | Run Selenium Test On Cloud",title,"Assert For Title validation");
        equals.assertAll();
    }

    @Test(priority = 2)
    public void CheckBox() throws InterruptedException {
        driver.findElement(By.linkText("Checkbox Demo")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("isAgeSelected")).click();
        boolean status = driver.findElement(By.id("isAgeSelected")).isSelected();

        System.out.println(status);
        if(status){
            System.out.println(" checkbox is “selected”");
        } else {
            System.out.println("Checkbox is unchecked");
        }

        equals.assertEquals(true,status,"Chek Box is not Checked");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.id("isAgeSelected")).click();
        Thread.sleep(1000);

        boolean status_1 = driver.findElement(By.id("isAgeSelected")).isSelected();
        System.out.println(status_1);
        if(status_1==true){
            System.out.println("Checkbox is checked");
        } else {
            System.out.println(" checkbox is “Unselected”");
        }

        equals.assertFalse(status_1,"Check box is still selected ");

        equals.assertAll();
    }

    @Test(priority = 3)
    public void javascriptAlerts(){
        driver.findElement(By.linkText("Javascript Alerts")).click();
        driver.findElement(By.xpath("(//*[text()='Click Me'])[1]")).click();
        String alerttext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals("I am an alert box!",alerttext,"The alert Meassage Is Diffrent ");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
