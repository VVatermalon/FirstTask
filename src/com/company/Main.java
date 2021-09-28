package com.company;

import converter.StringToDoubleConverter;
import entity.SimpleNumber;
import factory.SimpleNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reader.CustomFileReader;
import service.Addition;
import service.Division;
import service.Multiplication;
import service.Subtraction;

import java.util.ArrayList;

public class Main {
    static Logger logger = LogManager.getLogger();
    final static String FILE_SRC = "files\\numbers.txt";
    public static void main(String[] args) {
        try {
            ArrayList<String> strings = CustomFileReader.Read(FILE_SRC);
            ArrayList<SimpleNumber> numbers = new ArrayList<>(2);
            SimpleNumberFactory factory = new SimpleNumberFactory();
            for(String s: strings) {
                try {
                    double number = StringToDoubleConverter.Convert(s);
                    SimpleNumber simpleNumber = factory.createSimpleNumber(number);
                    numbers.add(simpleNumber);
                }
                catch (NumberFormatException e) {
                    logger.error(e);
                }
            }
            if(numbers.size()>1) {
                Addition.Add(numbers.get(0), numbers.get(1));
                Subtraction.Subtract(numbers.get(0), numbers.get(1));
                Multiplication.Multiply(numbers.get(0), numbers.get(1));
                Division.Divide(numbers.get(0), numbers.get(1));
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
