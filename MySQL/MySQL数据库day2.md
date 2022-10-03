# MySQL数据库

## 1、去除重复记录

注意：元数据不会被修改，只是查询结果去重。
去重取药使用一个关键字：`distinct`

```mysql
mysql> select distinct job from emp;
+-----------+
| job       |
+-----------+
| CLERK     |
| SALESMAN  |
| MANAGER   |
| ANALYST   |
| PRESIDENT |
+-----------+
5 rows in set (0.00 sec)
```

//`distinct` 只能出现在所有字段的最前方。

//`distinct` 出现在job，deptno两个字段之前，表示两个字段联合起来去重。

```mysql
mysql> select distinct job,deptno from emp;
+-----------+--------+
| job       | deptno |
+-----------+--------+
| CLERK     |     20 |
| SALESMAN  |     30 |
| MANAGER   |     20 |
| MANAGER   |     30 |
| MANAGER   |     10 |
| ANALYST   |     20 |
| PRESIDENT |     10 |
| CLERK     |     30 |
| CLERK     |     10 |
+-----------+--------+
9 rows in set (0.00 sec)
```

统计一下工作岗位的数量？

```mysql
mysql> select count(distinct job) from emp;
+---------------------+
| count(distinct job) |
+---------------------+
|                   5 |
+---------------------+
1 row in set (0.00 sec)
```

## 2、连接查询

### 2.1、什么是连接查询

从一张表中单独查询，称为单表查询。

emp表和dept表联合起来查询数据，从emp表中去月供名字，从dept表中取部门名字。
这种跨表查询，多张表联合起来查数据，称为链接查询。

### 2.2、连接查询的分类？

根据语法的年代分类：

- SQL92：1992年的时候出现的语法
- SQL99：1999年的时候出现的语法

重点学习SQL99。

根据表的连接方式分类：

- 内连接
  - 等值连接
  - 非等值连接
  - 自连接
- 外连接
  - 左外连接（左连接）
  - 有外连接（有链接）
- 全连接（不学）

### 2.3、当两张表进行连接查询时没有任何条件限制会发生什么问题？

案例：查询每个员工所在部门的名称？

```mysql
mysql> select ename,dname from emp,dept;
+--------+------------+
| ename  | dname      |
+--------+------------+
| SMITH  | ACCOUNTING |
| SMITH  | RESEARCH   |
| SMITH  | SALES      |
| SMITH  | OPERATIONS |
| ALLEN  | ACCOUNTING |
| ALLEN  | RESEARCH   |
| ALLEN  | SALES      |
...
56 rows in set (0.00 sec)

14 * 4 = 56
```

当两张表进行连接查询，没有任何条件限制的时候，最中查询结果条数，是两张表条数的乘积，这种现象被称为：笛卡尔积现象。（笛卡尔发现的，这是一个数学现象。）

### 2.4、怎么避免笛卡尔积现象？

连接时加条件，满足这个条件的记录会被删选出来！

```mysql
mysql> select ename,dname from emp,dept where emp.deptno = dept.deptno; 
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
+--------+------------+
14 rows in set (0.00 sec)

//提高效率的一种写法
mysql> select emp.ename,dept.dname from emp,dept where emp.deptno = dept.deptno;
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
+--------+------------+
14 rows in set (0.00 sec)

//表起别名，很重要。效率问题
mysql> select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno; //SQL92语法
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
+--------+------------+
14 rows in set (0.00 sec)
```

思考：最终查询的结果条数是14，但是匹配的过程中，匹配的次数减少了吗？
	还是56次，只不过进行了四选一，次数没有减少。

注意：通过笛卡尔积现象得出，表的连接次数越多效率越低，尽量避免表的连接次数过多。

### 2.5、内连接之等值连接

案例：查询每个员工所在部门的名称，显示员工名和部门名？

emp e 和 dept d 表进行连接。条件是：e.deptno = d.deptno

SQL92语法：结构不清晰，表的连接条件，和后期进一步筛选的条件，都放到了where后面

```mysql
mysql> select e.ename,d.dname from emp e, dept d where e.deptno = d.deptno;
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
+--------+------------+
14 rows in set (0.00 sec)
```

SQL99语法：表连接的条件是独立的，连接之后，如果还需要进一步筛选，在往后继续添加where

```mysql
mysql> select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno;
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
+--------+------------+
14 rows in set (0.00 sec)

//语法 
select
	...
from 
	...
	a
inner join //inner 可以省略，内连接，带着inner 可读性更好
	b
on
	a和b的连接条件  //条件是等量关系，所以是等值连接
where
	筛选条件
```

2.6、内连接之非等值连接

案例：找出每个员工的薪资等级，要求显示员工名，薪资、薪资等级？

