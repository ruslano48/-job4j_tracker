package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        int sumResult = sum(a);
        int multiplyResult = multiply(a);
        int minusResult = minus(a);
        int divideResult = divide(a);
        return sumResult + minusResult + minusResult + divideResult;
    }

    public static void main(String[] args) {
        int result1 = Calculator.sum(10);
        System.out.println("Result of sum: " + result1);
        int result2 = Calculator.minus(10);
        System.out.println("Result of minus: " + result2);
        Calculator calculator = new Calculator();
        int result3 = calculator.multiply(5);
        System.out.println("Result of multiply: " + result3);
        int result4 = calculator.divide(10);
        System.out.println("Result of divide: " + result4);
        int result5 = calculator.sumAllOperation(10);
        System.out.println("Result of sumAllOperation: " + result5);
    }
}