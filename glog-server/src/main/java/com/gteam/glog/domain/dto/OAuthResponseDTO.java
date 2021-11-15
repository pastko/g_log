package com.gteam.glog.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OAuthResponseDTO {
    private String accessToken;
    private String userId;
}
