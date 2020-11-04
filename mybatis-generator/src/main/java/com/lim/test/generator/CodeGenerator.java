package com.lim.test.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * mybatis 代码生成器
 *
 * @author lim
 * @since 2020/2/27
 */
public class CodeGenerator {

    // 文件相关设置
    /** 项目路径 */
    private final static String PROJECT_PATH = "E:\\workspace\\GitHub\\spring-cloud-test\\mybatis-generator";
    /** 包基础路径 */
    private final static String PACKAGE_PATH = "com.lim.test.generator";
    /** 是否覆盖原有的文件 */
    private final static Boolean FILE_OVERRIDE = true;
    /** 作者(文件author) */
    private final static String AUTHOR = "lim";
    /** swagger注释开关 */
    private final static Boolean SWAGGER = false;

    // 数据库连接设置
    /** 数据库连接信息格式 */
    private final static String DB_URL_FORMATTER = "jdbc:mysql://%s:%s/%s?characterEncoding=utf8&serverTimezone" +
            "=Asia/Shanghai&useSSL=false&zeroDateTimeBehavior=convertToNull";
    /** 数据库连接信息（ip, port, schema） */
    private final static String DB_URL = String.format(DB_URL_FORMATTER, "127.0.0.1", "3306", "test");
    /** 数据库账号 */
    private final static String DB_USERNAME = "root";
    /** 数据库密码 */
    private final static String DB_PASSWORD = "123456";

    // 代码生成内容配置
    /** 模块名(包名) */
    private static final String MODULE_NAME = "sys";
    /** 需逆向生成的表名 */
    private static final String[] TABLES = {"user"};
    /** 实体类父类-数据库通用字段 */
    private final static String ENTITY_PARENT = "com.lim.test.tools.commonmybatis.base.BaseEntity";
    /** 写于父类的字段 */
    private final static String[] PARENT_FIELDS = {"id", "creator_id", "creator_name", "create_time", "updater_id",
            "updater_name", "update_time", "deleted"};

    /**
     * 生成器主调用主方法
     */
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

    /**
     * 数据源配置
     */
    private static DataSourceConfig getDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PASSWORD);
//        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        return dsc;
    }

    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setFileOverride(FILE_OVERRIDE);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(SWAGGER);
        return gc;
    }

    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        pc.setParent(PACKAGE_PATH);
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
                return PROJECT_PATH + "/src/main/resources/mapper/" + MODULE_NAME
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
        strategy.setSuperEntityClass(ENTITY_PARENT);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(PARENT_FIELDS);
        strategy.setInclude(TABLES);
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(moduleName + "_");
        return strategy;
    }
}