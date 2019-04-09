package org.cklxl.helloworld.demo.service;

import org.springframework.stereotype.Component;

@Component
public class DemoService {

    public String getDemo() {
        return "Hello World";
    }
}
