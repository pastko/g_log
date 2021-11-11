package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "bord_cont")
@NoArgsConstructor
public class Contents {

    @Column(name = "bord_idx")
    private Board idx;

    @Column(name = "titl")
    private String title;

    @Column(name = "img_nm")
    private String img_nm;

    @Column(name = "cont")
    private String contents;

    @Column(name = "cret_dt")
    private Date createDt;

    @Column(name = "cret_dt")
    private Date updateDt;

}
