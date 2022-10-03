# 作业

## 1、取得每个部门的最高薪资的人员名称

```mysql
mysql> select ename,sal,deptno from emp where sal in (select max(sal) from emp group by deptno);      
+-------+---------+--------+
| ename | sal     | deptno |
+-------+---------+--------+
| BLAKE | 2850.00 |     30 |
| SCOTT | 3000.00 |     20 |
| KING  | 5000.00 |     10 |
| FORD  | 3000.00 |     20 |
+-------+---------+--------+
4 rows in set (0.00 sec)
```

## 2、哪些人的薪水在部门的平均薪水之上？

```mysql
mysql> select avg(sal),deptno from emp group by deptno;

mysql> select ename,sal from emp where (deptno = 10 and sal > 2916) or (deptno = 20 and sal > 2175) or (deptno = 30 and sal > 1566);

mysql> select b.ename ename, b.sal sal from (select avg(sal) as sal, deptno from emp group by deptno) as a join emp b on (b.deptno = a.deptno and b.sal > a.sal);
+-------+---------+
| ename | sal     |
+-------+---------+
| ALLEN | 1600.00 |
| JONES | 2975.00 |
| BLAKE | 2850.00 |
| SCOTT | 3000.00 |
| KING  | 5000.00 |
| FORD  | 3000.00 |
+-------+---------+
6 rows in set (0.00 sec)
```

## 3、取得部门中（所有人的）平均的薪资等级，如下：

```mysql
mysql> select deptno,avg(grade) from emp e join salgrade s on e.sal between s.losal and s.hisal group by deptno; 
+--------+------------+
| deptno | avg(grade) |
+--------+------------+
|     10 |     3.6667 |
|     20 |     2.8000 |
|     30 |     2.5000 |
+--------+------------+
3 rows in set (0.00 sec)
```

## 4、不准用组函数（max），取得最高薪水（给出两种方案）

```mysql
mysql> select sal from emp order by sal desc limit 1;
+---------+
| sal     |
+---------+
| 5000.00 |
+---------+
1 row in set (0.00 sec)
```

```mysql
select distinct a.sal from emp a join emp b on a.sal < b.sal;
 
mysql> select sal from emp where sal not in( select distinct a.sal from emp a join emp b on a.sal < b.sal);
+---------+
| sal     |
+---------+
| 5000.00 |
+---------+
1 row in set (0.00 sec)
```

## 5、取得平均薪资最高的部门的部门编号（至少给出两种方案）

```mysql
mysql> select deptno from emp group by deptno order by avg(sal) desc limit 1;    
+--------+
| deptno |
+--------+
|     10 |
+--------+
1 row in set (0.00 sec)
```

```mysql
select deptno,avg(sal) as avgsal from emp group by deptno;

mysql> select deptno,max(avgsal) from (select deptno,avg(sal) as avgsal from emp group by deptno) as a;
+--------+-------------+
| deptno | max(avgsal) |
+--------+-------------+
|     10 | 2916.666667 |
+--------+-------------+
1 row in set (0.00 sec)

select deptno from (select deptno,max(avgsal) from (select deptno,avg(sal) as avgsal from emp group by deptno) as a) as b;
+--------+
| deptno |
+--------+
|     10 |
+--------+
1 row in set (0.00 sec)
```

## 6、取得平均薪水最高的部门的部门名称

```mysql
mysql> select d.dname from (select avg(sal)as avgsal, deptno from emp group by deptno) as e join dept as d on e.deptno = d.deptno having max(avgsal); 
+------------+
| dname      |
+------------+
| ACCOUNTING |
+------------+
1 row in set (0.00 sec)
```

## 7、求平均薪资等级最低的部门名称


```mysql
select 
	e.deptno,d.dname,s.grade
from 
	(select avg(sal)as avgsal, deptno from emp group by deptno) e 
join
	salgrade s
on 
	avgsal between s.losal and s.hisal
join
	dept d
on
	e.deptno = d.deptno
having
	min(s.grade);
	
+--------+-------+-------+
| deptno | dname | grade |
+--------+-------+-------+
|     30 | SALES |     3 |
+--------+-------+-------+
1 row in set (0.00 sec)
```

## 8、取得比普通员工（员工代码没有在mgr字段上出现的）最高薪水还有高的领导人姓名

