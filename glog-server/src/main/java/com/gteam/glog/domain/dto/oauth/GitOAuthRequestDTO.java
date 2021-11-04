package com.gteam.glog.domain.dto.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitOAuthRequestDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
}
