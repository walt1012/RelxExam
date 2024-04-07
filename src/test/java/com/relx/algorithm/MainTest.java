package com.relx.algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walt1012 2024/4/6
 */
public class MainTest {

    private final InputStream originalInput = System.in;
    private final PrintStream originalOutput = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInput);
        System.setOut(originalOutput);
    }

    @Test
    public void testMainWithValidInput() {
        // Test case: 5 a 7 c 3 b 4 a 8
        String input = "5 a 7 c 3 b 4 a 8\n";
        String expectedOutput = "请输入自定义操作符表达式:\n结果：2256\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        Main.main(new String[]{});
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testMainWithOverflowedInput() {
        // Test case: 2147483648 a 2
        String input = "2147483648 a 2\n";
        String expectedOutput = "请输入自定义操作符表达式:\n操作数溢出\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        Main.main(new String[]{});
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }


    @Test
    public void testMainWithOverflowedResult() {
        // Test case: 2147483647 b 3
        String input = "2147483647 b 3\n";
        String expectedOutput = "请输入自定义操作符表达式:\n计算结果溢出\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        Main.main(new String[]{});
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testMainWithInvalidOperator() {
        // Test case: 5 a 7 c 3 b 4 a 8 e 2
        String input = "5 a 7 c 3 b 4 a 8 e 2\n";
        String expectedOutput = "请输入自定义操作符表达式:\n未知操作符: e\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Main.main(new String[]{});
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}

