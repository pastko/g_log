package com.gteam.glog.login.repository;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class LoginRepository {
    private final EntityManager entityManager;
    public LoginRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Get User MyPage Info by Userid
     *
     * @param id
     * @return UserInfoDTO
     */
    public Optional<UserInfoDTO> getUserInfoByUserId(String id){
        // 유저 MyPage 정보 조회
        List<UserInfoDTO> userInfoDTO = entityManager
                .createQuery("select usr from Mypage as usr where usr.usr_idx.userId = ?1", UserInfoDTO.class)
                .setParameter(1,id)
                .getResultList();
        return Optional.of(userInfoDTO.get(0));
    }

    /**
     * Get Users auth info by Userid
     *
     * @param id
     * @return Users
     */
    public Optional<Users> getUsersByUserId(String id){
        // 유저 인증 정보 조회
        List<Users> users = entityManager
                .createQuery("select usr from Users as usr where usr.userId = ?1", Users.class)
                .setParameter(1,id)
                .getResultList();

        return Optional.of(users.get(0));
    }
}
