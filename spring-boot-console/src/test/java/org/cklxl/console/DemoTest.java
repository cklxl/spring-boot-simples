package org.cklxl.console;

import org.cklxl.console.log.config.OperLogAutoConfig;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kun.Chen
 * @date 2019-04-09 14:24:00
 */
@Slf4j
public class DemoTest {


    @Test
    public void testClass() {
        log.info("{}",OperLogAutoConfig.class.getName());
    }


}
