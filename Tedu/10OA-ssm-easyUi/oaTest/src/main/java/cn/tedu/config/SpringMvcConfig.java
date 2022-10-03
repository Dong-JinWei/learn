package cn.tedu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"cn.tedu.controller", "cn.tedu.config"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    /*开启静态资源处理*/
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*静态资源的路径配置*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
        registry.addResourceHandler("/jeasyui/**").addResourceLocations("/WEB-INF/jeasyui/");
        registry.addResourceHandler("/html/**").addResourceLocations("/WEB-INF/html/");
    }

}