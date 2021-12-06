package com.gteam.glog.mypage.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Log4j2
@Repository
public class MyPageRepository {
    private final EntityManager entityManager;
    public MyPageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//
//    /**
//     * 사용자 개인정보 조외 <MyPage/> : 이메일
//     *
//     * @param mail
//     * @return UserInfoDTO
//     */
//    public Optional<Mypage> getUserInfoByUserId(String mail){
//        // 유저 MyPage 정보 조회
//        try {
//            return entityManager
//                    .createQuery("select mypage from Mypage as mypage where mypage.usrIdx.mail = ?1", Mypage.class)
//                    .setParameter(1, mail)
//                    .getResultList().stream().findFirst();
//        }catch (Exception e){
//            log.info("getUserInfoByUserId : false - {}",e.getCause());
//            log.info("getUserInfoByUserId : {}",e.getMessage());
//            entityManager.close();
//            return Optional.empty();
//        }
//    }
//
//
//    /**
//     * 사용자 개인정보 수정 <MyPage/> : 이메일
//     *
//     * @param userInfo
//     * @return Boolean
//     */
//    @Transactional
//    public Boolean updateUserInfo(UserInfoDTO userInfo){
//        // 유저 MyPage 정보 조회
//        Mypage mypage = entityManager
//                .createQuery("select mypage from Mypage as mypage where mypage.usrIdx.mail = ?1", Mypage.class)
//                .setParameter(1, userInfo.getMail())
//                .getResultList().stream().findFirst().orElse(null);
//
//        if( mypage != null)
//        {
//            mypage.setNikNm(userInfo.getNikNm());
//            mypage.setGlogTitle(userInfo.getGlogTitle());
//            mypage.setImgNm(userInfo.getImgNm());
//            entityManager.flush();
//            entityManager.close();
//            return true;
//        }else{
//            return false;
//        }
//
//    }

}
