package com.gteam.glog.domain.entity;

import com.gteam.glog.domain.enums.UserStatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "usr")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`usr_idx`")
    private int idx;

    @Column(name = "`mail`")
    @Email
    @NotNull
    private String mail;

    @Column(name = "`pwd`")
    @NotNull
    private String pwd;

    @Column(name = "`key`", nullable = true)
    private String key;

    @NotNull
    @Column(name = "`status`")
    @Enumerated(EnumType.STRING)
    private UserStatusCode status;          // enum('LOGIN', 'LOGOUT', 'UNREGISTER') NOT NULL,
}
