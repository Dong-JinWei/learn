package cn.tedu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String name;
    private int age;
    private Double[] score;
    private MyDate date;
    private List<String> joy;
    private Set<String> book;
    private Map<String, String> friend;

}
