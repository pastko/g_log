package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "usr_idx")
    private Users usr_idx;

    @Column(name = "nik_nm")
    private String nikName;

    @Column(name = "img_nm")
    private String imgName;

    @Column(name = "glog_titl")
    private String glogTitle;
}
