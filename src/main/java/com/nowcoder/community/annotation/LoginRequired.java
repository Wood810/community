package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// 该注解用于描述方法
@Target(ElementType.METHOD)
// 该注解运行时才有效
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {

}
