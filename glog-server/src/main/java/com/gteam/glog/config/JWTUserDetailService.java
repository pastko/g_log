package com.gteam.glog.config;

import com.gteam.glog.domain.entity.Users;
import com.gteam.glog.login.repository.LoginRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailService implements UserDetailsService {
    private final LoginRepository loginRepository;

    public JWTUserDetailService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = loginRepository.getUsersByUserId(username)
                .orElseThrow(()->new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return new User(users.getMail(),users.getPwd(),null);
    }
}