```mysql
mysql> select * from emp;
+-------+--------+-----------+------+------------+---------+---------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
|  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000.00 |    NULL |     20 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500.00 |    0.00 |     30 |
|  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100.00 |    NULL |     20 |
|  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950.00 |    NULL |     30 |
|  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300.00 |    NULL |     10 |
+-------+--------+-----------+------+------------+---------+---------+--------+
14 rows in set (0.00 sec)

mysql> select * from salgrade;
+-------+-------+-------+
| GRADE | LOSAL | HISAL |
+-------+-------+-------+
|     1 |   700 |  1200 |
|     2 |  1201 |  1400 |
|     3 |  1401 |  2000 |
|     4 |  2001 |  3000 |
|     5 |  3001 |  9999 |
+-------+-------+-------+
5 rows in set (0.00 sec)
```



```mysql
select
	e.ename,e.sal,s.grade
from 
	emp e
join	
	salgrade s
on
	e.sal between s.losal and s.hisal; //条件不是一个等量关系，称为非等值连接
	
+--------+---------+-------+
| ename  | sal     | grade |
+--------+---------+-------+
| SMITH  |  800.00 |     1 |
| ALLEN  | 1600.00 |     3 |
| WARD   | 1250.00 |     2 |
| JONES  | 2975.00 |     4 |
| MARTIN | 1250.00 |     2 |
| BLAKE  | 2850.00 |     4 |
| CLARK  | 2450.00 |     4 |
| SCOTT  | 3000.00 |     4 |
| KING   | 5000.00 |     5 |
| TURNER | 1500.00 |     3 |
| ADAMS  | 1100.00 |     1 |
| JAMES  |  950.00 |     1 |
| FORD   | 3000.00 |     4 |
| MILLER | 1300.00 |     2 |
+--------+---------+-------+
14 rows in set (0.00 sec)
```

### 2.7、内连接之自连接

案例：查询员工的上级领导，要求显示员工名和对应的领导名？

```mysql
mysql> select empno,ename,mgr from emp;
+-------+--------+------+
| empno | ename  | mgr  |
+-------+--------+------+
|  7369 | SMITH  | 7902 |
|  7499 | ALLEN  | 7698 |
|  7521 | WARD   | 7698 |
|  7566 | JONES  | 7839 |
|  7654 | MARTIN | 7698 |
|  7698 | BLAKE  | 7839 |
|  7782 | CLARK  | 7839 |
|  7788 | SCOTT  | 7566 |
|  7839 | KING   | NULL |
|  7844 | TURNER | 7698 |
|  7876 | ADAMS  | 7788 |
|  7900 | JAMES  | 7698 |
|  7902 | FORD   | 7566 |
|  7934 | MILLER | 7782 |
+-------+--------+------+
14 rows in set (0.00 sec)
```

技巧：一张表看成两张表

```mysql
select
	a.ename as '员工名',b.ename as '领导名'
from 
	emp a
join
	emp b
on
	a.mgr = b.empno;//员工的领导编号 = 领导的编号

+--------+--------+
| 员工名  | 领导名  |
+--------+--------+
| SMITH  | FORD   |
| ALLEN  | BLAKE  |
| WARD   | BLAKE  |
| JONES  | KING   |
| MARTIN | BLAKE  |
| BLAKE  | KING   |
| CLARK  | KING   |
| SCOTT  | JONES  |
| TURNER | BLAKE  |
| ADAMS  | SCOTT  |
| JAMES  | BLAKE  |
| FORD   | JONES  |
| MILLER | CLARK  |
+--------+--------+
13 rows in set (0.00 sec)

//13条记录，没有KING。《内连接》
```

以上就是内连接中的：自连接，技巧：一张表看两张表。

### 2.8、外连接

```mysql
mysql> select * from emp;
+-------+--------+-----------+------+------------+---------+---------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
|  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000.00 |    NULL |     20 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500.00 |    0.00 |     30 |
|  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100.00 |    NULL |     20 |
|  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950.00 |    NULL |     30 |
|  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300.00 |    NULL |     10 |
+-------+--------+-----------+------+------------+---------+---------+--------+
14 rows in set (0.00 sec)
```

```mysql
mysql> select * from dept;
+--------+------------+----------+
| DEPTNO | DNAME      | LOC      |
+--------+------------+----------+
|     10 | ACCOUNTING | NEW YORK |
|     20 | RESEARCH   | DALLAS   |
|     30 | SALES      | CHICAGO  |
|     40 | OPERATIONS | BOSTON   |
+--------+------------+----------+
4 rows in set (0.00 sec)
```

