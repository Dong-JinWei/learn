# MySQl数据库

## 1、什么是数据库

数据库（DataBase），简称DB。按照一定格式存储数据的一些文件的组合。

顾名思义：存储数据的仓库，实际上就是一堆文件。这些文件中存储了特定格式的数据。

数据库管理系统：
	DataBaseManagement，简称DBMS。
	数据库管理系统是专门用来管理数据库中数据的，数据库管理系统可以对数据库当中的数据进行增删改查。
常见的数据库管理系统:
	MySQL、Oracle、MS SqlServer、 DB2、 sybase等. .. .
SQL：结构化查询语言
	程序员需要学习SQL语句，程序员邇过编写SQL语句，然后DBMS负责执行SQL语句，最终来完成数据库中数据的增删改查操作。

SQL是一套标准，程序员主要学习就是SQL语句，这个SQL在mysql中可以使用，同时在Oracle中也可以使用，在DB2中也可以使用。

三者之间的关系?
	DBMS--执行--> SQL --操作--> DB

先安装数据库管理系统MySQL，然后学习SQL语句怎么写，编写SQL语句之后，DBMS对SQL语句进行执行，最终来完成数据库的数据管理。

## 2、安装MySQL

默认安装

需要注意的事项：

1. 端口号？

	- 端口号port是任何一个软件/应用都会有的，端口号是应用的唯一代表。
	- 端口号通常和IP地址在一块，IP地址用来定位计算机的，端口号port是用来定位计算机上某一个服务/某一个应用的！
	- 同一台计算上，端口号不能重复。具有唯一性。
	- MySQL启动的尚在，这个服务占有的默认端口号是3306。
2. 字符编码方式？

	- 设置MySQL数据库的字符编码方式为UTF8
	- 先选第三个，然后选UTF8
3. 服务名称？
   - 默认是MySQL，不用改
4. 环境变量path？
   - 选择环境变量path
   - 也可以手动配置
5. MySQL用户名密码
   - 超级管理员用户名不能更改，一定是：root
   - 自己设置管理员密码。（dowei）
   - 设置密码同时，可以选择激活root账户远程访问。
     - 激活：root账号可以在外地登录（选这个）
     - 不激活：表示root账号只能在本地登录

## 3、卸载MySQL

第一步：双击安装包选择卸载删除

第二步：删除目录

- 把C:\ProgramData下边的MySQL目录删除
- 把C:\ProgramFiles（x86）下的MySQL目录删除

## 4、查看计算机服务

计算机--右键--管理--服务和应用程序--服务--找到MySQL

MySQL默认是启动状态，只有启动了MySQL才能使用。

默认情况下是自动启动，自动启动表示下一期重启系统的时候自动启动该服务。



可以在服务上右键：

- 启动
- 重启服务
- 停止服务



还可以改变服务的默认配置：

- 服务上点击右键，属性，然后学则启动方式：
  - 自动（延时启动）
  - 自动
  - 手动
  - 禁用

## 5、命令启动/关闭MySQL服务

`net stop 服务名称`

`net start 服务名称`

## 6、登录MySQL

本地登录（显示密码）

`mysql -uroot -odowei`

本地登录（隐藏密码）

`mysql -uroot -p`

## 7、MySQL常用命令

退出mysql：exit

查看mysql中有那些数据库？

- `show databases;`

怎么使用数据库？

- use test

怎么创建数据库？

- create database bjpowernode;

怎么查看数据库下的表？

- show table;

查看数据库的版本号：

```mysql
mysql> select version();
+-----------+
| version() |
+-----------+
| 5.5.36    |
+-----------+
1 row in set (0.00 sec)
```

查看当前使用的是那个数据库：

```mysql
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| bjpowernode        |
| mysql              |
| performance_schema |
| test               |
+--------------------+
5 rows in set (0.00 sec)
```

**注意：mysql不见分号不执行，\c结束语句**

## 8、数据库中的基本单元是表：table

什么是表table？为什么用表来存储数据？

| 姓名 | 性别 | 年龄 |
| ---- | ---- | ---- |
| 张三 | 男   | 20   |
| 李四 | 女   | 20   |
| 王五 | 男   | 21   |

数据库中是吃表格的形式表示数据的。**因为比较直观。**



任何一张表都有行和列：

- 行（row）：被称为数据/记录。
- 列（column）：被称为字段。

*每个字段都有：字段名，数据类型，约束等属性*

- 字段名：见名知意
- 数据类型：数字，字符串，日期等
- 约束：唯一约束性，添加这种约束后，该字段的数据不能重复。

## 9、关于SQL语句的分类

SQL语句有很多，最好分门别类，这样更容易记忆。

- DQL：
  - 数据查询语言（凡是带有select关键字的都是查询语句）
  - select
- DML：
  - 数据库操作语言（凡是对表当中的数据进行增删改查的都是DML）
    - insert 增
    - delete 删
    - update 改
- DDL：
  - 数据定义语言（凡是带有create、drop、alter、的都是DDL。）
  - DDL主要操作的是表的结构。不是表中的数据。
    - create：新建，等同于增
    - drop：删除
    - alter：修改
  - 这个增删改和DML不同，这个主要是对表结构进行操作。
- TCL：
  - 事务控制语言。
    - 事务提交：commit；
    - 事务回滚：rollback；
- DCL：
  - 数据控制语言。
    - 授权grant
    - 撤销权限revoke

## 10、导入数据

`source 数据的路径`‘

注意路径不要有中文！！！

## 11、关于导入的表

dept是部门表

emp是员工表

salgrade是工资等级表



怎么查看表中的数据？

`select * from 表名;`  //统一执行这个语句。

`select * from emp` //从emp中查看所有数据，* 代表所有，from emp 代表从emp中查找

## 12、只查看表中的结构

desc 表名

describe 缩写为 desc

`mysql> desc dept;`

varchar是java中的String

## 13、简单查询

### 13.1、查询一个字段

`select 字段名 from 表名;`

