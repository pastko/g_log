package com.gteam.glog.signup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gteam.glog.domain.dto.ResponseDTO;
import com.gteam.glog.domain.dto.SignUpRequestDTO;
import com.gteam.glog.domain.dto.SignUpResponseDTO;
import com.gteam.glog.domain.entity.users.UsersRepository;
import okhttp3.*;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
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
        usersRepository.deleteAll();
    }

    @Before
    public void before(){
        usersRepository.deleteAll();
    }

    @Test
    void signUp() {
        String url = "http://localhost:"+port+"/api/signup";
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .mail("glog@gmail.com")
                .pwd("gl12#$")
                .nikNm("glog")
                .build();
        usersRepository.deleteAll();


        // send data id, secret key , access code , redirect url
        ResponseDTO response= restTemplate.postForObject(
                url,
                signUpRequestDTO,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());

//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            SignUpResponseDTO user = mapper.readValue(response.getBody().toString(), SignUpResponseDTO.class);
//         } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

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
        System.out.println("==>>>> " + response);
//        Users users = usersRepository.findById(responseDTO.getData()).orElse(null);
//        if( users != null) {
        assertThat(response.isSuccess()).isEqualTo(true);
//        assertThat(response.getBody()).isEqualTo();
//            assertThat(users.getMail()).isEqualTo(signUpRequestDTO.getMail());
//            assertThat(users.getPwd()).isEqualTo(passwordEncoder.matches(signUpRequestDTO.getPwd(), users.getPwd()));
//        }else{
//            System.out.println("Is Not Match : ");
//        }
    }


//    @Test
//    void signDrop() {
//    }
}