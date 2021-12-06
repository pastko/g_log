package com.gteam.glog.signin.controller;

import com.gteam.glog.common.utils.ResponseDTOUtils;
import com.gteam.glog.domain.dto.login.LoginRequestDTO;
import com.gteam.glog.signin.service.SignInService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@RestController
@RequiredArgsConstructor
public class SignInController {
    private final SignInService loginService;
    private final ResponseDTOUtils responseDTOUtils;

//    @PostMapping("/signin")
//    @ApiOperation(value = "로그인 API", notes = "로컬 사용자 로그인 API")
//    public ResponseEntity<?> signIn(@RequestBody LoginRequestDTO loginRequestDTO,
//                                    HttpServletResponse response){
//
//        log.info("Sign In : {}", loginRequestDTO.getMail());
//        // 사용자 로그인 검증
//        String accessToken = loginService.doLogin(loginRequestDTO);
//
//        log.info("Sign In finished: {}");
//        if(accessToken != null){
//            response.addCookie(loginService.getRefreshTokenToCookie(loginRequestDTO.getMail()));
//            log.info("Sign In make cookies: {}");
//            return responseDTOUtils.doGenerateResponseDTO(accessToken);
//        }else {
//            return responseDTOUtils.doGenerateResponseDTO(null);
//        }
//
//    }
//
//    @GetMapping("/signout")
//    @ApiOperation(value = "로그인 아웃 API", notes = "사용자 로그아웃 API")
//    public ResponseEntity<?> signOut(@RequestHeader(value = "authorization")String authorization,
//                                     @CookieValue(value = "refresh")Cookie reqCookie,
//                                     HttpServletResponse response){
//        log.info("Sign Out :");
//        if(loginService.doLogOut(authorization,reqCookie)){
//            // 쿠키 삭제
//            Cookie cookie = new Cookie("refresh","");
//            cookie.setMaxAge(0);
//            response.addCookie(cookie);
//            return responseDTOUtils.doGenerateResponseDTO("logout Success");
//        }else {
//            return responseDTOUtils.doGenerateResponseDTO(null);
//        }
//    }
}
