package rethink.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MySecondTest {

    @Test
    public void TestA() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
        driver.get("https://rta-bh-dev-app-qa3.azurewebsites.net/Healthcare#/Login");
        WebElement usernamefield = driver.findElement(By.xpath("//input[@name='User']"));
        WebElement passwordfield = driver.findElement(By.xpath("//input[@name='Password']"));
        WebElement login_btn = driver.findElement(By.xpath("//*[text()='Login']"));
        usernamefield.sendKeys("halwaraj");
        passwordfield.sendKeys("halwaraj");
        login_btn.click();
        Thread.sleep(5000);
        driver.quit();


    }


}
