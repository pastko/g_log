package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "mypg")
public class Mypage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mypg_idx")
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "usr_idx")
    private Users usrIdx;

    @Column(name = "nik_nm")
    @Size(max=13)
    private String nikNm;

    @Column(name = "img_nm")
    private String imgNm;

    @Column(name = "glog_titl")
    @Size(max=10)
    private String glogTitle;
}
