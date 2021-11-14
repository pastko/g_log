package com.gteam.glog.register.repository;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Mypage;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.domain.enums.UserStatusCode;
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
        Users users = entityManager.find(Users.class, email);
        return users == null;
    }
    public void createUserInfo(UserInfoDTO userInfoDTO) {

        if(duplicateCheck(userInfoDTO.getMail())) {
            Users users = new Users();
            Mypage mypage = new Mypage();

            users.setMail(userInfoDTO.getMail());
            users.setPwd(userInfoDTO.getPwd());
            users.setStatus(UserStatusCode.LOGOUT);

            mypage.setUsrIdx(users);
            mypage.setNikNm(userInfoDTO.getNikNm());

            entityManager.persist(users);
            entityManager.persist(mypage);

            entityManager.flush();
            entityManager.close();
        }
    }

    public Boolean createOatuhUserInfo(UserInfoDTO userInfoDTO) {

        if(duplicateCheck(userInfoDTO.getMail())) {
            Users users = new Users();
            Mypage mypage = new Mypage();

            users.setMail(userInfoDTO.getMail());
            users.setPwd(userInfoDTO.getPwd());
            users.setStatus(UserStatusCode.LOGIN);

            mypage.setUsrIdx(users);
            mypage.setNikNm(userInfoDTO.getNikNm());
            mypage.setGlogTitle(userInfoDTO.getGlogTitle());
            mypage.setImgNm(userInfoDTO.getImgNm());

            entityManager.persist(users);
            entityManager.persist(mypage);

            entityManager.flush();
            entityManager.close();
            return true;
        }else{
            return false;
        }
    }

    public void unRegistUser(String email) {
        Users users = entityManager.find(Users.class, email);

        users.setStatus(UserStatusCode.UNREGISTER);

        entityManager.persist(users);

        entityManager.flush();
        entityManager.close();
    }
}
