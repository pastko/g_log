package com.gteam.glog.register.repository;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Mypage;
import com.gteam.glog.domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public class RegisterRepository {

    private final EntityManager entityManager;

    @Autowired
    public RegisterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean duplicateCheck(String email) {
        UserInfoDTO userInfoDTO = entityManager.find(UserInfoDTO.class, email);
        return userInfoDTO == null;
    }
    public void createUserInfo(UserInfoDTO userInfoDTO) {
        if(duplicateCheck(userInfoDTO.getUserId())) {

            Users users = Users.builder().userId(userInfoDTO.getUserId()).userPwd(userInfoDTO.getUserPwd()).build();
            Mypage mypage = Mypage.builder().usr_idx(users).nikName(userInfoDTO.getNikName()).build();

            entityManager.persist(users);
            entityManager.persist(mypage);

            entityManager.flush();
            entityManager.close();
        }
    }

    public void unRegistUser(String email) {
        /*select * from mypage where id = {email}
        * -> isUnregist = true;
        *
        * entitymanager.persist() close*/
    }
}
