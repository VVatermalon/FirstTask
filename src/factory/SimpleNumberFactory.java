package factory;

import entity.SimpleNumber;

public class SimpleNumberFactory {
    public static SimpleNumber createSimpleNumber(double number) {
        return new SimpleNumber(number);
    }
}
