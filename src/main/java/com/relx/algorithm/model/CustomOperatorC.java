package com.relx.algorithm.model;

/**
 * @author walt1012 2024/4/5
 */
public class CustomOperatorC implements CustomOperator {
    @Override
    public long apply(int operand1, int operand2) {
        long result = (long) operand1 * operand1 - operand2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("计算结果溢出");
        }
        return result;
    }
}
