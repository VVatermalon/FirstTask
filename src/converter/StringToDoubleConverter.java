package converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringToDoubleConverter {
    static Logger logger = LogManager.getLogger();

    public double Convert(String input) {
        double output = Double.parseDouble(input);
        logger.info("Converted to double " + output);
        return output;
    }
}
