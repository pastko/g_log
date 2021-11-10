package com.gteam.glog.main.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MainRepository {
    private final EntityManager entityManager;

    @Autowired
    public MainRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
