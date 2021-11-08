package com.gteam.glog.mypage.repository;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.dto.login.LoginRequestDTO;
import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.mypage.service.MyPageRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {
    private final MyPageRepository myPageRepository;

    public MyPageService(MyPageRepository myPageRepository) {
        this.myPageRepository = myPageRepository;
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
        return myPageRepository.getUserInfoByUserId(mail).orElse(null);
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
    public UserInfoDTO saveUserInfo(String key, String mail, UserInfoDTO userInfoDTO){

        myPageRepository.updateUserInfo(userInfoDTO);


        return findUserInfoByUserId(userInfoDTO.getMail());
    }
}
