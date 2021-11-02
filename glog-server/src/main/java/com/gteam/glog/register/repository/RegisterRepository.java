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

    public boolean duplicateCheck(String id) {
        UserInfoDTO userInfoDTO = entityManager.find(UserInfoDTO.class, id);
        return userInfoDTO == null;
    }
    public void createUserInfo(UserInfoDTO userInfoDTO) {
        if(duplicateCheck(userInfoDTO.getUserId())) {
            Users users = new Users();
            Mypage mypage = new Mypage();

            users.setUserId(userInfoDTO.getUserId());
            users.setUserPwd(userInfoDTO.getUserPwd());
            users.setIdx(userInfoDTO.getUsrIdx());

            mypage.setUsr_idx(users);
            mypage.setNikName(userInfoDTO.getNikName());

            entityManager.persist(users);
            entityManager.persist(mypage);

            entityManager.flush();
            entityManager.close();
        }
    }
}
