package com.gteam.glog.register.controller;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.dto.UserRequestDTO;
import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.register.service.RegisterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RegisterController {

    private final RegisterService registerService;
    private final JWTTokenUtils jwtTokenUtils;

    @Autowired
    public RegisterController(RegisterService registerService, JWTTokenUtils jwtTokenUtils) {
        this.registerService = registerService;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @PostMapping(value = "/signup")
    @ApiOperation(value = "회원가입 API", notes = "로컬 사용자 회원가입 API")
    public String createUserinfo(@RequestBody(required = true) UserRequestDTO request, HttpServletResponse response) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();

        if(request.getMail() != null) {
            userInfoDTO.setMail(request.getMail());
            userInfoDTO.setPwd(request.getPwd());
            userInfoDTO.setNikNm(request.getNikNm());
        }
        return registerService.createUserInfo(userInfoDTO);
    }
}