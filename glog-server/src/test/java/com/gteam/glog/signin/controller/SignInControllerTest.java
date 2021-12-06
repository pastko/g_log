package com.gteam.glog.signin.controller;

import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignInControllerTest {

    @LocalRSocketServerPort
    private int port;
    private OkHttpClient client;


    @Test
    void signIn() {
    }

    @Test
    void signOut() {
    }
}