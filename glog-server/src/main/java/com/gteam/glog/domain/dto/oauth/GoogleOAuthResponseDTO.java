package com.gteam.glog.domain.dto.oauth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GoogleOAuthResponseDTO {
    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;
}
