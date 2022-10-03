# Spring

## 一、概念

- spring 框架是容器框架
- 使用 spring 框架创建对象
- 作用：
  - spring 框架是容器框架， 可以创建对象
  - spring 框架可以实现面向切面编程， 实现代码低耦合，高内聚
  - spring 框架实现与第三方框架的无缝集成，如mabatis框架
  - spring 框架提供了一套 spingMVC框架，方便web开发
  - spring 框架提供了一套JDBC访问模版
  - spring 集成了Junit4， 实现了单元测试

### **Spring 框架具有以下几个特点：**

##### 1）方便解耦，简化开发

Spring 就是一个大工厂，可以将所有对象的创建和依赖关系的维护交给 Spring 管理。

##### 2）方便集成各种优秀框架

Spring 不排斥各种优秀的开源框架，其内部提供了对各种优秀框架（如 Struts2、Hibernate、MyBatis 等）的直接支持。

##### 3）降低 Java EE API 的使用难度

Spring 对 Java EE 开发中非常难用的一些 API（JDBC、JavaMail、远程调用等）都提供了封装，使这些 API 应用的难度大大降低。

##### 4）方便程序的测试

Spring 支持 JUnit4，可以通过注解方便地测试 Spring 程序。

##### 5）AOP 编程的支持

Spring 提供面向切面编程，可以方便地实现对程序进行权限拦截和运行监控等功能。

##### 6）声明式事务的支持

只需要通过配置就可以完成对事务的管理，而无须手动编程。


## 二、spring框架的体系结构

![Spring 体系结构](Spring.assets/arch1.png)

## 三、spring两大核心技术

## 1. 控制反转IOC/依赖注入DI

控制反转：IOC（Inversion of Control）

- 由 spring 框架调用无参构造创建对象，使用配置文件或注解告诉框架，由框架来创建对象

依赖注入：DI（Dependency Injection）

- 给对象中的成员变量设置数值

## 2. 面向切片编程（AOP）

AOP：Aspect Oriented Pragramming

> Spring 框架的一个关键组件是**面向切面的程序设计（AOP）**框架。一个程序中跨越多个点的功能被称为**横切关注点**，这些横切关注点在概念上独立于应用程序的业务逻辑。有各种各样常见的很好的关于方面的例子，比如日志记录、声明性事务、安全性，和缓存等等。
>
> 在 OOP 中模块化的关键单元是类，而在 AOP 中模块化的关键单元是方面。AOP 帮助你将横切关注点从它们所影响的对象中分离出来，然而依赖注入帮助你将你的应用程序对象从彼此中分离出来。
>
> Spring 框架的 AOP 模块提供了面向方面的程序设计实现，可以定义诸如方法拦截器和切入点等，从而使实现功能的代码彻底的解耦出来。使用源码级的元数据，可以用类似于 .Net 属性的方式合并行为信息到代码中。

## 四、测试hello world

1. 创建maven工程
2. 添加依赖
   1. beans
   2. core
   3. context
   4. expression
   5. commons-logging
3. 创建实体类
   1. 必须要有无参构造方法
   2. toString
4. 创建`applicationContext.xml`配置文件
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
   
       <!-- 无参构造对象 -->
   		<bean id="stuBean" class="cn.tedu.bean.Student"/>
   </beans>
   ```
5. 创建测试文件

   ```java
   package cn.tedu.test;
   
   import cn.tedu.bean.Student;
   import org.springframework.context.support.ClassPathXmlApplicationContext;
   
   public class HelloTest {
       public static void main(String[] args) {
           ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
           Student stuBean = context.getBean("stuBean", Student.class);
           System.out.println(stuBean);
           context.close();
       }
   }
   ```

# bean标签

- id：在一个容器里是唯一的，使用id可以获取对应的bead
- class：bean的类型，一般写bean的全类名。

> 获取bean无论是通过id还是name获取，如果无法获取到，将抛出异常
> NoSuchBeanDefinitionException

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 单例模式 -->
    <!-- <bean id="userBean" class="cn.tedu.bean.User" scope="singleton"/> -->
    <!-- 非单例模式 -->
    <!-- <bean id="userBean" class="cn.tedu.bean.User" scope="prototype"/> -->
    <!-- 单例模式，延迟初始化 -->
    <bean id="userBean" class="cn.tedu.bean.User" scope="singleton" lazy-init="true"/>
  
    <!-- 有参构造 -->
    <bean id="userBean" class="cn.tedu.bean.User" lazy-init="true">
        <constructor-arg index="0" value="1001"/>
        <constructor-arg index="1" value="admin"/>
        <constructor-arg index="2" value="123456"/>
    </bean>
</beans>
```

