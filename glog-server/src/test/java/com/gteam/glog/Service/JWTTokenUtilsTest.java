package com.gteam.glog.Service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.entity.Users;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class JWTTokenUtilsTest {
    private final JWTTokenUtils jwtTokenUtils;
//    JWTTokenUtils jwtTokenUtils;
    @Autowired
    JWTTokenUtilsTest(JWTTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @BeforeEach
    public void befor(){
//        jwtTokenUtils = new JWTTokenUtils();
    }

    @Test
    void tokenTest() {
        Users users = new Users();
        users.setPwd("$2a$12$BQUaoQT9bBjbCxsZcWPUGeTWAbnwSniT5ZiNY.Uz3q/EjcTS0.dQG");
        users.setMail("glog@gmail.com");

        String tesToken = jwtTokenUtils.issuanceAccessToken(users);


        System.out.printf("\n\n");
        System.out.printf("Test Token : "+tesToken);
        System.out.printf("\n\n");
//        System.out.printf("Test user id : "+claims.get("userId"));
        System.out.printf("\n\n");

        assertThat(jwtTokenUtils.validateAccessInfoByToken(tesToken,users.getMail())).isEqualTo(true);
//        assertThat(jwtTokenUtils.getAllClaimsFromToken(tesToken).get("userId")).isEqualTo(users.getUserId());
    }

    private class ServerConfig {
    }
}