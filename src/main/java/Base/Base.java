package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base
{
    public static Properties prop;
    public FileInputStream fis;
    public void myproperty() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(RelativePath.Properties_File_path);
        prop.load(fis);
    }
}
