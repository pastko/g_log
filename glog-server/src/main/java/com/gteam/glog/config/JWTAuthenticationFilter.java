package com.gteam.glog.config;

import com.gteam.glog.common.utils.JWTTokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.log4j.Log4j2;
import org.hibernate.graph.InvalidGraphException;
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

    public JWTAuthenticationFilter(JWTTokenUtils jwtTokenUtils, JWTUserDetailService detailService) {
        this.jwtTokenUtils = jwtTokenUtils;
        this.detailService = detailService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, SecurityException{
        try {
            if(jwtTokenUtils.validateAccessInfoByToken(request.getHeader("authorization"),request.getHeader("X-USER-ID"))){

                UserAuthentication authentication = new UserAuthentication(request.getHeader("X-USER-ID"), null, null); //id를 인증한다.
                authentication.setDetails(detailService);
                SecurityContextHolder.getContext().setAuthentication(authentication);


            }else{

                //throw new InvalidGraphException("Access Token is invalid");
            }
            chain.doFilter(request,response);
        } catch (ServletException e) {
            log.error("Could not set user authentication in security context", e);
        }
    }
}
