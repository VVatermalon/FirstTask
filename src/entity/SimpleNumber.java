package entity;

import java.util.Objects;

public class SimpleNumber {
    private double number;

    public SimpleNumber(double number) {
        this.number = number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "SimpleNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleNumber that = (SimpleNumber) o;
        return Double.compare(that.number, number) == 0;
    }

    @Override
    public int hashCode() {
        final int CONST_NUMBER = 31;
        return (int)Math.round(number * CONST_NUMBER);
    }
}
