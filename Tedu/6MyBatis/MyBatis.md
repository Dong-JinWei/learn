# MyBatis

## 一、框架的好处

使用框架开发项目更高效，更规范

## 二、MyBatis是什么

mybatis是一个持久层的框架；

MyBatis 是支持定制化SQL、存储过程以及高级映射的优秀的持久层框架。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以对配置和原生Map使用简单的 XML 或注解，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。

> 下载：https://github.com/mybatis/mybatis-3

## 三、MyBatis的功能架构：

我们把Mybatis的功能架构分为三层：

1. API接口层：提供给外部使用的接口API，开发人员通过这些本地API来操纵数据库。接口层一接收到调用请求就会调用数据处理层来完成具体的数据处理。
2. 数据处理层：负责具体的SQL查找、SQL解析、SQL执行和执行结果映射处理等。它主要的目的是根据调用的请求完成一次数据库操作。
3. 基础支撑层：负责最基础的功能支撑，包括连接管理、事务管理、配置加载和缓存处理，这些都是共用的东西，将他们抽取出来作为最基础的组件。为上层的数据处理层提供最基础的支撑。

## 四、MyBatis的优缺点

**优点：**

- 简单易学：本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个sql映射文件易于学习，易于使用，通过文档和源代码，可以比较完全的掌握它的设计思路和实现。
- 灵活：mybatis不会对应用程序或者数据库的现有设计强加任何影响。 sql写在xml里，便于统一管理和优化。通过sql基本上可以实现我们不使用数据访问框架可以实现的所有功能，或许更多。
- 解除sql与程序代码的耦合：通过提供DAL层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试。sql和代码的分离，提高了可维护性。
- 提供映射标签，支持对象与数据库的orm字段关系映射
- 提供对象关系映射标签，支持对象关系组建维护
- 提供xml标签，支持编写动态sql。

**缺点：**

- 编写SQL语句时工作量很大，尤其是字段多、关联表多时，更是如此。
- SQL语句依赖于数据库，导致数据库移植性差，不能更换数据库。
- 框架还是比较简陋，功能尚有缺失，虽然简化了数据绑定代码，但是整个底层数据库查询实际还是要自己写的，工作量也比较大，而且不太容易适应快速数据库修改。
- 二级缓存机制不佳

## 五、测试Hello world

1. 创建Maven工程

2. 添加依赖，从而添加`mybatis`对应的jar包，`pom.xml`的配置

   ```xml
   
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
   
       <groupId>org.example</groupId>
       <artifactId>helloMyBatis</artifactId>
       <version>1.0-SNAPSHOT</version>
   
       <properties>
           <maven.compiler.source>8</maven.compiler.source>
           <maven.compiler.target>8</maven.compiler.target>
       </properties>
   
       <dependencies>
           <dependency>
               <groupId>org.mybatis</groupId>
               <artifactId>mybatis</artifactId>
               <version>3.5.10</version>
           </dependency>
   
           <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>8.0.29</version>
           </dependency>
   
       </dependencies>
   
   </project>
   ```

   

3. 创建mybatis-config.xml，配置连接数据库的信息、映射文件等等等

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
       <environments default="mybatis">
           <!--配置连接数据库的信息-->
           <environment id="mybatis">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
   <!--                加载驱动-->
                   <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                   <!-- &要使用&amp;-->
                   <property name="url" value="jdbc:mysql://localhost:3306/dowei?serverTimezone=GMT&amp;characterEncoding=utf8"/>
   <!--                用户名-->
                   <property name="username" value="root"/>
   <!--                密码-->
                   <property name="password" value="7758521.djw"/>
               </dataSource>
           </environment>
       </environments>
       <mappers>
   <!--        指定对应的mapper.xml文件-->
           <mapper resource="mysql/UserMapper.xml"/>
       </mappers>
   </configuration>
   ```

   

4. 接口的定义

   ```java
   package cn.tedu.mapper;
   
   import cn.tedu.User;
   
   public interface UserMapper {
   
   
   //    定义用户接口，用于查询用户
       public User findUser(String u_name);
   }
   ```

   

5. 创建mapper.xml、配置sql语句

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   
   <!--接口的包名及路径-->
   <mapper namespace="cn.tedu.mapper.UserMapper">
   <!--    id是接口中的方法名-->
   <!--    resultType是放回的类型-->
   <!--    里边写查询语句-->
       <select id="findUser" resultType="cn.tedu.User">
           select * from user_table WHERE u_name=#{u_name};
       </select>
   </mapper>
   ```