```mysql
内连接：（A和B连接，AB两张表没有主次关系。平等的。）
select 
	e.ename,d.dname
from
	emp e
join
	dept d
on
	e.deptno = d.deptno; //内连接的特点：完成能够匹配上这个条件的数据查询出来。
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
+--------+------------+
14 rows in set (0.00 sec)
```

外连接（右外连接）：

```mysql
select
	e.ename,d.dname
from
	emp e
right join  //outer 是可以省略的，带着可读性强
	dept d
on
	e.deptno = d.deptno;

+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
| NULL   | OPERATIONS |
+--------+------------+
15 rows in set (0.00 sec)
```

right代表什么：表示将join关键字右边的这张表看成主表，主要是将这张表的数据全部查出来，朝代者关联查询左边的表。
在外连接中，两张表连接，产生了主次关系。

外连接（左连接）

```mysql
mysql> select e.ename,d.dname from dept d left join emp e on e.deptno = d.deptno;
+--------+------------+
| ename  | dname      |
+--------+------------+
| CLARK  | ACCOUNTING |
| KING   | ACCOUNTING |
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| JONES  | RESEARCH   |
| SCOTT  | RESEARCH   |
| ADAMS  | RESEARCH   |
| FORD   | RESEARCH   |
| ALLEN  | SALES      |
| WARD   | SALES      |
| MARTIN | SALES      |
| BLAKE  | SALES      |
| TURNER | SALES      |
| JAMES  | SALES      |
| NULL   | OPERATIONS |
+--------+------------+
15 rows in set (0.00 sec)
```

带有right的是右外连接，又叫做有链接。
带有left的是左外连接，又叫做左连接。
任何一个右连接都有左连接的写法。
任何一个左连接都有右连接的写法。

思考：外连接的查询结果条数一定是 >= 内连接的查询结果？
	正确

案例：查询每个员工的上级领导，要求显示所有员工的名字和领导名？

```mysql
select
	  a.ename,b.ename
from
	emp a
left join
	emp b
on 
	a.mgr = b.empno;

+--------+-------+
| ename  | ename |
+--------+-------+
| SMITH  | FORD  |
| ALLEN  | BLAKE |
| WARD   | BLAKE |
| JONES  | KING  |
| MARTIN | BLAKE |
| BLAKE  | KING  |
| CLARK  | KING  |
| SCOTT  | JONES |
| KING   | NULL  |
| TURNER | BLAKE |
| ADAMS  | SCOTT |
| JAMES  | BLAKE |
| FORD   | JONES |
| MILLER | CLARK |
+--------+-------+
14 rows in set (0.00 sec)
```

2.9、三张表，四张表怎么连接？

```mysql
语法：
	select
		...
	from
		a
	join
		b
	on 
		a和b的连接条件
	join 
		c
	on
		a和c的连接条件

一条SQL语句中内连接和外连接可以混合，都可以出现。
```

案例：找出每个员工的部门名以及工资等级，要求显示员工名、部门名、薪资、薪资等级？

```mysql
select
	e.ename,d.dname,e.sal,s.grade
from 
	emp e
join
	dept d
on
	e.deptno = d.deptno
join
	salgrade s
on
	e.sal between s.losal and s.hisal;

+--------+------------+---------+-------+
| ename  | dname      | sal     | grade |
+--------+------------+---------+-------+
| SMITH  | RESEARCH   |  800.00 |     1 |
| ALLEN  | SALES      | 1600.00 |     3 |
| WARD   | SALES      | 1250.00 |     2 |
| JONES  | RESEARCH   | 2975.00 |     4 |
| MARTIN | SALES      | 1250.00 |     2 |
| BLAKE  | SALES      | 2850.00 |     4 |
| CLARK  | ACCOUNTING | 2450.00 |     4 |
| SCOTT  | RESEARCH   | 3000.00 |     4 |
| KING   | ACCOUNTING | 5000.00 |     5 |
| TURNER | SALES      | 1500.00 |     3 |
| ADAMS  | RESEARCH   | 1100.00 |     1 |
| JAMES  | SALES      |  950.00 |     1 |
| FORD   | RESEARCH   | 3000.00 |     4 |
| MILLER | ACCOUNTING | 1300.00 |     2 |
+--------+------------+---------+-------+
14 rows in set (0.00 sec)
```

案例：找出每个部门名称以及工资等级，还有上级领导，要求显示员工名、领导名、部门名、薪资、薪资等级？

