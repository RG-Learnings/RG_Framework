import Package_Helper.Helper_Class;
import Package_Helper.RelativePath;
import PageObjects.PO_Homepage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePagetest extends Helper_Class implements RelativePath
{
    PO_Homepage home;
    WebDriver driver;
    Properties prop = new Properties();
    FileInputStream fis= new FileInputStream(Properties_File_path);

    public HomePagetest() throws FileNotFoundException {
    }

    @BeforeClass
    public void browser() throws IOException {
        driver=Startbrowser();
    }
    @Test
    public void Navigate() throws IOException {
        prop.load(fis);
        String webpageUrl = prop.getProperty("url");
        driver.get(webpageUrl);
        Assert.assertEquals(driver.getCurrentUrl(),webpageUrl);
    }
    @Test
    public void practice()
    {
        if(home==null)
        home = new PO_Homepage(driver);
        Assert.assertTrue(home.getPractice().getText().equalsIgnoreCase("Practice"),
                "Practice Button is not available in home page");
    }

    @Test
    public void login()
    {
        if(home==null)
            home = new PO_Homepage(driver);
        home.getLogin().click();
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/sign_in/"),
                "Failed to navigated to Login page")    ;
    }

    @DataProvider
    public Object[][] getdata() throws IOException {
        prop.load(fis);

        //Rows for different tests
        //columns for different data fields for each test
        Object[][] o = new Object[2][2];
        o[0][0]="admin";
        o[0][1]="admin";
        o[1][0]=prop.getProperty("Username");
        o[1][1]=prop.getProperty("mypass");
        return o;
    }
    @AfterClass
    public void closebrowser()
    {
            driver.close();
            driver = null;
            home = null;
    }
}
