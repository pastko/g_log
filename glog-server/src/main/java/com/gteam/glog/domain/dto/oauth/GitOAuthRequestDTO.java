package com.gteam.glog.domain.dto.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class GitOAuthRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccessToken {
        private String client_id;
        private String client_secret;
        private String code;
        private String redirect_uri;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RefreshToken {
        private String refresh_token;
        private String grant_type;
        private String client_id;
        private String client_secret;
    }
}
