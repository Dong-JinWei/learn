create database mydb0301;
use mydb0301;

#创建表
create table student(
    sid int, # 学号
    sname varchar(20), #姓名
    sage int #年龄，最后一行没有分号
)engine myisam charset utf8;

show tables;

#改表名
rename table student to stu;
show tables;

#删除表
drop table stu;
show tables;

#同名表的创建
create table `table`(
    tid int,
    tname varchar(20)
)engine myisam charset utf8;

create table `order`(
    oid int,
    oname varchar(20)
)engine myisam charset utf8;

#查看表结构
desc `order`;

#查看详细建表语句
show create table `order`;
show create table `order` \G;

##############################################
#表的增删改查

#给表增加数据
insert into emp(eid,ename,eage) values(1,'DIO',200);
#列名可以省略
insert into emp values(5, "Kujo", 28);
insert into emp(eid, eage) values(6, 30);
insert into emp values(7, "Jotaro", 18), (8, "Josuke", 16);

#修改表数据
update emp set ename = 'Giorno', eage = 15;
update emp set ename = 'DIO', eage = 200 where eid = 2;

update emp set ename = '小张', eage = 28 where eid > 3;
update emp set ename = '小王' where eage >= 18 and eage < 25;
update emp set ename = '小李', eage = 19 where eid > 3 or eid < 2;

#MySql中的真假
#where true 全部修改 非0表示true
update emp set eage = 1 where true;
#全不修改 0 表示false
update emp set eage = 1 where false;
#NULL 表示假

#作业
create table student(
    Sno int,
    Sname varchar(20),
    Ssex varchar(20),
    Sbirthday varchar(20),
    class int
)engine myisam charset utf8;

insert into student
values
(108, '曾华', '男', '1977-09-01', 95033),
(105, '匡明', '男', '1975-10-02', 95031),
(107, '王丽', '女', '1976-01-23', 95033),
(101, '李军', '男', '1976-02-20', 95033),
(109, '王芳', '女', '1975-02-10', 95031),
(103, '陆君', '男', '1974-06-03', 95031);

update student set Sbirthday = '1975-10-11' where Sno = 105;
update student set Sbirthday = '1977-09-19' where Sno = 109;
update student set Sbirthday = '1979-01-01' where Sno = 103;

#查询
select eid,ename,eage from emp;
select eid,ename,eage from emp where eid >= 3;
select * from emp where eid >= 3;

select "helloWorld";
select "1+2";

#字符串拼接时，会尝试转换成数字，不能转换，视为0
select "张三" + "你好";
select "张三" + "23";

#字符串中包含数字，会从前往后转换
select "10张三" + "23";

#拼接字符串的函数concat函数
select concat("张三","李四","王五");

#删除
delete from emp where eage >= 18 and eage <=25;

create table teacher(
    #primary key 表示主键 auto_increment 表示自增
    tid int primary key auto_increment,
    #not null default ''  表示不能为空，默认为''
    tname varchar(20) not null default'',
    tage int not null default 0,
    #decimal(8,2) 共八位，小数栈两位,
    tsalary decimal(8,2) not null default 0.0,
    course varchar(20) not null default '',
    food int not null default 0
)engine myisam charset utf8;

desc teacher;
show create table teacher\G;

insert into teacher values(1, '张三', 30, 80000, 'JAVA', 200);
insert into teacher(tid, tname) values(2, '李四');
insert into teacher(tname, tage, course) values('王五', 40, 9000);

update teacher set tsalary = 6666, food = 2222 where (tid >= 3 and tid <= 5) and tage < 40;
update teacher set tsalary = 6666, food = 2222 where (between 3 and 5) and tage < 40;

delete from teacher where tid = 5;
insert into teacher (tname, tage) values ('赵六', 50);

# 删除表中所有数据，truncate 不会保留自增长数据。
truncate teacher;

