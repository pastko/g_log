package com.gteam.glog.signup.service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.dto.SignUpRequestDTO;
import com.gteam.glog.domain.dto.SignUpResponseDTO;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.users.Users;
import com.gteam.glog.domain.entity.users.UsersRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class SignUpService {
    private final JWTTokenUtils jwtTokenUtils;
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public Long saveUser(Users users){
        return usersRepository.save(users).getIdx();
    }

    public SignUpResponseDTO createUserInfo(SignUpRequestDTO userInfoDTO) {
        if(usersRepository.findByMail(userInfoDTO.getMail()).isPresent()){
            return SignUpResponseDTO.builder().id(null).build();
        }else{
            Users users = Users.initUsers()
                    .mail(userInfoDTO.getMail())
                    .pwd(passwordEncoder.encode(userInfoDTO.getPwd()))
                    .nikNm(userInfoDTO.getNikNm())
                    .build();
            return SignUpResponseDTO.builder().id(saveUser(users)).build();
        }
    }

    public String unRegistUser(String token) {
        Claims tokenData = jwtTokenUtils.getAllClaimsFromToken(token);

        try {

            return "ok";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
