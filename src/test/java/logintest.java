import Package_Helper.Helper_Class;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class logintest extends Helper_Class
{
    public WebDriver driver;

    @BeforeClass
    public void browser() throws IOException {
        if (driver != null)
            driver = Startbrowser();
    }

    @Test
    public void Login()
    {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(""));
    }
}