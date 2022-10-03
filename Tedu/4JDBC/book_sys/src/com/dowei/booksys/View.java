package com.dowei.booksys;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        int bookId;
        String bookTitle;
        int bookNumber;
        String bookAuthor;
        String bookType;
        String temp;
        Book oneBook;
        while (true) {
            System.out.println("******************欢迎使用图书管理系统***********************");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你需要的功能：\n" +
                    "1、增加  2、删除  3、修改  4、查询一个  5、查询所有  6、退出系统");
            String choose = sc.next();
            switch (choose) {
                case "1":
                    System.out.println("请输入书籍名称");
                    bookTitle = sc.next();
                    if (MyUtils.isNull(bookTitle)) {
                        System.out.println("书籍名称不能为空！！");
                        break;
                    }
                    if (bookTitle.length() < 1) {
                        System.out.println("书籍名称必须大于1！！");
                        break;
                    }
                    System.out.println("请输入书籍编号");
                    temp = sc.next();
                    if (MyUtils.isNumber(temp)) {
                        bookNumber = Integer.parseInt(temp);
                    } else {
                        System.out.println("书籍编号必须为数字！！");
                        break;
                    }
                    if (bookNumber <= 0) {
                        System.out.println("书籍编号不能小于0！！");
                        break;
                    }

                    System.out.println("请输入书籍作者");
                    bookAuthor = sc.next();
                    if ((MyUtils.isNull(bookAuthor))) {
                        System.out.println("作者名称不能为空！！");
                        break;
                    }
                    if (bookAuthor.length() < 1) {
                        System.out.println("作者名称必须大于1！！");
                        break;
                    }

                    System.out.println("请输入书籍类型");
                    bookType = sc.next();
                    if (MyUtils.isNull(bookType)) {
                        System.out.println("书籍类型不能为空！！");
                        break;
                    }
                    if (bookType.length() < 1) {
                        System.out.println("书籍类型必须大于1！！");
                        break;
                    }

                    Book book = new Book(null, bookTitle, bookNumber, bookAuthor, bookType);
                    dao.addBook(book);
                    System.out.println("插入成功！");
                    break;
                case "2":
                    System.out.println("请输入要删除的id");
                    temp = sc.next();
                    if (MyUtils.isNumber(temp)) {
                        bookId = Integer.parseInt(temp);
                    } else {
                        System.out.println("Id必须为数字！！");
                        break;
                    }
                    if (bookId <= 0) {
                        System.out.println("书籍id必须大于0！！");
                        break;
                    }
                    dao.delBook(bookId);
                    System.out.println("删除成功！");
                    break;
                case "3":
                    System.out.println("请输入要修改id");
                    temp = sc.next();
                    if (MyUtils.isNumber(temp)) {
                        bookId = Integer.parseInt(temp);
                    } else {
                        System.out.println("Id必须为数字！！");
                        break;
                    }
                    oneBook = dao.getOneBook(bookId);
                    System.out.println("请输入书籍名称");
                    bookTitle = sc.next();
                    if ((MyUtils.isNull(bookTitle))) {
                        System.out.println("书籍名称不能为空！！");
                        break;
                    }
                    if (bookTitle.length() < 1) {
                        System.out.println("书籍名称必须大于1！！");
                        break;
                    }

                    System.out.println("请输入书籍编号");
                    temp = sc.next();
                    if (MyUtils.isNumber(temp)){
                        bookNumber = Integer.parseInt(temp);
                    }else{
                        System.out.println("书籍编号必须为数字！！");
                        break;
                    }
                    if (bookNumber <= 0) {
                        System.out.println("书籍编号不能小于0！！");
                        break;
                    }

                    System.out.println("请输入书籍作者");
                    bookAuthor = sc.next();
                    if (MyUtils.isNull(bookAuthor)){
                        System.out.println("作者名称不能为空！！");
                        break;
                    }
                    if (bookAuthor.length() < 1) {
                        System.out.println("作者名称必须大于1！！");
                        break;
                    }

                    System.out.println("请输入书籍类型");
                    bookType = sc.next();
                    if (MyUtils.isNull(bookType)){
                        System.out.println("书籍类型不能为空！！");
                        break;
                    }
                    if (bookType.length() < 1) {
                        System.out.println("书籍类型必须大于1！！");
                        break;
                    }
                    System.out.println("===修改前的信息===");
                    System.out.println(oneBook);
                    book = new Book(bookId, bookTitle, bookNumber, bookAuthor, bookType);
                    int effect = dao.updateBook(book);
                    if (effect > 0) {
                        System.out.println("修改成功！！");
                    } else {
                        System.out.println("修改失败！！");
                    }
                    break;
                case "4":
                    System.out.println("请输入要查询的序号");
                    temp = sc.next();
                    if (MyUtils.isNumber(temp)){
                        bookId = Integer.parseInt(temp);
                    }else{
                        System.out.println("Id必须为数字！！");
                        break;
                    }
                    oneBook = dao.getOneBook(bookId);
                    if (oneBook == null) {
                        System.out.println("没有查到！！");
                        break;
                    }
                    System.out.println("================\n" + oneBook);
                    break;
                case "5":
                    List<Book> allBook = dao.getAllBook();
                    for (Book bookTemp : allBook) {
                        System.out.println("===================");
                        System.out.println(bookTemp);
                    }
                    System.out.println("5");
                    break;
                case "6":
                    System.out.println("欢迎下次使用！再见！");
                    return;
                default:
                    System.out.println("输入无效，请重新输入！！");
                    break;
            }
        }
    }
}
