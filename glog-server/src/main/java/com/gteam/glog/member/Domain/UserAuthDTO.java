package com.gteam.glog.member.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.SpringVersion;

@Getter
@Setter
public class UserAuthDTO {
    private String userId;
    private String passWd;
}
