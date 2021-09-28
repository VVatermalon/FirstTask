package factory;

import entity.SimpleNumber;

public class SimpleNumberFactory {
    public SimpleNumber createSimpleNumber(double number) {
        return new SimpleNumber(number);
    }
}
