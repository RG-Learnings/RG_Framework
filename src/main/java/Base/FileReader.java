package Base;

import java.io.FileInputStream;
import java.util.Properties;


public class FileReader implements RelativePath
{
    public static Properties readPropertyFile()
    {
        Properties prop = new Properties();
        FileInputStream fis;
        try
        {
            fis = new FileInputStream(RelativePath.Properties_File_path);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
