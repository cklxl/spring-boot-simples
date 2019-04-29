package org.cklxl.i18n.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.cklxl.i18n.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo")
    public String getHelloMessage() {
        return demoService.getDemo();
    }

    @GetMapping("/i18n")
    public Map<String, String> getLocale() {
        return new HashMap<String, String>() {
            private static final long serialVersionUID = 1L;
            {
                this.put("code", "1000");
                this.put("msg", "i18n.system.message.success");
            }
        };
    }

    @SuppressWarnings("unused")
    @GetMapping("/error")
    public Map<String, String> error() {
        if (true) {
            throw new RuntimeException("测试");
        }
        return null;
    }
}
