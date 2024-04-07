package com.relx.algorithm.service;

import com.relx.algorithm.model.CustomOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author walt1012 2024/4/6
 */
public class CustomArithmeticServiceTest {

    private CustomArithmeticService arithmeticService;

    @BeforeEach
    public void setUp() {
        Map<Character, CustomOperator> operators = new HashMap<>();
        operators.put('a', (operand1, operand2) -> operand1 * 2 + operand2);
        operators.put('b', (operand1, operand2) -> (operand1 - 5) * operand2);
        operators.put('c', (operand1, operand2) -> operand1 * operand1 - operand2);
        arithmeticService = new CustomArithmeticService(operators);
    }

    @Test
    public void testEvaluateExpressionWithValidInput() {
        // Test cases for CustomOperatorA
        assertEquals(7, arithmeticService.evaluateExpression(3, 'a', 1));
        assertEquals(0, arithmeticService.evaluateExpression(0, 'a', 0));
        //assertEquals(-5, arithmeticService.evaluateExpression(-5, 'a', 0));

        // Test cases for CustomOperatorB
        assertEquals(-4, arithmeticService.evaluateExpression(3, 'b', 2));
        //assertEquals(3, arithmeticService.evaluateExpression(3, 'b', 0));
        assertEquals(-5, arithmeticService.evaluateExpression(0, 'b', 1));

        // Test cases for CustomOperatorC
        assertEquals(8, arithmeticService.evaluateExpression(3, 'c', 1));
        assertEquals(0, arithmeticService.evaluateExpression(0, 'c', 0));
        //assertEquals(16, arithmeticService.evaluateExpression(-4, 'c', -4));
    }

    @Test
    public void testEvaluateExpressionWithInvalidInput() {
        // Test case for unknown operator
        assertThrows(IllegalArgumentException.class, () -> arithmeticService.evaluateExpression(3, 'd', 2));

        // Test case for invalid operands
        assertThrows(NumberFormatException.class, () -> arithmeticService.evaluateExpression(Integer.parseInt("a"), 'a', 2));
    }

    @Test
    public void testEvaluateExpressionWithOverflow() {
        // Test case for overflow
        assertThrows(ArithmeticException.class, () -> arithmeticService.evaluateExpression(Integer.MAX_VALUE, 'a', 1));
        assertThrows(ArithmeticException.class, () -> arithmeticService.evaluateExpression(Integer.MIN_VALUE, 'b', 1));
    }
}
