import Base.MyBrowser;
import PageObjects.PO_Homepage;
import PageObjects.PO_LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class logintest extends MyBrowser
{
      PO_LoginPage lp;

    @BeforeClass
    public void browser() throws IOException {
        if (mydriver == null)
            mydriver = Startbrowser();
        String webpageurl= prop.getProperty("url")+"index.php?controller=authentication&back=my-account";
        mydriver.get(webpageurl);
    }

    @Test(dataProvider = "getdata")
    public void Login(String uname,String pwd)
    {
        lp=PO_LoginPage.getInstance(mydriver);
        Assert.assertTrue(mydriver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigate to login page");
        lp.txtemail.clear();
        lp.txtpassword.clear();
        lp.login(uname,pwd);
        PO_Homepage home = PO_Homepage.getInstance(mydriver);
        Assert.assertTrue(home.btnMyaccount.getText().equalsIgnoreCase("My account"),
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
    @AfterSuite
    public void closebrowser()
    {
        mydriver.quit();
        mydriver = null;
        lp = null;
    }

}