package Test;

import converter.StringToDoubleConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConvertTest extends Assert {
    @Test
    public void testConverter() {
        double result = StringToDoubleConverter.Convert("-0");
        assertEquals(result, 0.0);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void testException() {
        StringToDoubleConverter.Convert("ggt5");
    }
}
