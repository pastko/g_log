package com.gteam.glog.domain.dto.oauth;

import lombok.Builder;
import lombok.Getter;

import lombok.Setter;


public class GitOAuthResponseDTO {

    @Getter
    @Setter
    @Builder
    public static class AccessToken {
        private String access_token;
        private String scope;
        private String token_type;
    }

    @Getter
    @Setter
    @Builder
    public static class RefreshToken{
        private String access_token;
        private String expires_in;
        private String refresh_token;
        private String refresh_token_expires_in;
        private String scope;
        private String token_type;
    }
}
