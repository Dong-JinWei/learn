package cn.tedu.test;

import cn.tedu.config.SpringConfig;
import cn.tedu.domain.Account;
import cn.tedu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


// 设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//    设置Spring环境对应的配置类
@ContextConfiguration(classes = {SpringConfig.class})// 加载配置类
public class Test03MybatisJunit {

    // 支持自动配置注入Bean
    @Autowired
    private AccountService accountService;

    @Test
    public void testInsert(){
        accountService.save(new Account(null, "Johnny", 3000.33));
    }

    @Test
    public void testFindById(){
        System.out.println(accountService.findById(1));
    }
    @Test
    public void testFindAll(){
        System.out.println(accountService.findAll());
    }

}
