import Base.BasePage;
import Base.MyBrowser;
import Base.RelativePath;
import PageObjects.PO_Homepage;
import Utilities.LogUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class HomePagetest extends MyBrowser implements RelativePath
{
    PO_Homepage home;
    public WebDriver driver;
    public Properties prop;
    public static Logger log;

    @BeforeClass
    public void browser() throws IOException {
        //log = LogManager.getLogger(HomePagetest.class.getName());
        log = LogUtil.getloggervariable(HomePagetest.class);
        driver=Startbrowser();
        log.info("Browser initialized");
        prop = myproperty();
        log.info("Property file loaded");
    }
    @Test
    public void Navigate() {
//        String webpageUrl = prop.getProperty("url")+"index.php";
        driver.get(prop.getProperty("url"));
        Assert.assertEquals(driver.getTitle(),"My Store", "Navigated to Home age successfully");
    }
    @Test
    public void bestselleritemsvalidation()
    {

        //home = PO_Homepage.getInstance(driver);
        home = BasePage.Getinstance(PO_Homepage.class,driver);
        Assert.assertTrue(home.linkbestsellers.getText().equalsIgnoreCase("Best Sellers"),
                "Practice Button is not available in home page");

        Assert.assertEquals(home.getbestselleritems.size(),7,
                "best seller items are supposed to be 7" );
    }

    @Test
    public void login()
    {
        home = BasePage.Getinstance(PO_Homepage.class,driver);
        home.clicklogin();
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigated to Login page");
    }
    @AfterClass
    public void closebrowser()
    {
        driver.close();
        driver = null;
    }
}