*其中要注意：*

- select和from都是关键字。
- 字段名和表名都成标识符。

*强调：*

- 对于SQL语句来说，是通用的。
- 所有的SQl语句以`";"`结尾
- SQL语句不区分大小写

查询部门的名字

```mysql
mysql> select dname from dept;
+------------+
| dname      |
+------------+
| ACCOUNTING |
| RESEARCH   |
| SALES      |
| OPERATIONS |
+------------+
4 rows in set (0.00 sec)
```

### 13.2、查询多个字段

使用逗号隔开`","`

查询部门编号和部门名

```mysql
mysql> select deptno,dname from dept;
+--------+------------+
| deptno | dname      |
+--------+------------+
|     10 | ACCOUNTING |
|     20 | RESEARCH   |
|     30 | SALES      |
|     40 | OPERATIONS |
+--------+------------+
4 rows in set (0.00 sec)
```

### 13.3、查询所有字段

第一种方式：可以吧每个字段都写上

- `select a,b,c,d,e,f...from tablename;`

第二种方式：可以使用\*

- `select * from dept;`
- 这种方式的缺点：
  1. 效率低
  2. 可读性差
- 实际的开发中不建议，可以在DOS命令窗口中想快速看一看全表数据采用这种方式。

### 13.3.1、查询所有的表

`show tables`

### 13.4、给查询的列起别名

```mysql
mysql> select deptno,dname as deptname from dept;
+--------+------------+
| deptno | deptname   |
+--------+------------+
|     10 | ACCOUNTING |
|     20 | RESEARCH   |
|     30 | SALES      |
|     40 | OPERATIONS |
+--------+------------+
4 rows in set (0.00 sec)
```

使用as关键字起别名。

注意：只是将显示的查询结果列名显示为deptname，原表列名还是叫：dname

注意：select语句是永远不会修改操作的。（因为只负责查询）

as关键字可以省略

```mysql
mysql> select deptno,dname deptname from dept;
+--------+------------+
| deptno | deptname   |
+--------+------------+
|     10 | ACCOUNTING |
|     20 | RESEARCH   |
|     30 | SALES      |
|     40 | OPERATIONS |
+--------+------------+
4 rows in set (0.00 sec)
```

假设起别名的时候，别名里面有空格，怎么办？

`mysql> select deptno,dname dept name from dept;`

DBMS看到这样的语句，进行SQL语句的编译，不符合语法，编译报错。

解决方法？

`select deptno,dname 'dept name' from dept;`//加单引号

`select deptno,dname "dept name from" dept;`//加双引号

```mysql
mysql> select deptno,dname 'dept name' from dept; 
+--------+------------+
| deptno | dept name  |
+--------+------------+
|     10 | ACCOUNTING |
|     20 | RESEARCH   |
|     30 | SALES      |
|     40 | OPERATIONS |
+--------+------------+
4 rows in set (0.00 sec)
```

注意：在所有的数据库中，字符串同意使用单引号括起来。

​	单引号是标准，双引号在oracle数据库中永不了，但是在mysql中可以使用。

### 13.5、计算员工年薪？sal * 12

select ename,sal from emp;

查看名字和工资

```mysql
mysql> select ename,sal from emp;
+--------+---------+
| ename  | sal     |
+--------+---------+
| SMITH  |  800.00 |
| ALLEN  | 1600.00 |
| WARD   | 1250.00 |
| JONES  | 2975.00 |
| MARTIN | 1250.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| SCOTT  | 3000.00 |
| KING   | 5000.00 |
| TURNER | 1500.00 |
| ADAMS  | 1100.00 |
| JAMES  |  950.00 |
| FORD   | 3000.00 |
| MILLER | 1300.00 |
+--------+---------+
14 rows in set (0.00 sec)
```

```mysql
mysql> select ename,sal*12 from emp; //字段可以使用数学表达式
+--------+----------+
| ename  | sal*12   |
+--------+----------+
| SMITH  |  9600.00 |
| ALLEN  | 19200.00 |
| WARD   | 15000.00 |
| JONES  | 35700.00 |
| MARTIN | 15000.00 |
| BLAKE  | 34200.00 |
| CLARK  | 29400.00 |
| SCOTT  | 36000.00 |
| KING   | 60000.00 |
| TURNER | 18000.00 |
| ADAMS  | 13200.00 |
| JAMES  | 11400.00 |
| FORD   | 36000.00 |
| MILLER | 15600.00 |
+--------+----------+
14 rows in set (0.00 sec)
```

```mysql
mysql> select ename,sal*12 as yearsal from emp; //使用别名，显示年薪
+--------+----------+
| ename  | yearsal  |
+--------+----------+
| SMITH  |  9600.00 |
| ALLEN  | 19200.00 |
| WARD   | 15000.00 |
| JONES  | 35700.00 |
| MARTIN | 15000.00 |
| BLAKE  | 34200.00 |
| CLARK  | 29400.00 |
| SCOTT  | 36000.00 |
| KING   | 60000.00 |
| TURNER | 18000.00 |
| ADAMS  | 13200.00 |
| JAMES  | 11400.00 |
| FORD   | 36000.00 |
| MILLER | 15600.00 |
+--------+----------+
14 rows in set (0.00 sec)
```

```mysql
mysql> select ename,sal*12 as '年薪' from emp;  //别名使用单引号，可以使用中文
+--------+----------+
| ename  | 年薪        |
+--------+----------+
| SMITH  |  9600.00 |
| ALLEN  | 19200.00 |
| WARD   | 15000.00 |
| JONES  | 35700.00 |
| MARTIN | 15000.00 |
| BLAKE  | 34200.00 |
| CLARK  | 29400.00 |
| SCOTT  | 36000.00 |
| KING   | 60000.00 |
| TURNER | 18000.00 |
| ADAMS  | 13200.00 |
| JAMES  | 11400.00 |
| FORD   | 36000.00 |
| MILLER | 15600.00 |
+--------+----------+
14 rows in set (0.00 sec)
```

