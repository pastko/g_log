package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "bord_cont")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idx`")
    private int idx;

    @ManyToOne
    @JoinColumn(name = "bord_idx")
    private Board board;

    @Column(name = "titl")
    private String title;

    @Column(name = "img_nm")
    private String img_nm;

    @Column(name = "cont")
    private String contents;

    @Column(name = "cret_dt")
    private String createDt;

    @Column(name = "upd_dt")
    private String updateDt;

    @Column(name = "tag")
    private String tag;

}
