package com.gteam.glog.login.repository;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.domain.enums.UserStatusCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Log4j2
@Repository
public class LoginRepository {
    private final EntityManager entityManager;
    public LoginRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * 사용자 정보 조회 <Users/>: 이메일
     *
     * @param mail
     * @return Users
     */
    public Optional<Users> getUsersByUserId(String mail){
        // 유저 인증 정보 조회
        log.info("getUsersByUserId -- : {}",mail);
        return entityManager
                .createQuery("select usr from Users as usr where usr.mail = ?1", Users.class)
                .setParameter(1, mail)
                .getResultList().stream().findFirst();
    }

    /**
     * 사용자 Refresh Token 값 수정
     *
     * @param key - Refresh Token
     * @param mail - User Mail
     *
     */
    @Transactional
    public void updateUserKey(String mail,String key){
        // 유저 MyPage 정보 조회
        Users users = entityManager
                .createQuery("select user from Users as user where user.mail = ?1", Users.class)
                .setParameter(1,mail)
                .getResultList().stream().findFirst().get();
        users.setKey(key);
        //entityManager.merge(users);
        entityManager.flush();
        entityManager.close();
    }


    /**
     * 사용자 Login 상태 수정
     *
     * @param mail - User Mail
     * @param status - User status
     *
     */
    @Transactional
    public void updateLoginStatus(String mail, UserStatusCode status){
        // 유저 MyPage 정보 조회
        Users users = entityManager
                .createQuery("select user from Users as user where user.mail = ?1", Users.class)
                .setParameter(1,mail)
                .getResultList().stream().findFirst().get();
        users.setStatus(status);
//        entityManager.merge(users);
        entityManager.flush();
        entityManager.close();
    }
}
