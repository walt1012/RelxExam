package com.relx.algorithm.config;


import com.relx.algorithm.model.CustomOperator;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author walt1012 2024/4/5
 */
public class CustomOperatorConfig {
    private final Map<Character, CustomOperator> operators;

    public CustomOperatorConfig() {
        this.operators = loadOperators();
    }

    /**
     * 根据配置文件加载操作符配置
     *
     * @return 操作符map
     */
    private Map<Character, CustomOperator> loadOperators() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("operators.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("无法找到操作符配置文件");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("无法加载操作符配置文件", e);
        }

        Map<Character, CustomOperator> operators = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            char symbol = key.charAt(0);
            String className = properties.getProperty(key);
            try {
                Class<?> clazz = Class.forName(className);
                if (!CustomOperator.class.isAssignableFrom(clazz)) {
                    throw new RuntimeException(className + " 不是 CustomOperator 的子类");
                }
                CustomOperator operator = (CustomOperator) clazz.newInstance();
                operators.put(symbol, operator);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("无法创建操作符对象: " + className, e);
            }
        }
        return operators;
    }

    public Map<Character, CustomOperator> getOperators() {
        return operators;
    }
}
