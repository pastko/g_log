package com.gteam.glog.login.service;

import com.gteam.glog.common.JWTTokenUtils;
import com.gteam.glog.domain.dto.UserAuthDTO;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.login.repository.LoginRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Log4j2
public class LoginService {

    private final LoginRepository loginRepository;
    private final JWTTokenUtils jwtTokenUtils;
    PasswordEncoder passwordEncoder;
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
        try{
            return loginRepository.getUsersByUserId(id).get();
        }catch (NoSuchElementException e){
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     *  유저 개인 정보 조회 Id
     *  User Nik-Name, user Img-name, user glog Title-name
     * @param id - userinfo id
     * @return :
     *          >  userId is exist       - return user info
     *          >  userId is not exist   - return null
     */
    public UserInfoDTO findUserInfoByUserId(String id){
        try{
            return loginRepository.getUserInfoByUserId(id).get();
        }catch (IllegalArgumentException e){
            log.error(e.getMessage());
            return null;
        }
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
    public Users validateUserLogin(UserAuthDTO authDTO){
            try{
                Users users = findUserByUserId(authDTO.getUserId());
                // Bcrypt password validate
                if(!passwordEncoder.matches(authDTO.getPassWd(),users.getUserPwd())){
                    log.trace("비밀번호 오류.");
                    return null;
                }
                log.trace("비밀번호 정상.");
                return users;
            }catch (IllegalArgumentException e){
                log.error(e.getMessage());
                return null;
            }
    }

    /**
     * 토큰 검증
     * 1. 토큰 내 Bearer 문자열 검사 ( Bearer 제거 )
     * 2. 인증서 유효성 검사 ( 만료 & Subject 검사 )
     *
     * @param key
     * @return
     *        >  인증서 유효함         : Token 저장되어있는 데이터
     *        >  인증서가 유효하지 않음 : null
     */
    public Users validateUserAuthInfo(String key){
        try {
            jwtTokenUtils.validationAuthorizationHeader(key);
            key = jwtTokenUtils.extractToken(key);

            if (jwtTokenUtils.validateToken(key)) {
                return (Users) jwtTokenUtils.getAllClaimsFromToken(key);
            } else {
                log.trace("토큰이 유효하지 않습니다.");
                return null;
            }
        }catch (IllegalArgumentException e){
            log.trace("토큰이 유효하지 않습니다.");
            return null;
        }
    }
}
