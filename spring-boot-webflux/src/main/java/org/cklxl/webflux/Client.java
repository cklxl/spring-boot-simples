package org.cklxl.webflux;

import org.cklxl.webflux.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * <p>
 * 在此描述类说明
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/11/15 18:09
 */
public class Client {
    public static void main(String[] args) {
        // 调用服务器地址
        final WebClient webClient = WebClient.create("http://127.0.0.1:8080");

        // 查询单个
        final User user = webClient.get().uri("/users/{id}", 1)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();

        System.out.println(user.getName());

        // 查询全部
        Flux<User> users = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(User.class);
        users.map(u -> u.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