6. 创建跟表相关的实体类

   ```java
   package cn.tedu;
   
   public class User {
       private String u_name;
       private String u_password;
   
       public User() {
           System.out.println("无参构造");
       }
   
       public User(String u_name, String u_password) {
           this.u_name = u_name;
           this.u_password = u_password;
       }
   
       public String getU_name() {
           System.out.println("get名字");
           return u_name;
       }
   
       public void setU_name(String u_name) {
           System.out.println("set名字");
           this.u_name = u_name;
       }
   
       public String getU_password() {
           System.out.println("get密码");
           return u_password;
       }
   
       public void setU_password(String u_password) {
           System.out.println("set密码");
           this.u_password = u_password;
       }
   
       @Override
       public String toString() {
           return "User{" +
                   "u_name='" + u_name + '\'' +
                   ", u_password='" + u_password + '\'' +
                   '}';
       }
   }
   
   ```

   

7. 编写java程序，操作数据库

   ```java
   package cn.tedu;
   
   import cn.tedu.mapper.UserMapper;
   import org.apache.ibatis.io.Resources;
   import org.apache.ibatis.session.SqlSession;
   import org.apache.ibatis.session.SqlSessionFactory;
   import org.apache.ibatis.session.SqlSessionFactoryBuilder;
   
   import java.io.IOException;
   import java.io.InputStream;
   
   public class MyBatisTest {
       public static void main(String[] args) throws IOException {
   //        指定mybatis-config.xml的配置文件路径
           String resource = "mysql/mybatis-config.xml";
           InputStream inputStream = Resources.getResourceAsStream(resource);
           SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   
           try (SqlSession session = sqlSessionFactory.openSession()) {
               UserMapper mapper = session.getMapper(UserMapper.class);
               User user = mapper.findUser("admin");
               System.out.println("用户名："+ user.getU_name() + "密码：" + user.getU_password());
           }
       }
   }
   ```

   

# 常用标签和增删改操作

## 一、properties标签

功能：通过改变钱引入一个properties文件，在本xml文件中使用${key}

```xml
<properties resource="mysql/mysql.properties"> </properties>

<property name="driver" value="${mysql.driverClassName}"/>
<property name="url" value="${mysql.url}"/>
<property name="username" value="${mysql.username}"/>
<property name="password" value="${mysql.password}"/>
```


## 二、settings标签

功能：配置一些信息

```xml
<settings>
  <!--下划线和驼峰命名发法互相转换 -->
    <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

```xml
<configuration>的子元素必须按照: <properties>
      <settings>
      <typeAliases>
      <typeHandlers>
      <objectFactory>
      <plugins>
      <enviroments>     
      <databaseIdProvider>                                                              
      <mappers>
以上顺序排列。否则Mybatis在解析XML时会报错。
```

## 三、增删改

1. 接口中的方法：返回值可以是整型也可以是boolean
2. mapper文件中增删改

增：`<insert>`

删：`<delete>`

改：`<update>`

## 四、传惨

### 1. 传递多个参数

```xml
<!--public int insertUserMore(String u_name, String u_password);-->

