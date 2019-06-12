package org.cklxl.console.demo.web;

import javax.inject.Inject;

import org.cklxl.console.config.NacosConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Inject
    private NacosConfig nacosConfig;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get() {
        return nacosConfig.getServerName();
    }

}
