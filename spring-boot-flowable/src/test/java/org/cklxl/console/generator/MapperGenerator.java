package org.cklxl.console.generator;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @author Kun.Chen
 * @date 2019-04-22 14:27:29
 */
public class MapperGenerator {

    private static final String CONFIG = "/generator/generatorConfig.xml";

    public static void main(String[] args) throws Exception {
        new MapperGenerator().generate(CONFIG);
    }

    private void generate(String xmlUrl) throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(MapperGenerator.class.getResourceAsStream(xmlUrl));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