<insert id="insertUserMore">
  INSERT INTO user_table VALUES(#{param1}, #{param2})
</insert>
```

```java
public int insertUserMoreParam(@Param("uName") String uName, @Param("uPassword") String uPassword);

<insert id="insertUserMoreParam">
	INSERT INTO user_table VALUES(#{uName}, #{uPassword})
</insert>
```

### 2. 参数类型是bean对象

```java
public int updateUserMore(User user);

<update id="updateUserMore">
    update user_table set u_password=#{uPassword} where u_name=#{uName}
</update>
```

```xml
public int updateUserMoreParam(@Param("user") User user);
// 使用@Param时，使用数据需要 别名.数据名

<update id="updateUserMoreParam">
    update user_table set u_password=#{user.uPassword} where u_name=#{user.uName}
</update>
```

### 3. 参数类型是map对象

```xml
<!--    public int updateUserMoreMap(Map<String , Object> map);-->
    <update id="updateUserMoreMap">
        update user_table set u_password=#{uPassword} where u_name=#{uName}
    </update>

<!--    public int updateUserMoreMapParam(@Param("map") Map<String, Object> map);-->
    <update id="updateUserMoreMapParam">
        update user_table set u_password=#{map.uPassword} where u_name=#{map.uName}
    </update>
```

### 4. 参数类型是数组或list集合

```xml
<!--    public int insertUserMoreList(@Param("userList") List<String> list);-->
    <insert id="insertUserMoreList">
        insert into user_table values(#{userList[0]}, #{userList[1]})
    </insert>
```

# 返回类型、#{}和${}区别

## 一、ResultMap

在SQL映射文件中设置ResultMap

```xml
<resultMap id="userResultMap" type="cn.tedu.bean.User">
    <result property="uName" column="u_name"/>
    <result property="uPassword" column="u_password"/>
</resultMap>
<!--id：该ResultMap的名字-->
<!--type：返回值，需要写完整的包名和类名-->
<!--proetry：类中属性-->
<!--column：列名-->
```

```xml
<select id="findUserByName" resultMap="userResultMap">
    select * from user_table where u_name=#{name}
</select>
<!-- id: 对应的mapper接口名  -->
<!-- resultMap: 映射的resultMap 的id名-->
```

## 二、查询返回类型

### 1. bean对象

```xml
<!--       public User findUserByName(String name); -->
<resultMap id="userResultMap" type="cn.tedu.bean.User">
  <result property="uName" column="u_name"/>
  <result property="uPassword" column="u_password"/>
</resultMap>

<select id="findUserByName" resultMap="userResultMap">
  select * from user_table where u_name=#{name}
</select>
```

### 2. Map对象

```xml
<!--    public Map<String, Object> findPartByName(@Param("name") String uName);-->
<select id="findPartByName" resultType="java.util.Map">
    select u_password from user_table where u_name=#{name}
</select>
```

### 3. 数组、List集合（基本类型数据、bean对象）

```xml
<!--    public List<User> findUserAll();-->
<select id="findUserAll" resultMap="userResultMap">
    select * FROM user_table
</select>
```

## 三、获取自增主键的值

1. 参数必须是类对象

2. 对`insert`标签中的属性赋值

   ```xml
    <!--   useGeneratedKeys="true" 开启主键  keyProperty="uId" 类对应的主键  keyColumn="u_id" 主键列名  parameterType="cn.tedu.bean.User" 类型必须是类对象 -->
   <insert id="insertUser" useGeneratedKeys="true" keyProperty="uId" keyColumn="u_id" parameterType="cn.tedu.bean.User">
     insert into user_table values(#{user.uName}, #{user.uPassword})
   </insert>
   ```

   

## 四、#{}和${}区别

- ${}：使用括号中的值替换，不会自动转换为字符串。无法解决sql注入问题

- #{}：如果是字符串，会自动添加单引号。可以解决sql注入问题

使用：

- #{}：使用的比较多，防止sql注入

- ${}：使用模糊查询，升序降序

### SQL注入

```xml
<!-- public Student findStuByName(Integer sId); -->
<select id="findStuByName" resultMap="StuResultMap">
    SELECT *
    FROM t_student
    WHERE s_name = ${name}
</select>

<resultMap id="StuResultMap" type="cn.tedu.bean.Student">
    <id column="s_id" property="sId"/>
    <result column="s_name" property="sName"/>
    <result column="s_pwd" property="sPwd"/>
</resultMap>
```

```java
// 使用$时，会有 sql 注入问题
// 使用#时，没有 sql 注入
List<Student> stuByName = mapper.findStuByName("'admin' or 'b' = 'b'");
for (Student student : stuByName) {
    System.out.println(student);
}
```

### `${}`的使用场景

```xml
<!-- public List<Student> findUserOrderBy(@Param("order") String orderBy); -->
    <select id="findUserOrderBy" resultMap="StuResultMap">
        select *
        from t_student
        order by s_id ${order};
    </select>

    <!-- public List<Student> findUserByLike(@Param("like") String like); -->
    <select id="findUserByLike" resultMap="StuResultMap">
        SELECT * FROM t_student WHERE s_name LIKE('%${like}%')
    </select>
```

```java
// ${} 的使用场景1
//  OrderBy排序时，desc和asc都是关键字，如果使用#{} 那么，系统会自动将它识别为字符串此时就会报错
//      如果使用${} 系统不会将关键字转换为字符串，就可以实现排序
List<Student> desc = mapper.findUserOrderBy("desc");
for (Student student : desc) {
    System.out.println(student);
}

// ${} 的使用场景2
// 使用模糊查询时，LIKE('%${like}%') 单引号已经写好了，所以使用#传参数时，会报错
//      而使用$时，传入的值不会转换，所以并不会报错
List<Student> userByLike = mapper.findUserByLike("d");
for (Student student : userByLike) {
    System.out.println(student);
}
```

> #### 既然$不安全，为什么还需要$，什么时候会用到它？
>
> 例如，在一些动态表格（根据不同的条件产生不同的动态列）中，我们要传递SQL的列名，根据某些列进行排序，或者传递列名给SQL都是比较常见的场景，这就无法使用预编译的方式了。

# 动态 SQL

## 一、概念、好处

根据条件组装不同的sql语句

好处：代码更灵活

- if
- choose (when, otherwise)
- trim (where, set)
- foreach

## if

```xml
<!--SQL-->
<if test+"条件">
	SQL 查询语法
</if>
<!--SQL-->

<!--
条件：表达式，类似于EL表达式
操作数：从传入的参数重获取数据。参数可以时基本类型，bean对象，Map，List，数组等
运算符：+-/% and or not > < >= <= 
-->
```

```xml
<!-- public List<Student> findUserById(@Param("id") Integer sId); -->
<select id="findUserById" resultMap="StuResultMap">
    select * from t_student
    <if test="id != null">
        where s_id=#{id}
    </if>
</select>
```

## trim(where, set)

prefix：前边添加的字符

prefixOverrides：后边消除的的字符

suffix：后边添加的字符

suffixOverrides：后边删除的字符

```xml
<!-- public int findStudentByTrim(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd); -->
<select id="findStudentByTrim" resultMap="StuResultMap">
    select * from t_student
    <trim prefix="where" prefixOverrides=" and | or">
        <if test="id != null">
            and s_id = #{id}
        </if>

        <if test="name != null">
            and s_name = #{name}
        </if>

        <if test="pwd != null">
            and s_pwd = #{pwd}
        </if>
    </trim>
</select>
```

```xml
<!-- public int updateStudentByTrim(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd); -->
<update id="updateStudentByTrim">
    update t_student

    <trim prefix="set" prefixOverrides=",">
        <choose>
            <when test="name != null">
                s_name = #{name},
            </when>
            <otherwise>
                s_name = s_name,
            </otherwise>
        </choose>

        <if test="pwd != null">
            s_pwd = #{pwd}
        </if>
    </trim>

    where s_id = #{id}
</update>
```

### where

*where* 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。

若子句的开头为 “AND” 或 “OR”，*where* 元素也会将它们去除。

```xml
<!-- public List<Student> findStudent(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd); -->
<select id="findStudent" resultMap="StuResultMap">
    select * from t_student
    <where>
        <if test="id != null">
            s_id = #{id}
        </if>

        <if test="name != null">
            and s_name = #{name}
        </if>

        <if test="pwd != null">
            and s_pwd = #{pwd}
        </if>

    </where>
</select>
```

### set

*set* 元素可以用于动态包含需要更新的列，忽略其它不更新的列。

- 把修改sql语句中的set关键字后的赋值部分放在set标签中。

- 自动添加set关键字。

- 自动清除后面的逗号。

```xml
<!-- public int updateStudentBySet(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd); -->
<update id="updateStudentBySet">
    update t_student
    <set>
        <if test="name != null">
            s_name = #{name},
        </if>
        <if test="pwd != null">
            s_pwd = #{pwd}
        </if>
    </set>
    where s_id = #{id}
</update>
```

## choose (when, otherwise)

有时候，我们不想使用所有的条件，而只是想从多个条件中选择一个使用。针对这种情况，MyBatis 提供了 choose 元素，它有点像 Java 中的 switch 语句

<!-- public int updateStudentByTrim(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd); -->
<update id="updateStudentByTrim">
    update t_student

```xml
<trim prefix="set" prefixOverrides=",">
    <choose>
        <when test="name != null">
            s_name = #{name},
        </when>
        <otherwise>
            s_name = s_name,
        </otherwise>
    </choose>

    <if test="pwd != null">
        s_pwd = #{pwd}
    </if>
</trim>

where s_id = #{id}
```
</update>

## foreach



```xml
<!-- public int deleteStudentByList(@Param("list") List<Student> StuList); -->
<delete id="deleteStudentByList">
    delete from t_student
    <where>
        <foreach collection="list" index="index" item="item" open="s_id in (" separator="," close=")"
                 nullable="true">
            #{item}
        </foreach>
    </where>
</delete>

<!-- collection：传入的数据，list -->
<!-- index：下标 -->
<!-- item：从list中取出的值 -->
<!-- open：开始的字符 -->
<!-- separator：分隔符 -->
<!-- close：结束的额字符 -->
<!-- nullable：允许为空 -->
```
