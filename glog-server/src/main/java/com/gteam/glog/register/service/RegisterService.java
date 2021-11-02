package com.gteam.glog.register.service;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.register.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public String createUserInfo(UserInfoDTO userInfoDTO) {
        UserInfoDTO setUserData = new UserInfoDTO();

        setUserData.setUserId(userInfoDTO.getUserId());
        setUserData.setNikName(userInfoDTO.getNikName());
        setUserData.setUserPwd(passwordEncoder.encode(userInfoDTO.getUserPwd()));

        registerRepository.createUserInfo(setUserData);

        if(!registerRepository.duplicateCheck(userInfoDTO.getUserId()) || userInfoDTO.getUserId() != null) {
            return "success";
        }

        return "false";
    }
}
