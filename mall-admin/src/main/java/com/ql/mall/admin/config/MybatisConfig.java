package com.ql.mall.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ql on 2022/11/21
 *
 * @author ql
 */
@MapperScan("com.ql.mall.admin.mapper")
@Configuration
public class MybatisConfig {
}
