package com.gteam.glog.common;

import com.gteam.glog.domain.dto.BadResponseDTO;
import com.gteam.glog.domain.dto.UserResponseDTO;
import com.gteam.glog.domain.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseDTOUtils {

    /**
     * Generater ResponseDTO
     *
     * @param users - users 정보
     * @param _msg  - 응답 메시지
     * @return - ResponseEntity
     */
    public ResponseEntity<?> doGenerateResponseDTO(Users users,int code, String _msg){
        return ResponseEntity
                .status(code)
                .body(
                    UserResponseDTO.builder()
                    .useridx(users.getIdx())
                    .data(users.getUserId())
                    .msg(_msg)
                    .build()
                );
    }

    /**
     * Generater Bad ResponseDTO
     *
     * @param _msg  - 응답 메시지
     * @return - ResponseEntity
     */
    public ResponseEntity<?> doGenerateBadResponseDTO(int code,String _msg){
        return ResponseEntity
                .status(code)
                .body(
                    UserResponseDTO.builder()
                        .data(null)
                        .msg(_msg).build()
                );
    }
}
