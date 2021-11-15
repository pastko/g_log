package com.gteam.glog.common.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@Service
public class CookiesUtils {
    /**
     * Request Servlet내 Cookie 값 조회
     * 1. name이 비어 있지 않을시 해당 이름으로 쿠키 조회
     *
     * @param request
     * @param name
     * @return Optional<string>
     */
    public Optional<String> readServletCookie(HttpServletRequest request, String name){
        if(name != null || name.isEmpty()) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> name.equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .findAny();
        }else{
            return Optional.empty();
        }
    }

    /**
     * 쿠키 생성
     * 1. key이 비어 있지 않을시 'refresh' 이름으로 쿠키 생성
     *
     * @param key
     * @return Optional<string>
     */
    public Cookie setServletCookie(String key){
        if(key != null || key.isEmpty()) {
            return new Cookie("refresh",key);
        }else{
            return null;
        }
    }
}