create table goods(
    goods_id int primary key auto_increment,
    cat_id int,
    goods_name varchar(20) not null default '',
    goods_number int default 0,
    market_price decimal(8,2) not null default 0.0,
    shop_price decimal(8,2) not null default 0.0
)engine myisam charset utf8;

insert into goods(goods_id, cat_id, goods_name, goods_number, market_price, shop_price)
values
(1, 4, "KD876", 10, 1665.60, 1388.00),
(4, 8, "诺基亚N85原装充电器", 17, 69.6, 58.00),
(3, 8, "诺基亚N85原装5800耳机", 24, 81.60, 68.00),
(5, 11, "索爱原装M2读卡器", 8, 24.0, 20.00),
(6, 6, "11胜创KINGMAX内存卡", 15, 50.40, 42.00),
(7, 8, "诺基亚685原装立体声耳机HS-82", 20, 120.00, 100.00),
(8, 3, "飞利浦9@9v", 17, 478.80, 399.00),
(9, 3, "诺基亚E66", 13, 2757.60, 2298.00),
(10, 3, "索爱CT02c", 7, 1593.60, 1328.00),
(11, 3, "索爱c702c", 1, 1560.00, 1300.00), 
(12, 3, "摩托罗拉A10", 8, 1179.60, 983.00),
(13, 3, "诺基亚5320 XpressMusic", 8, 1573.20, 1311.00), 
(14, 4, "诺基亚5800XM", 4, 3150.00, 2625.00),
(15, 3, "摩托罗拉A810", 3, 945.60, 788.00),
(16, 2, "恒基伟G101", 0, 988.00, 823.33),
(17, 3, "夏新N7", 1, 2760.00, 2300.00),
(18, 4, "夏新T5", 1, 3453.60, 2878.00),
(19, 3, "三星SGH-F258", 0, 1029.60, 858.00),
(20, 3, "三星BC01", 13, 336.00, 280.00),
(21, 3, "金立 A30", 40, 2400.00, 2000.00),
(22, 3, "多普达Touch HD",0,  7198.80, 5999.00),
(23, 5, "诺基亚N96", 8, 4440.00, 3700.00),
(24, 3, "P806", 148, 2400.00, 2000.00),
(25, 13, "小灵通/固话50元充值卡",2,  257.60, 48.00),
(26, 13, "小灵通/固话20元充值卡", 2, 22.80, 19.00),
(27, 15, "联通100元充值卡", 2, 114.00, 95.00),
(28, 15, "联通50元充值卡", 0, 54.00, 45.00),
(29, 14, "移动100元充值卡", 0, 108.00, 90.00),
(30, 14, "移动20元充值卡", 9, 21.60, 18.00),
(31, 3, "摩托罗拉E8", 1, 1604.40, 1337.00),
(32, 3, "诺基亚N85",1 , 3612.00, 3010.00);

