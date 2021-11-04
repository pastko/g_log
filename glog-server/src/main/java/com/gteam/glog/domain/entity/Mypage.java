package com.gteam.glog.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@Entity
@Builder
//@NoArgsConstructor
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
    @Size(max=13)
    private String nikName;

    @Column(name = "img_nm")
    private String imgName;

    @Column(name = "glog_titl")
    @Size(max=10)
    private String glogTitle;

    private Date UnregistDate;

    private Boolean isUnregist;
}
