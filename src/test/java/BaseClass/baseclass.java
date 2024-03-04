package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class baseclass {

    //InternetExplorerOptions ieoptions = new InternetExplorerOptions();
    public WebDriver driver;

    public WebDriverWait wait;


 // public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    String username = "avnish.kumarbinmile";
    String accesskey = "Z5C3TXPuPUSKaBQL1Z6qFk4zbzrP0v17UOFQOYu3jIVDl0Kngk";
    String gridURL = "@hub.lambdatest.com/wd/hub";

    DesiredCapabilities caps = new DesiredCapabilities();


//    @BeforeTest
//    @Parameters({ "browser","version","platform"})
//    public void setup(String browser , String version , String platform) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", browser);
//        capabilities.setCapability("browserVersion", version);
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", username);
//        ltOptions.put("accessKey", accesskey);
//        ltOptions.put("platformName", platform);
//        ltOptions.put("resolution", "1024x768");
//        ltOptions.put("build", "lambdaTest");
//        ltOptions.put("visual", true);
//        ltOptions.put("video", true);
//        ltOptions.put("network", true);
//        ltOptions.put("project", "Untitled");
//        ltOptions.put("console", "true");
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        capabilities.setCapability("LT:Options", ltOptions);
//        driver.set(new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities));
//        driver.get().manage().window().maximize();
//    }
//
//    @AfterTest
//    public void tearDown()
//    {
//        driver.get().quit();
//        System.out.println("successfully Done All TEst cases");
//    }

//}

//@BeforeClass
//@Parameters({"browser","version","platform"})
//    public void setup(String browser , String version , String platform) throws MalformedURLException {
//    caps.setCapability("browserName",browser);
//    caps.setCapability("browserVersion",version);
//
//    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//    ltOptions.put("username", username);
//    ltOptions.put("accessKey",accesskey);
//    ltOptions.put("platformName", platform);
//    ltOptions.put("resolution", "1024x768");
//    ltOptions.put("build", "lambdaTest");
//    ltOptions.put("visual", true);
//    ltOptions.put("video", true);
//    ltOptions.put("network", true);
//    ltOptions.put("project", "Untitled");
//    ltOptions.put("console", "true");
//    ltOptions.put("selenium_version", "4.0.0");
//    ltOptions.put("w3c", true);
//    caps.setCapability("LT:Options", ltOptions);
//
//
//    driver =new RemoteWebDriver(new URL("https://"+ username + ":" + accesskey + gridURL),caps);
//
//
//}



    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
            driver = new EdgeDriver();
        } else {
            throw new Exception("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }





    @AfterClass
    public void teardown(){
    driver.quit();
}
}
