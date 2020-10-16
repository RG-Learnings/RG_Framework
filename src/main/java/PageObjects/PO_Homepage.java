package PageObjects;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PO_Homepage extends BasePage
{
    public static  PO_Homepage obj;

    private PO_Homepage(WebDriver driver)
    {
        super(driver);
    }
    public static PO_Homepage getInstance(WebDriver driver)
    {

        if(obj==null)
        {
            synchronized (PO_Homepage.class)
            {
                if(obj==null)
                    obj = new PO_Homepage(driver);
            }

        }
        return obj;
    }

    @FindBy(xpath = "//a[contains(text(),'Best Sellers')]")
    public WebElement linkbestsellers;

    @FindBy(css = ".login")
    public WebElement btnLogin;

    @FindBy(xpath = "//ul[@id='blockbestsellers']/li")
    public List<WebElement> getbestselleritems;

    @FindBy(xpath = "//span[@class='navigation_page']")
    public WebElement btnMyaccount;

    public PO_LoginPage clicklogin()
    {
        btnLogin.click();
        return PO_LoginPage.getInstance(driver);
    }
}