```mysql
select
	e.ename,d.dname,s.grade,l.ename
from
	emp e
join
	dept d
on
	e.deptno = d.deptno
join
	salgrade s
on
	e.sal between s.losal and s.hisal
join
	emp l
on
	e.mgr = l.empno;
	
+--------+------------+-------+-------+
| ename  | dname      | grade | ename |
+--------+------------+-------+-------+
| SMITH  | RESEARCH   |     1 | FORD  |
| ALLEN  | SALES      |     3 | BLAKE |
| WARD   | SALES      |     2 | BLAKE |
| JONES  | RESEARCH   |     4 | KING  |
| MARTIN | SALES      |     2 | BLAKE |
| BLAKE  | SALES      |     4 | KING  |
| CLARK  | ACCOUNTING |     4 | KING  |
| SCOTT  | RESEARCH   |     4 | JONES |
| TURNER | SALES      |     3 | BLAKE |
| ADAMS  | RESEARCH   |     1 | SCOTT |
| JAMES  | SALES      |     1 | BLAKE |
| FORD   | RESEARCH   |     4 | JONES |
| MILLER | ACCOUNTING |     2 | CLARK |
+--------+------------+-------+-------+
13 rows in set (0.00 sec)
```

## 3、子查询

### 3.1、什么是子查询

select 语句中嵌套 select 语句，被嵌套的 select 语句被称为子查询。

3.2、子查询都可以出现在那里？

```mysql
select
	...(select)
from
	...(select)
where
	...(select)
```

3.3、where 语句中的子查询

案例：找出比最低工资高的员工姓名和工资？

```mysql
select
	ename,sal
from
	emp
where
	sal > min(sal);	
ERROR 1111 (HY000): Invalid use of group function
where 子句中不能直接使用分组函数。
```

实现思路：

- 第一步：查询最低工资是多少？

  ```mysql
  mysql> select min(sal) from emp;
  +----------+
  | min(sal) |
  +----------+
  |   800.00 |
  +----------+
  1 row in set (0.00 sec)
  ```

- 第二步：找出小于800的

  ```mysql
   mysql> select ename,sal from emp where sal > 800;  
  +--------+---------+
  | ename  | sal     |
  +--------+---------+
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
  13 rows in set (0.00 sec)
  ```

- 第三步：合并

  ```mysql
  mysql> select ename,sal from emp where (select min(sal) from emp);
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

### 3.4、from 子句中查询

注意：仿若吗后面的子查询，可以将子查询的结果当作一张临时表。（技巧）

案例：找你耍每个岗位的平局工资的薪资等级。

- 第一步：找出每个岗位的平均工资（按照岗位分组求平均值）

  - ```mysql
    mysql> select job,avg(sal) from emp group by job;
    +-----------+-------------+
    | job       | avg(sal)    |
    +-----------+-------------+
    | ANALYST   | 3000.000000 |
    | CLERK     | 1037.500000 |
    | MANAGER   | 2758.333333 |
    | PRESIDENT | 5000.000000 |
    | SALESMAN  | 1400.000000 |
    +-----------+-------------+
    5 rows in set (0.00 sec)
    ```

- 第二步：把以上表的查询结果当作一张真是存在的表

  - ```mysql
     mysql> select * from salgrade;
    +-------+-------+-------+
    | GRADE | LOSAL | HISAL |
    +-------+-------+-------+
    |     1 |   700 |  1200 |
    |     2 |  1201 |  1400 |
    |     3 |  1401 |  2000 |
    |     4 |  2001 |  3000 |
    |     5 |  3001 |  9999 |
    +-------+-------+-------+
    5 rows in set (0.00 sec)
    ```

  - ```mysql
    select
    	t.*,s.grade
    from
    	(select job,avg(sal) as avgsal from emp group by job) t
    join
    	salgrade s
    on
    	t.avgsal between s.losal and s.hisal;
    
    +-----------+-------------+-------+
    | job       | avgsal      | grade |
    +-----------+-------------+-------+
    | CLERK     | 1037.500000 |     1 |
    | SALESMAN  | 1400.000000 |     2 |
    | ANALYST   | 3000.000000 |     4 |
    | MANAGER   | 2758.333333 |     4 |
    | PRESIDENT | 5000.000000 |     5 |
    +-----------+-------------+-------+
    5 rows in set (0.00 sec)
    ```

### 3.5、select后面出现的子查询（这个内容不需要掌握，了解即可！！）

案例：找出每个员工的部门名称，要求显示员工名，部门名？

```mysql
 select 
 e.ename,e.deptno,(select d.dname from dept d where e.deptno = d.deptno) as dname
 from 
  emp e;

