package com.gteam.glog.common.helper;

import org.springframework.core.convert.converter.Converter;
import com.gteam.glog.domain.enums.SocialLoginType;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class SocialLoginTypeConverter implements Converter<String, SocialLoginType> {
    /**
     * 파라메터로 넘어오는 Social Type을  Enum 타입과 비교하기 위하여 대문자로 변경 후 비교로직 
     * @param _msg
     * @return
     */
    @Override
    public SocialLoginType convert(String _msg){
        return SocialLoginType.valueOf(_msg.toUpperCase(Locale.ROOT));
    }
}
