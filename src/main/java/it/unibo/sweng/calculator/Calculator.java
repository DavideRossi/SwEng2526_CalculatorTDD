package it.unibo.sweng.calculator;

public class Calculator {
    public int compute(String expression) {
        if (expression == null || "".equals(expression)) {
            throw new IllegalArgumentException("expression cannot be null");
        }
        if (expression.contains("+")) {
            int operatorPosition = expression.indexOf("+");
            int a = Integer.parseInt(expression.substring(0, operatorPosition));
            int b = Integer.parseInt(expression.substring(operatorPosition+1));
            return a + b;
        }
        if (expression == null || "".equals(expression) || expression.length() > 3) {
            throw new IllegalArgumentException("expression cannot be null");
        }
        return Integer.parseInt(expression);
    }
}
