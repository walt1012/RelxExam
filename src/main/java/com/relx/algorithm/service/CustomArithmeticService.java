package com.relx.algorithm.service;

import com.relx.algorithm.model.CustomOperator;

import java.util.Map;

/**
 * @author walt1012 2024/4/5
 */
public class CustomArithmeticService {
    private final CustomOperatorFactory operatorFactory;

    public CustomArithmeticService(Map<Character, CustomOperator> operators) {
        this.operatorFactory = new CustomOperatorFactory(operators);
    }


    /**
     * 根据操作符计算操作数1和操作数2
     *
     * @param operand1 操作数1
     * @param operator 操作符
     * @param operand2 操作数2
     * @return 计算结果
     */
    public int evaluateExpression(long operand1, char operator, long operand2) {
        CustomOperator customOperator = operatorFactory.getOperator(operator);
        if (customOperator == null) {
            throw new IllegalArgumentException("未知操作符: " + operator);
        }
        if (operand1 > Integer.MAX_VALUE || operand1 < Integer.MIN_VALUE
                || operand2 > Integer.MAX_VALUE || operand2 < Integer.MIN_VALUE) {
            throw new ArithmeticException("操作数溢出");
        }
        long result = customOperator.apply((int) operand1, (int) operand2);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("计算结果溢出");
        }
        return (int) result;
    }
}
