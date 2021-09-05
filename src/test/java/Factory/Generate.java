package Factory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
/*
This class generates the following via static methods  - Report name,
Browser (Firefox,Chrome),EnvironmentSetup (QA or Prod ).

The static method BrowserDefaults - maximizes the window and sets up implicit wait for all browsers that consume it.
The static method getScreenshot provides a string output which contains the path to a screenshot.
 */
public class Generate  {
    public WebDriver driver;

    public static String getScreenshot(WebDriver driver){
        String path = null ;
        TakesScreenshot ts = (TakesScreenshot) driver ;
        File scr = ts.getScreenshotAs(OutputType.FILE);
        path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
        File destination = new File(path);
        try{
            FileUtils.copyFile(scr,destination);
        }
        catch(IOException e ){
            System.out.println(e.getStackTrace());
        }
        return path ;
    }

    public static String ReportName(){
        String name = null ;
        Date today_date = new Date();
        SimpleDateFormat timestamp = new SimpleDateFormat("MM-dd-y HH:mm:ss");
        name = timestamp.format(today_date ).toString().replaceAll("-","_").replaceAll(" ","_").replaceAll(":","_");
        return name ;
    }

    private static void BrowserDefaults(WebDriver driver){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public static WebDriver GetBrowser(String browsername) throws Exception {
        WebDriver driver;
        if(browsername.toLowerCase().contains("chrome")){
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
            BrowserDefaults(driver);
        }
        else if (browsername.toLowerCase().contains("firefox")){
            driver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/geckodriver");
            BrowserDefaults(driver);
        }
        else if (browsername.toLowerCase().contains("safari")){
            driver = new SafariDriver();
            BrowserDefaults(driver);
        }
        else if (browsername.toLowerCase().contains("headless")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
            driver = new ChromeDriver(options);
        }
        else{
            throw new Exception("Browser is not supported");
        }
        return driver;
    }
    public static void EnvironmentSetup(WebDriver driver, String env) throws Exception {
        if (env.toLowerCase().contains("qa")){
            driver.get("https://rta-bh-dev-app-qa3.azurewebsites.net/");
            }
        else if (env.toLowerCase().contains("prod")){
            driver.get("https://www.rethinkbehavioralhealth.com/bh/");
        }
        else {
            throw new Exception("Environment is not valid ");
        }
    }
}