+--------+--------+------------+
| ename  | deptno | dname      |
+--------+--------+------------+
| SMITH  |     20 | RESEARCH   |
| ALLEN  |     30 | SALES      |
| WARD   |     30 | SALES      |
| JONES  |     20 | RESEARCH   |
| MARTIN |     30 | SALES      |
| BLAKE  |     30 | SALES      |
| CLARK  |     10 | ACCOUNTING |
| SCOTT  |     20 | RESEARCH   |
| KING   |     10 | ACCOUNTING |
| TURNER |     30 | SALES      |
| ADAMS  |     20 | RESEARCH   |
| JAMES  |     30 | SALES      |
| FORD   |     20 | RESEARCH   |
| MILLER |     10 | ACCOUNTING |
+--------+--------+------------+
14 rows in set (0.00 sec)
```

//错误：ERROR 1242 (21000): Subquery returns more than 1 row

```mysql
    select 
      e.ename,e.deptno,(select dname from dept) as dname
    from
      emp e;
```

注意：对于select后面的子查询来说，这个子查询只能一次返回1条结果，多于1条，就报错了。！

## 4、union合并查询查询结果集

 案例：查询工作岗位是MANAGER 和SALESMAN 的员工？

```mysql
mysql> select ename,job from emp where job in ('MANAGER','SALESMAN');
+--------+----------+
| ename  | job      |
+--------+----------+
| ALLEN  | SALESMAN |
| WARD   | SALESMAN |
| JONES  | MANAGER  |
| MARTIN | SALESMAN |
| BLAKE  | MANAGER  |
| CLARK  | MANAGER  |
| TURNER | SALESMAN |
+--------+----------+
7 rows in set (0.00 sec)
```

```mysql
mysql> select ename,job from emp where job = 'MANAGER' 
    -> union
    -> select ename,job from emp where job = 'SALESMAN';
+--------+----------+
| ename  | job      |
+--------+----------+
| JONES  | MANAGER  |
| BLAKE  | MANAGER  |
| CLARK  | MANAGER  |
| ALLEN  | SALESMAN |
| WARD   | SALESMAN |
| MARTIN | SALESMAN |
| TURNER | SALESMAN |
+--------+----------+
7 rows in set (0.00 sec)
```

union 的效率更高一些。对于表连接来说，每连接一次新表，
则匹配的次数满足笛卡尔积，成倍的翻。。。
但是union可以减少匹配的次数，在减少匹配的情况下，还可以完成两个结果的拼接。

a 连接 b 连接 c
a 10条记录
b 10条记录
c 10条记录
匹配次数是a * b * c  = 1000次

a 连接 b 一个结果：10 * 10 = 100次
a 连接 c 一个结果：10 * 10 = 100次
使用union 的话是：100次+100次 = 200次。（union 把乘法变成了假发运算）

union 在使用的时候有注意事项吗？

```mysql
//错误的：union 在进行结果集合并的时候，要求有两个结果集的列数相同。
mysql> select ename,job from emp where job = 'MANAGER'
    -> union
    -> select ename from emp where job = 'SALESMAN'; 
ERROR 1222 (21000): The used SELECT statements have a different number of columns
```

```MYSQL
//MySQL可以，oracle语法严格，不可以，报错。要求：结果集合并列和列数的数据类型也要一致。
mysql> select ename,job from emp where job = 'MANAGER'
    -> union
    -> select ename,sal from emp where job = 'SALESMAN';
+--------+---------+
| ename  | job     |
+--------+---------+
| JONES  | MANAGER |
| BLAKE  | MANAGER |
| CLARK  | MANAGER |
| ALLEN  | 1600    |
| WARD   | 1250    |
| MARTIN | 1250    |
| TURNER | 1500    |
+--------+---------+
7 rows in set (0.00 sec)
```

## 5、limit（非常重要）

### 5.1、limit 作用：将查询结果集的一部分取出来。通常使用分页在分页查询当中。

百度默认：一夜显示10条记录。
分页的作用是完了提高用户的体验，因为一次全部都查出来，用户体验差。
可以一页一页，翻页看。

### 5.2、limit 怎么用呢？

完整用法：`linmit starIndex, length`
starIndex 是其实下标，length 是长度。
起始下标从0开始。

缺省用法：`limit 5`；这是取前5。

按照薪资降序，取出排名在前五名的员工？

```mysql
select
	ename,sal
from
	emp
order by
	sal desc
limit 5;
+-------+---------+
| ename | sal     |
+-------+---------+
| KING  | 5000.00 |
| SCOTT | 3000.00 |
| FORD  | 3000.00 |
| JONES | 2975.00 |
| BLAKE | 2850.00 |
+-------+---------+
5 rows in set (0.00 sec)

mysql> select   
    ->  ename,sal
    -> from 
    ->  emp
    -> order by
    ->  sal desc
    -> limit 0,5;
