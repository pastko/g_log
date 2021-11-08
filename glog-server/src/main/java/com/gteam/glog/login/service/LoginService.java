package com.gteam.glog.login.service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.dto.login.LoginRequestDTO;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.domain.enums.UserStatusCode;
import com.gteam.glog.login.repository.LoginRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Service
@Log4j2
public class LoginService {

    private final LoginRepository loginRepository;
    private final JWTTokenUtils jwtTokenUtils;
    PasswordEncoder passwordEncoder;
    @Autowired
    public LoginService(LoginRepository loginRepository, JWTTokenUtils jwtTokenUtils) {
        this.loginRepository = loginRepository;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    /**
     * 유저 인증 정보 조회 by Id
     * UserId, UserPassword
     * @param id - user id
     * @return :
     *          > userId is exist       - return user info
     *          > userId is not exist   - return null
     */
    public Users findUserByUserId(String id){
        return loginRepository.getUsersByUserId(id).orElse(null);
    }


    /**
     * 로그인 검증
     *  1. 회원 조회
     *  2. 비밀번호 확인
     *
     * @param  - UserAuthDTO
     * @return :
     *       >  all correct    : UserIdx, userId
     *       >  is not correct : null
     */
    public Users validateUserLogin(LoginRequestDTO authDTO){
            try {
                Users users = findUserByUserId(authDTO.getMail());
                if (users != null) {
                    // Bcrypt password validate
                    if (!passwordEncoder.matches(authDTO.getPwd(), users.getPwd())) {
                        log.info("비밀번호 오류.");
                        return null;
                    }
                    log.info("비밀번호 정상.");
                    return users;
                } else{
                    log.info("사용자가 존재하지 않습니다.");
                    return null;
                }
            }catch (IllegalArgumentException e){
                log.error(e.getMessage());
                return null;
            }
    }

    /**
     * 사용자 로그인
     *
     * @param loginRequestDTO
     * @return
     *       > 사용자 검증 성공 : Access Token
     *       > 사용자 검증 실패 : null
     */
    public String doLogin(LoginRequestDTO loginRequestDTO){
        Users users = validateUserLogin(loginRequestDTO);
        if(users != null){
            loginRepository.updateLoginStatus(users.getMail(),UserStatusCode.LOGIN);

            String accessToken = jwtTokenUtils.issuanceAccessToken(users);
            if (!jwtTokenUtils.validateRefreshToken(users.getKey(), loginRequestDTO.getMail())) {
                jwtTokenUtils.reissuanceRefreshToken(users.getMail());
            }
            return accessToken;
        }else{
            return null;
        }
    }


    /**
     * 사용자 로그아웃
     * 1. Access Token / 사용자 검증
     * 2. Access Token 만료시 Refresh Token을 사용한 검증
     * 3. 로그아웃
     *
     * @param key - Access Token
     * @param mail - User Id
     * @param cookie - Refresh Token
     * @return
     *       > 사용자 검증 성공 : ture
     *       > 사용자 검증 실패 : false
     */
    public Boolean doLogOut(String key, String mail, Cookie cookie){
        if(jwtTokenUtils.validateAccessInfoByToken(key,mail)){
            loginRepository.updateLoginStatus(mail, UserStatusCode.LOGOUT);
            return true;
        }else{
            if(jwtTokenUtils.validateRefreshToken(cookie.getValue(),mail)){
                loginRepository.updateLoginStatus(mail, UserStatusCode.LOGOUT);
                return true;
            }else {
                return false;
            }
        }
    }

    /**
     * Refresh Token을 Cookie로 만들어 반환
     * 1. 사용자 인증 정보의 Key로 저장되어 있는 Refresh Token 조회
     * 2. Token 만료시 & Null 시 Refresh Token 재발급 하여 DB 저장
     * 3. Refresh Token를 Cookie로 만들어 반환
     *
     * @param mail
     * @return Cookie
     */
    public Cookie getRefreshTokenToCookie(String mail){
       return new Cookie("refresh", jwtTokenUtils.getRefreshToken(mail));
    }
}
