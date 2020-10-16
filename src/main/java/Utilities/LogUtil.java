package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil
{
    ZonedDateTime dateTime =ZonedDateTime.now();
    DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    String filenameformat =dateTime.format(df);
    static final Logger log = LogManager.getLogger(LogUtil.class.getName());
    public BufferedWriter bufferedWriter=null;

    public void Createfile() throws IOException {
        File logfile =new File("Log"+filenameformat);
        FileWriter fileWriter = new FileWriter(logfile.getAbsoluteFile());
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void write (String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.close();
    }
}
