package com.gteam.glog.config.jwtfilter;

import lombok.extern.log4j.Log4j2;
import org.hibernate.graph.InvalidGraphException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Log4j2
@Component
public class JWTExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("JWTExceptionHandlerFilter : start");
        try {
            log.info("JWTExceptionHandlerFilter : try inner");
            filterChain.doFilter(request,response);
        }catch (InvalidGraphException e){
            log.info("JWTExceptionHandlerFilter : catch inner");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.setContentType("application/json");
//            response.getWriter().write(e.getMessage());
        }
    }
}
