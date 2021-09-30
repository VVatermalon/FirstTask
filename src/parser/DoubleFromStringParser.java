package parser;

import converter.StringToDoubleConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleFromStringParser {
    static Logger logger = LogManager.getLogger();
    final static String REG = "^([+-]?(\\d+\\.?\\d*|\\d*\\.?\\d+))$";

    public List<Double> Parse(String input) {
        String[] splittedInput = input.split("[\\s, \\,]");

        Pattern pattern = Pattern.compile(REG);
        StringToDoubleConverter converter = new StringToDoubleConverter();
        List<Double> output = new ArrayList<>(2);

        for(String part: splittedInput) {
            logger.info('\''+ part + '\'');
            Matcher matcher = pattern.matcher(part);
            if (matcher.find()) {
                try {
                    output.add(converter.Convert(part));
                }
                catch (Exception e) {
                    logger.error(e);
                }
            }
        }
        return output;
    }
}
