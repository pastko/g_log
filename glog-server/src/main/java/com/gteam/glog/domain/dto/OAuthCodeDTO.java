package com.gteam.glog.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OAuthCodeDTO {
    @Id
    private Long id;

    @Column(nullable = false, length = 100)
    private String ClientId;

    @Column(nullable = false, length = 100)
    private String ClientSecret;
}