insert into goods(goods_id, cat_id, goods_name, goods_number, market_price, shop_price)
values
(1,4,"K0876",10,1665.60,1388.00)
(4,8,"诺基亚N85原装充电器",17,69.60,58.00)
(3,8,"诺基亚原装5800耳机",24,81.60,68.00)
(5,11,"索爱原装M2卡读卡器",8,24.00,20.00)
(6,11,"胜创KINGMAX内存卡胜创KINGMAX内存卡",15,50.40,42.00)
(7,8,"诺基亚N85原装立体声耳机HS-82",20,120.00,100.00)
(8,3,"飞利浦9@9v",17,478.80,399.00)
(9,3,"诺基亚E66",13,2757.60,2298.00)
(10,3,"索爱C702c",7,1593.60,1328.00)
(11,3,"索爱C702c",1,1560.00,1300.00)
(12,3,"摩托罗拉A810",8,1179.60,983.00)
(13,3,"诺基亚5320 XpressMusic",8,1573.20,1311.00)
(14,4,"诺基亚5800XM",4,3150.00,2625.00)
(15,3,"摩托罗拉A810",3,945.60,788.00)
(16,2,"恒基伟业G101",0,988.00,823.33)
(17,3,"夏新N7",1,2760.00,2300.00)
(18,4,"夏新T5",1,3453.60,2878.00)
(19,3,"三星SGH-F258",0,1029.60,858.00)
(20,3,"三星BC01",13,336.00,280.00)
(21,3,"金立A30",40,2400.00,2000.00)
(22,3,"多普达Touch HD",0,7198.80,5999.00)
(23,5,"诺基亚N96",8,4440.00,3700.00)
(24,3,"P806",148,2400.00,2000.00)
(25,13,"小灵通/固话50元充值卡",2,57.60,48.00)
(26,13,"小灵通/固话20元充值卡",2,22.80,19.00)
(27,15,"联通100元充值卡",2,114.00,95.00)
(28,15,"联通50元充值卡",0,54.00,45.00)
(29,14,"移动100元充值卡",0,108.00,90.00)
(30,14,"移动20元充值卡",9,21.60,18.00)
(31,3,"摩托罗拉E8",1,1604.40,1337.00)
(32,3,"诺基亚N85",1,3612.00,3010.00)


#高级查询########################
/*
goods_id商品编号，主键，自增
cat_id 商品分类编号
goods_name商品名称
goods_number商品数量
market_price市场价格
shop_price网店价格
*/
select goods_name,market_price,goods_number from goods where goods_id = 15;
select * from goods where goods_id <> 3;
select * from goods where market_price >= 3000;
select * from goods where shop_price < 100;
select * from goods where cat_id = 3 or cat_id = 11;
select * from goods where cat_id in (3, 11);
select * from goods where cat_id <> 3 and cat_id <> 11;
select * from goods where cat_id not in (3, 11);

select * from goods where market_price between 500 and 1000;
select * from goods where market_price < 500 or market_price > 1000;
select * from goods where market_price not between 500 and 1000;

#去重distinct关键字
select distinct cat_id from goods;

#模糊查询
select * from goods where goods_name like "%充值卡%";
select * from goods where goods_name like "诺基亚%";
select * from goods where goods_name like "%充值卡";
select * from goods where goods_name like "%元%";
select * from goods where goods_name like "_基%";
insert into goods (goods_name) values ("x_aHello");
select * from goods where goods_name like "_\_a%";


#查询模型
#查询不会改变原表的值，对列值的运算称为“广义投影”
# as 别名
select goods_name, goods_number*2 as new_number from goods;
select goods_name, goods_number, shop_price * 0.38 as new_price from goods;
select goods_name, goods_number, convert(shop_price * 0.38, decimal(10,2)) as new_price from goods;

select goods_name, goods_number, cat_id, market_price - shop_price as new_price from goods;
select goods_name, goods_number, cat_id, (market_price - shop_price) as new_price from goods where (market_price - shop_price) >= 200;

select goods_name, goods_number, cat_id, market_price - shop_price as new_price from goods having new_price >= 200;


select max(market_price) from goods;
select max(goods_number) from goods;
select min(shop_price) from goods;
select * from goods where market_price = (select max(market_price) max_price from goods);
select * from goods where goods_number = (select max(goods_number) from goods);
#mysql版本中不支持等号后查询返回多个值，但是mysql8支持。
select * from goods where shop_price in (select min(shop_price) from goods);

select sum(market_price) total_price from goods;
select sum(goods_number * market_price) from goods;
select avg(shop_price) from goods;
select avg(goods_number) as avg_goods_number from goods;


select ceil(avg(shop_price)) from goods;
select floor(avg(shop_price)) from goods;
select round(avg(shop_price)) from goods;
select round(avg(ship_price), 3) from goods;
select count(*) from goods;

create table emp(
    id int primary key auto_increment,
    name varchar(20),
    age int
)engine myisam charset utf8;
insert into emp values(null,"张三",20),(null,null,null);
select count(*) from emp;
select count(1) from emp;
select count(name) from emp;
select count(id) from emp;

