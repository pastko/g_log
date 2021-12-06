package com.gteam.glog.signin.service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.dto.login.LoginRequestDTO;
import com.gteam.glog.domain.entity.users.Users;
import com.gteam.glog.domain.entity.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

@Log4j2
@Service
@RequiredArgsConstructor
public class SignInService {
    private final UsersRepository usersRepository;
    private final JWTTokenUtils jwtTokenUtils;
    private final PasswordEncoder passwordEncoder;


//    /**
//     * 로그인 검증
//     *  1. 회원 조회
//     *  2. 비밀번호 확인
//     *
//     * @param  - UserAuthDTO
//     * @return :
//     *       >  all correct    : UserIdx, userId
//     *       >  is not correct : null
//     */
//    public Users validateUserLogin(LoginRequestDTO authDTO){
//            try {
////                Users users = usersRepository.findByMail(authDTO.getMail());
//                log.info("validateLogin :  === {}",users);
//                if (users != null) {
//                    // Bcrypt password validate
//                    if (!passwordEncoder.matches(authDTO.getPwd(), users.getPwd())) {
//                        log.info("비밀번호 오류.");
//                        return null;
//                    }
//                    log.info("비밀번호 정상.");
//                    return users;
//                } else{
//                    log.info("사용자가 존재하지 않습니다.");
//                    return null;
//                }
//            }catch (IllegalArgumentException e){
//                log.info("validateUserLogin : False - {}",authDTO.getMail());
//                log.error(e.getMessage());
//                return null;
//            }
//    }

//    /**
//     * 사용자 로그인
//     *
//     * @param loginRequestDTO
//     * @return
//     *       > 사용자 검증 성공 : Access Token
//     *       > 사용자 검증 실패 : null
//     */
//    public String doLogin(LoginRequestDTO loginRequestDTO){
//        Users users = validateUserLogin(loginRequestDTO);
//        log.info("doLogin = > ::: {}",users);
//        if(users != null){
//            users.isLogin();
//            String accessToken = jwtTokenUtils.issuanceAccessToken(users);
//            if (!jwtTokenUtils.validateRefreshToken(users.getKey())) {
//                jwtTokenUtils.reissuanceRefreshToken(users.getMail());
//            }
//            return accessToken;
//        }else{
//            log.info("doLogin finish : false - {}", users.getMail());
//            return null;
//        }
//    }
//
//
//    /**
//     * 사용자 로그아웃
//     * 1. Access Token / 사용자 검증
//     * 2. Access Token 만료시 Refresh Token을 사용한 검증
//     * 3. 로그아웃
//     *
//     * @param key - Access Token
//     * @param cookie - Refresh Token
//     * @return
//     *       > 사용자 검증 성공 : ture
//     *       > 사용자 검증 실패 : false
//     */
//    public Boolean doLogOut(String key, Cookie cookie){
////        Users users = UsersRepository.findByMail(jwtTokenUtils.getUserInfoToToken(key));
//        if(jwtTokenUtils.validateAccessInfoByToken(key)){
//
//            return true;
//        }else{
//            if(jwtTokenUtils.validateRefreshToken(cookie.getValue())){
////                loginRepository.updateLoginStatus(jwtTokenUtils.getUserInfoToToken(key), UserStatusCode.LOGOUT);
//                return true;
//            }else {
//                return false;
//            }
//        }
//    }
//
//    /**
//     * Refresh Token을 Cookie로 만들어 반환
//     * 1. 사용자 인증 정보의 Key로 저장되어 있는 Refresh Token 조회
//     * 2. Token 만료시 & Null 시 Refresh Token 재발급 하여 DB 저장
//     * 3. Refresh Token를 Cookie로 만들어 반환
//     *
//     * @param mail
//     * @return Cookie
//     */
//    public Cookie getRefreshTokenToCookie(String mail){
//       return new Cookie("refresh", jwtTokenUtils.getRefreshToken(mail));
//    }
}
