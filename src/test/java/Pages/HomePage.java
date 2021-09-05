package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final WebElement loginlink = GetElement("xpath","//a[text()='Log-In'][1]");
    public void ClickLogin(){
        loginlink.click();
    }
}
