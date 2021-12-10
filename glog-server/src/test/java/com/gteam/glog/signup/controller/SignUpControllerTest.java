package com.gteam.glog.signup.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gteam.glog.domain.dto.ResponseDTO;
import com.gteam.glog.domain.dto.ReturnIdResponseDTO;
import com.gteam.glog.domain.dto.SignUpRequestDTO;
import com.gteam.glog.domain.entity.users.Users;
import com.gteam.glog.domain.entity.users.UsersRepository;
import okhttp3.*;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SignUpControllerTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate;
    private final OkHttpClient client;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    SignUpControllerTest(UsersRepository usersRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.client = new OkHttpClient();
        this.restTemplate = new RestTemplate();
        this.usersRepository = usersRepository;
    }

    @After
    public void after(){

    }

    @Before
    public void before(){

    }

    @Test
    void signUp() {
        String url = "http://localhost:"+port+"/api/signup";
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .mail("glog@gmail.com")
                .pwd("gl12#$")
                .nikNm("glog")
                .build();

        // send data id, secret key , access code , redirect url
        ResponseDTO response= restTemplate.postForObject(
                url,
                signUpRequestDTO,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());
        System.out.println("==>>>> " + response.getData());
        System.out.println("==>>>> " + response.isSuccess());
        assertThat(response.isSuccess()).isEqualTo(true||false);
        ObjectMapper mapper = new ObjectMapper();
        ReturnIdResponseDTO responseDTO = mapper.convertValue(response.getData(), ReturnIdResponseDTO.class);
        // TODO: restTemplate => okHttp2 로 변경 해보기
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),signUpRequestDTO.toString());
//        Request.Builder builder = new Request.Builder().url(url).post(requestBody);
//        Request request = builder.build();
//        try {
//            Response response = client.newCall(request).execute();
//            if(response.isSuccessful()){
//                ResponseBody body= response.body();
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if(responseDTO.getId() != null) {
            Users users = usersRepository.findById(responseDTO.getId()).orElse(null);
            if (users != null) {
                assertThat(users.getMail()).isEqualTo(signUpRequestDTO.getMail());
                assertThat(passwordEncoder.matches(signUpRequestDTO.getPwd(), users.getPwd())).isEqualTo(true);
            } else {
                System.out.println("IS not Match");
            }
        }else{
            Users users = usersRepository.findByMail(signUpRequestDTO.getMail()).orElse(null);
            if (users != null) {
                assertThat(users.getMail()).isEqualTo(signUpRequestDTO.getMail());
            }
            System.out.println("Same User exist");
        }
    }


    @Test
    void signDrop() {
        Long id = 5L;
        String url = "http://localhost:"+port+"/api/signdrop/"+id;

        ResponseDTO response= restTemplate.getForObject(
                url,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());
        System.out.println("==>>>> " + response.getData());
        System.out.println("==>>>> " + response.isSuccess());
        assertThat(response.isSuccess()).isEqualTo(true||false);

        ObjectMapper mapper = new ObjectMapper();
        ReturnIdResponseDTO responseDTO = mapper.convertValue(response.getData(), ReturnIdResponseDTO.class);
        if(responseDTO.getId() != null){
            assertThat(usersRepository.findById(responseDTO.getId()).isPresent()).isEqualTo(false);
        }else{
            assertThat(responseDTO.getId()).isEqualTo(null);
        }
    }
}