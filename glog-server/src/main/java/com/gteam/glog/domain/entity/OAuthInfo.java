package com.gteam.glog.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Getter
@NoArgsConstructor
@Table(name="oauth_info")
public class OAuthInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_id")
    @Size(max=100)
    @NotNull
    private String ClientId;

    @Column(name="client_secret")
    @Size(max=100)
    @NotNull
    private String ClientSecret;

    @Column(name="token_url")
    @Size(max=100)
    @NotNull
    private String tokenUrl;

    @Column(name="profile_url")
    @Size(max=100)
    @NotNull
    private String profileUrl;

}
