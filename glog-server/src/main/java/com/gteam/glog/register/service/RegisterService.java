package com.gteam.glog.register.service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.register.repository.RegisterRepository;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final JWTTokenUtils jwtTokenUtils;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(RegisterRepository registerRepository, JWTTokenUtils jwtTokenUtils) {
        this.registerRepository = registerRepository;
        this.jwtTokenUtils = jwtTokenUtils;
        this.passwordEncoder = new BCryptPasswordEncoder();;
    }

    public String createUserInfo(UserInfoDTO userInfoDTO) {
        UserInfoDTO setUserData = UserInfoDTO.builder()
                .mail(userInfoDTO.getMail())
                .nikNm(userInfoDTO.getNikNm())
                .pwd(passwordEncoder.encode(userInfoDTO.getPwd()))
                .build();
        if(registerRepository.duplicateCheck(userInfoDTO.getMail()) && userInfoDTO.getMail() != null) {
            registerRepository.createUserInfo(setUserData);
            return "success";
        }

        return null;
    }

    public String unRegistUser(String token) {
        Claims tokenData = jwtTokenUtils.getAllClaimsFromToken(token);

        try {
            registerRepository.unRegistUser((String) tokenData.get("email"));
            return "ok";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
