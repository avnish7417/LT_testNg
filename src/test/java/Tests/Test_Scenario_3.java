package Tests;
import BaseClass.baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Test_Scenario_3 extends baseclass {

    @Test
    public void javascriptAlerts() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//div[@class='container__selenium'])/ul/li[21]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'JavaScript Alerts')]//following-sibling::button")));
        driver.findElement(By.xpath("//p[contains(text(),'JavaScript Alerts')]//following-sibling::button")).click();
        String alerttext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals("I am an alert box!", alerttext, "The alert Meassage Is Diffrent ");
    }
}

