package com.dmsdbj.team.springbootdemo.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Jessica
 * @version 1.0.0
 * @ClassName MyBatisPlusConfig.java
 * @Description MybatisPlus 的分页插件
 * @createTime 2020年03月12日 15:24:00
 */
@Configuration
@MapperScan("com.dmsdbj.team.springbootdemo.mapper")
public class MyBatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作，true调回到首页，false继续请求，默认false
//        paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认500 条，-1不受限制
//        paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化，只针对left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;

    }



}
