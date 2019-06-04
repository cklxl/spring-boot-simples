package org.cklxl.helloworld.demo.web;

import org.cklxl.helloworld.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    public String getHelloMessage() {
        return demoService.getDemo();
    }

    @GetMapping("/demo")
    public String demo(@RequestParam String id) {
        log.info("{}", id);
        return demoService.getDemo();
    }

    @RequestMapping(value = "/demo/{name}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String demo(@PathVariable String name, @RequestParam(value = "id", required = true) String id) {
        log.info("{}", id);
        return demoService.getDemo();
    }

    @RequestMapping(value = "/demo1", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String demo1(@RequestParam(value = "id", required = true) String id) {
        log.info("{}", id);
        return demoService.getDemo();
    }

    @PostMapping("/demo1/{name}")
    public String demo1(@PathVariable String name, @RequestParam String id) {
        log.info("{}", id);
        return demoService.getDemo();
    }
}
