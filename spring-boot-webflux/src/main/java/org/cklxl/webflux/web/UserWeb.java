package org.cklxl.webflux.web;

import org.cklxl.webflux.model.User;
import org.cklxl.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 15:16
 */
@RestController
public class UserWeb {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/user")
    public Flux<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping("/user")
    public Mono<Void> save(@RequestBody User user) {
        return userService.save(Mono.justOrEmpty(user));
    }
}
