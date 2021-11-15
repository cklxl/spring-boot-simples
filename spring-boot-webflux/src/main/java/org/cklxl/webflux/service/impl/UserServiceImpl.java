package org.cklxl.webflux.service.impl;

import org.cklxl.webflux.model.User;
import org.cklxl.webflux.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 15:26
 */
@Repository
public class UserServiceImpl implements UserService {

    public final Map<Long, User> map;

    public UserServiceImpl() {
        map = new HashMap<>();
        map.put(1L, new User(1L, "张三丰", "男", 150));
        map.put(2L, new User(2L, "刘西", "女", 40));
        map.put(3L, new User(3L, "秦二世", "男", 1000));
        map.put(4L, new User(4L, "尤二娘", "女", 71));
    }

    @Override
    public Mono<User> getById(Long id) {
//        return Mono.just(map.get(id));
        return Mono.justOrEmpty(map.get(id));
    }

    @Override
    public Flux<User> getAll() {
        return Flux.fromIterable(map.values());
    }

    @Override
    public Mono<Void> save(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            user.setId(map.size() + 1L);
            map.put(user.getId(), user);
        }).thenEmpty(Mono.empty());
    }
}
