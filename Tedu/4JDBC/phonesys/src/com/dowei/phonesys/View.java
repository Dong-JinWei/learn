package com.dowei.phonesys;

import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        PhoneDao dao = new PhoneDao();
        Scanner in = new Scanner(System.in);
        int phoneId;
        String phoneBrand;
        String phoneModel;
        String phoneName;
        double phonePrice;
        String temp;
        Phone phone;
        while (true) {
            System.out.println("===============欢迎使用手机管理系统===============");
            System.out.println("1、增加 2、删除 3、修改 4、查询一个 5、查询所有 6、退出");
            String choose = in.next();
            switch (choose) {
                case "1":
                    System.out.println("请输入要增加的品牌");
                    phoneBrand = in.next();
                    if (MyUtils.isNull(phoneBrand)){
                        System.out.println("品牌名称不能为空！！");
                        break;
                    }
                    System.out.println("请输入手机型号");
                    phoneModel = in.next();
                    if (MyUtils.isNull(phoneModel)){
                        System.out.println("手机型号不能为空！！");
                        break;
                    }
                    System.out.println("请输入手机名称");
                    phoneName = in.next();
                    if (MyUtils.isNull(phoneName)){
                        System.out.println("手机名字不能为空！！");
                        break;
                    }
                    System.out.println("请输入手机价格");
                    temp = in.next();
                    if (MyUtils.isDouble(temp)){
                        phonePrice = Double.parseDouble(temp);
                    }else{
                        System.out.println("请输入一个有效的价格!!");
                        break;
                    }
                    phone = new Phone(null, phoneBrand, phoneModel, phoneName, phonePrice);
                    dao.add(phone);
                    System.out.println("插入成功！！");
                    break;
                case "2":
                    System.out.println("请输入要删除的Id");
                    temp = in.next();
                    if (MyUtils.isNumber(temp)){
                        phoneId = Integer.parseInt(temp);
                    }else{
                        System.out.println("Id必须是数字！！");
                        break;
                    }
                    dao.del(phoneId);
                    System.out.println("删除成功！！");
                    break;
                case "3":
                    System.out.println("请输入要修改的Id");
                    temp = in.next();
                    if (MyUtils.isNumber(temp)){
                        phoneId = Integer.parseInt(temp);
                    }else{
                        System.out.println("Id必须是数字！！");
                        break;
                    }
                    System.out.println("请输入要修改的品牌");
                    phoneBrand = in.next();
                    if (MyUtils.isNull(phoneBrand)){
                        System.out.println("品牌名称不能为空！！");
                        break;
                    }
                    System.out.println("请输入手机型号");
                    phoneModel = in.next();
                    if (MyUtils.isNull(phoneModel)){
                        System.out.println("手机型号不能为空！！");
                        break;
                    }
                    System.out.println("请输入手机名称");
                    phoneName = in.next();
                    if (MyUtils.isNull(phoneName)){
                        System.out.println("手机名字不能为空！！");
                        break;
                    }
                    System.out.println("请输入手机价格");
                    temp = in.next();
                    if (MyUtils.isDouble(temp)){
                        phonePrice = Double.parseDouble(temp);
                    }else{
                        System.out.println("请输入一个有效的价格!!");
                        break;
                    }
                    phone = new Phone(phoneId, phoneBrand, phoneModel, phoneName, phonePrice);
                    Phone one = dao.getOne(phoneId);
                    System.out.println("====修改前的数据是=====\n" + one);
                    int effect = dao.update(phone);
                    if (effect>0){
                        System.out.println("修改成功！！");
                    }else{
                        System.out.println("修改失败！！");
                    }
                    break;
                case "4":
                    System.out.println("请输入要查询的Id");
                    temp = in.next();
                    if (MyUtils.isDouble(temp)){
                        phoneId = Integer.parseInt(temp);
                    }else{
                        System.out.println("Id必须是数字！！");
                        break;
                    }
                    phone = dao.getOne(phoneId);
                    System.out.println(phone);
                    break;
                case "5":
                    List<Phone> all = dao.getAll();
                    if (all.size() == 0) {
                        System.out.println("没有任何数据！！");
                        break;
                    } else {
                        for (Phone phone1 : all) {
                            System.out.println("============");
                            System.out.println(phone1);
                        }
                    }
                    break;
                case "6":
                    System.out.println("欢迎下次使用，再见！！");
                    return;
                default:
                    System.out.println("输入有误，重新输入！！");
            }
        }
    }
}
