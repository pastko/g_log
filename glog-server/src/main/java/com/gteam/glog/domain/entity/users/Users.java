package com.gteam.glog.domain.entity.users;

import com.gteam.glog.domain.dto.UsersDTO;
import com.gteam.glog.domain.entity.TimeStamp;
import com.gteam.glog.domain.enums.UserStatusCode;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "usr")
public class Users extends TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`usr_idx`")
    private Long idx;

    @Column(name = "mail")
    @Email
    @NotNull
    private String mail;

    @Column(name = "nik_nm")
    private String nikNm;


    @Column(name = "pwd")
    @NotNull
    private String pwd;

    @Column(name = "img_nm")
    private String imgNm;

    @Column(name = "glog_title")
    private String glogTitle;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatusCode status;          // enum('LOGIN', 'LOGOUT', 'UNREGISTER') NOT NULL,

    @Builder(builderClassName = "initUsers", builderMethodName = "initUsers")
    public Users(String mail, String nikNm, String pwd){
        this.mail = mail;
        this.nikNm = nikNm;
        this.pwd = pwd;
        this.status = UserStatusCode.LOGOUT;
    }

    public Long update(String nikNm, String imgNm, String glogTitle){
        this.nikNm = nikNm;
        this.imgNm = imgNm;
        this.glogTitle = glogTitle;
        return this.idx;
    }

    public void isLogin(){
        this.status = UserStatusCode.LOGIN;
    }

    public void isLogout(){
        this.status = UserStatusCode.LOGOUT;
    }
}
