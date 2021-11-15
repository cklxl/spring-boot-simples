package org.cklxl.webflux.handler;

import org.cklxl.webflux.model.User;
import org.cklxl.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 16:51
 */
public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        final String id = request.pathVariable("id");
        // 空处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        final Mono<User> userMono = this.userService.getById(Long.valueOf(id));
        return userMono
                .flatMap(user -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(user))
                        .switchIfEmpty(notFound)
                );
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<User> users = this.userService.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.save(userMono));
    }
}
