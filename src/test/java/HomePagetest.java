import Base.BasePage;
import Base.Browserfactory;
import Base.FileReader;
import Base.RelativePath;
import PageObjects.PO_Homepage;
import PageObjects.PO_LoginPage;
import Utilities.LogUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;

public class HomePagetest extends FileReader implements RelativePath
{
    PO_Homepage page_Home;
    PO_LoginPage page_Login;
    public WebDriver driver;
    public Properties prop;
    public static Logger log;
    public Browserfactory browserfactory;

    @BeforeClass
    public void browser()
    {
        //log = LogManager.getLogger(HomePagetest.class.getName());
        log = LogUtil.getloggervariable(HomePagetest.class);
        browserfactory = Browserfactory.getInstance();
        driver = browserfactory.instanciateBrowser();
        log.info("Browser initialized");
        prop = readPropertyFile();
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
        page_Home = BasePage.Getinstance(PO_Homepage.class,driver);
        Assert.assertTrue(page_Home.linkbestsellers.getText().equalsIgnoreCase("Best Sellers"),
                "Practice Button is not available in home page");

        Assert.assertEquals(page_Home.getbestselleritems.size(),7,
                "best seller items are supposed to be 7" );
    }

    @Test
    public void navigateToLogin()
    {
        page_Home = BasePage.Getinstance(PO_Homepage.class,driver);
        page_Login = page_Home.clicklogin();
        Assert.assertTrue(page_Login.getPageTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigated to Login page");
    }
    @AfterClass
    public void end()
    {
        browserfactory.teardownBrowser();
    }
}