+-------+---------+
| ename | sal     |
+-------+---------+
| KING  | 5000.00 |
| SCOTT | 3000.00 |
| FORD  | 3000.00 |
| JONES | 2975.00 |
| BLAKE | 2850.00 |
+-------+---------+
5 rows in set (0.00 sec)
```

### 5.3、注意：mysql当中limit在order by 之后执行！！！！！

### 5.4、取出工资排名在\[3-5\]名的员工？

```mysql
select
	ename,sal
from
	emp
order by 
	sal desc
limit 2,3;

+-------+---------+
| ename | sal     |
+-------+---------+
| FORD  | 3000.00 |
| JONES | 2975.00 |
| BLAKE | 2850.00 |
+-------+---------+
3 rows in set (0.00 sec)

2 表示起始位置从下标 2 开始，就是第三条记录。
3 表示长度。
```

### 5.5、取出工资排名在\[5-9\]名的员工？

```mysql
select
	ename,sal
from
	emp
order by
	sal desc
limit 4,5;
+--------+---------+
| ename  | sal     |
+--------+---------+
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| ALLEN  | 1600.00 |
| TURNER | 1500.00 |
| MILLER | 1300.00 |
+--------+---------+
5 rows in set (0.00 sec)
```

### 5.6、分页

每页显示 3 条记录

第一页：limit 0，3	\[0 1 2]
第二页：limit 3，3	\[3 4 5]
第三页：limit 6，3	\[6 7 8]
第四页：limit 9，3	\[0 10 11]

每页显示 pageSize 条记录
第PageNo页：limit（pageNo -1）、*pageSize ，pageSize

```java
public static void main(String[] args){
    //用户提交火来一个代码，以及显示每页显示的记录条数。
    int pageNo = 5;//第五页
    int pageSize = 10;//每页显示10条
    
    int starIndex = (pageNo - 1) * pageSize;
    String sql = "select ... limit " + startIndex + "," + pagSize;
}
```

记公式 ：`limit (pageNo - 1) * pageSize , pageSize`

## 6、关于DQL语句的大总结：

```mysql
select 
	...
from
	...
where
	...
group by
	...
having
	...
order by
	...
limit
	...
```

执行顺序：

1. from
2. where
3. group by
4. having
5. select
6. order by
7. limit..

## 7、表的创建（建表）

### 7.1、见表格的语法格式：（建表属于 DDL 语句，DDL 包括：create drop alter）

```mysql
create table 表名(
	字段名 数据类型.
	字段名2 数据类型,
	字段名3 数据类型);
```

表名：建议以t_ 或者 tbl_开始，可读性强。见名知意。
	字段名：见名知意。
	表名和字段名都属于标识符。

### 7.2、关于mysql中的数据类型？

很多数据类型，我们只需要掌握一些常见的数据类型即可。

varchar(最长255)：
- 可变长度的字符串
- 比较智能，节省空间。
- 会根据实际的数据长度动态分配空间。
- 优点：节省空间
- 缺点：需要动态分配空间，速度慢。

char（最长255）

- 定长字符串
- 不管实际的数据长度是多少。
- 分配固定长度的空间去存储数据。
- 使用不恰当的时候，可能会导致空间的浪费。
- 优点：不需要动态分配空间，速度快。
- 缺点：使用不当可能会导致空间的浪费。

varchar和char我们应该怎么选择？

性别字段你选什么？因为性别是固定长度的字符串，所以选择char。
姓名字段你选什么？每一个人的名字长度不同，所以选择varchar。

int(最长11)：
数字中的整数型。等同于java的int。

bigint：
数字中的长整型。等同于java中的long。
	
float：
单精度浮点型数据
	
double：
双精度浮点型数据
	
date：
短日期类型
	
datetime：
长日期类型

clob：
字符大对象
最多可以存储4G的字符串。
比如：存储一篇文章，存储一个说明。
超过255个字符的都要采用CLOB字符大对象来存储。
Character Large OBject:CLOB

blob：
二进制大对象
Binary Large OBject
专门用来存储图片、声音、视频等流媒体数据。
往BLOB类型的字段上插入数据的时候，例如插入一个图片、视频等，
你需要使用IO流才行。

t_movie 电影表（专门存储电影信息的）

| 编号  | 名字 | 故事情节           | 上映日期   | 时长 | 海报   |
| ----- | ---- | ------------------ | ---------- | ---- | ------ |
| 10001 | 哪吒 | 从前有个小孩。。。 | 2019-10-1  | 2.5  | 。。。 |
| 10002 | 悟空 | 从前有个猴子。。。 | 2019-11-11 | 2.1  | 。。。 |

### 7.3、创建一个学生表？

学号、姓名、年龄、性别、邮箱地址

```mysql
create table t_student(
	no int,
    name varchar(32),
    age int(3),
    sex char(1),
    email varchar(255)
);
```

删除表：

```mysql
//当这张表不存在的时候会报错！
drop table t_student;