select null = null;
select 3<null;

select *, ifnull(age, 0) + 15 as new_age from emp;
select * from emp where age is null;
select * from emp where age is not null;
select * from emp order by age asc;

#排序
select * from goods order by market_price desc;
select * from goods order by goods_id asc;
select * from goods order by cat_id asc, goods_number desc;
select * from goods order by goods_number asc, cat_id asc, shop_price desc;

#拼接字符串
select goods_name, concat("妇女节", goods_name) from goods;

#分组
select avg(market_price) from goods where cat_id = 3;
select cat_id,avg(market_price) from goods group by cat_id;

select cat_id, sum(goods_number) from goods group by cat_id;
select cat_id, sum(goods_number * market_price) from goods group by cat_id;
select cat_id, sum(goods_number * market_price) as goods_all from goods group by cat_id having goods_all > 20000;



#分页显示
select * from goods order by market_price desc limit 3;
select * from goods order by goods_id desc limit 5;
#limit m,n m表示偏移量（跳过多少条）n表示显示多少条
select * from goods order by goods_number asc limit 5,5;
select * from goods order by shop_price desc limit 2,6;
select * from goods order by shop_price desc limit 5;
select * from goods order by shop_price desc limit 5, 5;
select * from goods order by shop_price desc limit 10, 5;


#多表查询
select * from goods, category;
select * from goods as g, category as c where g.cat_id = c.cat_id;

select g.goods_name, g.cat_id, c.cat_name from goods as g, category as c where g.cat_id = c.cat_id and g.goods_id = 15;
select cat_id from goods where goods_name = "夏新T5"
select g.goods_id, g.goods_name, g.goods_number, g.cat_id, c.cat_name from goods as g, category as c where g.cat_id = c.cat_id and g.cat_id in (select cat_id from goods where goods_name = "夏新T5");


/*创建部门表*/
CREATE TABLE dept(
	deptno		INT 	PRIMARY KEY,#部门编号
	dname		VARCHAR(50),#部门名称
	loc 		VARCHAR(50)#部门所属地
)engine innodb charset utf8;

/*插入dept表数据*/
INSERT INTO dept VALUES (10, '教研部', '北京');
INSERT INTO dept VALUES (20, '学工部', '上海');
INSERT INTO dept VALUES (30, '销售部', '广州');
INSERT INTO dept VALUES (40, '财务部', '武汉');

#左外连接
select * from goods as g left outer join category as c on g.cat_id = c.cat_id; 
select * from category c left join goods g on c.cat_id = g.cat_id;

select g.goods_id, g.goods_name, g.goods_number, g.cat_id, c.cat_name
from category as c left join goods as g on c.cat_id = g.cat_id
where g.cat_id in (select cat_id from goods where goods_name = "夏新T5");

select g.goods_name, g.cat_id, c.cat_name
from category as c left join goods as g on c.cat_id = g.cat_id 
order by g.goods_number desc limit 3;

create table man(
    name varchar(20),
    card varchar(20)
)engine myisam charset utf8;

create table woman(
    name varchar(20),
    card varchar(20)
)engine myisam charset utf8;

insert into man values('男士1','A'),('男士2','B'),('男士3','C'),('男士4','D'),('男士5','E');
insert into woman values('女士1','B'),('女士2','C'),('女士3','D'),('女士4','E'),('女士5','F');

select * from man left join woman on man.card = woman.card;
select * from woman left join man on man.card = woman.card;

#右连接
select * from man right join woman on man.card = woman.card;
select * from woman right join man on man.card = woman.card;

#内连接
select * from man inner join woman on man.card = woman.card;
select * from woman inner join man on man.card = woman.card;


#模拟外连接union去重 和 union all不去重
select * from category union select cat_id, goods_name from goods;
select * from category union all select cat_id, goods_name from goods;

insert into category values (16, 'aaa');
insert into category values (88, 'aaa');

