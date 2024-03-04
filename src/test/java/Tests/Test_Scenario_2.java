package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BaseClass.baseclass;
import java.time.Duration;

public class Test_Scenario_2 extends baseclass{
//    WebDriver driver;

    WebDriverWait wait;
    SoftAssert equal = new SoftAssert() ;
//    @BeforeClass
//    @Parameters({"browser"})
//    public void SetUp(String browser){
//        WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
////        driver = new browser;
//        driver.manage().window().maximize();
//        driver.get("https://www.lambdatest.com/selenium-playground/");
//    }

    @Test
    public void CheckBox() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //WebElement click = driver.findElement(By.xpath("(//div[@class='container__selenium'])/ul/li[9]"));
        WebElement click = driver.findElement(By.linkText("Checkbox Demo"));
        click.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("isAgeSelected")).click();
        boolean status = driver.findElement(By.id("isAgeSelected")).isSelected();

        System.out.println(status);
        if(status){
            System.out.println(" checkbox is “selected”");
        } else {
            System.out.println("Checkbox is unchecked");
        }

        equal.assertEquals(true,status,"Chek Box is not Checked");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.id("isAgeSelected")).click();

        boolean status_1 = driver.findElement(By.id("isAgeSelected")).isSelected();
        System.out.println(status_1);
        if(status_1=false){
            System.out.println("Checkbox is checked");
        } else {
            System.out.println(" checkbox is “Unselected”");
        }

        equal.assertFalse(status_1,"Check box is still selected ");

        equal.assertAll();
    }


    @AfterClass
    public void TearDown(){
        driver.quit();
    }

}