//如果这张表存有的的话，删除
drop table if exists t_student;
```

### 7.4、插入数据insert（DML）

语法格式：

```mysql
insert into 表名(字段1，字段2，字段3...) values(值1，值2，值3);
```

注意：字段名要和值一一对应。数量要对应，数据类型也要对应。

```mysql
insert into t_student(no,name,sex,age,email) values(1,'zhangsan','m',20,'zhangsan@1qq.com');

insert into t_student(email,age,sex,name,no) values('lisi@qq.com','12','f','lisi',2);

insert into t_student(no) values(3);

mysql> select * from t_student;                                                                   
+------+----------+------+------+------------------+
| no   | name     | age  | sex  | email            |
+------+----------+------+------+------------------+
|    1 | zhangsan |   20 | m    | zhangsan@1qq.com |
|    2 | lisi     |   12 | f    | lisi@qq.com      |
|    3 | NULL     | NULL | NULL | NULL             |
+------+----------+------+------+------------------+
3 rows in set (0.00 sec)
```

```mysql
insert into t_student(name) values('wangwu');
mysql> select * from t_student;
+------+----------+------+------+------------------+
| no   | name     | age  | sex  | email            |
+------+----------+------+------+------------------+
|    1 | zhangsan |   20 | m    | zhangsan@1qq.com |
|    2 | lisi     |   12 | f    | lisi@qq.com      |
|    3 | NULL     | NULL | NULL | NULL             |
| NULL | wangwu   | NULL | NULL | NULL             |
+------+----------+------+------+------------------+
4 rows in set (0.00 sec)
```

注意：insert 语句但凡执行成功了，那么必然会多一条记录。没有给其他字段指定值的话，默认是NULL。

```mysql
drop table if exists t_student;
create table t_student(
no int,
name varchar(32),
sex char(1) default 'm',
age int(3),
email varchar(255));

mysql> DESCRIBE t_student;     
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| no    | int(11)      | YES  |     | NULL    |       |
| name  | varchar(32)  | YES  |     | NULL    |       |
| sex   | char(1)      | YES  |     | m       |       |
| age   | int(3)       | YES  |     | NULL    |       |
| email | varchar(255) | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
5 rows in set (0.02 sec)

mysql> insert into t_student(no) values(1);
mysql> select * from t_student;
+------+------+------+------+-------+
| no   | name | sex  | age  | email |
+------+------+------+------+-------+
|    1 | NULL | m    | NULL | NULL  |
+------+------+------+------+-------+
1 row in set (0.00 sec)
```

`insert` 语句中的字段名可以省略吗？可以

`insert into t_student values(2);` //错误的

//注意：签名的字段省略的话，等于都写上了！所以值也要都写上。

```mysql
mysql> insert into t_student values(2,'lisi','f',20,'lisi@qq.com');
mysql> select * from t_student; 
+------+------+------+------+-------------+
| no   | name | sex  | age  | email       |
+------+------+------+------+-------------+
|    1 | NULL | m    | NULL | NULL        |
|    2 | lisi | f    |   20 | lisi@qq.com |
+------+------+------+------+-------------+
2 rows in set (0.00 sec)
```

### 7.5、`inset`插入日期

数字格式化：format



```mysql
select ename,sal from emp;

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