## 14、条件查询

### 14.1、什么是条件查询

不是将表中所有的数据都查出来，是查出来符合条件的。

语法格式；

- select
  - 字段1，字段2，字段3
- from
  - 表名
- where
  - 条件;

### 14.2、有哪些条件

- = 等于

    ```mysql
    mysql> select empno,ename from emp where sal = 800;//工资等于800的员工
    +-------+-------+
    | empno | ename |
    +-------+-------+
    |  7369 | SMITH |
    +-------+-------+
    1 row in set (0.00 sec)
    
    mysql> select empno,ename from emp where ename = 'SMITH';// 查询'SMITH'的编号
    +-------+-------+
    | empno | ename |
    +-------+-------+
    |  7369 | SMITH |
    +-------+-------+
    1 row in set (0.00 sec)
    ```

- <>或!= 不等于

  

    ```mysql
    mysql> select empno,ename from emp where sal != 800;//查询工资不等于800的人，姓名和编号
    mysql> select empno,ename from emp where sal <> 800;
    +-------+--------+
    | empno | ename  |
    +-------+--------+
    |  7499 | ALLEN  |
    |  7521 | WARD   |
    |  7566 | JONES  |
    |  7654 | MARTIN |
    |  7698 | BLAKE  |
    |  7782 | CLARK  |
    |  7788 | SCOTT  |
    |  7839 | KING   |
    |  7844 | TURNER |
    |  7876 | ADAMS  |
    |  7900 | JAMES  |
    |  7902 | FORD   |
    |  7934 | MILLER |
    +-------+--------+
    13 rows in set (0.00 sec)
    ```

- < 小于

  ```mysql
  mysql> select empno,ename from emp where sal < 3000; //查询工资少于3000的员工
  +-------+--------+
  | empno | ename  |
  +-------+--------+
  |  7369 | SMITH  |
  |  7499 | ALLEN  |
  |  7521 | WARD   |
  |  7566 | JONES  |
  |  7654 | MARTIN |
  |  7698 | BLAKE  |
  |  7782 | CLARK  |
  |  7844 | TURNER |
  |  7876 | ADAMS  |
  |  7900 | JAMES  |
  |  7934 | MILLER |
  +-------+--------+
  11 rows in set (0.00 sec)
  ```

- <=

  ```mysql
  mysql> select empno,ename,sal from emp where sal <= 3000; //小于等于3000的员工姓名和编号和工资  
  +-------+--------+---------+
  | empno | ename  | sal     |
  +-------+--------+---------+
  |  7369 | SMITH  |  800.00 |
  |  7499 | ALLEN  | 1600.00 |
  |  7521 | WARD   | 1250.00 |
  |  7566 | JONES  | 2975.00 |
  |  7654 | MARTIN | 1250.00 |
  |  7698 | BLAKE  | 2850.00 |
  |  7782 | CLARK  | 2450.00 |
  |  7788 | SCOTT  | 3000.00 |
  |  7844 | TURNER | 1500.00 |
  |  7876 | ADAMS  | 1100.00 |
  |  7900 | JAMES  |  950.00 |
  |  7902 | FORD   | 3000.00 |
  |  7934 | MILLER | 1300.00 |
  +-------+--------+---------+
  13 rows in set (0.00 sec)
  ```

  

- \>

  ```mysql
  mysql> select empno,ename,sal from emp where sal > 3000;//大于3000的员工姓名和编号和工资  
  +-------+-------+---------+
  | empno | ename | sal     |
  +-------+-------+---------+
  |  7839 | KING  | 5000.00 |
  +-------+-------+---------+
  1 row in set (0.00 sec)
  ```

  

- \>=

  ```mysql
  mysql> select empno,ename,sal from emp where sal >=3000;//工资大于等于3000的员工的工资和姓名和工资
  +-------+-------+---------+
  | empno | ename | sal     |
  +-------+-------+---------+
  |  7788 | SCOTT | 3000.00 |
  |  7839 | KING  | 5000.00 |
  |  7902 | FORD  | 3000.00 |
  +-------+-------+---------+
  3 rows in set (0.00 sec)
  ```

  

- between ... and ... 

  ```mysql
  第一种方式：between ... and ...
  mysql> select empno,ename,sal from emp where sal between 2450 and 3000; //查询薪资在2450和3000之间的员工信息
  +-------+-------+---------+
  | empno | ename | sal     |
  +-------+-------+---------+
  |  7566 | JONES | 2975.00 |
  |  7698 | BLAKE | 2850.00 |
  |  7782 | CLARK | 2450.00 |
  |  7788 | SCOTT | 3000.00 |
  |  7902 | FORD  | 3000.00 |
  +-------+-------+---------+
  5 rows in set (0.00 sec)
  
  //注意：使用 between and 的时候必须遵循左小右大。
  //注意：between and 是闭区间，包含两端的值。
  
  第二种方式：字段 >= 2450 and 字段 <= 3000;
  mysql> select empno,ename,sal from emp where sal >= 2450 and sal <= 3000; 
  +-------+-------+---------+
  | empno | ename | sal     |
  +-------+-------+---------+
  |  7566 | JONES | 2975.00 |
  |  7698 | BLAKE | 2850.00 |
  |  7782 | CLARK | 2450.00 |
  |  7788 | SCOTT | 3000.00 |
  |  7902 | FORD  | 3000.00 |
  +-------+-------+---------+
  5 rows in set (0.00 sec)
  ```

  

