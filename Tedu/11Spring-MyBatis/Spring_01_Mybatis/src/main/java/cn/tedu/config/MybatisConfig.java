package cn.tedu.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {

    // 定义Bean 用于产生SqlSessionFactoryBean对象
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        // 模型类的别名扫描
        ssfb.setTypeAliasesPackage("cn.tedu.domain");
        // 设置数据源
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    /**
     * 主要定义bean
     *
     * @return MapperScannerConfigurer用于mapper的扫描
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 设置要扫描的包
        msc.setBasePackage("cn.tedu.dao");
        return msc;
    }

}
