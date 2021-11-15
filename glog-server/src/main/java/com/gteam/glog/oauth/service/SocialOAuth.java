package com.gteam.glog.oauth.service;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


public interface SocialOAuth {
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
    Optional<?> requestAccessToken(String code);


}
