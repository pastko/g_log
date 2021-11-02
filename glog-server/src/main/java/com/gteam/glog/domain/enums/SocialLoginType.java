package com.gteam.glog.domain.enums;


/**
 * 소셜 타입 ENum
 *
 * 현재 적용 : Google, GiT
 * 추후 적용 예정 : KAAKO, NAVER
 */
public enum SocialLoginType {
    GOOGLE(0), GIT(1), KAKAO(2), NAVER(3);

    private int values;
    SocialLoginType(int values){
        this.values = values;
    }
    public int get(){
        return this.values;
    }
}