- is null  为null （is not null 不为空）

  ```mysql
  mysql> select empno,ename,sal,comm from emp where comm is null; //查询那些员工的津贴为null
  +-------+--------+---------+------+
  | empno | ename  | sal     | comm |
  +-------+--------+---------+------+
  |  7369 | SMITH  |  800.00 | NULL |
  |  7566 | JONES  | 2975.00 | NULL |
  |  7698 | BLAKE  | 2850.00 | NULL |
  |  7782 | CLARK  | 2450.00 | NULL |
  |  7788 | SCOTT  | 3000.00 | NULL |
  |  7839 | KING   | 5000.00 | NULL |
  |  7876 | ADAMS  | 1100.00 | NULL |
  |  7900 | JAMES  |  950.00 | NULL |
  |  7902 | FORD   | 3000.00 | NULL |
  |  7934 | MILLER | 1300.00 | NULL |
  +-------+--------+---------+------+
  10 rows in set (0.00 sec)
  //注意：在数据库中，null不能使用 = 进行衡量，只能使用is null
  //因为数据库中的null代表什么也没有，他不是一个值，所以不能使用等号衡量。
  
  mysql> select empno,ename,sal,comm from emp where comm is not null;//查询那些员工的津贴不为null
  +-------+--------+---------+---------+
  | empno | ename  | sal     | comm    |
  +-------+--------+---------+---------+
  |  7499 | ALLEN  | 1600.00 |  300.00 |
  |  7521 | WARD   | 1250.00 |  500.00 |
  |  7654 | MARTIN | 1250.00 | 1400.00 |
  |  7844 | TURNER | 1500.00 |    0.00 |
  +-------+--------+---------+---------+
  4 rows in set (0.00 sec)
  ```

  

- and 并且

  ```mysql
  mysql> select empno,ename,sal,job from emp where job = 'MANAGER' and sal > 2500;//查询工作岗位是MANAFGER并且工资大于2500的员工信息。
  +-------+-------+---------+---------+
  | empno | ename | sal     | job     |
  +-------+-------+---------+---------+
  |  7566 | JONES | 2975.00 | MANAGER |
  |  7698 | BLAKE | 2850.00 | MANAGER |
  +-------+-------+---------+---------+
  2 rows in set (0.00 sec)
  ```

  

- or 或者

  ```MYSQL
  mysql> select empno,ename,job from emp where job = 'MANAGER' OR JOB = 'SALESMAN';//查询工作岗位是 manager 或者是 salesman 的员工信息。
  +-------+--------+----------+
  | empno | ename  | job      |
  +-------+--------+----------+
  |  7499 | ALLEN  | SALESMAN |
  |  7521 | WARD   | SALESMAN |
  |  7566 | JONES  | MANAGER  |
  |  7654 | MARTIN | SALESMAN |
  |  7698 | BLAKE  | MANAGER  |
  |  7782 | CLARK  | MANAGER  |
  |  7844 | TURNER | SALESMAN |
  +-------+--------+----------+
  7 rows in set (0.00 sec)
  ```

- and 与 or 的优先级问题

  - and 优先级高，如果想让 or 先执行，加括号。

  ```mysql
  mysql> select * from emp where sal > 2500 and (deptno = 10 or deptno = 20);//工资大于2000，并且部门编号是10或者20的部门。
  +-------+-------+-----------+------+------------+---------+------+--------+
  | EMPNO | ENAME | JOB       | MGR  | HIREDATE   | SAL     | COMM | DEPTNO |
  +-------+-------+-----------+------+------------+---------+------+--------+
  |  7566 | JONES | MANAGER   | 7839 | 1981-04-02 | 2975.00 | NULL |     20 |
  |  7788 | SCOTT | ANALYST   | 7566 | 1987-04-19 | 3000.00 | NULL |     20 |
  |  7839 | KING  | PRESIDENT | NULL | 1981-11-17 | 5000.00 | NULL |     10 |
  |  7902 | FORD  | ANALYST   | 7566 | 1981-12-03 | 3000.00 | NULL |     20 |
  +-------+-------+-----------+------+------------+---------+------+--------+
  4 rows in set (0.00 sec)
  ```

  

- in 包含，相当于多个 or （not in 不在这个范围中）

  ```MYSQL
  mysql> select empno,ename,job from emp where job in ('MANAGER','SALESMAN');//查询工作岗位是 MANAGER 和 SALESMAN 的员工。
  +-------+--------+----------+
  | empno | ename  | job      |
  +-------+--------+----------+
  |  7499 | ALLEN  | SALESMAN |
  |  7521 | WARD   | SALESMAN |
  |  7566 | JONES  | MANAGER  |
  |  7654 | MARTIN | SALESMAN |
  |  7698 | BLAKE  | MANAGER  |
  |  7782 | CLARK  | MANAGER  |
  |  7844 | TURNER | SALESMAN |
  +-------+--------+----------+
  7 rows in set (0.00 sec)
  //in 不是一个区间，in后边跟着具体的值
  ```

  

- not ：not 可以取非，主要用在 is 或 in 中。

  - is null
  - is not null
  - in
  - not in

- like ：like成为模糊查询，支持%或下划线匹配

  ```mysql
  mysql> select ename from emp where ename like '%o%'; //查询名字里有'o' 的。
  +-------+
  | ename |
  +-------+
  | JONES |
  | SCOTT |
  | FORD  |
  +-------+
  3 rows in set (0.00 sec)
  
  //找出名字以't'结尾的。
  mysql> select ename from emp where ename like '%t';
  
  //找出名字以'k'开头的。
  mysql> select ename from emp where ename like '%k';
  
  //找出第二个字母是'A'的名字。
  mysql> select ename from emp where ename like '_A%';
  
  //找出第三个字母是'R'的名字。
  mysql> select ename from emp where ename like '__R%';
  ```

  

  - %：任意多个字符
  - \_：任意一个字符
  - \：是转义字符

## 15、排序

### 15.1、查询所有员工薪资，排序

```mysql
mysql> select ename,sal from emp order by sal;//默认是升序
+--------+---------+
| ename  | sal     |
+--------+---------+
| SMITH  |  800.00 |
| JAMES  |  950.00 |
| ADAMS  | 1100.00 |
| WARD   | 1250.00 |
| MARTIN | 1250.00 |
| MILLER | 1300.00 |
| TURNER | 1500.00 |
| ALLEN  | 1600.00 |
| CLARK  | 2450.00 |
| BLAKE  | 2850.00 |
| JONES  | 2975.00 |
| FORD   | 3000.00 |
| SCOTT  | 3000.00 |
| KING   | 5000.00 |
+--------+---------+
14 rows in set (0.00 sec)
```

