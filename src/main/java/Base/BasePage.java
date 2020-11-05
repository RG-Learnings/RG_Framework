package Base;

import Utilities.LogUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class BasePage
{
    public static final Logger log = LogUtil.getloggervariable(BasePage.class);
    private static final Map<Class,Object> POMinstances = new HashMap<Class, Object>();
    public WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public static synchronized <Tpage extends BasePage> Tpage Getinstance(Class<Tpage> page, WebDriver driver)
    {
        Object obj = null;
//        if(driver==null)
        try
        {
            if(POMinstances.containsKey(page.getName()))
            {
                obj = POMinstances.get(page.getName());
                log.info("pom object returned from POMinstances hash map for "+page);
            }
            else
            {
                obj = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
                POMinstances.put(page,obj);
                log.info("pom object added to POMinstances hash map and returned for "+page);
            }
        }
        catch (Exception e)
        {
            log.error("Exception" +e + " occurred while creating the POM object");
        }
        return (Tpage) obj;
    }


}
