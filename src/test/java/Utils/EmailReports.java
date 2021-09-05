package Utils;
import rethink.selenium.BaseTest;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class EmailReports extends BaseTest  {

    public static void SendReportEmail (String repname) throws  MessagingException, AddressException {
        MonitoringMail mail = new MonitoringMail();
        mail.sendMail("smtp.gmail.com","marugud52@gmail.com", new String[]{"marugud52@gmail.com"},"Srikant Email Success","Here is an email ","/Users/srikantkavuru/IdeaProjects/SeleniumMasterFramework/src/test/Reports/"+repname+".html",repname+".html");

    }
}
