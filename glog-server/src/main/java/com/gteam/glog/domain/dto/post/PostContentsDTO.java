package com.gteam.glog.domain.dto.post;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostContentsDTO {

    private int idx;
    private String title;
    private String contents;
    private String nikNm;
    private String imgNm;
    private Date createDt;
}
