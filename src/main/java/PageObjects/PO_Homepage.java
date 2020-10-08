package PageObjects;

import Package_Helper.Helper_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_Homepage extends Helper_Class
{
    public WebDriver driver;
    By bestsellersbutton = By.xpath("//a[contains(text(),'Best Sellers')]");
    By loginbutton = By.cssSelector(".login");
    By bestselleritems = By.xpath("//ul[@id='blockbestsellers']/li");

    public PO_Homepage(WebDriver driver)
    {
        this.driver =driver;
    }

    public WebElement getbestsellers()
    {
       return driver.findElement(bestsellersbutton);
    }
    public WebElement getLogin()
    {
        return driver.findElement(loginbutton);
    }
    public List<WebElement> getbestselleritems()
    {
        return driver.findElements(bestselleritems);
    }
}
