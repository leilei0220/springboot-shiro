package com.example.leilei.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个shiro生命周期的Bean一定要单独配置
 */
@Configuration
public class ShiroLifecycleBeanPostProcessorConfig {

    /**
     * Shiro生命周期处理器
     *
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}