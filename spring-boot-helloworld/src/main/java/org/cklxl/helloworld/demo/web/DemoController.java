package org.cklxl.helloworld.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.cklxl.helloworld.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
