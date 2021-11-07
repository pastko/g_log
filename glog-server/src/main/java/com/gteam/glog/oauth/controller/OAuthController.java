package com.gteam.glog.oauth.controller;

import com.gteam.glog.domain.enums.SocialLoginType;
import com.gteam.glog.oauth.service.OAuthService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/oauth")
public class OAuthController {
    private final OAuthService oAuthService;
    @Autowired
    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }


    @PostMapping("/{socialLoginType}")
    @ApiOperation(value = "소셜 로그인 API", notes = "소셜 사용자 로그인 API ")
    public ResponseEntity<?> OAuthSigin(@PathVariable("socialLoginType") SocialLoginType socialLoginType){
        try{
            // TODO : OAtuhServie 연결 필요
            return ResponseEntity.ok().body("");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Not found!");
        }
    }

    @GetMapping("/{socialLoginType}/callback")
    @ApiOperation(value = "소셜 로그인 API callback", notes = "소셜 로그인 리디렉션 URI")
    public ResponseEntity<?> OAuthCallback(@PathVariable("socialLoginType") SocialLoginType socialLoginType,
                                           @RequestParam(value = "code") String code){
        try{
            // TODO : OAtuhServie 연결 필요
            System.out.println(code);
            System.out.println(socialLoginType.get());
            return ResponseEntity.ok().body("");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Not found!");
        }
    }

}
