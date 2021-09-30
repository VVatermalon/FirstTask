package service;

import entity.SimpleNumber;
import factory.SimpleNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArithmeticalServices {
    static Logger logger = LogManager.getLogger();

    public SimpleNumber Add(SimpleNumber first, SimpleNumber second) {
        double result = first.getNumber() + second.getNumber();
        logger.info(first.getNumber() + " + " + second.getNumber() + " = " + result);
        return SimpleNumberFactory.createSimpleNumber(result);
    }

    public SimpleNumber Divide(SimpleNumber first, SimpleNumber second) {
        double result = first.getNumber() / second.getNumber();
        logger.info(first.getNumber() + " / " + second.getNumber() + " = " + result);
        return SimpleNumberFactory.createSimpleNumber(result);
    }

    public SimpleNumber Multiply(SimpleNumber first, SimpleNumber second) {
        double result = first.getNumber() * second.getNumber();
        logger.info(first.getNumber() + " * " + second.getNumber() + " = " + result);
        return SimpleNumberFactory.createSimpleNumber(result);
    }

    public SimpleNumber Subtract(SimpleNumber first, SimpleNumber second) {
        double result = first.getNumber() - second.getNumber();
        logger.info(first.getNumber() + " - " + second.getNumber() + " = " + result);
        return SimpleNumberFactory.createSimpleNumber(result);
    }
}
