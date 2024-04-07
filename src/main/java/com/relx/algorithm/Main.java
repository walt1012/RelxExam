package com.relx.algorithm;

import com.relx.algorithm.config.CustomOperatorConfig;
import com.relx.algorithm.service.CustomArithmeticService;

import java.util.Scanner;

/**
 * @author walt1012 2024/4/5
 */
public class Main {
    public static void main(String[] args) {
        // 加载配置
        CustomOperatorConfig operatorConfig = new CustomOperatorConfig();
        CustomArithmeticService arithmeticService = new CustomArithmeticService(operatorConfig.getOperators());

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入自定义操作符表达式:");
        String input = scanner.nextLine();
        scanner.close();

        String[] inputs = input.split("\\s+");

        if (inputs.length % 2 == 0) {
            System.out.println("输入格式错误");
            return;
        }

        try {
            long result = Long.parseLong(inputs[0]);
            for (int i = 1; i < inputs.length; i += 2) {
                char operator = inputs[i].charAt(0);
                long operand = Long.parseLong(inputs[i + 1]);
                result = arithmeticService.evaluateExpression(result, operator, operand);
            }
            System.out.println("结果：" + result);
        } catch (NumberFormatException e) {
            System.out.println("输入的操作数不是整数");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
