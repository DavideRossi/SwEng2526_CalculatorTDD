package it.unibo.sweng.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    protected int apply(String operator, int a, int b) {
        if ("+".equals(operator)) {
            return a + b;
        } else if ("-".equals(operator)) {
            return a - b;
        } else if ("*".equals(operator)) {
            return a * b;
        } else if ("/".equals(operator)) {
            return a / b;
        }
        throw new RuntimeException("Unknown operator");
    }

    protected String getExpressionPattern() {
        return "^\\d{1,3}([+\\-*/]\\d{1,3})*$";
    }

    protected String getTokenizerPattern() {
        return "^([+\\-*/])(\\d{1,3})";
    }

    public int compute(String expression) {
        if (expression == null || "".equals(expression)) {
            throw new IllegalArgumentException("expression cannot be null or empty");
        }
        Pattern expressionPattern = Pattern.compile(getExpressionPattern());
        Matcher matcher = expressionPattern.matcher(expression);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid expression");
        }
        Pattern numberPattern = Pattern.compile("^(\\d{1,3})");
        matcher = numberPattern.matcher(expression);
        if (!matcher.find()) {
            throw new IllegalArgumentException("invalid initial number: " + expression);
        }
        int value = Integer.parseInt(matcher.group(1));
        expression = expression.substring(matcher.end());
        while(!expression.isEmpty()) {
            Pattern tokenizerPattern = Pattern.compile(getTokenizerPattern());
            matcher = tokenizerPattern.matcher(expression);
            matcher.find();
            String operandToken = matcher.group(2);
            String operator = matcher.group(1);
            expression = expression.substring(matcher.end());
            int operand = Integer.parseInt(operandToken);
            value = apply(operator, value, operand);
        }
        return value;
    }
}