insert into goods (goods_id, goods_name) values(88, 'aaa');

select * from category union all select goods_id, goods_name from goods;
select * from category union select goods_id, goods_name from goods;

select * from man left join woman on man.card = woman.card union select * from man right join woman on woman.card = man.card;
select * from man left join woman on man.card = woman.card union all select * from man right join woman on woman.card = man.card;

select * from man left join woman on man.card = woman.card;
select * from man right join woman on man.card = woman.card;

select * from man right join woman on man.card = woman.card where man.card is null;
select * from man left join woman on man.card = woman.card
union all
select * from man right join woman on man.card = woman.card where man.card is null;


select * from man left join woman on man.card = woman.card where woman.name is null
union all
select * from man right join woman on man.card = woman.card;

#用户
create user 'admin'@127.0.0.1 identified by 'abc123';
mysql -h127.0.0.1 -P3306 -uadmin -pabc123

create table t1(
    a tinyint,
    b tinyint unsigned
)engine innodb charset utf8;

#时间
create table t1(
    a year,
    b time,
    c date,
    d datetime,
    e timestamp
)engine innodb charset utf8;

insert into t1 values(
    '2018', '123:23:6', '2000-8-8', '2022-3-15 19:25:32', '2022-3-15 19:25:32'
);

#获取当前时间
insert into t1 values(now(), now(), now(), now(), now());
select now();

create table member(
    id int primary key auto_increment,
    name varchar(20),
    pwd varchar(20),
    phone int,
    sex char(1),
    birhtday date,
    last_login datetime,
    sal int
)engine innodb charset utf8;

#修改表
alter table 表名 add 列名称 列类型 列约束;
alter table t1 add name varchar(20) not null default'';
alter table t1 add age int not null default 0 after a;
alter table t1 add gender char(1) not null default '' first;
alter table t1 add sex varchar(20) not null default '' last;

#修改列类型的语法
#没有数据可以随意修改，有数据，数据类型要匹配
alter table 表名 modify 列名 新类型 新约束;
alter table t1 modify b datetime not null default '0000-00-00 0:0:0';
update t1 set a = null;
alter table t1 modify age bigint;

#删除列
alter table 表名 drop 列名;
alter table t1 drop a;

#修改列明
alter table 表名 change 旧列名 新列名 新约束：
alter table t1 change name username varchar(20);

#列约束
create database mydb0316;
use mydb0316;
create table t1(
    a varchar(20) primary key,
    b varchar(20)
)engine myisam charset utf8;
insert into t1 values(null, null);
insert into t1 values(a, null), (a, null);

#uuid
select uuid();
select replace(uuid(),'-','');

create table t2(
    a varchar(20) not null,
    b varchar(20)
)engine myisam charset utf8;
insert into t2(b) values("hello");

create table t3(
    a varchar(20) not null default "hello",
    b varchar(20)
)engine myisam charset utf8;
insert into t3(b) values("world");

create table t4(
    a varchar(20) unique key,
    b varchar(20) unique key,
    c char(32)
)engine myisam charset utf8;
insert into t4 values("a", "a", "a");
insert into t4 values(null, null, null);

create table dept(
    did int primary key,
    dname varchar(20)
)engine innodb charset utf8;

create table emp(
    eid int primary key,
    ename varchar(20),
    #使用主表的主键作为外键
    did int,
    #外键的语法
    constraint fk_emp_dept foreign key(did) references dept(did)
)engine innodb charset utf8;

insert into dept values(10, "a");
insert into emp values(1, '张三',null);
insert into emp values(2, '张三',10);


create table student(
    sid int primary key auto_increment,
    sname varchar(20),
    cid int,
    constraint fk_student_classroom foreign key(cid) references classroom(cid)
)engine innodb charset utf8;

insert into classroom values(10, '计算机科学与技术');
insert into student values(null, '张三', 10);
insert into student values(null, "王五", null);
insert into student values(null, "赵六", null);

