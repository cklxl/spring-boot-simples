package org.cklxl.console.config;

import org.springframework.stereotype.Component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

import lombok.Getter;

@Component
@NacosPropertySource(dataId = "cklxl.springboot.demo", autoRefreshed = true)
@Getter
public class NacosConfig {

    @NacosValue(value = "${service.name:1}", autoRefreshed = true)
    private String serverName;

}
