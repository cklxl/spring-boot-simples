package org.cklxl.console;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Simple {@link ServletContextListener} to test gh-2058.
 */
@Component
@Slf4j
public class ExampleServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("*** contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("*** contextDestroyed");
    }

}