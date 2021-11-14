package com.gteam.glog.domain.dto.oauth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GoogleOAuthUserInfoResponseDTO {
    private String id;
    private String name;
    private String given_name;
    private String picture;
    private String locale;
}
