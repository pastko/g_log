package com.gteam.glog.domain.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {
    private String title;
    private String contents;
    private String nikNm;
    private String imgNm;
    private int idx;
}
