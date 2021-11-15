package com.gteam.glog.oauth.controller;

import com.gteam.glog.common.utils.ResponseDTOUtils;
import com.gteam.glog.domain.dto.OAuthRequestDTO;
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
    private final ResponseDTOUtils responseDTOUtils;
    @Autowired
    public OAuthController(OAuthService oAuthService, ResponseDTOUtils responseDTOUtils) {
        this.oAuthService = oAuthService;
        this.responseDTOUtils = responseDTOUtils;
    }


    @PostMapping("/{socialLoginType}")
    @ApiOperation(value = "소셜 로그인 API", notes = "소셜 사용자 로그인 API ")
    public ResponseEntity<?> OAuthSigin(@PathVariable("socialLoginType") SocialLoginType socialLoginType,
                                        @RequestBody OAuthRequestDTO oAuthRequestDTO){
        log.info("====>> OAuth Login - {}",socialLoginType);
        switch (socialLoginType) {
            case GOOGLE: {
                return responseDTOUtils.doGenerateResponseDTO(oAuthService.doRequestGoogleOauth(oAuthRequestDTO.getAuthorizationCode()));
            }
            case GIT: {
                // TODO: git oauth
                return responseDTOUtils.doGenerateResponseDTO(oAuthService.doRequestgitOauth(oAuthRequestDTO.getAuthorizationCode()));
            }
            default: {
                return responseDTOUtils.doGenerateResponseDTO(null);
            }
        }
    }

    @GetMapping("/{socialLoginType}/callback")
    @ApiOperation(value = "소셜 로그인 API callback", notes = "소셜 로그인 리디렉션 URI")
    public ResponseEntity<?> OAuthCallback(@PathVariable("socialLoginType") SocialLoginType socialLoginType,
                                           @RequestParam(value = "code") String code){
        // TODO : OAtuhServie 연결 필요
        System.out.println(code);
        System.out.println(socialLoginType.get());
        return responseDTOUtils.doGenerateResponseDTO(null);
    }

}
