package com.gteam.glog.domain.dto.oauth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GitOAuthResponseDTO {
    private String access_token;
    private String scope;
    private String token_type;
}
