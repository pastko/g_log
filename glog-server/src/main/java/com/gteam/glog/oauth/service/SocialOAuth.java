package com.gteam.glog.oauth.service;


import com.gteam.glog.domain.entity.OAuthInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


public interface SocialOAuth {
    final RestTemplate restTemplate = new RestTemplate();

    /**
     * @param token
     * @return Authorization 해더 반환
     */
    HttpEntity createHeaders(String token);


    /**
     * Client에서  받은 code를 활용하여 사용자 Access_token
     * @param code
     * @return
     */
    String requestAccessToken(String code);



    /**
     * Access Token을 사용하여 각 소셜 사이트에서
     * 사용자 정보를 불러오는 함수
     *
     * @param accessToken
     * @return ResponseEntity
     */
    default ResponseEntity<?> getOauthUserProfile(String accessToken, OAuthInfo oAuthInfo) {
        try {
            HttpEntity httpEntity = createHeaders(accessToken);

            return restTemplate.exchange(
                    oAuthInfo.getUrl(),
                    HttpMethod.GET,
                    httpEntity,
                    String.class);
        }catch (HttpStatusCodeException e) {
            return null;
        }
    }
}
