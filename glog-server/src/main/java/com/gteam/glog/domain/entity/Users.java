package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "usr")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_idx")
    private int idx;

    @Column(name = "mail", nullable = false)
    private String userId;


    @Column(name = "pwd", nullable = false)
    private String userToken;
}
