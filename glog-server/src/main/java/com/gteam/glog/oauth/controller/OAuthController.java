package com.gteam.glog.oauth.controller;

import com.gteam.glog.domain.dto.OAuthRequestDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {


    @PostMapping("/oauth")
    @ApiOperation(value = "소셜 로그인 API", notes = "소셜 사용자 로그인 API { }")
    public ResponseEntity<?> OAuthSigin(@RequestBody() OAuthRequestDTO authorization){
        try{
            return ResponseEntity.ok().body("");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Not found!");
        }
    }
}
