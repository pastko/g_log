package com.gteam.glog.mypage.service;

import com.gteam.glog.domain.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class MyPageRepository {
    private final EntityManager entityManager;
    public MyPageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * 사용자 개인정보 조외 <MyPage/> : 이메일
     *
     * @param mail
     * @return UserInfoDTO
     */
    public Optional<UserInfoDTO> getUserInfoByUserId(String mail){
        // 유저 MyPage 정보 조회
        return entityManager
                .createQuery("select mypage from Mypage as mypage where mypage.usrIdx.mail = ?1", UserInfoDTO.class)
                .setParameter(1, mail)
                .getResultList().stream().findFirst();
    }


    /**
     * 사용자 개인정보 수정 <MyPage/> : 이메일
     *
     * @param userInfo
     * @return Boolean
     */
    @Transactional
    public Boolean updateUserInfo(UserInfoDTO userInfo){
        // 유저 MyPage 정보 조회
        UserInfoDTO currentUserInfo = entityManager
                .createQuery("select mypage from Mypage as mypage where mypage.usrIdx.mail = ?1", UserInfoDTO.class)
                .setParameter(1, userInfo.getMail())
                .getResultList().stream().findFirst().orElse(null);

        if( currentUserInfo != null)
        {
            currentUserInfo.setNikNm(userInfo.getNikNm());
            currentUserInfo.setGlogTitle(userInfo.getGlogTitle());
            currentUserInfo.setImgNm(userInfo.getImgNm());
            entityManager.merge(currentUserInfo);
            entityManager.flush();

            return true;
        }else{
            return false;
        }

    }

}
