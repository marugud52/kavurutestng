package rethink.selenium;
import Factory.Generate;
import Utils.EmailReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import javax.mail.MessagingException;
import java.io.IOException;

public class BaseTest {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports rep ;
    public ExtentTest extentTest ;
    public WebDriver driver ;
    String report_name = Generate.ReportName();
    @BeforeSuite
    public void initializeTest() throws Exception {
        htmlReporter = new ExtentHtmlReporter("src/Test/Reports/"+report_name+".html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Srikant Reports");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        rep = new ExtentReports();
        rep.attachReporter(htmlReporter);

      }


    @AfterMethod
    public void AfterMyTest(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.SUCCESS){
           String ssobj = Generate.getScreenshot(driver);
           extentTest.pass(" Test passed " , MediaEntityBuilder.createScreenCaptureFromPath(ssobj).build());
        }
        if (result.getStatus() ==ITestResult.FAILURE){
            String ssobj = Generate.getScreenshot(driver);
            extentTest.fail(result.getThrowable().getMessage()+"has failed",MediaEntityBuilder.createScreenCaptureFromPath(ssobj).build());
        }
    }

    @AfterSuite
    public void closeTest() throws MessagingException {
        System.out.println("Going to quit driver");
        driver.quit();
        rep.flush();
        EmailReports.SendReportEmail(report_name);
    }
}
