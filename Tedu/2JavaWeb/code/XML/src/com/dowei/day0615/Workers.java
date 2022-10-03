package com.dowei.day0615;

public class Workers {
    private Integer id;
    private String name;
    private Integer age;
    private Double wage;

    public Workers(Integer id, String name, Integer age, Double wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
    }

    public Workers() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", wage=" + wage +
                '}';
    }
}
