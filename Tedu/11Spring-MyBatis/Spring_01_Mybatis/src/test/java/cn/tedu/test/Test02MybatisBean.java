package cn.tedu.test;

import cn.tedu.config.SpringConfig;
import cn.tedu.domain.Account;
import cn.tedu.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test02MybatisBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService as = acac.getBean(AccountService.class);
        List<Account> all = as.findAll();
        System.out.println(all);
    }
}
