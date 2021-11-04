package com.gteam.glog.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    private String mail;
    private String pwd;
    private String nikNm;
}
