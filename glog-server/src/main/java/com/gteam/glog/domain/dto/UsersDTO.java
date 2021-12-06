package com.gteam.glog.domain.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UsersDTO {
    private String mail;
    private String pwd;
    private String key;
}
