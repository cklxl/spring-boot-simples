package org.cklxl.webflux.service;

import org.cklxl.webflux.BaseTest;
import org.cklxl.webflux.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/16 9:26
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    void getById() {
        final Mono<User> userMono = userService.getById(null);
        if (userMono.blockOptional().isPresent()) {
            System.out.println("123213213" + userMono.blockOptional().get().getName());
        }
        System.out.println("123213213" + userService.getById(1L).block().getName());
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }
}
