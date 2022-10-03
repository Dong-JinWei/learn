package cn.tedu.config;

import cn.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService service;

    // @Resource
    @Autowired
    PersistentTokenRepository repository;


    /**
     *  使用多线程时，初始化的存储策略
     */

    @PostConstruct
    public void init(){
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Bean
    public PersistentTokenRepository jdbcRepository(@Autowired DataSource dataSource) {
        // 使用基于jdbc实现remember操作
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource); // 设置数据源
        // jdbcTokenRepository.setCreateTableOnStartup(true);// 启动时自动创建存储Token的表，建议第一次开启，然后删掉
        return jdbcTokenRepository;
    }

    // 继承WebSecurityConfigurerAdapter，之后会进行配置
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // 这里使用SpringSecurity提供的BCryptPasswordEncoder
        auth
                .userDetailsService(service)/*使用自定义的service实现类进行验证*/
                .passwordEncoder(new BCryptPasswordEncoder());/*加密*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // 什么角色可以访问
                .antMatchers("/static/**").permitAll() // 静态资源任何人可以访问，需要放到前边
                .antMatchers("/jeasyui/**").permitAll() // 静态资源任何人可以访问，需要放到前边
                .antMatchers("/user.jsp").permitAll() // 静态资源任何人可以访问，需要放到前边
                .antMatchers("/user/**").permitAll() // 静态资源任何人可以访问，需要放到前边
                .antMatchers("/html/**").permitAll() // 静态资源任何人可以访问，需要放到前边
                // 基于角色权限
                // .antMatchers("/**").hasRole("user") // 所有请求必须登陆，并且是user角色才可以访问
                .antMatchers("/index").hasAnyRole("user", "admin") // index 页面可以让这两个人访问
                .anyRequest().hasRole("admin") // admin可以访问所有内容
                // .antMatchers("/index").hasAnyAuthority("page:index")
                // .anyRequest().hasAnyAuthority("page:index")
                .and()
                .formLogin() /* 配置form 表单登陆 */
                .loginPage("/login")// 登陆页面地址（GET）
                .loginProcessingUrl("/doLogin")// form表单的提交地址（POST）
                .defaultSuccessUrl("/index", true) // 登陆成功后跳转的页面，也可以通过Handler实现高度自定义
                .permitAll() // 登陆页面允许所有人访问
                .and()
                .logout()
                .logoutUrl("/logout") // 退出登陆的请求地址
                .logoutSuccessUrl("/login") // 退出后重定向的地址
                .and()
                .csrf().disable() // 关闭csrf
                .rememberMe()// 开启记住我功能
                .rememberMeParameter("remember") // 登陆请求表单中需要携带的参数，如果携带那么本次登陆会被记住
                // .tokenRepository(new InMemoryTokenRepositoryImpl()); // 直接保存到内存中，服务器重启后cookies就会消失
                .tokenRepository(repository)// 将token存储的数据库中
                .tokenValiditySeconds(60*60*24*7); // 设置存在的时间7天，单位秒

    }
}