```mysql
mysql> select distinct bename,bsal from (select a.ename as aename,a.sal as asal, b.ename as bename,b.sal as bsal from emp a join emp b on a.mgr = b.empno) as f where bsal > asal; 
+--------+---------+
| bename | bsal    |
+--------+---------+
| FORD   | 3000.00 |
| BLAKE  | 2850.00 |
| KING   | 5000.00 |
| SCOTT  | 3000.00 |
| CLARK  | 2450.00 |
+--------+---------+
5 rows in set (0.00 sec)

mysql> select distinct mgr from emp where mgr is not null;
+------+
| mgr  |
+------+
| 7902 |
| 7698 |
| 7839 |
| 7566 |
| 7788 |
| 7782 |
+------+
6 rows in set (0.00 sec)

mysql> select max(sal) from emp where empno not in(select distinct mgr from emp where mgr is not null);
+----------+
| max(sal) |
+----------+
|  1600.00 |
+----------+
1 row in set (0.00 sec)

mysql> select distinct ename,sal from emp where sal > (select max(sal) from emp where empno not in(select distinct mgr from emp where mgr is not null));
+-------+---------+
| ename | sal     |
+-------+---------+
| JONES | 2975.00 |
| BLAKE | 2850.00 |
| CLARK | 2450.00 |
| SCOTT | 3000.00 |
| KING  | 5000.00 |
| FORD  | 3000.00 |
+-------+---------+
6 rows in set (0.00 sec)
```

## 9、取得薪水最高的前五名员工

```mysql
mysql> select ename,sal from emp order by sal desc limit 5;
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

## 10、取得薪水最高的第六名到第十名员工

```mysql
mysql> select ename,sal from emp order by sal desc limit 5,5; 
+--------+---------+
| ename  | sal     |
+--------+---------+
| CLARK  | 2450.00 |
| ALLEN  | 1600.00 |
| TURNER | 1500.00 |
| MILLER | 1300.00 |
| MARTIN | 1250.00 |
+--------+---------+
5 rows in set (0.00 sec)
```

## 11、取得最后入职的5名员工

```mysql
mysql> select ename,hiredate from emp order by hiredate desc limit 5; 
+--------+------------+
| ename  | hiredate   |
+--------+------------+
| ADAMS  | 1987-05-23 |
| SCOTT  | 1987-04-19 |
| MILLER | 1982-01-23 |
| FORD   | 1981-12-03 |
| JAMES  | 1981-12-03 |
+--------+------------+
5 rows in set (0.00 sec)
```

## 12、取得每个薪水等级有多少个员工

```mysql
mysql> select grade,count(*) from (select s.grade from emp e join salgrade s on e.sal between s.losal and hisal) as f group by grade;
+-------+----------+
| grade | count(*) |
+-------+----------+
|     1 |        3 |
|     2 |        3 |
|     3 |        2 |
|     4 |        5 |
|     5 |        1 |
+-------+----------+
5 rows in set (0.00 sec)
```

## 13、面试题

有3个表S（学生表），C（课程表），SC（学生选课表）  
S（SNO,SNAME）代表（学号，姓名）  
C（SNO,CNO,SCGRADE）代表（学号，课号，成绩）  
问题：
1. 找你耍没有选过“黎明”老师的所有学生姓名。
2. 列出2门以上（含2门）不及格学生姓名及平均成绩。
3. 即学过1 号课程有学过 2 号课程所有学生的姓名。
请用标准的SQL语言写出答案，方言也行（请说明使用的是什么方言）。

```mysql
数据
mysql> insert into c(cno,cname,cteacher) values('1','chinese','zhang');
Query OK, 1 row affected (0.00 sec)

mysql> insert into c(cno,cname,cteacher) values('2','zhengzhi','wang');
Query OK, 1 row affected (0.00 sec)

mysql> insert into c(cno,cname,cteacher) values('3','english','li');   
Query OK, 1 row affected (0.00 sec)

mysql> insert into c(cno,cname,cteacher) values('4','math','zhao'); 
Query OK, 1 row affected (0.01 sec)

mysql> insert into c(cno,cname,cteacher) values('5',               
    -> 'wuli','liming');
Query OK, 1 row affected (0.01 sec)

mysql> commit;
Query OK, 0 rows affected (0.00 sec)

mysql> insert into s(sno,sname) values('1','stu1');
Query OK, 1 row affected (0.01 sec)

