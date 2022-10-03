/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/4/10 19:15:27                           */
/*==============================================================*/


drop table if exists dept;

drop table if exists emp;

drop table if exists tb_user;

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   dept_id              int not null,
   dept_name            varchar(255),
   primary key (dept_id)
);

/*==============================================================*/
/* Table: emp                                                   */
/*==============================================================*/
create table emp
(
   emp_id               int not null,
   dept_id              int,
   emp_name             varchar(255),
   emp_gender           varchar(255),
   emp_salary           decimal(9,2),
   primary key (emp_id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   user_id              int not null,
   username             varchar(255),
   password             varchar(255),
   nickname             varchar(255),
   primary key (user_id)
);

