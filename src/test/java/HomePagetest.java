import Base.MyBrowser;
import Base.RelativePath;
import PageObjects.PO_Homepage;
import PageObjects.PO_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePagetest extends MyBrowser implements RelativePath
{
    PO_Homepage home;
    //WebDriver driver;
    Properties prop = new Properties();
    FileInputStream fis= new FileInputStream(Properties_File_path);

    public HomePagetest() throws FileNotFoundException {
    }

    @BeforeClass
    public void browser() throws IOException {
        mydriver=Startbrowser();
    }
    @Test
    public void Navigate() {
        //prop.load(fis);
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
        PO_LoginPage lp = home.clicklogin();
        Assert.assertTrue(mydriver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigated to Login page");
    }


    @AfterClass
    public void closebrowser()
    {
            mydriver.close();
            mydriver = null;
    }
}
