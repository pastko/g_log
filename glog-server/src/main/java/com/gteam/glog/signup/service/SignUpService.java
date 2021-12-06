package com.gteam.glog.signup.service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.dto.SignUpRequestDTO;
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


    public Long createUserInfo(SignUpRequestDTO userInfoDTO) {
        if(usersRepository.findByMail(userInfoDTO.getMail()).isPresent()){
            return null;
        }else{
            return usersRepository.save(
                    Users.initUsers()
                            .mail(userInfoDTO.getMail())
                            .pwd(passwordEncoder.encode(userInfoDTO.getPwd()))
                            .nikNm(userInfoDTO.getNikNm())
                            .build()).getIdx();
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
