package com.gteam.glog.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Builder
//@NoArgsConstructor
@Table(name = "usr")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_idx")
    private int idx;

    @Column(name = "mail", nullable = false)
    @Email
    @NotNull
    private String userId;


    @Column(name = "pwd", nullable = false)
    @NotNull
    private String userPwd;
}
