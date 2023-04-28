package com.learning.dwivna.ekaasaa.controller;

import com.learning.dwivna.ekaasaa.data.User;
import com.learning.dwivna.ekaasaa.service.UserService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public Mono<User> getUser(@Argument String id) {
        return this.userService.getUser(id);
    }

    @QueryMapping
    public Mono<List<User>> getUsers() {
        return this.userService.getUsers();
    }

    @MutationMapping
    public Mono<String> putUser(@Argument User user) {
        return this.userService.putUser(user);
    }

    @MutationMapping
    public Mono<User> updateUser(@Argument String id, @Argument User user) {
        return this.userService.updateUser(id, user);
    }

    @MutationMapping
    public Mono<String> deleteUser(@Argument String id) {
        return this.userService.deleteUser(id);
    }

    @SubscriptionMapping
    public Publisher<List<User>> userSub() {
        return this.userService.userSub();
    }
}