create table husband(
    hid int primary key,
    hname varchar(20)
)engine innodb charset utf8;

create table wife(
    wid int primary key,
    wname varchar(20),
    constraint fk_wife_husband foreign key(wid) references husband(hid)
)engine innodb charset utf8;

insert into husband values(1, '丈夫1'), (2, '丈夫2'), (3, '丈夫3');
insert into husband values(1, '妻子1');

create table m1(
    id int primary key auto_increment,
    name varchar(20)
)engine innodb charset utf8;

create table m2(
    tid int primary key auto_increment,
    tname varchar(20),
    id int,
    constraint fk_m2_m1 foreign key(id) references m1(id)
)engine innodb charset utf8;
insert into m1 values(1, '师傅');
insert into m1 values(2, '徒弟');
insert into m2 values(1, '张三', 1), (2, '李四', 2);

create table teacher(
    tid int primary key,
    tname varchar(20)
)engine innodb charset utf8;
insert into teacher values(1, '老师1'),(2, '老师2'),(3, '老师3');

create table stu(
    sid int primary key,
    sname varchar(20)
)engine innodb charset utf8;
insert into stu values(1, '学生1'),(2, '学生2'),(3, '学生3');
insert into stu values(4, '学生4'),(6, '学生6'),(7, '学生7');

##多对多
create table r_teacher_stu(
    tid int,
    sid int,
    constraint fk_r_teacher foreign key(tid) references teacher(tid),
    constraint fk_r_stu foreign key(sid) references stu(sid)
)engine innodb charset utf8;
insert into r_teacher_stu values(1,1),(1,2),(1,3),(2,3),(3,1),(3,2),(3,3);
insert into r_teacher_stu values(1,4),(1,6),(1,7),(2,4),(3,6),(3,7);

select tid from teacher where tname = '老师2';
select sid from r_teacher_stu where tid in (select tid from teacher where tname = '老师2');
select * from stu where sid in (select sid from r_teacher_stu where tid in (select tid from teacher where tname = '老师2'));

select t.tid, t.tname, s.sid, s.sname from teacher as t, stu as s, r_teacher_stu as r where t.tid = r.tid and s.sid = r.sid and t.tname = "老师2";

select t.tid, t.tname, s.sid, s.sname from teacher as t left join r_teacher_stu as r on t.tid = r.tid
left join stu as s on r.sid = s.sid
where t.tid in (select tid from teacher where tname = '老师2');

create table user(
    uid int primary key,
    name varchar(20)
)engine innodb charset utf8;
insert into user values(1, '超级管理员'), (2, '管理员'), (3, '普通用户');

create table per(
    pid int primary key,
    name varchar(20)
)engine innodb charset utf8;
insert into per values(10, "增加用户"), (20, "删除用户"), (30, "查看用户");

create table r_user_per(
    uid int,
    pid int,
    constraint fk_r_user foreign key(uid) references user(uid),
    constraint fk_r_per foreign key(pid) references per(pid)
)engine innodb charset utf8;
insert into r_user_per values(1, 10),(1, 20), (1, 30);
insert into r_user_per values(2, 10), (2, 30);
insert into r_user_per values(3, 30);

select u.uid, u.name, p.pid, p.name from user as u
left join r_user_per as r on u.uid = r.uid
left join per as p on r.pid = p.pid
where u.uid= (select uid from user where name = '管理员');


#视图

select cat_id, avg(market_price) from goods group by cat_id;
select cat_id,avg(market_price) as a_m_price from goods group by cat_id order by a_m_price desc limit 3;
select cat_id,avg(market_price) as a_m_price from goods group by cat_id order by a_m_price desc limit 2,3;

#创建视图
create view v_goods
as select cat_id,avg(market_price) as a_m_price from goods group by cat_id order by a_m_price desc;

select * from v_goods limit 3;
select * from v_goods limit 2,3;