### 15.2、降序

指定降序

```mysql
mysql> select ename,sal from emp order by sal desc;//指定降序
+--------+---------+
| ename  | sal     |
+--------+---------+
| KING   | 5000.00 |
| SCOTT  | 3000.00 |
| FORD   | 3000.00 |
| JONES  | 2975.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| ALLEN  | 1600.00 |
| TURNER | 1500.00 |
| MILLER | 1300.00 |
| MARTIN | 1250.00 |
| WARD   | 1250.00 |
| ADAMS  | 1100.00 |
| JAMES  |  950.00 |
| SMITH  |  800.00 |
+--------+---------+
14 rows in set (0.00 sec)
````

指定升序

`mysql> select ename,sal from emp order by sal asc;`

### 15.3、多个字段排序

查询员工名字和薪资，要求按照薪资升序，如果薪资一样的话，再按照米子升序排列。

```mysql
//sal 在前，起主导，只有 sal 相等的时候，才会有考虑启用 ename 排序。
mysql> select ename,sal from emp order by sal asc, ename asc;
+--------+---------+
| ename  | sal     |
+--------+---------+
| SMITH  |  800.00 |
| JAMES  |  950.00 |
| ADAMS  | 1100.00 |
| MARTIN | 1250.00 |
| WARD   | 1250.00 |
| MILLER | 1300.00 |
| TURNER | 1500.00 |
| ALLEN  | 1600.00 |
| CLARK  | 2450.00 |
| BLAKE  | 2850.00 |
| JONES  | 2975.00 |
| FORD   | 3000.00 |
| SCOTT  | 3000.00 |
| KING   | 5000.00 |
+--------+---------+
14 rows in set (0.00 sec)
```

### 15.4、了解：根据字段的位置也可以排序

了解一下，不建议在开发中这样写，因为不健壮。
因为列的顺序很容易发生变化，列顺序修改之后，2就费了。

```mysql
mysql> select ename,sal from emp order by 2; 
+--------+---------+
| ename  | sal     |
+--------+---------+
| SMITH  |  800.00 |
| JAMES  |  950.00 |
| ADAMS  | 1100.00 |
| WARD   | 1250.00 |
| MARTIN | 1250.00 |
| MILLER | 1300.00 |
| TURNER | 1500.00 |
| ALLEN  | 1600.00 |
| CLARK  | 2450.00 |
| BLAKE  | 2850.00 |
| JONES  | 2975.00 |
| FORD   | 3000.00 |
| SCOTT  | 3000.00 |
| KING   | 5000.00 |
+--------+---------+
14 rows in set (0.00 sec)
```

### 16、综合案例

找出工资在1250到3000之间的员工信息，要求按照薪资降序排列。

```mysql
mysql> select empno,ename,sal from emp where sal  between  1250 and 3000  order by sal desc;  
+-------+--------+---------+
| empno | ename  | sal     |
+-------+--------+---------+
|  7902 | FORD   | 3000.00 |
|  7788 | SCOTT  | 3000.00 |
|  7566 | JONES  | 2975.00 |
|  7698 | BLAKE  | 2850.00 |
|  7782 | CLARK  | 2450.00 |
|  7499 | ALLEN  | 1600.00 |
|  7844 | TURNER | 1500.00 |
|  7934 | MILLER | 1300.00 |
|  7654 | MARTIN | 1250.00 |
|  7521 | WARD   | 1250.00 |
+-------+--------+---------+
10 rows in set (0.00 sec)
```

关键字顺序不能变：

  select
  ...
  from
  ...
  where
  ...
  order by
  ...

以上语句的执行顺序必须掌握：
  1. 第一步：from
  2. 第二步：where
  3. 第三步：select
  4. 第四步：order by（排序总是在最后执行)

## 17、数据处理函数

### 17.1、单行处理函数

数据处理函数又被称为单行处理函数

单行处理函数的特点：一个输入对应一个输出。

和单行处理函数相对的是：多行处理函数。

多行处理函数的特点（多个输入，对应1个输出！）

### 17.2、常见的单行处理函数

lower 转换小写
  ```mysql
  mysql> select lower(ename) from emp;
  +--------------+
  | lower(ename) |
  +--------------+
  | smith        |
  | allen        |
  | ward         |
  | jones        |
  | martin       |
  | blake        |
  | clark        |
  | scott        |
  | king         |
  | turner       |
  | adams        |
  | james        |
  | ford         |
  | miller       |
  +--------------+
  14 rows in set (0.00 sec)
  //14个输入，最后还是14个输出。
  ```

upper 转换大写

```mysql
  mysql> select lower(ename) from emp;
