package com.gteam.glog.domain.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {
    private int postIdx;
    private String title;
    private String contents;
    private String html;
    private String nikNm;
    private String imgNm;
    private String[] tag;
}
