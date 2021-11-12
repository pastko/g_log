package com.gteam.glog.config.jwtfilter;

import com.gteam.glog.common.utils.CookiesUtils;
import com.gteam.glog.common.utils.JWTTokenUtils;
import com.gteam.glog.config.UserAuthentication;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    private final JWTTokenUtils jwtTokenUtils;
    private final JWTUserDetailService detailService;
    private final CookiesUtils cookiesUtils;

    public JWTAuthenticationFilter(JWTTokenUtils jwtTokenUtils, JWTUserDetailService detailService, CookiesUtils cookiesUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
        this.detailService = detailService;
        this.cookiesUtils = cookiesUtils;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, SecurityException{
        try {
            if(!request.getRequestURI().contains("/signin") && !request.getRequestURI().contains("/board")) {
                // access token 검증
                if (jwtTokenUtils.validateAccessInfoByToken(request.getHeader("authorization"), request.getHeader("X-USER-ID"))) {
                    // 검증 성공시 인증정보를 UserAuthentication에 등록하여 SecurityContextHolder에 등록
                    UserAuthentication authentication = new UserAuthentication(request.getHeader("X-USER-ID"), null,null); //id를 인증한다.
                    authentication.setDetails(detailService);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    // access toekn 만료 및 잘못된 토큰일시 포함된 cookie 조회하여 refresh token 유무 확인
                    String refreshToken = cookiesUtils.readServletCookie(request,"refresh").orElse(null);
                    if( refreshToken != null) {
                        // refresh token가 존재 할시 refresh token 검증 후 access token 재발급
                        if (jwtTokenUtils.validateRefreshToken(refreshToken, request.getHeader("X-USER-ID"))) {
                            UserAuthentication authentication = new UserAuthentication(request.getHeader("X-USER-ID"), null, null); //id를 인증한다.
                            authentication.setDetails(detailService);

                            //TODO : access token reissurance
//                            String accessToken = jwtTokenUtils.reissuanceAccessToken(refreshToken);
                        }
                    }else{
                        log.info("doFilterInternal : false - UnAuthorized Error");
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorized Error");
                        return;
                    }
                }
            }
            chain.doFilter(request, response);
        } catch (ServletException e) {
            log.info("JWTAuthenticationFilter : false - {} : {}",e.getCause(),e.getMessage());
            log.error("Could not set user authentication in security context", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorized Error");
        }
    }
}
