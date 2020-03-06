package com.lim.test.base;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * mybatis 代码生成器
 * @author Lim
 * @date 2020/2/27
 */
public class CodeGenerator {

    /**
     * 是否覆盖原有的文件
     */
    private final static Boolean fileOverride = true;
    /** 模块名 */
    private static final String moduleName = "sys";
    /** 表名*/
    private static final String[] tables = {"sys_user"};
    /** 项目路径 */
    private final static String projectPath = "C:\\Users\\Lim\\Workspaces\\GitHub\\springCloudTest\\mybatis-generator";
    /** 包基础路径 */
    private final static String packagePath = "com.lim.test.base";
    /** 父类-数据库通用字段 */
    private final static String entityParent = "com.lim.test.base.BaseEntity";
    /** 写于父类的字段 */
    private final static String[] parentFields = {"id","creator_id","creator_name","create_time","updater_id","updater_name","update_time","deleted"};

    /**
     * 数据源配置
     */
    private static DataSourceConfig getDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.40.128:3307/bms?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setUsername("root");
        dsc.setPassword("123456");
//        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        return dsc;
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());
        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());
        // 包配置
        PackageConfig pc = getPackageConfig();
        mpg.setPackageInfo(pc);
        // xml输出配置
        mpg.setCfg(getInjectionConfig());
        // 模板配置
        mpg.setTemplate(getTemplateConfig());
        // 策略配置
        mpg.setStrategy(getStrategyConfig());
        // 模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("lim");
        gc.setOpen(false);
        gc.setFileOverride(fileOverride);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        return gc;
    }

    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(packagePath);
        return pc;
    }

    private static InjectionConfig getInjectionConfig() {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + moduleName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    private static TemplateConfig getTemplateConfig() {
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        return templateConfig;
    }

    private static StrategyConfig getStrategyConfig() {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(entityParent);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns(parentFields);
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(moduleName + "_");
        return strategy;
    }
}