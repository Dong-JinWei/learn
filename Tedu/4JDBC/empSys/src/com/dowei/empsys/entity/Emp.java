package com.dowei.empsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 表示无参的构造方法
@AllArgsConstructor // 表示有参的构造方法
@Data // 表示set和get方法，toString方法
public class Emp {
    private Integer empId;
    private Dept dept;
    private String empName;
    private String empGender;
    private Double empSalary;
}
