package org.cklxl.webflux.service;

import org.cklxl.webflux.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 15:23
 */
public interface UserService {
    Mono<User> getById(Long id);

    Flux<User> getAll();

    Mono<Void> save(Mono<User> userMono);
}
