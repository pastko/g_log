package com.gteam.glog.login.controller;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.common.utils.ResponseDTOUtils;
import com.gteam.glog.domain.dto.login.LoginRequestDTO;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.login.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Log4j2
public class LoginController {
    private final LoginService loginService;
    private final JWTTokenUtils jwtTokenUtils;
    private final ResponseDTOUtils responseDTOUtils;
    @Autowired
    public LoginController(LoginService loginService, JWTTokenUtils jwtTokenUtils, ResponseDTOUtils responseDTOUtils) {
        this.loginService = loginService;
        this.jwtTokenUtils = jwtTokenUtils;
        this.responseDTOUtils = responseDTOUtils;
    }

    @PostMapping("/signin")
    @ApiOperation(value = "로그인 API", notes = "로컬 사용자 로그인 API")
    public ResponseEntity<?> signIn(@RequestBody LoginRequestDTO loginRequestDTO,
                                    HttpServletResponse response){

        log.info("Sign In : {}", loginRequestDTO.getMail());
        // 사용자 로그인 검증
        String accessToken = loginService.doLogin(loginRequestDTO);
        if(accessToken != null){
            response.addCookie(loginService.getRefreshTokenToCookie(loginRequestDTO.getMail()));
            return responseDTOUtils.doGenerateResponseDTO(accessToken);
        }else {
            return responseDTOUtils.doGenerateResponseDTO(null);
        }

    }

    @GetMapping("/signout")
    @ApiOperation(value = "로그인 아웃 API", notes = "사용자 로그아웃 API")
    public ResponseEntity<?> signOut(@RequestHeader(value = "authorization")String authorization,
                                     @RequestHeader(value = "X-USER-ID") String mail,
                                     @CookieValue(value = "refresh")Cookie reqCookie,
                                     HttpServletResponse response){
        log.info("Sign Out :", mail);
        if(loginService.doLogOut(authorization,mail,reqCookie)){
            // 쿠키 삭제
            Cookie cookie = new Cookie("refresh","");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return responseDTOUtils.doGenerateResponseDTO("logout Success");
        }else {
            return responseDTOUtils.doGenerateResponseDTO(null);
        }
    }
}