create view vv_goods as 
select goods_id, cat_id, goods_name, goods_number, market_price from goods;

create view vv_goods2 as
select goods_id, cat_id, goods_name, market_price from vv_goods;

#修改视图
alter view vv_goods as select goods_id, cat_id, goods_name, market_price from goods;

#查看视图
desc vv_goods;

#查看建视图的详细语句
show create view vv_goods \G;

#删除视图
drop view vv_goods2;

update vv_goods set goods_name = '500元充值卡' where goods_id = 27;
update v_goods set a_m_price = 25 where cat_id = 11;

create view v_goods3 as
select g.goods_id, g.cat_id, g.goods_name, g.goods_number, g.market_price, g.shop_price, c.cat_name
from goods as g left join category as c on g.cat_id = c.cat_id;

select * from v_goods3;
update v_goods3 set goods_name = "100000元优惠券" where goods_id = '27';

#####################################################
#查询练习
create database mydb0319;
use mydb0319;
create table student(
    id int(10) not null unique primary key auto_increment,
    name varchar(20) not null,
    sex varchar(4),
    birth year,
    department varchar(20) not null,
    address varchar(50)
)engine innodb charset utf8;
create table score(
    id int(10) not null unique primary key auto_increment,
    stu_id int(10) not null,
    c_name varchar(20),
    grade int(10)
)engine innodb charset utf8;

insert into student values(901, '张老大', '男', 1985, '计算机系', '北京市海定区');
insert into student values(902, '张老二', '男', 1986, '中文系', '北京市昌平区');
insert into student values(903, '张三', '女', 1990, '中文系', '湖南省永寿市');
insert into student values(904, '李四', '男', 1990, '英语系', '辽宁省阜新市');
insert into student values(905, '王五', '女', 1991, '英语系', '福建省厦门市');
insert into student values(906, '王六', '男', 1988, '计算机系', '辽宁省衡阳市');

insert into score values(null, 901, '计算机', 98);
insert into score values(null, 901, '英语', 80);
insert into score values(null, 902, '计算机', 65);
insert into score values(null, 902, '中文', 88);
insert into score values(null, 903, '中文', 95);
insert into score values(null, 904, '计算机', 70);
insert into score values(null, 904, '英语', 92);
insert into score values(null, 905, '英语', 94);
insert into score values(null, 906, '计算机', 90);
insert into score values(null, 906, '英语', 85);

#引擎
create database mydb0321;
create table t1(id int primary key)engine myisam charset utf8;
create table t2(id int primary key)engine innodb charset utf8;
show engines;
create table t3(id int);
show create table t3 \G;

#事务
create table zhangsan(
    zmoney int
)engine innodb charset utf8;
create table lisi(
    lmoney int
)engine innodb charset utf8;
insert into zhangsan values(5000);
insert into lisi values(0);

update zhangsan set zmoney = zmoney - 1000;
update zhangsan set zmoney = zmoney + 1000;

#开启事务，事务回滚
start transaction;
update zhangsan set zmoney = zmoney - 1000;
rollback;

#开启事务，事务提交
select * from zhangsan,lisi;
start transaction;
update zhangsan set zmoney = zmoney - 1000;
update lisi set lmoney = lmoney + 1000;
commit;
select * from zhangsan,lisi;

#索引（index）
create database mydb0322;
use mydb0322;
create table t1(
    tid int primary key,
    tname varchar(20) unique key,
    temail varchar(255),
    index idx_temail(temail)
);
show create table t1 \G;

#语法 索引类型 索引名(列名), 当索引名省略时，和列明相同
show index from t1;
insert into t1 values
(1, '张三', "abc@qq.com"),
(2, '李四', "def@qq.com"),
(3, '王五', "ghc@qq.com"),
(4, '李六', "imn@qq.com"),
(5, '马七', "fes@qq.com");

explain select tid,tname,temail from t1 where tid = 5;
explain select tid,tname,temail from t1 where tname = "张三";
explain select tid,tname,temail from t1 where temail = "abc@qq.com";

