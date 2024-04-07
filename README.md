# RelxExam

RelxExam提供了一个用于计算自定义操作符表达式的java程序。

# 简介
### 代码设计
* `CustomOperatorConfig`用来读取配置文件。
* `CustomOperator`表示自定义操作符，用户可以通过实现该接口来创建操作符对象。
* `CustomArithmeticService`用来处理输入的表达式，并计算结果。
* `CustomOperatorFactory`可以根据配置文件动态创建和获取操作符对象。

### 打包和运行
* 该项目使用maven进行构建和管理，在项目根目录下执行下列命令即可打包。
    ```bash
    mvn clean package -Dmaven.test.skip=true
    ```
* 在项目根目录下执行下列命令即可运行。
    ```bash
    cd target
    java -jar RelxExam-1.0-SNAPSHOT.jar
    ```

### 其他
* 用户可以根据实际需要扩展自定义操作符，首先需要实现`CustomOperator`接口，并根据需求覆写`apply`方法。
* 该项目仅适用于处理`[Integer.MIN_VALUE, Integer.MAX_VALUE]`集合内的整数，如果计算过程中发生溢出时也会抛出异常。
* 项目运行后可以接受一次输入，并在输出结果后自动退出。



