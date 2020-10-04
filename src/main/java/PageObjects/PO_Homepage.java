package PageObjects;

import Package_Helper.Helper_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_Homepage extends Helper_Class
{
    public WebDriver driver;
    By blockbestsellers = By.xpath("//a[contains(text(),'Best Sellers')]");
    By loginbutton = By.cssSelector(".login");

    public PO_Homepage(WebDriver driver)
    {
        this.driver =driver;
    }

    public WebElement getPractice()
    {
       return driver.findElement(blockbestsellers);
    }
    public WebElement getLogin()
    {
        return driver.findElement(loginbutton);
    }
}
