package com.relx.algorithm.model;

/**
 * @author walt1012 2024/4/5
 */
public class CustomOperatorA implements CustomOperator {
    @Override
    public long apply(int operand1, int operand2) {
        long result = operand1 * 2L + operand2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("计算结果溢出");
        }
        return result;
    }
}


