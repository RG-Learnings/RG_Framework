package Base;

import Utilities.LogUtil;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Base extends MyBrowser implements ITestListener,RelativePath

{

public static final Logger log = LogUtil.getloggervariable(Base.class);
    @Override
    public void onTestFailure( ITestResult result)
    {
       String failedtest = result.getMethod().getMethodName()+getdatetime();
//        ITestContext context = result.getTestContext();
//        WebDriver driver = (WebDriver) context.getAttribute("webDriver");

        try {
            WebDriver driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            getScreenshot(driver,failedtest);
            log.debug("Testcase " +failedtest+ " has failed and screenshot is taken for referrence");

        } catch (Exception e) {
            log.warn("Unable to take Screenshot for at " + failedtest);
        }
    }
    public void getScreenshot(WebDriver driver,String failedtest) throws IOException {


            TakesScreenshot ts = (TakesScreenshot) driver;
            File source= ts.getScreenshotAs(OutputType.FILE);
            String destination = Screenshotpath+failedtest+".png";
            FileUtils.copyFile(source,new File(destination));
    }

    public WebElement waitforelement(WebDriver driver, WebElement element)
    {
        WebDriverWait wait= new WebDriverWait(driver,5);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getdatetime()
    {
        ZonedDateTime dateTime =ZonedDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dateTime.format(df);

    }
}
