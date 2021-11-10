package com.gteam.glog.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfoDTO {
    private int usrIdx;
    private String mail;
    private String pwd;
    private String nikNm;
    private String imgNm;
    private String glogTitle;
}
