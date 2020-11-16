package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil
{
    /*ZonedDateTime dateTime =ZonedDateTime.now();
    DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    String filenameformat =dateTime.format(df);
    static final Logger log = LogManager.getLogger(LogUtil.class.getName());
    public BufferedWriter bufferedWriter=null;

    public void Createfile() throws IOException {
        File logfile =new File("Log"+filenameformat+".log");
        FileWriter fileWriter = new FileWriter(logfile.getAbsoluteFile());
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void write (String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.close();
    }*/


    public static Logger getloggervariable(Class myclass)
    {
        Logger log = LogManager.getLogger(myclass);
        System.out.println("logs:" + log.toString());
        return log;
    }
}