package com.gteam.glog.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gteam.glog.domain.entity.Users;
import io.jsonwebtoken.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JWTTokenUtils {

    @Value("${auth.tokenSecret}")
    private String SIGN_KEY;
    @Value("${auth.subject}")
    private String SUBJECT_KEY;
    private static final long JWT_TOKEN_EXPIRED_TIME = 5 * 60  * 1000;
    private static final long COOKIES_EXPIRED_TIME = 20 * 60  * 1000;
    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     * jwt 토큰에서 만효되는 날짜 조회
     *
     * @param token -
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    /**
     * secret 키를 가지고 토큰 내부 정보 조회
     *
     * @param token -
     * @return
     */
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(token).getBody();
    }

    /**
     * 토큰 만료 체크
     *
     * @param token -
     * @return
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    /**
     * 토큰을 생성하는 동안
     * 1. 토큰, Issuer, Expiration, Subject, ID로 claims를 정의한다.
     * 2. HS512알고리즘과 secret key를 가지고 JWT를 서명한다.
     *
     * @param claims -
     * @return generater token string
     */
    private String doGenerateToken(Map<String, Object> claims,long expireTime) {
        return Jwts.builder()
                .setHeader(new HashMap<>(){{
                    put("typ","JWT");
                    put("alg","HS256");
                }})
                .setClaims(claims)
                .setSubject(SUBJECT_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS512, SIGN_KEY)
                .compact();
    }


    /**
     * 전달된 OBJECT로 토큰생성
     *
     * @param data -
     * @return Token String
     */
    public String generateObjectToken(Object data) {
        Map<String, Object> claims = objectMapper.convertValue(data, Map.class);
        return doGenerateToken(claims,JWT_TOKEN_EXPIRED_TIME);
    }

    /**
     * JWT 리프레쉬 토큰을 전달하는 쿠키 생성
     *
     * @param data
     * @return Cookie String
     */
    public Cookie generateCookieToRefreshToken(Object data){
        Map<String, Object> claims = objectMapper.convertValue(data, Map.class);
        return new Cookie("reFreshToken", doGenerateToken(claims,COOKIES_EXPIRED_TIME));
    }

    /**
     * jwt 토큰에서 유효성 검사를 위한 subject 조회
     *
     * @param token -
     * @return
     */
    private String getSubjectFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    /**
     * 토큰 유효성 검증
     * 만료 기간 및 Subject 검증
     * @param token -
     * @return
     */
    public Boolean validateToken(String token) {
        final String subject = getSubjectFromToken(token);
        return (subject.equals(SUBJECT_KEY) && !isTokenExpired(token));
    }

    /**
     * 헤더에 "Bearer "를 제거합니다.
     *
     * @param header -
     */
    public void validationAuthorizationHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException();
        }
    }
    public String extractToken(String authorizationHeader) {
        return authorizationHeader.substring("Bearer ".length());
    }
}
