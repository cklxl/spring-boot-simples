package org.cklxl.helloworld.demo.web;

import org.cklxl.helloworld.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    @ResponseBody
    public String getHelloMessage() {
        return demoService.getDemo();
    }
}
