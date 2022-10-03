package cn.tedu.confing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cn.tedu.controller")
public class MvcConfiguration implements WebMvcConfigurer {

    /*我们需要使用thymeleaf做为视图解析器 解析我们的HTML页面*/
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(
            @Autowired SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver tvr = new ThymeleafViewResolver();
        tvr.setOrder(1);
        tvr.setCharacterEncoding("UTF-8");
        tvr.setTemplateEngine(springTemplateEngine);

        return tvr;
    }

    /*配置模板解析器*/
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver =
                new SpringResourceTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setCharacterEncoding("UTF-8");

        return  templateResolver;
    }

    @Bean
    /*配置模板引擎*/
    public SpringTemplateEngine springTemplateEngine(@Autowired ITemplateResolver iTemplateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(iTemplateResolver);

        return springTemplateEngine;
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/static/");
    }
}
