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

        setUserData.setMail(userInfoDTO.getMail());
        setUserData.setNikNm(userInfoDTO.getNikNm());
        setUserData.setPwd(passwordEncoder.encode(userInfoDTO.getPwd()));

        registerRepository.createUserInfo(setUserData);

        if(!registerRepository.duplicateCheck(userInfoDTO.getMail()) || userInfoDTO.getMail() != null) {
            return "success";
        }

        return "false";
    }
}
