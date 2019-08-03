package com.example.leilei.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import org.junit.Test;

public class CodeGenerator {

    @Test
    public void codeGenerate(){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //配置 GlobalConfig
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        globalConfig.setAuthor("leilei");
        globalConfig.setOpen(false);
        mpg.setGlobalConfig(globalConfig);
        //配置 DataSourceConfig
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/crm?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        mpg.setDataSource(dataSourceConfig);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.leilei");
        mpg.setPackageInfo(pc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityLombokModel(false);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.execute();


    }

}
