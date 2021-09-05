package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver)  {
        super(driver);
    }

    private final WebElement username    = GetElement("xpath","//input[@name = 'User']");
    private final WebElement password    = GetElement("xpath","//input[@name = 'Password']");
    private final WebElement loginbutton = GetElement("xpath","//*[text()='Login']");

    public void entercreds() throws IOException {
        Properties prop = new Properties();
        String s = System.getProperty("user.dir");
        InputStream is = new FileInputStream(s + "/src/test/resources/Data.properties");
        prop.load(is);
        username.sendKeys(prop.getProperty("username"));
        password.sendKeys(prop.getProperty("password"));
        prop.clear();
    }

    public BucketsPage clicklogin() {
        loginbutton.click();
        return new BucketsPage(driver);
    }

}


