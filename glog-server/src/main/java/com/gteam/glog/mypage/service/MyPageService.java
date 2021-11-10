package com.gteam.glog.mypage.service;

import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Mypage;
import com.gteam.glog.mypage.repository.MyPageRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MyPageService {
    private final MyPageRepository myPageRepository;
    private final JWTTokenUtils jwtTokenUtils;

    public MyPageService(MyPageRepository myPageRepository, JWTTokenUtils jwtTokenUtils) {
        this.myPageRepository = myPageRepository;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    /**
     *  유저 개인 정보 조회 Id
     *  User Nik-Name, user Img-name, user glog Title-name
     *
     * 1. 사용자 검증 ( Access Token )
     * 2. 정보 조회
     *
     * @param mail - user Id
     * @return :
     *          >  userId is exist       - return user info
     *          >  userId is not exist   - return null
     */
    public UserInfoDTO findUserInfoByUserId(String mail){
        Mypage mypage = myPageRepository.getUserInfoByUserId(mail).orElse(null);
        if( mypage != null) {
            return UserInfoDTO.builder()
                    .mail(mypage.getUsrIdx().getMail())
                    .pwd("")
                    .imgNm(mypage.getImgNm())
                    .glogTitle(mypage.getGlogTitle())
                    .imgNm(mypage.getImgNm())
                    .build();
        }
        else{
            log.info("findUserInfoByUserId : false - null");
            return null;
        }
    }





    /**
     *  유저 개인 정보 수정
     *  User Nik-Name, user Img-name, user glog Title-name
     *
     *  1. 사용자 검증 ( Access Token )
     *  2. 정보 수정
     *
     * @param userInfoDTO - userinfo id
     * @return :
     *          >  userId is exist       - return user info
     *          >  userId is not exist   - return null
     */
    public UserInfoDTO saveUserInfo(String mail, UserInfoDTO userInfoDTO){
        if(myPageRepository.updateUserInfo(userInfoDTO)){
            return this.findUserInfoByUserId(userInfoDTO.getMail());
        }else{
            log.info("saveUserInfo : false - {} : {}",userInfoDTO.getMail(),mail);
            return null;
        }
    }
}
