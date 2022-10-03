package cn.tedu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


//  配置类注解
@Configuration
// 包扫描，主要是扫描项目中的service
@ComponentScan("cn.tedu")
// 该注解可以引入数据库连接配置
@PropertySource("classpath:jdbc.properties")
// 管理数据源
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}