```java
package cn.tedu.test;

import cn.tedu.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 单例模式
        User userBead = context.getBean("userBean", User.class);
        User userBead2 = context.getBean("userBean", User.class);
        System.out.println(userBead == userBead2); // true

        // 非单例模式
        User userBead = context.getBean("userBean", User.class);
        User userBead2 = context.getBean("userBean", User.class);
        System.out.println(userBead == userBead2); // false

        // 单例模式，延迟初始化 true
        User userBead = context.getBean("userBean", User.class);
      
      	// 使用有参构造
        User userBead = context.getBean("userBean", User.class);
        System.out.println(userBead);
    }
}
```

## 一、scope

```xml
<bean id="bookDao" class="cn.tedu.bean.BookDaoImp" scope="singleton"/>
<!--
scope="singleton" 单例模式
				1. 只会创建一个对象
				2. 只要上下文对象（ClassPathXmlApplicationContext）创建了，对象就会创建。
lazy-init="true" 	延迟初始化 (Lazy Initialization)
				1. 使用的时候创建对象，不实用就不创建

scope="prototype"	非单例模式
				1. 只有在执行getBean()的时候创建对象

name="stu"	为bean指定别名
				1. 别名可以有多个，使用逗号，分号，空格进行分隔
-->
```

### 单例模式

只能实例化一个对象

### 1、饿汉式

1. 构造方法私有化
2. 类里边new一个对象私有的，静态的
3. 提供接口获取对象

没有实现懒加载，执行效率高

```java
package cn.tedu.bean;

/**
 * 饿汉式
 *
 * 是否 Lazy 初始化：否
 *
 * 是否多线程安全：是
 *
 * 实现难度：易
 *
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 *
 * 它基于 classloader 机制避免了多线程的同步问题，
 * 不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用 getInstance 方法，
 * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
public class Singleton01 {

    //  2. 类里边new一个对象私有的，静态的

    private static Singleton01 singleton01 = new Singleton01();

    //  1. 构造方法私有化
    private Singleton01() {
        System.out.println("Singleton01()");
    }

    //  3. 提供接口获取对象
    public static Singleton01 getSingleton01() {
        return singleton01;
    }
}
```

### 2、懒汉式，线程不安全

1. 构造方法私有化
2. 定义变量，不付初始值
3. 定义接口，获取对象，并new对象。
4. if判断，如果为空，new对象。

实行了懒加载，但是对比饿汉式，执行效率低

```java
package cn.tedu.bean;

/**
 * 懒汉式，线程不安全
 * 是否 Lazy 初始化：是
 *
 * 是否多线程安全：否
 *
 * 实现难度：易
 *
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class Singleton02 {

    private static Singleton02 singleton02;

    // 私有化构造方法
    private Singleton02(){}

    // 提供接口，获取对象


    public static Singleton02 getSingleton02() {
        singleton02 = new Singleton02();
        return singleton02;
    }
}
```

### 3、懒汉式，线程安全

```java
package cn.tedu.bean;


/**
 * 懒汉式，线程安全
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：易
 * <p>
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
public class Singleton03 {

    private static Singleton03 singleton03;

    private Singleton03() {
    }

    public static synchronized Singleton03 getSingleton03() {
        if (singleton03 == null)
            singleton03 = new Singleton03();
        return singleton03;
    }
}

```

### 4、双检锁/双重校验锁（DCL，即 double-checked locking）

```java
package cn.tedu.bean;


/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：较复杂
 * <p>
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class Singleton04 {
    private static Singleton04 singleton04;

    private Singleton04() {
    }

    public static Singleton04 getSingleton04() {
        if (singleton04 == null) {
            synchronized (Singleton04.class) {
                if (singleton04 == null) {
                    singleton04 = new Singleton04();
                }
            }
        }
        return singleton04;
    }
}
```

### 5、登记式/静态内部类

