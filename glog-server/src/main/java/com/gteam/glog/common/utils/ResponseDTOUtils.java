package com.gteam.glog.common.utils;



import com.gteam.glog.domain.dto.ResponseDTO;
import com.gteam.glog.domain.enums.ResponseStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseDTOUtils {

    /**
     * Generater ResponseDTO
     *
     * @param data  - Response Data
     * @return - ResponseEntity
     */
    public ResponseEntity<?> doGenerateResponseDTO(Object data){
        if(data != null) {
            return ResponseEntity
                    .status(ResponseStatusCode.OK.get())
                    .body(ResponseDTO
                            .builder()
                            .success(true)
                            .data(data)
                            .msg(ResponseStatusCode.OK.getMsg())
                            .build());
        }else{
            return ResponseEntity
                    .status(ResponseStatusCode.BADREQUEST.get())
                    .body(ResponseDTO
                            .builder()
                            .success(false)
                            .data(null)
                            .msg(ResponseStatusCode.BADREQUEST.getMsg())
                            .build());
        }
    }
}
