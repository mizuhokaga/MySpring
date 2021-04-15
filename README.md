# MySpring
##### 1.spring_myspringframework

- 基于自定义注解的自定义spring 框架
- `com.yc.springframework.context`是核心包
- `MyAnnotationConfigApplicationContext` 根据 `ComponentScan`扫描，然后根据路径将所有路径下的包及子包的bean存到一个map里托管
- 循环map，根据bean上不同的注解进行不同的逻辑操纵

##### 2.spring 2_aop

- aop 入门的感知demo
- aop 基本步骤
  - 引入 aop maven 坐标
  - declaring Aspect类，使用@Aspect 和 @ Component
  - declaring Pointcut，其实就是一个根据规则的拦截器，判断哪些方法需求切面来注入增强
  - declaring Advice，需要注意 Around Advice，注意几个增强的执行顺序和优先级问题（环绕增强优先级比before早）
  - 增强里是真正的需要加入的逻辑代码

##### 3.spring3、4

- spring aop 的底层-两种动态代理的理解，jdk 和cglib
- 什么时候用哪种方式是自动感知的，若是接口的方式则是jdk动态代理反之cglib
- 动态代理原则是代理类持有委托类对象 ，然后创建代理，再重写 invoke 方法来处理

##### 5.spring5_tx
-  Spring-tx模块负责在spring框架中实现事务管理功能。以aop切面的方式将事务注入到业务代码中,并实现不同类型的事务管理器
----------
tips：

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
```

让测试类自动注入的注释