```java
package cn.tedu.bean;

/**
 * 5、登记式/静态内部类
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：一般
 * <p>
 * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。
 * 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 
 * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，
 * 它跟第 3 种方式不同的是：第 3 种方式只要 Singleton 类被装载了，
 * 那么 instance 就会被实例化（没有达到 lazy loading 效果），
 * 而这种方式是 Singleton 类被装载了，instance 不一定被初始化。
 * 因为 SingletonHolder 类没有被主动使用，
 * 只有通过显式调用 getInstance 方法时，
 * 才会显式装载 SingletonHolder 类，从而实例化 instance。
 * 想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，
 * 另外一方面，又不希望在 Singleton 类加载时就实例化，
 * 因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，
 * 那么这个时候实例化 instance 显然是不合适的。这个时候，这种方式相比第 3 种方式就显得很合理。
 */
public class Singleton05 {
    private static class Singleton {
        private static final Singleton05 instance = new Singleton05();

        static {
            System.out.println("内部类被加载了");
        }
    }

    private Singleton05() {
    }

    public static Singleton05 getInstance() {
        return Singleton.instance;
    }

}

```

> 注意：内部静态类不会自动初始化，只有调用静态内部类的方法，静态域，或者构造方法的时候才会加载静态内部类。

## 二、对象创建模式

### 1、调用带参数构造方法

```xml
<!-- 有参构造 -->
<bean id="userBean" class="cn.tedu.bean.User" lazy-init="true">
    <constructor-arg index="0" value="1001"/>
    <constructor-arg index="1" value="admin"/>
    <constructor-arg index="2" value="123456"/>
</bean>
```

### 2、通过工厂模式创建对象

```xml
<!--使用工厂类中的静态方法创建对象-->
<bean id="userFac" factory-method="getUser" class="cn.tedu.bean.UserFactory"/>

<!--使用工厂类中的非静态方法创建对象-->
<bean id="factory" class="cn.tedu.bean.UserFactory"/>
<bean id="userFac2" factory-method="getUser2" factory-bean="factory"/>

<!--使用工厂类中的静态带参方法创建对象-->
<bean id="userFac3" factory-method="getUser3" class="cn.tedu.bean.UserFactory">
    <constructor-arg index="0" value="1003"/>
    <constructor-arg index="1" value="Johnny"/>
    <constructor-arg index="2" value="Johnny"/>
</bean>
```

```java
package cn.tedu.bean;

public class UserFactory {

    public static User getUser(){
        return new User(101, "admin", "123456");
    }

    public User getUser2(){
        return new User(102, "dowei", "dowei");
    }

    public static User getUser3(Integer id, String name, String address){
        return new User(id, name, address);
    }
}
```

```java
package cn.tedu.test;

import cn.tedu.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("userFac", User.class);
        System.out.println(user);

        User usrFac2 = context.getBean("userFac2", User.class);
        System.out.println(usrFac2);

        User userFac3 = context.getBean("userFac3", User.class);
        System.out.println(userFac3);
    }
}
```

# 依赖注入

## 一、使用set方法注入

- property标签
  - name：属性名
  - value：为属性赋值
  - ref：引用类型使用ref，String除外
- bean类型
  - 除了string之外，其他引用类型使用ref
- 数值、List集合

  - `<array></array>`

    - `<value>97.8</value>`
  - `<list></list>`
    - <value>唱</value>
- set集合

  - `<set></set>`
  - `<value>java</value>`
- map集合
  - `<map></map>``
    - ``<entry key="Johnny" value="18"/>`

- 特殊情况

  - null：`<null/><null></null>`
  - 空字符串：`<value/>或<value></value>`

```xml
<bean id="date" class="cn.tedu.bean.MyDate"/>

<bean id="user01" class="cn.tedu.bean.User">
  <property name="id" value="1001"/>
  <property name="name" value="admin"/>
  <property name="age" value="20"/>
  <property name="score" >
    <array>
      <value>97.8</value>
      <value>92.6</value>
      <value>94.1</value>
    </array>
  </property>
  <property name="date" ref="date"/>
  <property name="joy">
    <list>
      <value>唱</value>
      <value>跳</value>
      <value>rap</value>
      <value>篮球</value>
      <value/>
      <null/>
    </list>
  </property>
  <property name="book">
    <set>
      <value>java</value>
      <value>mybatis</value>
      <value>spring</value>
      <value>springMVC</value>
    </set>
  </property>
  <property name="friend">
    <map>
      <entry key="Johnny" value="18"/>
      <entry key="Dio" value="308"/>
    </map>
  </property>
</bean>
```

## 二、使用p命名空间注入

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<!-- 需要使用 xmlns:p="http://www.springframework.org/schema/p"-->
  
