import Base.BasePage;
import Base.MyBrowser;
import PageObjects.PO_Homepage;
import PageObjects.PO_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class logintest extends MyBrowser
{
    PO_LoginPage lp;
    public WebDriver driver;
    public Properties prop;

    @BeforeClass
    public void initializer(ITestContext context) throws IOException {
        driver = Startbrowser();
        context.setAttribute("webDriver", driver);
        prop = myproperty();
        String webpageurl= prop.getProperty("url")+"index.php?controller=authentication&back=my-account";
        driver.get(webpageurl);
    }

    @Test(dataProvider = "getdata")
    public void Login(String uname,String pwd)
    {
        lp= BasePage.Getinstance(PO_LoginPage.class,driver);
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigate to login page");
        lp.txtemail.clear();
        lp.txtpassword.clear();
        lp.login(uname,pwd);
        PO_Homepage home = BasePage.Getinstance(PO_Homepage.class,driver);
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My account - My Store"),
                "Failed to Login");
    }
    @DataProvider
    public Object[][] getdata()  {
        // prop.load(fis);

        //Rows for different tests
        //columns for different data fields for each test
        Object[][] o = new Object[2][2];
        o[0][0]="admin@admin.com";
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
    }

}