格式化数字：format(数字，’格式')

```mysql
mysql> select ename,format(sal,'$999,999') from emp;
+--------+------------------------+
| ename  | format(sal,'$999,999') |
+--------+------------------------+
| SMITH  | 800                    |
| ALLEN  | 1,600                  |
| WARD   | 1,250                  |
| JONES  | 2,975                  |
| MARTIN | 1,250                  |
| BLAKE  | 2,850                  |
| CLARK  | 2,450                  |
| SCOTT  | 3,000                  |
| KING   | 5,000                  |
| TURNER | 1,500                  |
| ADAMS  | 1,100                  |
| JAMES  | 950                    |
| FORD   | 3,000                  |
| MILLER | 1,300                  |
+--------+------------------------+
14 rows in set, 14 warnings (0.00 sec)
```

`str_to_data:` 将字符串 `varchar` 类型转换 data 类型
`date_format:` 将 `date` 类型转换成具有一定格式的 `varchar` 字符串类型。

```mysql
drop table if exists t_user;
create table t_user(
	id int,
	name varchar(32),
	birth date // 生日也可以使用date日期类型
);

create table t_user(
	id int,
	name varchar(32),
	birth char(10) // 生日可以使用字符串，没问题。
);

生日：1990-10-11 （10个字符）

注意：数据库中的有一条命名规范：
	所有的标识符都是全部小写，单词和单词之间使用下划线进行衔接。

mysql> desc t_user;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| id    | int(11)     | YES  |     | NULL    |       |
| name  | varchar(32) | YES  |     | NULL    |       |
| birth | date        | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
```

插入数据？

`insert into t_user(id, name, birth) values(1, 'lisi', '01-10-1990');`
出问题了：原因是类型不匹配。数据库birth是date类型，这里给了一个字符串varchar。

怎么办？可以使用str_to_date函数进行类型转换。
str_to_date函数可以将字符串转换成日期类型date？

语法格式：
str_to_date('字符串日期', '日期格式')

mysql 的日期格式：

- %Y  年
- %m  月
- %d  日
- %h  时
- %i  分
- %s  秒

```mysql
insert into t_user(id,name,birth) values(1,'lisi',str_to_date('10-10-1990','%d-%m-%Y'));
```

str_to_date函数可以把字符串varchar转换成日期date类型数据，
通常使用在插入insert方面，因为插入的时候需要一个日期类型的数据，
需要通过该函数将字符串转换成date。

如果你提供的日期字符串时这个格式，str_to_date 函数就不需要了。`%Y-%m-%d`
`insert into t_user(id, name, birth) values(2,'whwu', '1990-10-01');`

查询的时候可以以某个特定的日期格式展示吗？
`date_format`
这个函数可以将日期类型转换成特定格式的字符串。

```mysql
mysql> select id,name,date_format(birth, '%m/%d/%Y') as birth from t_user; 
+------+------+------------+
| id   | name | birth      |
+------+------+------------+
|    1 | lisi | 10/10/1990 |
|    2 | whwu | 10/01/1990 |
+------+------+------------+
2 rows in set (0.00 sec)
```

date_format函数怎么用？
date_format(日期类型数据, '日期格式')
这个函数通常使用在查询日期方面。设置展示的日期格式。

```mysql
mysql> select id,name,birth from t_user;
+------+------+------------+
| id   | name | birth      |
+------+------+------------+
|    1 | lisi | 1990-10-10 |
|    2 | whwu | 1990-10-01 |
+------+------+------------+
2 rows in set (0.00 sec)
```

以上的SQL语句实际上是进行了默认的日期格式化，
自动将数据库中的date类型转换成varchar类型。
并且采用的格式是mysql默认的日期格式：'%Y-%m-%d'

java 中的日期格式？`yyyy-MM-dd HH:mm:ss SSS`

### 7.6、date 和 datetime 两个类型的区别？

date 是短日期：只包括年月日信息。

datetime 是长日期：包括年月日时分秒信息。

```mysql
drop table if exists t_user;
create table t_user(
id int,
name varchar(32),
birth date,
create_time datetime
);
```

id是整数
name是字符串
birth是短日期
create_time是这条记录的创建时间：长日期类型

mysql短日期默认格式：`%Y-%m-%d`
mysql长日期默认格式：`%Y-%m-%d %h:%i:%s`

```mysql
insert into t_user(id,name, birth, create_time) values(1, 'lisi', '1900-10-1', '2021-03-18 15:49:50' );

mysql> select * from t_user;
+------+------+------------+---------------------+
| id   | name | birth      | create_time         |
+------+------+------------+---------------------+
|    1 | lisi | 1900-10-01 | 2021-03-18 15:49:50 |
+------+------+------------+---------------------+
1 row in set (0.00 sec)
```

在mysql当中怎么获取系统当前时间？
now() 函数，并且获取的时间带有：时分秒信息！！！！是datetime类型的。

`insert into t_user(id,name,birth,create_time) values(2,'lisi','1991-10-01',now());`

### 7.7、修改update（DML）

语法格式：

​	update 表名 set 字段名1 = 值1， 字段名2 = 值2， 字段名3 = 值3... where 条件；

注意：没有条件限制会导致所有数据全部更新。

```mysql
update t_user set name = 'jack' , birth = '2000-10-11' where id = 2;

mysql> select * from t_user;
+------+------+------------+---------------------+
| id   | name | birth      | create_time         |
+------+------+------------+---------------------+
|    1 | jack | 1900-10-01 | 2021-03-18 15:49:50 |
|    1 | jack | 1900-10-01 | 2021-03-18 15:49:50 |
+------+------+------------+---------------------+
2 rows in set (0.00 sec)
```

```mysql
update t_user set name = 'jack', birth = '2000-10-11', create_time = now() where id = 2;

更新所有数据？
update t_user set name = 'abc';
```

### 7.8、删除数据 delete（DML）

语法格式：
`delete from 表名 where 条件;`

注意：没有条件，整张表的数据全会删除！

```mysql
delete from t_user where id = 2;

insert into t_user(id) valuses(2);

delete from t_user;

```



