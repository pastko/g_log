package com.gteam.glog.domain.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private String nikNm;
    private String content;
    private int bord_idx;
}
