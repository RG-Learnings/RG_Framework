package PageObjects;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PO_Homepage extends BasePage
{
    public static  PO_Homepage obj;

    public PO_Homepage(WebDriver driver)
    {
        super(driver);
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
        return BasePage.Getinstance(PO_LoginPage.class,driver);
    }
}