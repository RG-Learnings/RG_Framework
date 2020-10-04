package PageObjects;

import Package_Helper.Helper_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_Homepage extends Helper_Class
{
    public WebDriver driver;
    public void PO_Homepage(WebDriver driver)
    {
        this.driver =driver;
    }

    public WebElement Practicebutton()
    {
        By practicebutton = By.xpath("//a[contains(text(),'Practice')]");
       return driver.findElement(practicebutton);
    }
}
