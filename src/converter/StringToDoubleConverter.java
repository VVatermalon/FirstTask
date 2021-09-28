package converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringToDoubleConverter {
    static Logger logger = LogManager.getLogger();
    public static double Convert(String input) throws NumberFormatException {
        try {
            double output = Double.parseDouble(input);
            logger.info("Converted to float " + output);
            return output;
        }
        catch (NumberFormatException e) {
            logger.error(e);
            throw e;
        }
    }
}
