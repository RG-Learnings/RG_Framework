package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;


public class Browserfactory {

    private static Browserfactory instance=null;
    ThreadLocal<WebDriver> browser=new ThreadLocal<>();
    Properties prop = FileReader.readPropertyFile();
    private Browserfactory() {
        //Private Constructor to block object creation
    }
    public static Browserfactory getInstance()
    {
        if(instance==null) {
            try {
                instance=new Browserfactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;

    }
    private void setDriver()
    {
        String SelectedBrowser = System.getProperty("browser");
        //String SelectedBrowser = prop.getProperty("browser");
        if(SelectedBrowser.equals("Firefox"))
        {
            System.setProperty(RelativePath.Firefox_prop, RelativePath.Firefox_Driver_path);
            browser.set(new FirefoxDriver());
        }
        else if(SelectedBrowser.equals("Edge"))
        {
            System.setProperty(RelativePath.Edge_prop, RelativePath.Edge_Driver_path);
            browser.set(new EdgeDriver());
        }
        else
            System.out.println("Please enter Valid Browser name");
    }


    public void teardownBrowser ()
    {
        browser.get().quit();
        browser.remove();
    }
    public WebDriver instanciateBrowser()
    {
        setDriver();
        return browser.get();
    }
}
