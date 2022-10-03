package cn.tedu.bean.Aoon;

import cn.tedu.bean.MyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;

//@Controller // 控制器
//@Component	// 普通bean
//@Service		// 逻辑处理类
//@Repository	// dao层
@Component("AnnoUser")  // 普通bean, user相当于id
@Scope("singleton")  // 单例模式
//@Scope("prototype") // 非单例模式
@Lazy(true)
public class AnnoUser {

    @Value("1002") // 使用反射为次属性注入值， 基本类型使用Value，引用类型使用Resource
    private Integer id;
    @Value("dowei")
    private String name;
    @Value("22")
    private Integer age;
    //@Resource(name="AnnoDate")
    @Autowired // 可是设置自动注解，更具类型自动装配
    @Qualifier("AnnoDate") // 根据名字自动注入，需要填入对应的名字
    private AnnoMyDate annoDate;


    public AnnoUser() {
    }

    public AnnoUser(Integer id, String name, Integer age, AnnoMyDate annoDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.annoDate = annoDate;
    }

    @PostConstruct // 初始化时自动调用
    public void init(){
        System.out.println("----init()---");
    }

    @PreDestroy     // 销毁时自动创建
    public void destroy(){
        System.out.println("----destroy()---");
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

    public AnnoMyDate getAnnoDate() {
        return annoDate;
    }

    public void setAnnoDate(AnnoMyDate annoDate) {
        this.annoDate = annoDate;
    }

    @Override
    public String toString() {
        return "AnnoUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", annoDate=" + annoDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoUser annoUser = (AnnoUser) o;
        return Objects.equals(id, annoUser.id) && Objects.equals(name, annoUser.name) && Objects.equals(age, annoUser.age) && Objects.equals(annoDate, annoUser.annoDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, annoDate);
    }
}