```

substr 取子串（substr(被截取的字符串，其实下标，截取长度)）

注意：起始下标是下从1开始，没有0。

```mysql
mysql> select substr(ename,1,1) as ename from emp;
+-------+
| ename |
+-------+
| S     |
| A     |
| W     |
| J     |
| M     |
| B     |
| C     |
| S     |
| K     |
| T     |
| A     |
| J     |
| F     |
| M     |
+-------+
14 rows in set (0.00 sec)
```

找出员工名字第一个字母是A的员工信息

  第一种方式：模糊查询

    select ename from emp where like 'A%';

  第二种方式：substr函数

      mysql> select ename from emp where substr(ename, 1, 1) = 'A';
      +-------+
      | ename |
      +-------+
      | ALLEN |
      | ADAMS |
      +-------+
      2 rows in set (0.00 sec)


concat函数进行字符串拼接

    mysql> select concat(empno,ename) from emp;
    +---------------------+
    | concat(empno,ename) |
    +---------------------+
    | 7369SMITH           |
    | 7499ALLEN           |
    | 7521WARD            |
    | 7566JONES           |
    | 7654MARTIN          |
    | 7698BLAKE           |
    | 7782CLARK           |
    | 7788SCOTT           |
    | 7839KING            |
    | 7844TURNER          |
    | 7876ADAMS           |
    | 7900JAMES           |
    | 7902FORD            |
    | 7934MILLER          |
    +---------------------+
    14 rows in set (0.00 sec)

除首字母外，其余全部小写

    //1、截取后边的字符
    select substr(ename,2,length(ename)) from emp;
    
    //2、截取首字母
    select substr(ename,1,1) from emp;
    
    //3、转换为小写字母
    select lower(substr(ename, 2, length(ename))) from emp;
    
    //4、拼接字符串
    select concat(substr(ename,1,1), lower(substr(ename, 2, length(ename))) ) as result from emp;
    
    mysql> select concat(substr(ename,1,1), lower(substr(ename, 2, length(ename))) ) as result from emp;
    +--------+
    | result |
    +--------+
    | Smith  |
    | Allen  |
    | Ward   |
    | Jones  |
    | Martin |
    | Blake  |
    | Clark  |
    | Scott  |
    | King   |
    | Turner |
    | Adams  |
    | James  |
    | Ford   |
    | Miller |
    +--------+
    14 rows in set (0.00 sec)

length 取长度

    mysql> select length(ename) enamelength from emp;
    +-------------+
    | enamelength |
    +-------------+
    |           5 |
    |           5 |
    |           4 |
    |           5 |
    |           6 |
    |           5 |
    |           5 |
    |           5 |
    |           4 |
    |           6 |
    |           5 |
    |           5 |
    |           4 |
    |           6 |
    +-------------+
    14 rows in set (0.00 sec)

trim 去除前后空格

    mysql> select * from emp where ename = trim('  KING  '); 
    +-------+-------+-----------+------+------------+---------+------+--------+
    | EMPNO | ENAME | JOB       | MGR  | HIREDATE   | SAL     | COMM | DEPTNO |
    +-------+-------+-----------+------+------------+---------+------+--------+
    |  7839 | KING  | PRESIDENT | NULL | 1981-11-17 | 5000.00 | NULL |     10 |
    +-------+-------+-----------+------+------------+---------+------+--------+
    1 row in set (0.00 sec)

str_to_date 将字符串转换为日期

date_format 格式化日期

timestampdiff(类型，开始日期，结束日期)

format 设置千分位

case.. when.. then.. when.. then.. else.. end

    当员工工作岗位是MANGGER的时候，工资上调10%，当国祚岗位是SALESMAN 的时候，工资上调50%。（注意：不修改数据库，只是将查询结果显示为工资上调）
    
    mysql> select ename,job,sal,(case job when 'MANAGER' then sal*1.1 when 'SALESMAN' then sal*1.5 else sal end ) as newsal from emp;
    +--------+-----------+---------+---------+
    | ename  | job       | sal     | newsal  |
    +--------+-----------+---------+---------+
    | SMITH  | CLERK     |  800.00 |  800.00 |
    | ALLEN  | SALESMAN  | 1600.00 | 2400.00 |
    | WARD   | SALESMAN  | 1250.00 | 1875.00 |
    | JONES  | MANAGER   | 2975.00 | 3272.50 |
    | MARTIN | SALESMAN  | 1250.00 | 1875.00 |
    | BLAKE  | MANAGER   | 2850.00 | 3135.00 |
    | CLARK  | MANAGER   | 2450.00 | 2695.00 |
    | SCOTT  | ANALYST   | 3000.00 | 3000.00 |
    | KING   | PRESIDENT | 5000.00 | 5000.00 |
    | TURNER | SALESMAN  | 1500.00 | 2250.00 |
    | ADAMS  | CLERK     | 1100.00 | 1100.00 |
    | JAMES  | CLERK     |  950.00 |  950.00 |
    | FORD   | ANALYST   | 3000.00 | 3000.00 |
    | MILLER | CLERK     | 1300.00 | 1300.00 |
    +--------+-----------+---------+---------+
    14 rows in set (0.00 sec)

round 四舍五入

  结论：select后面可以跟某个表的字段名（可以等同看做变量名），也可以跟字面量/字面值（数据）。

    mysql> select round(12345.67, 0) as result from emp;
    +--------+
    | result |
    +--------+
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    |  12346 |
    +--------+
    14 rows in set (0.00 sec)

  保留一位小数
    select round(1234.56, 1) as result from emp;

  保留到十位，结果是1230
    select round(1234.57, -1) as result from emp;



select now() as 当前日期时间;
select curdate() as 今天日期;
select curtime() as 当前时间;    



rand() 生成随机数

    **mysql> select rand() from emp;
    +---------------------+
    | rand()              |
    +---------------------+
    |  0.6068895055045276 |
    |  0.4544186316937382 |
    |   0.451424672688753 |
    |  0.8938674990961957 |
    | 0.11506350814836426 |
    |  0.8937150741868792 |
    |  0.1233848772229486 |
    |  0.9357791942877501 |
    | 0.30874137050354983 |
    |  0.7363693003881436 |
    |  0.7556224211637139 |
    |  0.5690042353877837 |
    |  0.5781539441814217 |
    | 0.18375704547740243 |
    +---------------------+
    14 rows in set (0.00 sec)

  一百以内的随机数
    mysql> select round(rand()*100) from emp; 
    +-------------------+
    | round(rand()*100) |
    +-------------------+
    |                18 |
    |                37 |
    |                30 |
    |                38 |
    |                 2 |
    |                94 |
    |                64 |
    |                40 |
    |                 8 |
    |                20 |
    |                75 |
    |                16 |
    |                55 |
    |                25 |
    +-------------------+
    14 rows in set (0.00 sec)

ifnull 可以将 null 转换成一个具体的值

  ifnull是空处理函数，专门处理空的。  
  **所有数据库中，只要有NULL参与的运算，最终结果就是NULL。为避免这个现象，需要使用 ifnull 函数**

  ifnull 函数用法：ifnull（数据，被当作哪个值）  
    如果数据为null，那么他就会被当做后边的值。

  计算每个员工的年薪？  
    年薪 = （月薪 + 月补助） * 12

    mysql> select ename, (sal + ifnull(comm, 0)) * 12 as yearsal from emp; 
    +--------+----------+
    | ename  | yearsal  |
    +--------+----------+
    | SMITH  |  9600.00 |
    | ALLEN  | 22800.00 |
    | WARD   | 21000.00 |
    | JONES  | 35700.00 |
    | MARTIN | 31800.00 |
    | BLAKE  | 34200.00 |
    | CLARK  | 29400.00 |
    | SCOTT  | 36000.00 |
    | KING   | 60000.00 |
    | TURNER | 18000.00 |
    | ADAMS  | 13200.00 |
    | JAMES  | 11400.00 |
    | FORD   | 36000.00 |
    | MILLER | 15600.00 |
    +--------+----------+
    14 rows in set (0.00 sec)

## 18、分组函数（多行处理函数）

  多行处理函数的特点：输入多行，最终输出一行。  
  5个函数：  
  - count 计数  
  - sum 求和  
  - avg 平均值  
  - max 最大值  
  - min 最小值

注意：  
分组函数在使用的时候必须先进行分组，然后才能使用。  如果你没有对数据进行分组，整张表默认为一组。

找出最高工资？  

```mysql
mysql> select max(sal) from emp;
+----------+
| max(sal) |
+----------+
|  5000.00 |
+----------+
1 row in set (0.00 sec)
```

找出最低工资？

```mysql
mysql> select min(sal) from emp;
+----------+
| min(sal) |
+----------+
|   800.00 |
+----------+
1 row in set (0.00 sec)
```

计算工资和？

```mysql
mysql> select sum(sal) from emp;
+----------+
| sum(sal) |
+----------+
| 29025.00 |
+----------+
1 row in set (0.00 sec)
```

计算平均工资？

```mysql
mysql> select avg(sal) from emp; 
+-------------+
| avg(sal)    |
+-------------+
| 2073.214286 |
+-------------+
1 row in set (0.00 sec)
```

计算员工数量？

```mysql
mysql> select count(ename) from emp;
+--------------+
| count(ename) |
+--------------+
|           14 |
+--------------+
1 row in set (0.00 sec)
```

分组函数在使用的后，需要注意的事项  
1. 分组函数自动忽略 NULL，不需要对 NULL 提前处理。


```mysql
  //求和，自动排除 NULL  
    mysql> select sum(comm) from emp;
    +-----------+
    | sum(comm) |
    +-----------+
    |   2200.00 |
    +-----------+
    1 row in set (0.00 sec)
