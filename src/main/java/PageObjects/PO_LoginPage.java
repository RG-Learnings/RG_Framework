package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginPage {

    public WebDriver driver;

    public PO_LoginPage(WebDriver driver)
    {
        this.driver =driver;
    }

    public WebElement getEmail()
    {
        By emailid = By.id("user_email");
        return driver.findElement(emailid);
    }
    public WebElement getPassword()
    {
            By password = By.id("user_password");
        return driver.findElement(password);
    }
}
