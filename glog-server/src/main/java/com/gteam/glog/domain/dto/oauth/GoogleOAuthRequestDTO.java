package com.gteam.glog.domain.dto.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class GoogleOAuthRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
     public static class AccessToken {
        private String client_id;
        private String client_secret;
        private String code;
        private String grant_type;
        private String redirect_uri;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RefreshToken {
        private String id;
    }

}
