package PageObjects;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PO_Homepage extends BasePage
{

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

    public PO_LoginPage clicklogin()
    {
        btnLogin.click();
        return new PO_LoginPage(driver);
    }
}