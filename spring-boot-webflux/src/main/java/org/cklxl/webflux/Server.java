package org.cklxl.webflux;

import org.cklxl.webflux.handler.UserHandler;
import org.cklxl.webflux.service.UserService;
import org.cklxl.webflux.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * <p>
 * netty 服务启动
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 17:20
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routerFunction() {
        UserService userService = new UserServiceImpl();
        UserHandler userHandler = new UserHandler(userService);

        return RouterFunctions.route(GET("/users/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getById)
                .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::getAll)
                .andRoute(POST("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::save);
    }

    // 创建服务器完成适配
    public void createReactorServer() {
        // 路由跟handler适配
        RouterFunction<ServerResponse> route = routerFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer httpServer = HttpServer.create();
//        httpServer.handle(adapter).port(8080).bind();
        httpServer.handle(adapter).port(8080).bindNow();
    }
}
