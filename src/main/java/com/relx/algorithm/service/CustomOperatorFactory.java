package com.relx.algorithm.service;


import com.relx.algorithm.model.CustomOperator;

import java.util.Map;

/**
 * 自定义操作符工厂类
 *
 * @author walt1012 2024/4/5
 */
public class CustomOperatorFactory {
    private final Map<Character, CustomOperator> operators;

    public CustomOperatorFactory(Map<Character, CustomOperator> operators) {
        this.operators = operators;
    }

    public CustomOperator getOperator(char symbol) {
        return operators.get(symbol);
    }
}
