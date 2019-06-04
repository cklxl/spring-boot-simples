package org.cklxl.console;

import org.cklxl.console.log.annotation.EnableOperLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Kun.Chen
 * @date 2019-04-09 14:16:13
 */
@SpringBootApplication
@MapperScan("org.cklxl.console.*.mapper")
@EnableOperLog
public class ConsoleApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }
}
