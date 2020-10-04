package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginPage {

    public WebDriver driver;

    By password = By.id("passwd");
    By emailid = By.id("email");
    By signinbutton = By.xpath("//button[@id='SubmitLogin']");

    public PO_LoginPage(WebDriver driver)
    {
        this.driver =driver;
    }

    public WebElement getEmail()
    {
        return driver.findElement(emailid);
    }
    public WebElement getPassword()
    {
        return driver.findElement(password);
    }
    public WebElement getsignin()
    {
        return driver.findElement(signinbutton);
    }
}
