import Package_Helper.Helper_Class;
import Package_Helper.RelativePath;
import PageObjects.PO_Homepage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
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
        home = new PO_Homepage();
        Assert.assertTrue(home.Practicebutton().getText().equalsIgnoreCase("Practice"),
                "Practice Button is available");
    }

    @AfterClass
    public void closebrowser()
    {
            driver.close();
            driver = null;
            home = null;
    }
}
