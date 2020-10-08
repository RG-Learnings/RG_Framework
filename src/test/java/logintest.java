import Package_Helper.Helper_Class;
import PageObjects.PO_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class logintest extends Helper_Class
{
    public WebDriver driver;
    PO_LoginPage lp;
/*    Properties prop = new Properties();
    FileInputStream fis= new FileInputStream(Properties_File_path);*/

    @BeforeClass
    public void browser() throws IOException {
        //prop.load(fis);
        if (driver == null)
            driver = Startbrowser();
        String webpageurl= prop.getProperty("url")+"index.php?controller=authentication&back=my-account";
        driver.get(webpageurl);
    }

    @Test(dataProvider = "getdata")
    public void Login(String uname,String pwd)
    {
        lp=new PO_LoginPage(driver);
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Login - My Store"),
                "Failed to navigate to login page");
//        String currentemail= lp.getEmail().getAttribute("Value").toString();
        if(!lp.getEmail().getAttribute("value").equalsIgnoreCase(""))
        {
            lp.getEmail().clear();
        }
        System.out.println("value of the email field is"+lp.getEmail().getText());
        lp.getEmail().sendKeys(uname);
        if(!lp.getPassword().getAttribute("value").equalsIgnoreCase(""))
        {
            lp.getPassword().clear();
        }
        lp.getPassword().sendKeys(pwd);
        lp.getsignin().click();
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
        lp = null;
    }

}