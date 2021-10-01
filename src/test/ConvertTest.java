package test;

import converter.StringToDoubleConverter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConvertTest extends Assert {
    @DataProvider(name = "convertData")
    public Object[][] convertData() {
        return new Object[][]{
                {"-0", 0.0},
                {"5.", 5.0}
        };
    }

    public final StringToDoubleConverter converter = new StringToDoubleConverter();

    @Test(dataProvider = "convertData")
    public void testConverter(String input, double expected) {
        double result = converter.Convert(input);
        assertEquals(result, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testException() {
        converter.Convert("null");
    }
}
