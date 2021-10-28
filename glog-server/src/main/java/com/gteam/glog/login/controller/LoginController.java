package com.gteam.glog.login.controller;

import com.gteam.glog.common.JWTTokenUtils;
import com.gteam.glog.domain.dto.UserAuthDTO;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.login.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@Log4j2
public class LoginController {
    private final LoginService loginService;
    private final JWTTokenUtils jwtTokenUtils;
    @Autowired
    public LoginController(LoginService loginService, JWTTokenUtils jwtTokenUtils) {
        this.loginService = loginService;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @PostMapping("/signin")
    @ApiOperation(value = "로그인 API", notes = "로컬 사용자 로그인 API")
    public ResponseEntity<?> signin(@RequestBody() UserAuthDTO userAuthDTO, HttpServletResponse response){
        try{
            log.trace("Sign In :",userAuthDTO.getUserId());
            // 사용자 로그인 검증
            Users user = loginService.validateUserLogin(userAuthDTO);
            if(user != null) {
                response.addCookie(jwtTokenUtils.generateCookieToRefreshToken(user));
            }
            return ResponseEntity.ok().body(loginService.doGenerateResponseDTO(user,"Login success"));
        }catch (IllegalArgumentException e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(loginService.doGenerateBadResponseDTO("Login Failed"));
        }
    }

    @GetMapping("/myinfo")
    @ApiOperation(value = "유저 정보 조회", notes = "유저 정보를 요청하는 API")
    public ResponseEntity<?> getMypage(@RequestHeader Map<String, String> requestHeader) {
        try {
            Users users = loginService.validateUserAuthInfo(requestHeader.get("authorization"));
            UserInfoDTO userInfoDTO = loginService.findUserInfoByUserId(users.getUserId());
            return ResponseEntity.ok().body(loginService.doGenerateResponseDTO(users, "MyPage Load Success"));
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(loginService.doGenerateBadResponseDTO("MyPage Load Failed"));
        }
    }
}
