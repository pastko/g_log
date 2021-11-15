package com.gteam.glog.domain.dto.comment;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class CommentContentsDTO {
    private String nikNm;
    private String content;
    private LocalDate createDt;
    private int bord_idx;
}
