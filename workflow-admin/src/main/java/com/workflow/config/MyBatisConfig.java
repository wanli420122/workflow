package com.workflow.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by wanli on 2020/07/15.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.workflow.mapper","com.workflow.dao"})
public class MyBatisConfig {
}