<bean id="user02" p:id="1002" p:name="dowei" p:age="21" p:date-ref="date" class="cn.tedu.bean.User">
```

在bean标签中，使用p:成员变量名="初始化值"

只能初始化基本类型，String类型，bean类型。

## 三、使用SpEl注入

SpEl：Sping Expression Language

从已有的一个对象中取数据，对另一个对象的成员变量进行初始化

```xml
<bean id="user03" class="cn.tedu.bean.User">
    <property name="id" value="#{user02.id}"/>
    <property name="name" value="#{user02.name}"/>
    <property name="age" value="#{user02.age}"/>
    <property name="score" value="#{user02.score}"/>
    <property name="date" value="#{user02.date}"/>
    <property name="joy" value="#{user02.joy}"/>
    <property name="book" value="#{user02.book}"/>
    <property name="friend" value="#{user02.friend}"/>
</bean>
```

## 四、使用properties文件注入

1. 加载properties文件
2. 使用${key}访问

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context.xsd">

    <context:property-placeholder location="classpath:data.properties"/>
    <bean id="user04" class="cn.tedu.bean.User">
        <property name="id" value="${id}"/>
        <property name="name" value="${name}"/>
        <property name="age" value="${age}"/>
    </bean>

</beans>
```

## 五、使用自动装配注入

bean标签中的autowire属性

- no：不会自动装配
- byName：bean的id属性值与成员变量名相同的bean对象进行初始化

```xml
<bean id="user01" p:id="1001" p:name="admin" p:age="21" class="cn.tedu.bean.User" autowire="byName">
<!--
根据名字自动装填
：检测当前页面是否有bead的id与该类型的属性相同，如果有，就自动注入
-->
```

- byType：bean的class值与成员变量类型相同的bean对象进行初始化

```xml
<bean id="user01" p:id="1001" p:name="admin" p:age="21" class="cn.tedu.bean.User" autowire="byType"/>
<!--
根据名字自动装填
：检测当前页面是否有bead的类型与该类的属性相同，如果有，就自动注入
-->
```

- constructor：使用构造方法实例化对象，与构造方法中行参类型相同的实参传递给构造方法

```xml
<bean id="user01" class="cn.tedu.bean.User" autowire="constructor"/>
<!--
根据名字自动装填
：根据构造器自动注入
	：如果页面页面有类中属性对应的bean，当bean全部满足时，就是调用构造方法初始化，如果有一个属性不满足，就不会掉用
-->

<bean id="int" class="java.lang.Integer">
    <constructor-arg type="java.lang.String" value="1002"/>
</bean>
<bean id="String" class="java.lang.String">
    <constructor-arg type="java.lang.String" value="dowei"/>
</bean>
```

- default：使用beans标签中的default-autowire属性值作为自动装配

```xml
<beans default-autowire="byType">
<!-- 需要在beans标签中，定义该属性的值 -->

<!-- default就会默认执行自己定义的装配方式 -->
<bean id="user01" p:id="1001" p:name="admin" p:age="21" class="cn.tedu.bean.User" autowire="default"/>
```

## 六、使用注解注入

### 1、beans标签头添加

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
       xmlns:context="http://www.springframework.org/schema/context">
  
  
    <!-- 使spring框架可是识别注解并创建对象 -->
    <context:annotation-config/>

    <!-- 设置扫描包 -->
    <context:component-scan base-package="cn.tedu.bean"/>
```

### 2、控制反转的相关注解

```java
@Controller // 控制器
@Component	// 普通bean
@Service		// 逻辑处理类
@Repository	// dao层

// 写在类前
```

### 3、依赖注入的相关注解

```java
@value("值"):定义在基本类型成员变量前
@Resource(name="bean对象")：定义在引用类型成员变量之前

根据类型自动装配
@Autowired：定义在引用类型成员变量前。更具类型自动装配

根据名字自动装配：
@Autowired
@Qualifier("bean对象名");

```

#### 测试案例

```java
//@Controller // 控制器
//@Component   // 普通bean
//@Service    // 逻辑处理类
//@Repository  // dao层
@Component("AnnoUser")  // 普通bean, user相当于id
public class AnnoUser {

    @Value("1002") // 使用反射为次属性注入值， 基本类型使用Value
    private Integer id;
    @Value("dowei")
    private String name;
    @Value("22")
    private Integer age;
    //@Resource(name="AnnoDate") // 引用类型使用Resource
    @Autowired // 可是设置自动注解，更具类型自动装配
    @Qualifier("AnnoDate") // 根据名字自动注入，需要填入对应的名字
    private AnnoMyDate annoDate;
    public AnnoUser() {
    }  
}
```

### 4、其他注解

```java
@Scope("singleton") @Scope("prototype")
//添加到类前，设置是否是单例模式