```

```mysql
  //统计个数，自动排除 NULL  
    mysql> select count(comm) from emp;
    +-------------+
    | count(comm) |
    +-------------+
    |           4 |
    +-------------+
    1 row in set (0.00 sec)
```


```mysql
  //统计补助的平均值，自动排除 NULL  
    mysql> select avg(comm) from emp; 
    +------------+
    | avg(comm)  |
    +------------+
    | 550.000000 |
    +------------+
    1 row in set (0.00 sec)
```

2. 分组函数中count(*) 和 count(具体字段)有什么区别？  
   - count(*)：统计表当中的总行数，只要有一行数据，count 则++，  因为每一行记录不可能都为 NULL， 一行数据中有一列不为 NULL，则这行数据就是有效的。
   - count(具体字段)：统计该字段下不为 NULL 的元素的总数。

```mysql
    mysql> select count(*) from emp;
    +----------+
    | count(*) |
    +----------+
    |       14 |
    +----------+
    1 row in set (0.00 sec)

    mysql> select count(comm) from emp; 
    +-------------+
    | count(comm) |
    +-------------+
    |           4 |
    +-------------+
    1 row in set (0.00 sec)
```

3. 分组函数不能直接使用在where子句中。

找出比最低工资高的员工信息。

4. 所有分组函数可以结合起来一起用。

  ```mysql
  mysql> select min(sal), max(sal), avg(sal), count(*) from emp;
  +----------+----------+-------------+----------+
  | min(sal) | max(sal) | avg(sal)    | count(*) |
  +----------+----------+-------------+----------+
  |   800.00 |  5000.00 | 2073.214286 |       14 |
  +----------+----------+-------------+----------+
  1 row in set (0.00 sec)
  ```

---

## 19、分组查询（非常重要：五颗星*****）

### 19.1、什么是分组查询？  
在实际的引用中，可能有这样的需求，需要进行分组， 然后对每一组的数据进行操作。  
这个术后我们需要使用分组查询，怎么进行分组查询呢？

    select
    ...
    from 
    ...
    group by
    ...

计算每个部分的工资和？

计算每个工作岗位的平均薪资？

找出每个工作岗位的最高薪资？

### 19.2、 全部关键字的执行顺序。

    select
    ...
    from
    ...
    where
    ...
    group by
    ...
    order by
    ...

以上关键字的顺序不能颠倒，需要记忆。  执行顺序是什么？

1. from
2. where
3. group by
4. select
5. order by

为什么分组函数不嫩直接使用在where后边？  
`select ename, sal fro emp where sal > min(sal);`//报错  
因为分组函数在使用的时候必须先分组之后才能使用。  
where执行的时候，还没有分组。所以where 后面不嫩出现分组函数。

`select sum(sal) from emp;`  
这个没有分组，为啥sum() 函数可以用呢？  
因为 select 在 group by 之后执行。

### 19.3、找出每个工作岗位的工资和？

实现思路：按照工作岗位分组，让后对工资求和。

```mysql
mysql> select job,sum(sal) from emp group by job;
+-----------+----------+
| job       | sum(sal) |
+-----------+----------+
| ANALYST   |  6000.00 |
| CLERK     |  4150.00 |
| MANAGER   |  8275.00 |
| PRESIDENT |  5000.00 |
| SALESMAN  |  5600.00 |
+-----------+----------+
5 rows in set (0.00 sec)

