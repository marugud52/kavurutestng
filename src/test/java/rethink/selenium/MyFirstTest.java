package rethink.selenium;
import Factory.Generate;
import Pages.BucketsPage;
import Pages.HomePage;
import Pages.LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyFirstTest extends BaseTest {
    public LoginPage lp ;
    public BucketsPage bp;
    @Test
    public void TestA() throws Exception {
        Properties prop = new Properties();
        String s = System.getProperty("user.dir");
        InputStream is = new FileInputStream(s+"/src/test/resources/FirstTest.properties");
        prop.load(is);
        driver =  Generate.GetBrowser(prop.getProperty("browser"));
        Generate.EnvironmentSetup(driver,prop.getProperty("environment"));
        HomePage homePage = new HomePage(driver);
        String title = homePage.getPageTitle();
        System.out.println("Title before clicking on log in is " + title);
        homePage.ClickLogin();
        extentTest=  rep.createTest("Clicked on Login");
        extentTest.log(Status.PASS,"Test Method Successful");
        prop.clear();
    }
    @Test
    public void TestB() throws IOException {
        System.out.println("first line of test b");
        lp = new LoginPage(driver);
        System.out.println("after lp instantiation");
        String title1 = lp.getPageTitle();
        lp.entercreds();
        System.out.println("Title is " + title1);
        bp = lp.clicklogin();
        extentTest.log(Status.PASS,"Test B has passed");
    }
    @Test
    public void TestC(){
       bp = new BucketsPage(driver);
       bp.Logout();
    }
}
