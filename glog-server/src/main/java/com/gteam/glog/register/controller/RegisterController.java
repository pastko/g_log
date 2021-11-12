package com.gteam.glog.register.controller;

import com.gteam.glog.common.utils.ResponseDTOUtils;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.dto.RegisterRequestDTO;
import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.register.service.RegisterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RegisterController {

    private final RegisterService registerService;
    private final ResponseDTOUtils responseDTOUtils;

    @Autowired
    public RegisterController(RegisterService registerService, ResponseDTOUtils responseDTOUtils) {
        this.registerService = registerService;
        this.responseDTOUtils = responseDTOUtils;
    }

    @PostMapping(value = "/signup")
    @ApiOperation(value = "회원가입 API", notes = "로컬 사용자 회원가입 API")
    public ResponseEntity<?> createUserinfo(@RequestBody(required = true) RegisterRequestDTO request, HttpServletResponse response) {
        UserInfoDTO userInfoDTO = UserInfoDTO.builder().mail(request.getMail()).nikNm(request.getNikNm()).pwd(request.getPwd()).build();

        if(request.getMail() != null) {
            userInfoDTO.setMail(request.getMail());
            userInfoDTO.setPwd(request.getPwd());
            userInfoDTO.setNikNm(request.getNikNm());
        }
        return responseDTOUtils.doGenerateResponseDTO(registerService.createUserInfo(userInfoDTO));
    }
    @GetMapping(value = "/unregister")
    @ApiOperation(value = "회원탈퇴 API", notes = "로컬 사용자 회원탈퇴 API")
    public ResponseEntity<?> unRegistUser(@RequestHeader("AccessToken") String token, HttpServletResponse response) {
        return responseDTOUtils.doGenerateResponseDTO(registerService.unRegistUser(token));
    }
}