以上这个语句的执行顺序？  
1. 先从 emp 表中查询数据。
2. 根据 job 字段进行分组。
3. 然后对每一组的数据进行 sum(sal)
```

```mysql
mysql> select ename,job, sum(sal) from emp group by job; 
+-------+-----------+----------+
| ename | job       | sum(sal) |
+-------+-----------+----------+
| SCOTT | ANALYST   |  6000.00 |
| SMITH | CLERK     |  4150.00 |
| JONES | MANAGER   |  8275.00 |
| KING  | PRESIDENT |  5000.00 |
| ALLEN | SALESMAN  |  5600.00 |
+-------+-----------+----------+
5 rows in set (0.00 sec)

按照职业分组
以上语句在 mysql 中可以执行，但是毫无意义。
以上语句在 oracle 中执行会报错。
oracle 的语法比mysql的语法严格。（mysql 的语法相对来说松散一些！）
```
**重点结论：**  

**在一条 select 语当中，如果有 group by 语句的话，select 后面只能跟：参加了分组的字段，以及分组函。其他一律不能跟。**

### 19.4、找出每个部门的最高薪资？

实现思路：按照部门编号分组，然后计算最高薪资。

    mysql> select deptno,max(sal) from emp group by deptno; 
    +--------+----------+
    | deptno | max(sal) |
    +--------+----------+
    |     10 |  5000.00 |
    |     20 |  3000.00 |
    |     30 |  2850.00 |
    +--------+----------+
    3 rows in set (0.00 sec)

### 19.5、找出每个部门不同工作岗位的最高薪资？

技巧：两个字段联合成一个字段看。（两个字段联合分组）

    select
      ...
    from
      emp
    group by
      deptno,job;
    
    mysql> select deptno,job,max(sal) from emp group by deptno,job;  
    +--------+-----------+----------+
    | deptno | job       | max(sal) |
    +--------+-----------+----------+
    |     10 | CLERK     |  1300.00 |
    |     10 | MANAGER   |  2450.00 |
    |     10 | PRESIDENT |  5000.00 |
    |     20 | ANALYST   |  3000.00 |
    |     20 | CLERK     |  1100.00 |
    |     20 | MANAGER   |  2975.00 |
    |     30 | CLERK     |   950.00 |
    |     30 | MANAGER   |  2850.00 |
    |     30 | SALESMAN  |  1600.00 |
    +--------+-----------+----------+
    9 rows in set (0.00 sec)

### 19.6、使用having 可以对分组之后的数据进一步过滤。

having 不能单独使用，having 不能代替where，having必须和group by 联合使用。

找出每个部门的最高薪资，要求显示最高薪资大于3000的？

1. 第一步：找出每个部门的最高薪资
   - 按照部门编号分组，求每一组的最大值。  
    ```mysql
    mysql> select deptno,max(sal) from emp group by deptno; 
    +--------+----------+
    | deptno | max(sal) |
    +--------+----------+
    |     10 |  5000.00 |
    |     20 |  3000.00 |
    |     30 |  2850.00 |
    +--------+----------+
    3 rows in set (0.00 sec)
    ```
2. 第二步：要求显示出薪资大于3000的。

```mysql
//使用having进行过滤。
    mysql> select deptno,max(sal) from emp group by deptno having max(sal) > 3000;
    +--------+----------+
    | deptno | max(sal) |
    +--------+----------+
    |     10 |  5000.00 |
    +--------+----------+
    1 row in set (0.00 sec)
```

```mysql
//思考一个问题：以上的sql 语句执行效率是不是低？
-- 比较低，实际上可以这样考虑
-- 先使用 where 过滤出工资大于3000的，然后进行分组。
mysql> select deptno,max(sal) from emp where sal > 3000 group by deptno;       
+--------+----------+
| deptno | max(sal) |
+--------+----------+
|     10 |  5000.00 |
+--------+----------+
1 row in set (0.00 sec)
```

优化策略：where 和 having，优先选择where， where实在完成不了的，再选择 having。

### 19.7 where 无法完成的。

找出平均薪资，要求显示平均薪资高于2500的。

1. 第一步：找出每个部门平均薪资
   - `select deptno,avg(sal) from emp group by deptno;`

```mysql
mysql> select deptno,avg(sal) from emp group by deptno;
+--------+-------------+
| deptno | avg(sal)    |
+--------+-------------+
|     10 | 2916.666667 |
|     20 | 2175.000000 |
|     30 | 1566.666667 |
+--------+-------------+
3 rows in set (0.00 sec)
```

2. 第二步：要求只显示平均薪资高于2500的

```mysql
    mysql> select deptno,avg(sal) from emp group by deptno having avg(sal) > 2500;
    +--------+-------------+
    | deptno | avg(sal)    |
    +--------+-------------+
    |     10 | 2916.666667 |
    +--------+-------------+
    1 row in set (0.00 sec)
```

## 20、总结（单表查询学完了）

    select
      ...
    where
      ...
    group by
      ...
    having
      ...
    order by
      ...

执行顺序：  
1. from
2. where
3. group by
4. having
5. select
6. order by

从某张表中查询数据。  
先经过where 条件筛选出有价值的数据。  
对这些有价值的数据进行分组。  
分组之后可以使用having 继续筛选。  
select 查询出来。  
最后排序输出。

找出每个岗位的平均薪资，要求显示平均薪资大于1500的，除MANGER 岗位之外，要求按照平均薪资降序排列。

```mysql
select 
  job,avg(sal) as avgsal
from 
  emp 
where 
  job != 'MANAGER' 
group by 
  job 
having 
  avg(sal) > 1500 
order by 
  avg(sal) desc;

  +-----------+-------------+
  | job       | avg(sal)    |
  +-----------+-------------+
  | PRESIDENT | 5000.000000 |
  | ANALYST   | 3000.000000 |
  +-----------+-------------+
  2 rows in set (0.00 sec)
```