mysql> insert into s(sno,sname) values('2','stu2'); 
Query OK, 1 row affected (0.01 sec)

mysql> insert into s(sno,sname) values('3','stu3'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into s(sno,sname) values('4','stu4'); 
Query OK, 1 row affected (0.01 sec)

mysql> commit;
Query OK, 0 rows affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('1','1','40');
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('1','2','30'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('1','3','20');   
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('1','4','80'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('1','5','60'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('2','1','60');   
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('2','2','60');   
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('2','3','60'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('2','4','60'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('2','5','40'); 
Query OK, 1 row affected (0.00 sec)

mysql> insert into sc(sno,cno,scgrade) values('3','1','60'); 
Query OK, 1 row affected (0.01 sec)

mysql> insert into sc(sno,cno,scgrade) values('3','3','80');   
Query OK, 1 row affected (0.00 sec)

mysql> commit;
Query OK, 0 rows affected (0.00 sec)
```

## 14、列出所有员工及领导的姓名

```mysql
mysql> select e.ename,ifnull(m.ename,'没有上级') from emp e left join emp m on e.mgr = m.empno; 
+--------+----------------------------+
| ename  | ifnull(m.ename,'没有上级')       |
+--------+----------------------------+
| SMITH  | FORD                       |
| ALLEN  | BLAKE                      |
| WARD   | BLAKE                      |
| JONES  | KING                       |
| MARTIN | BLAKE                      |
| BLAKE  | KING                       |
| CLARK  | KING                       |
| SCOTT  | JONES                      |
| KING   | 没有上级                         |
| TURNER | BLAKE                      |
| ADAMS  | SCOTT                      |
| JAMES  | BLAKE                      |
| FORD   | JONES                      |
| MILLER | CLARK                      |
+--------+----------------------------+
14 rows in set (0.00 sec)
```

## 15、列出受雇日期早于其直接上级的所有员工的编号，姓名，部门名称

```mysql
mysql> select e.empno,e.ename,d.dname from emp e join emp m on e.mgr = m.empno join dept d on e.deptno = d.deptno where e.hiredate < m.hiredate; 
+-------+-------+------------+
| empno | ename | dname      |
+-------+-------+------------+
|  7782 | CLARK | ACCOUNTING |
|  7369 | SMITH | RESEARCH   |
|  7566 | JONES | RESEARCH   |
|  7499 | ALLEN | SALES      |
|  7521 | WARD  | SALES      |
|  7698 | BLAKE | SALES      |
+-------+-------+------------+
6 rows in set (0.00 sec)
```

## 16、列出部门名称和这些部门的员工信息，同时列出哪些没有员工的部门。

```mysql
mysql> select e.*,d.dname from emp e right join dept d on e.deptno = d.deptno;
+-------+--------+-----------+------+------------+---------+---------+--------+------------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO | dname      |
+-------+--------+-----------+------+------------+---------+---------+--------+------------+
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 | ACCOUNTING |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000.00 |    NULL |     10 | ACCOUNTING |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300.00 |    NULL |     10 | ACCOUNTING |
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 | RESEARCH   |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 | RESEARCH   |
|  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000.00 |    NULL |     20 | RESEARCH   |
|  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100.00 |    NULL |     20 | RESEARCH   |
|  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 | RESEARCH   |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 | SALES      |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 | SALES      |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 | SALES      |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 | SALES      |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500.00 |    0.00 |     30 | SALES      |
|  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950.00 |    NULL |     30 | SALES      |
|  NULL | NULL   | NULL      | NULL | NULL       |    NULL |    NULL |   NULL | OPERATIONS |
+-------+--------+-----------+------+------------+---------+---------+--------+------------+
```

## 17、列出至少有 5 个员工的所有部门

```mysql
mysql> select d.dname,count(*) from dept d join emp e on d.deptno = e.deptno group by d.dname having count(*) >= 5;  
+----------+----------+
| dname    | count(*) |
+----------+----------+
| RESEARCH |        5 |
| SALES    |        6 |
+----------+----------+
2 rows in set (0.00 sec)
```

## 18、列出薪资比 “SMITH” 多的所有员工的信息。

```mysql
mysql> select * from emp where sal > (select sal from emp where ename = 'SMITH'); 
+-------+--------+-----------+------+------------+---------+---------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO |
+-------+--------+-----------+------+------------+---------+---------+--------+
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
13 rows in set (0.00 sec)
```

## 19、列出所有 ”CLERK“（办事员）的姓名及部门名称，部门人数。

```mysql
mysql> select d.dname as cname,count(d.dname) as cc from emp e join dept d on e.deptno = d.deptno group by d.dname;
+------------+----+
| cname      | cc |
+------------+----+
| ACCOUNTING |  3 |
| RESEARCH   |  5 |
| SALES      |  6 |
+------------+----+
3 rows in set (0.00 sec)

mysql> select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno  where job = 'CLERK';     
+--------+------------+
| ename  | dname      |
+--------+------------+
| MILLER | ACCOUNTING |
| SMITH  | RESEARCH   |
| ADAMS  | RESEARCH   |
| JAMES  | SALES      |
+--------+------------+
4 rows in set (0.00 sec)
```

```mysql
mysql> select e.ename,d.dname,c.cc from emp e join dept d on e.deptno = d.deptno  join (select d.dname as cname,count(d.dname) as cc from emp e join dept d on e.deptno = d.deptno group by d.dname) as c on d.dname = c.cname where job = 'CLERK';
+--------+------------+----+
| ename  | dname      | cc |
+--------+------------+----+
| SMITH  | RESEARCH   |  5 |
| ADAMS  | RESEARCH   |  5 |
| JAMES  | SALES      |  6 |
| MILLER | ACCOUNTING |  3 |
+--------+------------+----+
4 rows in set (0.00 sec)
```

## 20、列出最低薪资大于1500 的各个工作及从事工作的全部雇员人数

```mysql
mysql> select job,sal from emp where sal > 1500;     
+-----------+---------+
| job       | sal     |
+-----------+---------+
| SALESMAN  | 1600.00 |
| MANAGER   | 2975.00 |
| MANAGER   | 2850.00 |
| MANAGER   | 2450.00 |
| ANALYST   | 3000.00 |
| PRESIDENT | 5000.00 |
| ANALYST   | 3000.00 |
+-----------+---------+
7 rows in set (0.00 sec)

mysql> select job from emp group by job;
+-----------+
| job       |
+-----------+
| ANALYST   |
| CLERK     |
| MANAGER   |
| PRESIDENT |
| SALESMAN  |
+-----------+
5 rows in set (0.00 sec)
```

```mysql
mysql> select job,count(job) from emp where sal > 1500 group by job; 
+-----------+------------+
| job       | count(job) |
+-----------+------------+
| ANALYST   |          2 |
| MANAGER   |          3 |
| PRESIDENT |          1 |
| SALESMAN  |          1 |
+-----------+------------+
4 rows in set (0.00 sec)

mysql> select job,count(*) from emp group by job having min(sal) > 1500;
+-----------+----------+
| job       | count(*) |
+-----------+----------+
| ANALYST   |        2 |
| MANAGER   |        3 |
| PRESIDENT |        1 |
+-----------+----------+
3 rows in set (0.00 sec)
```

## 21、列出在部门 ”SALES" <销售部> 工作的员工的姓名，假定不知道销售部的部门编号。

```mysql
mysql> select e.ename from emp e join dept d on e.deptno = d.deptno where d.dname = 'SALES';
+--------+
| ename  |
+--------+
| ALLEN  |
| WARD   |
| MARTIN |
| BLAKE  |
| TURNER |
| JAMES  |
+--------+
6 rows in set (0.00 sec)
```

## 22、列出薪资高于公司平均薪资的所有员工，所在部门，上级领导，雇员的工资等级

```mysql
mysql> select avg(sal) from emp;
+-------------+
| avg(sal)    |
+-------------+
| 2073.214286 |
+-------------+
1 row in set (0.00 sec)

mysql> select ename from emp where sal > (select avg(sal) from emp); 
+-------+
| ename |
+-------+
| JONES |
| BLAKE |
| CLARK |
| SCOTT |
| KING  |
| FORD  |
+-------+
6 rows in set (0.00 sec)


```

```mysql
select
    e.ename,d.dname,l.ename,s.grade
from 
    emp e 
join 
    dept d 
on 
    e.deptno = d.deptno 
left join 
    emp l 
on 
    e.mgr = l.empno  
join
	salgrade s
on
	e.sal between s.losal and s.hisal
where 
    e.sal > (select avg(sal) from emp);
    
+-------+------------+-------+-------+
| ename | dname      | ename | grade |
+-------+------------+-------+-------+
| JONES | RESEARCH   | KING  |     4 |
| BLAKE | SALES      | KING  |     4 |
| CLARK | ACCOUNTING | KING  |     4 |
| SCOTT | RESEARCH   | JONES |     4 |
| KING  | ACCOUNTING | NULL  |     5 |
| FORD  | RESEARCH   | JONES |     4 |
+-------+------------+-------+-------+
6 rows in set (0.00 sec)
```

## 23、列出与“SCOTT”从事相同工作的所有员工及部门名称

```mysql
select ename,job from emp where ename = 'SCOTT'; 

select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno;
```

```mysql
mysql> select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno where job = (select job from emp where ename = 'SCOTT') limit 1,1;
+-------+----------+
| ename | dname    |
+-------+----------+
| FORD  | RESEARCH |
+-------+----------+
1 row in set (0.00 sec)xxxxxxxxxxxxx

mysql> select e.ename,d.dname from emp e join dept d on e.deptno = d.deptno where job = (select job from emp where ename = 'SCOTT') and e.ename <> 'scott';
+-------+----------+
| ename | dname    |
+-------+----------+
| FORD  | RESEARCH |
+-------+----------+
1 row in set (0.00 sec)
```

## 24、列出薪资等于部门30中员工的薪资的其他员工的姓名和薪资。

```mysql
mysql> select ename,sal from emp where sal in(select sal from emp where deptno = 30);
+--------+---------+
| ename  | sal     |
+--------+---------+
| ALLEN  | 1600.00 |
| WARD   | 1250.00 |
| MARTIN | 1250.00 |
| BLAKE  | 2850.00 |
| TURNER | 1500.00 |
| JAMES  |  950.00 |
+--------+---------+
6 rows in set (0.00 sec)xxxxxxxxxxxxxxxxxxxxxxx

mysql> select ename,sal from emp where sal in(select sal from emp where deptno = 30) and deptno <> 30;
Empty set (0.00 sec)
```

## 25、列出薪资高于在部门 30 工作的所有员工的薪资的员工姓名和薪资。部门名称

```mysql
mysql> select e.ename,e.sal,d.dname from emp e join dept d on e.deptno = d.deptno where 
e.sal > (select max(sal) from emp where deptno = 30);
+-------+---------+------------+
| ename | sal     | dname      |
+-------+---------+------------+
| KING  | 5000.00 | ACCOUNTING |
| JONES | 2975.00 | RESEARCH   |
| SCOTT | 3000.00 | RESEARCH   |
| FORD  | 3000.00 | RESEARCH   |
+-------+---------+------------+
4 rows in set (0.00 sec)
```

## 26、列出在每个部门工作的员工数量，平均工资和平均服务期限。

```mysql
select count(deptno) as coudeptno ,avg(sal) as avgsal , deptno from emp group by deptno; 

mysql> select e.coudeptno, e.avgsal, d.dname from (select count(deptno) as coudeptno, avg(sal) as avgsal, deptno from emp group by deptno) as e join dept d on e.deptno = d.deptno;
+-----------+-------------+------------+
| coudeptno | avgsal      | dname      |
+-----------+-------------+------------+
|         3 | 2916.666667 | ACCOUNTING |
|         5 | 2175.000000 | RESEARCH   |
|         6 | 1566.666667 | SALES      |
+-----------+-------------+------------+
3 rows in set (0.00 sec)xxxxxxx

mysql> select e.coudeptno, ifnull(e.avgsal,0), d.dname from (select count(deptno) as coudeptno, avg(sal) as avgsal, deptno from emp group by deptno) as e right join dept d on e.deptno = d.deptno;
+-----------+--------------------+------------+
| coudeptno | ifnull(e.avgsal,0) | dname      |
+-----------+--------------------+------------+
|         3 |        2916.666667 | ACCOUNTING |
|         5 |        2175.000000 | RESEARCH   |
|         6 |        1566.666667 | SALES      |
|      NULL |           0.000000 | OPERATIONS |
+-----------+--------------------+------------+
4 rows in set (0.00 sec)xxxxxxxxxxxxxxxxxxxxxxxxxxxxx

mysql> select e.coudeptno, ifnull(e.avgsal,0), d.dname, ifnull(e.time,0) from (select count(deptno) as coudeptno, avg(sal) as avgsal, deptno,avg(timestampdiff(year,hiredate,now())) as time from emp group by deptno) as e right join dept d on e.deptno = d.deptno;
+-----------+--------------------+------------+------------------+
| coudeptno | ifnull(e.avgsal,0) | dname      | ifnull(e.time,0) |
+-----------+--------------------+------------+------------------+
|         3 |        2916.666667 | ACCOUNTING |          39.3333 |
|         5 |        2175.000000 | RESEARCH   |          37.4000 |
|         6 |        1566.666667 | SALES      |          39.8333 |
|      NULL |           0.000000 | OPERATIONS |           0.0000 |
+-----------+--------------------+------------+------------------+
4 rows in set (0.00 sec)

```

## 27、列出所有员工的姓名、部门名称和工资。

```mysql
mysql> select e.ename,d.dname,e.sal from emp e join dept d on e.deptno = d.deptno; 
+--------+------------+---------+
| ename  | dname      | sal     |
+--------+------------+---------+
| CLARK  | ACCOUNTING | 2450.00 |
| KING   | ACCOUNTING | 5000.00 |
| MILLER | ACCOUNTING | 1300.00 |
| SMITH  | RESEARCH   |  800.00 |
| JONES  | RESEARCH   | 2975.00 |
| SCOTT  | RESEARCH   | 3000.00 |
| ADAMS  | RESEARCH   | 1100.00 |
| FORD   | RESEARCH   | 3000.00 |
| ALLEN  | SALES      | 1600.00 |
| WARD   | SALES      | 1250.00 |
| MARTIN | SALES      | 1250.00 |
| BLAKE  | SALES      | 2850.00 |
| TURNER | SALES      | 1500.00 |
| JAMES  | SALES      |  950.00 |
+--------+------------+---------+
14 rows in set (0.00 sec)
```

## 28、列出所有部门的详细信息和人数

```mysql
 select deptno from emp group by deptno; 
 
mysql> select e.deptno,d.dname,d.loc,count(e.deptno) from emp e right join dept d on e.deptno = d.deptno group by e.deptno;
+--------+------------+----------+-----------------+
| deptno | dname      | loc      | count(e.deptno) |
+--------+------------+----------+-----------------+
|   NULL | OPERATIONS | BOSTON   |               0 |
|     10 | ACCOUNTING | NEW YORK |               3 |
|     20 | RESEARCH   | DALLAS   |               5 |
|     30 | SALES      | CHICAGO  |               6 |
+--------+------------+----------+-----------------+
4 rows in set (0.00 sec)
```

## 29、列出各种工作的最低工资及从事此工作的雇员姓名??

```mysql
mysql> select empno,ename,job,mgr,hiredate,min(sal),comm,deptno from emp group by job;
+-------+-------+-----------+------+------------+----------+--------+--------+
| empno | ename | job       | mgr  | hiredate   | min(sal) | comm   | deptno |
+-------+-------+-----------+------+------------+----------+--------+--------+
|  7788 | SCOTT | ANALYST   | 7566 | 1987-04-19 |  3000.00 |   NULL |     20 |
|  7369 | SMITH | CLERK     | 7902 | 1980-12-17 |   800.00 |   NULL |     20 |
|  7566 | JONES | MANAGER   | 7839 | 1981-04-02 |  2450.00 |   NULL |     20 |
|  7839 | KING  | PRESIDENT | NULL | 1981-11-17 |  5000.00 |   NULL |     10 |
|  7499 | ALLEN | SALESMAN  | 7698 | 1981-02-20 |  1250.00 | 300.00 |     30 |
+-------+-------+-----------+------+------------+----------+--------+--------+
5 rows in set (0.00 sec)xxxxxxxx

select 
	e.ename,t.*
from 
	emp e
join
	(select job,min(sal) as minsal from emp group by job) as t
on
	e.job = t.job and e.sal = t.minsal;
	
+--------+-----------+---------+
| ename  | job       | minsal  |
+--------+-----------+---------+
| SMITH  | CLERK     |  800.00 |
| WARD   | SALESMAN  | 1250.00 |
| MARTIN | SALESMAN  | 1250.00 |
| CLARK  | MANAGER   | 2450.00 |
| SCOTT  | ANALYST   | 3000.00 |
| KING   | PRESIDENT | 5000.00 |
| FORD   | ANALYST   | 3000.00 |
+--------+-----------+---------+
7 rows in set (0.00 sec)
```

  ## 30、列出各个部门的 MANAGER(领导)的最低薪金

```mysql
select s.deptno from emp e join emp s on e.mgr = s.empno;

mysql> select deptno,min(sal) from emp group by deptno; 

mysql> select deptno,min(sal) from (select s.deptno as  deptno,s.sal as sal from emp e join emp s on e.mgr = s.empno) as emp group by deptno;
+--------+----------+
| deptno | min(sal) |
+--------+----------+
|     10 |  2450.00 |
|     20 |  2975.00 |
|     30 |  2850.00 |
+--------+----------+
3 rows in set (0.00 sec)
```

## 31、列出所有员工的年工资，按年薪从高到低排序

```mysql
mysql> select ename,(sal * 12 + ifnull(comm,0)) as income from emp order by income;  
+--------+----------+
| ename  | income   |
+--------+----------+
| SMITH  |  9600.00 |
| JAMES  | 11400.00 |
| ADAMS  | 13200.00 |
| WARD   | 15500.00 |
| MILLER | 15600.00 |
| MARTIN | 16400.00 |
| TURNER | 18000.00 |
| ALLEN  | 19500.00 |
| CLARK  | 29400.00 |
| BLAKE  | 34200.00 |
| JONES  | 35700.00 |
| FORD   | 36000.00 |
| SCOTT  | 36000.00 |
| KING   | 60000.00 |
+--------+----------+
14 rows in set (0.00 sec)
```

## 32、求出员工领导的薪水超过3000员工名称与领导名称

```mysql
mysql> select a.ename,b.ename from emp a join emp b on a.mgr = b.empno where b.sal > 3000;         
+-------+-------+
| ename | ename |
+-------+-------+
| JONES | KING  |
| BLAKE | KING  |
| CLARK | KING  |
+-------+-------+
3 rows in set (0.00 sec)
```

## 33、救出部门名称中，带‘S'字符的部门栓共的工资合计、部门人数。

```mysql
mysql> select dname from dept where dname like '%S%'; 
+------------+
| dname      |
+------------+
| RESEARCH   |
| SALES      |
| OPERATIONS |
+------------+
3 rows in set (0.00 sec)

mysql> select sum(sal) as sumsal,count(deptno) as countdeptno from emp group by deptno; 
+----------+---------------+
| sum(sal) | count(deptno) |
+----------+---------------+
|  8750.00 |             3 |
| 10875.00 |             5 |
|  9400.00 |             6 |
+----------+---------------+
3 rows in set (0.00 sec)


```

```mysql
mysql> select d.dname,ifnull(e.sumsal,0),ifnull(e.countdeptno,0) from dept d left join (select sum(sal) as sumsal,count(deptno) as countdeptno,deptno from emp group by deptno) as e on  d.deptno = e.deptno where dname like '%S%';
+------------+--------------------+-------------------------+
| dname      | ifnull(e.sumsal,0) | ifnull(e.countdeptno,0) |
+------------+--------------------+-------------------------+
| RESEARCH   |           10875.00 |                       5 |
| SALES      |            9400.00 |                       6 |
| OPERATIONS |               0.00 |                       0 |
+------------+--------------------+-------------------------+
3 rows in set (0.00 sec)
```

## 34、给任职日期超过 30 年的员工加薪 10%

```mysql
update emp set sal = sal * 1.1 where (timestampdiff(year,hiredate,now())) > 30;

mysql> select * from emp;
+-------+--------+-----------+------+------------+---------+---------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  880.00 |    NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1760.00 |  300.00 |     30 |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1375.00 |  500.00 |     30 |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 3272.50 |    NULL |     20 |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1375.00 | 1400.00 |     30 |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 3135.00 |    NULL |     30 |
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2695.00 |    NULL |     10 |
|  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3300.00 |    NULL |     20 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5500.00 |    NULL |     10 |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1650.00 |    0.00 |     30 |
|  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1210.00 |    NULL |     20 |
|  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 | 1045.00 |    NULL |     30 |
|  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3300.00 |    NULL |     20 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1430.00 |    NULL |     10 |
+-------+--------+-----------+------+------------+---------+---------+--------+
14 rows in set (0.00 sec)
```



