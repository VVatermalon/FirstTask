package service;

import entity.SimpleNumber;
import factory.SimpleNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Multiplication {
    static Logger logger = LogManager.getLogger();
    public static SimpleNumber Multiply(SimpleNumber first, SimpleNumber second) {
        SimpleNumberFactory factory = new SimpleNumberFactory();
        double result = first.getNumber() * second.getNumber();
        logger.info(first.getNumber() + " * " + second.getNumber() + " = " + result);
        return factory.createSimpleNumber(result);
    }
}
