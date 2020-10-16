import Base.MyBrowser;
import Base.RelativePath;
import PageObjects.PO_Homepage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class HomePagetest extends MyBrowser implements RelativePath
{
    PO_Homepage home;

    @BeforeSuite
    public void browser() throws IOException {
        mydriver=Startbrowser();
        myproperty();
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
        //PO_LoginPage lp = home.clicklogin();
        Assert.assertTrue(mydriver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigated to Login page");
    }


    @AfterTest
    public void closebrowser()
    {
            Teardown();
    }
}
