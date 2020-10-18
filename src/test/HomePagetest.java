import Base.MyBrowser;
import Base.RelativePath;
import PageObjects.PO_Homepage;
import Utilities.LogUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class HomePagetest extends MyBrowser implements RelativePath
{
    PO_Homepage home;
    public Properties prop;
    public static Logger log;

    @BeforeSuite
    public void browser() throws IOException {
        //log = LogManager.getLogger(HomePagetest.class.getName());
        log = LogUtil.getloggervariable(HomePagetest.class);
        mydriver=Startbrowser();
        log.info("Browser initialized");
        prop = myproperty();
        log.info("Property file loaded");
    }
    @Test
    public void Navigate() {
        String webpageUrl = prop.getProperty("url")+"index.php";
        mydriver.get(webpageUrl);
        Assert.assertEquals(mydriver.getCurrentUrl(),webpageUrl);
    }
    @Test
    public void bestselleritemsvalidation()
    {
        home = PO_Homepage.getInstance(mydriver);
        Assert.assertTrue(home.linkbestsellers.getText().equalsIgnoreCase("Best Sellers"),
                "Practice Button is not available in home page");

        Assert.assertEquals(home.getbestselleritems.size(),7,
                "best seller items are supposed to be 7" );
    }

    @Test
    public void login()
    {
        home = PO_Homepage.getInstance(mydriver);
        home.clicklogin();
        Assert.assertTrue(mydriver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigated to Login page");
    }
    @AfterClass
    public void closebrowser()
    {
        mydriver.quit();
        mydriver = null;
    }
}

