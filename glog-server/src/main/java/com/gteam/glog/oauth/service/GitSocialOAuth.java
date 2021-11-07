package com.gteam.glog.oauth.service;

import com.gteam.glog.domain.enums.SocialLoginType;
import com.gteam.glog.domain.dto.oauth.GitOAuthRequestDTO;
import com.gteam.glog.domain.dto.oauth.GitOAuthResponseDTO;
import com.gteam.glog.domain.entity.OAuthInfo;
import com.gteam.glog.oauth.repository.OAuthRepository;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


@Service
@Log4j2
public class GitSocialOAuth implements SocialOAuth {
    @Value("oauth.redirectionRootUrl")
    private String redirectionRootUrl;

    private OkHttpClient okHttpClient;
    private RestTemplate restTemplate;
    private  final OAuthRepository oAuthRepository;

    @Autowired
    public GitSocialOAuth(OAuthRepository oAuthRepository) {
        this.oAuthRepository = oAuthRepository;
        this.okHttpClient = new OkHttpClient();
        this.restTemplate = new RestTemplate();
    }

    /**
     * git Authorization 해더 반환
     *
     * @param token
     * @return Authorization 해더
     */
    @Override
    public HttpEntity createHeaders(String token) {
        String authHeader = "token " + token;
        return new HttpEntity(new HttpHeaders(){{
            set("Authorization", authHeader);
        }});
    }

    /**
     * Git OAuth Request Access Token
     * 사용자 Access code를 사용하여 Access Token 발급
     *
     * @param code
     * @return Token
     */
    @Override
    public String requestAccessToken(String code) {
        try {
            OAuthInfo oAuthInfo = oAuthRepository.FindUserOAuthCode(SocialLoginType.GIT).get();
            GitOAuthRequestDTO.AccessToken gItOAuthRequestDTO = new GitOAuthRequestDTO.AccessToken(
                    oAuthInfo.getClientId(),
                    oAuthInfo.getClientSecret(),
                    code,
                    redirectionRootUrl+"/git/callback"
            );

            // TODO: restTemplate => okHttp2 로 변경 해보기
            // send data id, secret key , access code , redirect url
            GitOAuthResponseDTO.AccessToken token = restTemplate.postForObject(
                    oAuthInfo.getTokenUrl(),
                    gItOAuthRequestDTO,
                    GitOAuthResponseDTO.AccessToken.class);
            if (token != null) {
                return token.getAccess_token();
            } else {
                log.info("Token Null : null");
                return null;
            }
        } catch (IllegalArgumentException e){
            log.error("Null Exception : "+ e.getMessage());
            return null;
        } catch (HttpStatusCodeException e){
            log.error("Http Status Exception : " + e.getMessage());
            return null;
        }
    }



    @Override
    public String requestUserProfile(String accessToken) {
        try{
            // TODO : 사용자 프로필 가저오기 (git)
            return null;
        }catch (IllegalArgumentException e) {
            return null;
        }catch (HttpStatusCodeException e){
            return null;
        }
    }
}
