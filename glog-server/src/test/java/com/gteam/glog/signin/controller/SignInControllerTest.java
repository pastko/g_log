package com.gteam.glog.signin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gteam.glog.domain.dto.ResponseDTO;
import com.gteam.glog.domain.dto.ReturnIdResponseDTO;
import com.gteam.glog.domain.dto.SignUpRequestDTO;
import com.gteam.glog.domain.dto.login.LoginRequestDTO;
import com.gteam.glog.domain.entity.users.Users;
import com.gteam.glog.domain.entity.users.UsersRepository;
import com.gteam.glog.domain.enums.UserStatusCode;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignInControllerTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate;
    private final OkHttpClient client;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    SignInControllerTest(UsersRepository usersRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.client = new OkHttpClient();
        this.restTemplate = new RestTemplate();
        this.usersRepository = usersRepository;
    }

    @Test
    void signIn() {
        String url = "http://localhost:"+port+"/api/signin";
        LoginRequestDTO loginRequestDTO = LoginRequestDTO.builder().mail("gl@gmail.com").pwd("gl12#$").build();

        // send data id, secret key , access code , redirect url
        ResponseDTO response= restTemplate.postForObject(
                url,
                loginRequestDTO,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());
        System.out.println("==>>>> " + response.getData());
        System.out.println("==>>>> " + response.isSuccess());
        assertThat(response.isSuccess()).isEqualTo(true||false);
        ObjectMapper mapper = new ObjectMapper();
        ReturnIdResponseDTO responseDTO = mapper.convertValue(response.getData(), ReturnIdResponseDTO.class);

        Users users = usersRepository.findById(responseDTO.getId()).orElse(null);
        if(users != null){
            assertThat(users.getMail()).isEqualTo(loginRequestDTO.getMail());
            assertThat(users.getStatus()).isEqualTo(UserStatusCode.LOGIN);
        }
    }

    @Test
    void signOut() {
        Long id = usersRepository.findByMail("glog@gmail.com").get().getIdx();
        String url = "http://localhost:"+port+"/api/signout/"+id;

        // send data id, secret key , access code , redirect url
        ResponseDTO response= restTemplate.getForObject(
                url,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());
        System.out.println("==>>>> " + response.getData());
        System.out.println("==>>>> " + response.isSuccess());
        assertThat(response.isSuccess()).isEqualTo(true||false);
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.convertValue(response.getData(), String.class);

        Users users = usersRepository.findById(id).orElse(null);
        assertThat(res).isEqualTo("logout Success");
        if(users != null){
            assertThat(users.getMail()).isEqualTo("glog@gmail.com");
            assertThat(users.getStatus()).isEqualTo(UserStatusCode.LOGOUT);
        }
    }
}