#删除索引
alter table t1 drop primary key;

#删除唯一索引
alter table t1 drop key tname;
alter table t1 drop key idx_temail;
explain select tid, tname, temail from t1 where temail = "abc@qq.com";

#联合索引
create table t2(
    tid int primary key,
    tname varchar(255),
    temail varchar(255),
    key mul_tname_temail(tname,temail)
);
insert into t2 values
(1, '张三', "abc@qq.com"),
(2, '李四', "def@qq.com"),
(3, '王五', "ghc@qq.com"),
(4, '李六', "imn@qq.com"),
(5, '马七', "fes@qq.com");

show index from t2;
explain select * from t2 where tname = '张三';
explain select * from t2 where temail = 'abc@qq.com';
explain select * from t2 where tname = '张三' and temail = 'abc@qq.com';
explain select * from t2 where temail = 'abc@qq.com'and  tname = '张三';

create table t3(
    tid int primary key,
    tname varchar(255),
    temail varchar(255),
    key mul_tname_temail(tname,temail),
    key idx_tname(tname)
);
insert into t3 values
(1, '张三', "abc@qq.com"),
(2, '李四', "def@qq.com"),
(3, '王五', "ghc@qq.com"),
(4, '李六', "imn@qq.com"),
(5, '马七', "fes@qq.com");
show index from t3;
explain select * from t3 where tname = '张三';

create table t4(
    tid int primary key,
    tname varchar(255),
    temail varchar(255),
    #对指定字符数添加索引
    key idx_tname(tname(10))
);

#导入sql文件
source D:\学习\数据库\bigdata.sql
use bigdata;
select count(*) from student_info

select * from student_info where student_id = 3;
select * from student_info where id = 3;
explain select * from student_info where student_id = 3;
explain select * from student_info where id = 3;

alter table student_info add key mulkey(student_id, name, course_id);

explain select * from student_info where student_id = 3;
explain select * from student_info where name = 'hkdkSH';
explain select * from student_info where course_id = 10014;

explain select * from student_info where student_id = 3 and name = 'hkdkSH';
explain select * from student_info where student_id = 3 and course_id = 10014;
explain select * from student_info where name = 'hkdkSH' and course_id = 10014;
explain select * from student_info where course_id = 10014 and student_id = 3;
explain select * from student_info where name = 'hkdkSH' and student_id = 3;
explain select * from student_info where student_id = 3 and name = "hkdkSH" and course_id = 10014;
explain select * from student_info where name = "hkdkSH" and  student_id = 3  and course_id = 10014;
explain select * from student_info where name = "hkdkSH" and course_id = 10014 and  student_id = 3;

explain select * from student_info where floor(student_id) = 3;
explain select * from student_info where student_id * 2 = 3;
explain select count(*) from student_info where student_id = 3;

alter table student_info add key mulkey2(name);
explain select * from student_info where name = 123;
explain select * from student_info where name = '123';

alter table student_info drop key mulkey;
alter table student_info drop key mulkey2;
show index from student_info;

alter table student_info add key mukey(student_id, course_id, name);
explain select * from student_info where student_id = 3 and course_id = 1 and name = 'asdf';
explain select * from student_info where student_id > 3 and course_id = 1 and name = 'asdf';
explain select * from student_info where student_id = 3 and course_id > 1 and name = 'asdf';
alter table student_info add key mukey2(student_id, name, course_id);

explain select * from student_info where student_id <> 3 and course_id = 1 and name = 'asdf';
explain select * from student_info where student_id = 3 and course_id <> 1 and name = 'asdf';
explain select * from student_info where student_id = 3 and course_id =  1 and name <> 'asdf';

alter table student_info add key mukey3(name);
explain select * from student_info where name is null;
explain select * from student_info where name is not null;
explain select * from student_info where name like "abc%";
explain select * from student_info where name like "%abc";