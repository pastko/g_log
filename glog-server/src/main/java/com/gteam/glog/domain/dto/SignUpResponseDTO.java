package com.gteam.glog.domain.dto;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class SignUpResponseDTO {
    private Long id;

    @Builder
    public SignUpResponseDTO(Long id){
        this.id = id;
    }
}
