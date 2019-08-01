package org.cklxl.jetty.demo.web;

import org.cklxl.jetty.demo.web.request.DemoRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

    @GetMapping("/date")
    @ResponseBody
    public String date(@RequestBody DemoRequest request) {
        System.out.println(request.toString());
        return "";
    }
}
