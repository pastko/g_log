package com.gteam.glog.common.helper;

import com.gteam.glog.domain.enums.SocialLoginType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.Locale;

@Configuration
public class SocialLoginTypeConverter implements Converter<String, SocialLoginType> {

    @Override
    public SocialLoginType convert(String socialtype){
        return SocialLoginType.valueOf(socialtype.toUpperCase(Locale.ROOT));
    }
}
