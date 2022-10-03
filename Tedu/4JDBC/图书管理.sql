/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/4/12 22:58:33                           */
/*==============================================================*/


drop table if exists tb_author;

drop table if exists tb_book;

drop table if exists tb_type;

/*==============================================================*/
/* Table: tb_author                                             */
/*==============================================================*/
create table tb_author
(
   author_id            int not null,
   author_name          varchar(255),
   primary key (author_id)
);

/*==============================================================*/
/* Table: tb_book                                               */
/*==============================================================*/
create table tb_book
(
   book_id              int not null,
   book_title           varchar(255),
   author_id            int,
   book_isbn            int,
   type_id              int,
   primary key (book_id)
);

/*==============================================================*/
/* Table: tb_type                                               */
/*==============================================================*/
create table tb_type
(
   type_id              int not null,
   type_name            varchar(255),
   primary key (type_id)
);

