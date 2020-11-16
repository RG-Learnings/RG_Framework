package PageObjects;


import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PO_LoginPage extends BasePage {

    public PO_LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id="email")
    public WebElement txtemail;

    @FindBy(id="passwd")
    public WebElement txtpassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public WebElement btnlogin;

    public void login(String userName, String password)
    {
        txtemail.sendKeys(userName);
        txtpassword.sendKeys(password);
        btnlogin.click();
    }
}
