package com.gteam.glog.oauth.service;

import com.gteam.glog.domain.dto.OAuthResponseDTO;
import com.gteam.glog.domain.dto.OAuthCodeDTO;
import com.gteam.glog.domain.entity.OAuthInfo;
import com.gteam.glog.oauth.repository.OAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OAuthService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final OAuthRepository oAuthRepository;

    @Autowired
    public OAuthService(OAuthRepository oAuthRepository) {
        this.oAuthRepository = oAuthRepository;
    }


    public Optional<OAuthResponseDTO> validateOAuthLogin(){
        try {


            OAuthInfo oAuthCode = oAuthRepository.FindUserOAuthCode().get();

            // send data id, secret key , ...
            OAuthResponseDTO token = restTemplate.postForObject(
                    "https://github.com/login/oauth/access_token",
                    null, // {요청할 때 보낼 데이터}
                    OAuthResponseDTO.class);
            if (token != null) {
                return Optional.ofNullable(token);
            } else {
                return null;
            }
        }catch (IllegalArgumentException e){
            return null;
        }
    }

}
