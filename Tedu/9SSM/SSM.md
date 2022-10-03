# SSM

通过查询所有问题表的内容

- SS：
  - 增加一个xml文件，在该文件；名配置扫描Controller对象包
  - 配置标签创建SqlSessionFactory对象，Mapper对象，Dao对象，连接数据库对象
- SM：
  - 由spring创建SqlSessionFactory对象
  - 由spring创建Mapper对象
  - spring创建Dao对象
  - 由spring进行数据库的连接

## 一、搭建工程框架

- bean
- dao
- service
- controller

## 二、添加maven依赖

1. spring核心jar：
2. springMVC相关的jar：srping-mvc
3. 数据库相关的jar：mybatis, mysql-connector, spring-jdbc, 
4. mybatis和spring整合的jar：mybatis-spring
5. druid相关的jar：druid
6. servlet相关的jar：servlet-api
7. gson

## 三、创建文件

1. StudentBean.java
2. StudentController.java
3. StudentDao.interface, @Mapper
4. StudentService.java
5. mybatis-config.xml
6. StudentMapper.xml
7. springmvc.xml
8. applicationContext.xml
9. db.properties
10. web.xml

## 四、编写文件

1. db.properties
2. springMVC.xml
3. applicationContext.xml
4. 



