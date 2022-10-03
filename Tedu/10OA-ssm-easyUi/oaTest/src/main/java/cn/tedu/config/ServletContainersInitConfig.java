package cn.tedu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    // 加载spring配置类
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class, SecurityConfiguration.class};
    }

    // 加载springMVC
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    // 设置烂片路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 设置中文乱码过滤器
    protected Filter[] getServletFilters(){

        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8", true);
        return new Filter[]{filter};

    }
}
