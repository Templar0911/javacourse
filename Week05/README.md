# 作业
## 第一题（选做）
### 要求
使 Java 里的动态代理，实现一个简单的 AOP。
### 解答说明
- 实现代码：https://github.com/Templar0911/javacourse/tree/main/Week05/spring01/src/main/java/com/templar/javatraining/dynamicproxy
- 测试用例：https://github.com/Templar0911/javacourse/blob/main/Week05/spring01/src/main/java/com/templar/javatraining/dynamicproxy/HiProxy.java

## 第二题（必做）
### 要求
写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 GitHub。
### 解答说明
- 实现代码：https://github.com/Templar0911/javacourse/tree/main/Week05/spring01/src/main/java/com/templar/javatraining/assemble
- 测试用例：https://github.com/Templar0911/javacourse/blob/main/Week05/spring01/src/test/java/AssembleTest.java

## 第三题（选做）
### 要求
实现一个 Spring XML 自定义配置，配置一组 Bean，例如：Student/Klass/School。
### 解答说明
- 实现代码：https://github.com/Templar0911/javacourse/tree/main/Week05/spring01/src/main/java/com/templar/javatraining/xml
- 测试用例：https://github.com/Templar0911/javacourse/blob/main/Week05/spring01/src/test/java/XmlTest.java

## 第五题（选做）
### 要求
总结一下，单例的各种写法，比较它们的优劣。
### 解答说明
https://github.com/Templar0911/javacourse/tree/main/Week05/spring01/src/main/java/com/templar/javatraining/singleton

## 第六题（选做）
### 要求
maven/spring 的 profile 机制，都有什么用法？
### 解答
#### 一、web.xml
``` xml
<context-param>
    <param-name>spring.profiles.active</param-name>
    <param-value>dev</param-value>
</context-param>
```

#### 二、JVM启动参数
`-Dspring.profiles.active`

#### 三、application.properties
`spring.profiles.active`

#### 四、Maven
``` xml
<profiles>
    <profile>
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <env>dev</env>
        </properties>
    </profile>
    <profile>
        <id>prod</id>
        <properties>
            <env>prod</env>
        </properties>
    </profile>
</profiles>
```

`mvn clean install -Pdev`

`mvn clean install -Pprod`

## 第八题（必做）
### 要求
给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。
### 解答说明
在`school-spring-boot-starter`工程实现了简单的starter，`mvn clean install`之后导入工程`springboot01`的pom中。
- 实现代码：https://github.com/Templar0911/javacourse/tree/main/Week05/school-spring-boot-starter
- 测试用例：https://github.com/Templar0911/javacourse/tree/main/Week05/springboot01/src/test/java/PropTest.java
