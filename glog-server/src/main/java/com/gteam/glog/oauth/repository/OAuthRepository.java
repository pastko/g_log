package com.gteam.glog.oauth.repository;

import com.gteam.glog.domain.dto.OAuthCodeDTO;
import com.gteam.glog.domain.dto.OAuthResponseDTO;
import com.gteam.glog.domain.entity.OAuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class OAuthRepository {
    private final EntityManager entityManager;

    @Autowired
    public OAuthRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public Optional<OAuthInfo> FindUserOAuthCode(){
        return Optional.of(entityManager.find(OAuthInfo.class, 0L));
    }
}
