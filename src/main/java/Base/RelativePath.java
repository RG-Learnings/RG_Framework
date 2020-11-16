package Base;

public interface RelativePath
{
    String Projectpath = System.getProperty("user.dir");
    String Properties_File_path = Projectpath + "\\src\\main\\java\\RG_Auto.properties";
    String Firefox_prop="webdriver.gecko.driver";
    String Edge_prop="webdriver.edge.driver";
    String Firefox_Driver_path = Projectpath + "\\Webdriver\\geckodriver.exe";
    String Edge_Driver_path = Projectpath + "\\Webdriver\\msedgedriver.exe";
    String ScreenshotPath =  Projectpath + "\\Reports\\Screenshots\\";
    String Report_path = Projectpath+"\\Reports\\TestReport.html";

}
