package com.gteam.glog.oauth.service;

import com.gteam.glog.domain.enums.SocialLoginType;
import com.gteam.glog.oauth.repository.OAuthRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class OAuthService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final GoogleSocialOAuth googleSocialOAuth;
    private final GitSocialOAuth gitSocialOAuth;
    private final OAuthRepository oAuthRepository;

    @Autowired
    public OAuthService(GoogleSocialOAuth googleSocialOAuth, GitSocialOAuth gitSocialOAuth, OAuthRepository oAuthRepository) {
        this.googleSocialOAuth = googleSocialOAuth;
        this.gitSocialOAuth = gitSocialOAuth;
        this.oAuthRepository = oAuthRepository;
    }

    public void doRequestUserInfo(SocialLoginType socialLoginType, String code) {
        ResponseEntity<?> responseEntity;
        String AccessToken;
        try {
            switch (socialLoginType) {
                case GOOGLE: {
                    AccessToken = googleSocialOAuth.requestAccessToken(code);
                    responseEntity = googleSocialOAuth.getOauthUserProfile(
                            AccessToken,
                            oAuthRepository.FindUserOAuthCode(socialLoginType).get()
                    );
                } break;
                case GIT: {
                    AccessToken = gitSocialOAuth.requestAccessToken(code);
                    responseEntity = gitSocialOAuth.getOauthUserProfile(
                            AccessToken,
                            oAuthRepository.FindUserOAuthCode(socialLoginType).get()
                    );
                } break;
                default: {
                    AccessToken = "";
                    responseEntity = null;
                }
            }

        // TODO: 사용자 로그인 검증 로직 추가


        } catch (IllegalArgumentException e) {
            log.error("Null Exception : "+ e.getMessage());
        }
    }

    public String doRequestAccessTokenSwicherSocialType(){

        return null;
    }



    // TODO : 검증 로직
    public String validateOAuthLogin(){
        try {
            return null;
        }catch (IllegalArgumentException e){
            return null;
        }
    }


}


