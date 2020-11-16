package Base;

import Utilities.LogUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Base extends FileReader implements ITestListener,RelativePath

{
    public Base() {
        reports=reportGeneration();
    }

    public static final Logger log = LogUtil.getloggervariable(Base.class);
    ExtentReports reports;
    ExtentTest myTest;
    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result)
    {
        myTest = reports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(myTest);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        reports.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTestThreadLocal.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure( ITestResult result)
    {
        extentTestThreadLocal.get().fail(result.getThrowable());
        String failedTest = result.getMethod().getMethodName()+getdatetime();
        try
        {
            WebDriver driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            extentTestThreadLocal.get().addScreenCaptureFromPath(getScreenshot(driver,failedTest),failedTest);
            log.debug("Testcase " +failedTest+ " has failed and screenshot is taken for referrence");

        }
        catch (Exception e)
        {
            log.warn("Unable to take Screenshot for at " + failedTest);
        }
    }
    public String getScreenshot(WebDriver driver, String failedtest) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        String destination = ScreenshotPath +failedtest+".png";
        FileUtils.copyFile(source,new File(destination));
        return destination;
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

    public ExtentReports reportGeneration()
    {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Report_path);
        sparkReporter.config().setReportName("RG_Automation Results");
        sparkReporter.config().setDocumentTitle("RG_Test Report");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Tester","Rohith");
        return reports;
    }
}
