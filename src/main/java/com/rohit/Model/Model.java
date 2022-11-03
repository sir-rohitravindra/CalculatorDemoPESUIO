package com.rohit.Model;

public class Model {

    private int result;

    public void addValues(int value1, int value2) {
        this.result = value1 + value2;
    }

    public void subtractValues(int value1, int value2) {
        this.result = value1 - value2;
    }

    public void multiplyValues(int value1, int value2) {
        this.result = value1 * value2;
    }

    public void divideValues(int value1, int value2) {

        try {
            this.result = value1 / value2;
        } catch (ArithmeticException ae) {

            System.out.println("Can't divide by 0!");
            this.result = 0;

        }

    }

    public int getResult() {
        return this.result;
    }

}