@PostConstruct	 // 初始化时加载次方法
@PreDestory 	// 对象销毁时加载此方法
//添加到方法前面，创建，关闭上下文对象时调用
```

```java
@PostConstruct // 初始化时自动调用
public void init(){
    System.out.println("----init()---");
}

@PreDestroy     // 销毁时自动创建
public void destroy(){
    System.out.println("----destroy()---");
}
```

### 5、代理模式

```java
public interface Play {
    public void showTime();
}


public class Player implements Play{
    @Override
    public void showTime() {
        System.out.println("player say: is show time...");
    }
}

public class Singer implements Play{
    @Override
    public void showTime() {
        System.out.println("Singer say : is show time...");
    }
}

public class ProxyPlay implements Play{
    private Play play;
    private Other other;

    public ProxyPlay(Play play){
        this.play = play;
    }

    public ProxyPlay(Play play, Other other) {
        this.play = play;
        this.other = other;
    }

    @Override
    public void showTime() {
        if (other == null){
            System.out.println("loading....");
            play.showTime();
            System.out.println("ending.....");
        }else {
            other.before();
            play.showTime();
            other.after();
        }

    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
  
  public interface Other {
    public void before();
    public void after();
}

  public class OtherImp01 implements Other{
    @Override
    public void before() {
        System.out.println("other01 before do something...");
    }

    @Override
    public void after() {
        System.out.println("other01 after do something...");
    }
}
  
  public class OtherImp02 implements Other{
    @Override
    public void before() {
        System.out.println("other02 before do something...");
    }

    @Override
    public void after() {
        System.out.println("other02 after do something...");
    }
}

```

# AOP

## 一、AOP的概念

AOP：Asppect Oriented Programming 面向切面编程

## 二、测试hello world

1. 添加与AOP相关的jar包

   ```xml
           <!-- https://mvnrepository.com/artifact/aopalliance/aopalliance -->
           <dependency>
               <groupId>aopalliance</groupId>
               <artifactId>aopalliance</artifactId>
               <version>1.0</version>
           </dependency>
   
           <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-aop</artifactId>
               <version>5.3.20</version>
           </dependency>
   ```

2. 创建业务接口

   ```java
   public interface Play {
       public void showTime();
   }
   ```

3. 创建业务类，实现业务

   ```java
   public class Singer implements Play{
       @Override
       public void showTime() {
           System.out.println("singer say : is show time...");
       }
   }
   ```

4. 创建非业务类--通知

   ```java
   public class OtherBefore implements MethodBeforeAdvice {
       @Override
       public void before(Method method, Object[] args, Object target) throws Throwable {
           System.out.println("before.... do something...");
       }
   }
   ```

5. 配置applicationContext.xml文件

   ```java
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
   
       <!-- 业务处理对象 -->
       <bean id="singer" class="cn.tedu.Singer"/>
       <bean id="programmer" class="cn.tedu.Programmer"/>
   
       <!-- 非业务处理对象 -->
       <bean id="otherBefore" class="cn.tedu.OtherBefore"/>
       <bean id="otherAfter" class="cn.tedu.OtherAfter"/>
       <bean id="otherAround" class="cn.tedu.OtherAround"/>
   
       <!-- 代理对象 -->
       <bean id="proxy" class="org.springframework.aop.framework.ProxyFactoryBean">
           <property name="proxyInterfaces">
               <array>
                   <value>cn.tedu.Play</value>
               </array>
           </property>
   
           <property name="interceptorNames">
               <list>
                   <value>otherBefore</value>
                   <value>otherAfter</value>
                   <value>otherAround</value>
               </list>
           </property>
   
           <property name="targetName">
               <value>singer</value>
           </property>
       </bean>
   </beans>
   ```

6. 测试代码

## 三、相关概念

- 目标对象：即将切入切面的对象，也称为被代理对象

- 切面：从对象中抽取出来的横切性功能模块，即非业务处理代码

- 通知：切面的具体实现

- 连接点：目标对象中可以插入通知的地方

- 切入点：定义的通知应该被插入到什么连接点上

- 代理对象：将通知应用到目标对象之后被动态创建的对象

- 织入：将通知应用对目标对象，从而创建新的代理对象的过程
