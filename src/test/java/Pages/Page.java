package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class Page {

    public WebDriver driver ;
    public WebDriverWait wait ;
    public Page(WebDriver driver){
       this.driver = driver;
       this.wait = new WebDriverWait(this.driver , Duration.ofSeconds(15));
    }
    protected WebElement GetElement (String typeoflocator, String locator){
        WebElement e = null;
        if (typeoflocator.toLowerCase().contains("id")){
            e = driver.findElement(By.id(locator));
        }
        else if (typeoflocator.toLowerCase().contains("css")){
            e = driver.findElement(By.cssSelector(locator));
        }
        else if (typeoflocator.toLowerCase().contains("name")){
            e = driver.findElement(By.name(locator));
           }
        else if (typeoflocator.toLowerCase().contains("classname")){
            e = driver.findElement(By.className(locator));
        }
        else if (typeoflocator.toLowerCase().contains("linktext")){
            e = driver.findElement(By.linkText(locator));
        }
        else if (typeoflocator.toLowerCase().contains("partial")){
            e = driver.findElement(By.partialLinkText(locator));
        }
        else if (typeoflocator.toLowerCase().contains("xpath")){
            e = driver.findElement(By.xpath(locator));
        }
       return  e;
    }
    public  String getPageTitle(){
        return driver.getTitle().toString().trim();
    }
    public WebElement WaitForElementVisibility(String typeoflocator ,String locator){
        WebElement e = null ;
        if (typeoflocator.toLowerCase().contains("id")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("xpath")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("css")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("linktext")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("partial")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("classname")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("name")){
            e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
        }
        return e ;

    }
    public WebElement WaitForClickable_Visible (String typeoflocator , String locator){
        WebElement e = null ;
        if (typeoflocator.toLowerCase().contains("id")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("xpath")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("css")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("linktext")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("partial")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("classname")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
        }
        else if (typeoflocator.toLowerCase().contains("name")){
            e = wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
        }
        return e ;
    }
    public Boolean PageTitleContains(WebDriver driver , String expectedtitle){
        String pagetitle = driver.getTitle().toString().trim();
        Boolean flag = false ;
        if ( pagetitle.toLowerCase().equals(expectedtitle.toLowerCase())){
            flag = true ;
        }
        else
            flag = false ;
        return flag ;
    }


}
