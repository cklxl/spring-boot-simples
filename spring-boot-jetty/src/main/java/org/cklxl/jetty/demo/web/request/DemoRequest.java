package org.cklxl.jetty.demo.web.request;

import java.util.Date;

import lombok.Data;

@Data
public class DemoRequest {

    private String id;
    
    private Date createDate;
}
