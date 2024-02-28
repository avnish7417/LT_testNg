import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Test_Scenario_2 {
   WebDriver driver;
   WebDriverWait wait;
   SoftAssert equal = new SoftAssert() ;
    @BeforeClass
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test
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

        equal.assertEquals(true,status,"Chek Box is not Checked");

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

        equal.assertFalse(status_1,"Check box is still selected ");

        equal.assertAll();
    }


    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
