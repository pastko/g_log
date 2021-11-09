package com.gteam.glog.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseDTO {
    private boolean success;
    private Object data;
    private String msg;
}
