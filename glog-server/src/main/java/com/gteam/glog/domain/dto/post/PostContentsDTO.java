package com.gteam.glog.domain.dto.post;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostContentsDTO {

    private int idx;
    private String title;
    private String contents;
    private String html;
    private String nikNm;
    private String id;
    private String imgNm;
    private String createDt;
    private String tag;
}
