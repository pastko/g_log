package com.gteam.glog.oauth.service;

import com.gteam.glog.domain.enums.SocialLoginType;
import com.gteam.glog.domain.dto.oauth.GitOAuthRequestDTO;
import com.gteam.glog.domain.dto.oauth.GitOAuthResponseDTO;
import com.gteam.glog.domain.entity.OAuthInfo;
import com.gteam.glog.oauth.repository.OAuthRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;


@Service
@Log4j2
public class GitSocialOAuth implements SocialOAuth {
    @Value("oauth.redirectionRootUrl")
    private String redirectionRootUrl;
    private  final OAuthRepository oAuthRepository;

    @Autowired
    public GitSocialOAuth(OAuthRepository oAuthRepository) {
        this.oAuthRepository = oAuthRepository;
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
            GitOAuthRequestDTO gItOAuthRequestDTO = new GitOAuthRequestDTO(
                    oAuthInfo.getClientId(),
                    oAuthInfo.getClientSecret(),
                    code,
                    redirectionRootUrl+"/git/callback"
            );


            // send data id, secret key , access code , redirect url
            GitOAuthResponseDTO token = restTemplate.postForObject(
                    oAuthInfo.getUrl(),
                    gItOAuthRequestDTO,
                    GitOAuthResponseDTO.class);
            if (token != null) {
                return token.getAccess_token();
            } else {
                return null;
            }
        } catch (IllegalArgumentException e){
            log.error("Null Exception : "+ e.getMessage());
            return null;
        } catch ( HttpStatusCodeException e){
            log.error("Http Status Exception : " + e.getMessage());
            return null;
        }
    }
}
