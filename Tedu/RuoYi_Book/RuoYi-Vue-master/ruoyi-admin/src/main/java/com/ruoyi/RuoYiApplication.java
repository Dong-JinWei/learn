package com.ruoyi;

import io.swagger.models.auth.In;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan({"com.ruoyi.*"})
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        // SpringApplication.run(RuoYiApplication.class, args);
        // System.out.println("(♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
        //         " .-------.       ____     __        \n" +
        //         " |  _ _   \\      \\   \\   /  /    \n" +
        //         " | ( ' )  |       \\  _. /  '       \n" +
        //         " |(_ o _) /        _( )_ .'         \n" +
        //         " | (_,_).' __  ___(_ o _)'          \n" +
        //         " |  |\\ \\  |  ||   |(_,_)'         \n" +
        //         " |  | \\ `'   /|   `-'  /           \n" +
        //         " |  |  \\    /  \\      /           \n" +
        //         " ''-'   `'-'    `-..-'              ");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++){
            list.add(i);
        }
        System.out.println("原：" + list.toString());

        System.out.println("修改后：" + list.toString());
    }


}
