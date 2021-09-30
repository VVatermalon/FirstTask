package com.company;

import converter.StringToDoubleConverter;
import entity.SimpleNumber;
import factory.SimpleNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.DoubleFromStringParser;
import reader.CustomFileReader;
import service.*;

import java.util.ArrayList;

public class Main {
    static Logger logger = LogManager.getLogger();
    final static String FILE_SRC = "files\\numbers.txt";

    public static void main(String[] args) {
        try {
            CustomFileReader reader = new CustomFileReader();
            String str = reader.Read(FILE_SRC);
            DoubleFromStringParser parser = new DoubleFromStringParser();
            ArrayList<Double> list = (ArrayList<Double>) parser.Parse(str);

            ArrayList<SimpleNumber> numbers = new ArrayList<>(2);
            for(Double number: list) {
                try {
                    SimpleNumber simpleNumber = SimpleNumberFactory.createSimpleNumber(number);
                    numbers.add(simpleNumber);
                }
                catch (NumberFormatException e) {
                    logger.error(e);
                }
            }
            if(numbers.size()>1) {
                ArithmeticalServices services = new ArithmeticalServices();
                services.Add(numbers.get(0), numbers.get(1));
                services.Subtract(numbers.get(0), numbers.get(1));
                services.Multiply(numbers.get(0), numbers.get(1));
                services.Divide(numbers.get(0), numbers.get(1));
            }
            else {
                logger.warn("Only 1 number left, cannot do operations!");
            }
        }
        catch(Exception e) {
            logger.error(e);
        }
    }
}
