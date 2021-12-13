package com.gteam.glog.mypage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gteam.glog.domain.dto.ResponseDTO;
import com.gteam.glog.domain.dto.ReturnIdResponseDTO;
import com.gteam.glog.domain.dto.SignUpRequestDTO;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.users.Users;
import com.gteam.glog.domain.entity.users.UsersRepository;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyPageControllerTest {
    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate;
    private final OkHttpClient client;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    MyPageControllerTest(UsersRepository usersRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.client = new OkHttpClient();
        this.restTemplate = new RestTemplate();
        this.usersRepository = usersRepository;
    }


    @Test
    void getMyPage() {
        Long id = usersRepository.findAll().get(0).getIdx();
        String url = "http://localhost:"+port+"/api/myinfo/"+id;

        // send data id, secret key , access code , redirect url
        ResponseDTO response= restTemplate.getForObject(
                url,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());
        System.out.println("==>>>> " + response.getData());
        System.out.println("==>>>> " + response.isSuccess());
        assertThat(response.isSuccess()).isEqualTo(true||false);
        ObjectMapper mapper = new ObjectMapper();
        UserInfoDTO userInfoDTO = mapper.convertValue(response.getData(), UserInfoDTO.class);

        if(userInfoDTO != null){
            assertThat(usersRepository.findById(id).isPresent()).isEqualTo(true);
            usersRepository.findById(id).stream().map(entity->{
                assertThat(entity.getMail()).isEqualTo(userInfoDTO.getMail());
                assertThat(entity.getNikNm()).isEqualTo(userInfoDTO.getNikNm());
                assertThat(entity.getGlogTitle()).isEqualTo(userInfoDTO.getGlogTitle());
                return entity;
            }).findAny().orElse(null);

        }else{
            assertThat(userInfoDTO).isEqualTo(null);
        }
    }

    @Test
    void updateMyPage() {
        Long id = usersRepository.findAll().get(0).getIdx();
        String url = "http://localhost:"+port+"/api/myinfo";
        UserInfoDTO userInfoDTO = UserInfoDTO.builder().mail("test@gmail.com")
                .imgNm("img.png").glogTitle("glogConvert").nikNm("changenik").build();

        // send data id, secret key , access code , redirect url
        ResponseDTO response= restTemplate.postForObject(
                url,
                userInfoDTO,
                ResponseDTO.class);
        System.out.println("==>>>> " + response.getMsg());
        System.out.println("==>>>> " + response.getData());
        System.out.println("==>>>> " + response.isSuccess());
        assertThat(response.isSuccess()).isEqualTo(true||false);
        ObjectMapper mapper = new ObjectMapper();
        ReturnIdResponseDTO res = mapper.convertValue(response.getData(), ReturnIdResponseDTO.class);

        if(res != null){
            assertThat(usersRepository.findById(res.getId()).isPresent()).isEqualTo(true);
            usersRepository.findById(res.getId()).stream().map(entity->{
                assertThat(entity.getMail()).isEqualTo(userInfoDTO.getMail());
                assertThat(entity.getNikNm()).isEqualTo(userInfoDTO.getNikNm());
                assertThat(entity.getGlogTitle()).isEqualTo(userInfoDTO.getGlogTitle());
                assertThat(entity.getImgNm()).isEqualTo(userInfoDTO.getImgNm());
                return entity;
            }).findAny().orElse(null);

        }else{
            assertThat(userInfoDTO).isEqualTo(null);
        }
    }
}