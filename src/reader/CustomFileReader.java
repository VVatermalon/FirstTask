package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomFileReader {
    static Logger logger = LogManager.getLogger();

    public String Read(String src) throws IOException {
        File file = new File(src);
        try (FileReader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader)) {
            String output = "";
            String line = bufferedReader.readLine();
            while (line != null) {
                logger.info("Read from file " + line);
                output += '\n' + line;
                line = bufferedReader.readLine();
            }
            return output;

        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
    }
}
