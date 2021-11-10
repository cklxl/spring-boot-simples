package org.cklxl.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/5/17 13:45
 */
@MapperScan("org.cklxl.activiti.*.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
