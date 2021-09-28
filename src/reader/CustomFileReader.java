package reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomFileReader {
    static Logger logger = LogManager.getLogger();
    public static ArrayList<String> Read(String src) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(src))) {
            ArrayList<String> output = new ArrayList<>(2);
            String line = bufferedReader.readLine();
            while (line != null) {
                logger.info("Read from file " + line);
                output.add(line);
                line = bufferedReader.readLine();
            }
            return output;
        } catch (IOException e) {
            logger.error(e);
            throw e;
        }
    }
}
