package com.gteam.glog.common.utils;


import com.gteam.glog.domain.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseDTOUtils {

    /**
     * Generater ResponseDTO
     *
     * @param data  - Response Data
     * @param code  - Status Code
     * @param _msg  - 응답 메시지
     * @return - ResponseEntity
     */
    public ResponseEntity<?> doGenerateSuccessResponseDTO(Object data,int code, String _msg){
        return ResponseEntity
                .status(code)
                .body(
                    UserResponseDTO.builder()
                    .data(data)
                    .msg(_msg)
                    .build()
                );
    }

    /**
     * Generater Bad ResponseDTO
     *
     * @param _msg  - 응답 메시지
     * @param code  - Status Code
     * @return - ResponseEntity
     */
    public ResponseEntity<?> doGenerateFailedResponseDTO(int code,String _msg){
        return ResponseEntity
                .status(code)
                .body(
                    UserResponseDTO.builder()
                        .data(null)
                        .msg(_msg).build()
                );
    }
}
