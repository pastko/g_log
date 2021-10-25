package com.gteam.glog.auth.repository;

import com.gteam.glog.domain.dto.OAuthCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class OAuthRepository {
    private final EntityManager entityManager;

    @Autowired
    public OAuthRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public OAuthCodeDTO FindUserOAuthCode(){
        return entityManager.find(OAuthCodeDTO.class, 0L);
    }
}
