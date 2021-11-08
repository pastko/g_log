package com.gteam.glog.domain.dto.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestDTO {
    private String mail;
    private String pwd;
}
