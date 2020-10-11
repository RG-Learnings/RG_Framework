import Base.MyBrowser;
import PageObjects.PO_Homepage;
import PageObjects.PO_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class logintest extends MyBrowser
{
    public WebDriver driver;
    PO_LoginPage lp;

    @BeforeClass
    public void browser() throws IOException {
        if (driver == null)
            driver = Startbrowser();
        String webpageurl= prop.getProperty("url")+"index.php?controller=authentication&back=my-account";
        driver.get(webpageurl);
    }

    @Test(dataProvider = "getdata")
    public void Login(String uname,String pwd)
    {
        lp=PO_LoginPage.getInstance(driver);
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigate to login page");
        lp.login(uname,pwd);
//        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My account - My Store"),
//                "Failed to Login");
        PO_Homepage home = PO_Homepage.getInstance(mydriver);
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
        lp = null;
    }

}