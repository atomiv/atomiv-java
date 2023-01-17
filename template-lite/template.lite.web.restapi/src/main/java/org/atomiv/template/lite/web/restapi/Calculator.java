package org.atomiv.template.lite.web.restapi;

public class Calculator {

    // addition
    public long add(long x, long y) {
        return x + y;
    }

    // subtraction
    public int subtract(int x, int y) {
        return x - y;
    }

    // multiplication
    public int multiply(int x, int y) {
        return x * y;
    }

    // division
    public int divide(int x, int  y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }

    /*
    public void loop(int x, int y) { //Endless loop
        for (; ; )
            x = y;
    }

    public void unCompleted(int x, int y) { //Unfinished modules: such as square, square root, etc.
        //Still under development
    }


// public static void main(String[] args) {// traditional code test
//        int a = 8;
//        int b = 2;
//        Calculator calculator = new Calculator();
//        System.out.println(calculator.add(a, b));
//        System.out.println(calculator.sub(a, b));
//        System.out.println(calculator.mul(a, b));
//        System.out.println(calculator.div(a, b));
//        System.out.println(calculator.div2(a,0));
//    }
     */

}
