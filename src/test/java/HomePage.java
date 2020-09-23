import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HomePage extends Helper_Class implements RelativePath
{
    WebDriver driver;
    Properties prop = new Properties();
    FileInputStream fis= new FileInputStream(Properties_File_path);

    public HomePage() throws FileNotFoundException {
    }

    @BeforeClass
    public void browser() throws IOException {
        driver=Startbrowser();
    }
    @Test
    public void Navigate() throws IOException {
        prop.load(fis);
        driver.get(prop.getProperty("url"));
    }
    @AfterClass
    public void closebrowser()
    {
            driver.close();
            driver = null;
    }
}
