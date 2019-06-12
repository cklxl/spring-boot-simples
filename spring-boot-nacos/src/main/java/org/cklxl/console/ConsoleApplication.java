package org.cklxl.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Kun.Chen
 * @date 2019-04-09 14:16:13
 */
@SpringBootApplication
public class ConsoleApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }
}
