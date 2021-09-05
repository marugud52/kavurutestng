package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BucketsPage extends Page {
    public BucketsPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement logout_link = WaitForClickable_Visible("xpath","//span[text()='Log Out']");
    public void Logout (){
        logout_link.click();
    }
}
