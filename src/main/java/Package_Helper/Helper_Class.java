package Package_Helper;//import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Helper_Class implements RelativePath
{
    public WebDriver mydriver;
    public WebDriver Startbrowser() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(RelativePath.Properties_File_path);
        prop.load(fis);
        String SelectedBrowser = prop.getProperty("browser");
        if(SelectedBrowser.equals("Firefox"))
        {
            //System.setProperty(RelativePath.Firefox_prop, RelativePath.Firefox_Driver_path);
            WebDriverManager.firefoxdriver().setup();
            mydriver= new FirefoxDriver();
        }
        else if(SelectedBrowser.equals("Edge"))
        {
            System.setProperty(RelativePath.Edge_prop, RelativePath.Edge_Driver_path);
            mydriver = new EdgeDriver();
        }
        else
            System.out.println("Please enter Valid Browser name");
        mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return mydriver;
    }
}
