package com.nowcoder.community.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

//此注解表示这是一个配置类，不是普通类
@Configuration
public class AlphaConfig {

    //Bean的名字就是方法名,这个方法返回的对象将被装配在容器里
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}
