package com.nowcoder.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

// 声明这不是一个普通类而是配置类
@Configuration
public class KaptchaConfig {

    // 能被Spring管理和装配，Bean的名字就是方法名,这个方法返回的对象将被装配在容器里
    @Bean
    public Producer kaptchaProducer() {
        Properties properties = new Properties();
        properties.setProperty("kaptcha.image.width", "100");
        properties.setProperty("kaptcha.image.height", "40");
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        properties.setProperty("kaptcha.textproducer.font.color", "0,0,0");
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYAZ");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        // DefaultKaptcha实现了Producer接口
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        // 其实传入的properties相当于是一个map
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }

}
