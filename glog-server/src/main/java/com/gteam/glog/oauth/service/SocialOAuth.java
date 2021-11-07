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
     * Client에서 받은 code를 활용하여 사용자 Access_token
     *
     * @param code
     * @return access_token : string
     */
    String requestAccessToken(String code);


    /**
     * Access token을 사용하여 사용자 profile을 요청 합니다.
     *
     * @param accesstoken
     * @return
     */
    String requestUserProfile(String accesstoken);


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

            return this.restTemplate.exchange(
                    oAuthInfo.getUrl(),
                    HttpMethod.GET,
                    httpEntity,
                    String.class);
        }catch (HttpStatusCodeException e) {
            return null;
        }
    }
}
