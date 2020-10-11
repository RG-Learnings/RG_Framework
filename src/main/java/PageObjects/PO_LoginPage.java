package PageObjects;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_LoginPage extends BasePage {
    public static PO_LoginPage obj;
    private PO_LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public static PO_LoginPage getInstance(WebDriver driver)
    {

        if(obj==null)
            obj = new PO_LoginPage(driver);
        return obj;
    }

    @FindBy(id="email")
    public WebElement txtemail;

    @FindBy(id="passwd")
    public WebElement txtpassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public WebElement btnlogin;

    public PO_Homepage login(String userName, String password)
    {
        txtemail.sendKeys(userName);
        txtpassword.sendKeys(password);
        btnlogin.click();
        return PO_Homepage.getInstance(driver);
    }
}
