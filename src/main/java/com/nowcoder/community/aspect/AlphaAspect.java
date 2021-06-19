package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlphaAspect {

    // ("执行（所有返回值 包内所有的业务组件里所有的方法里*（..）所有的参数）")
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointcut() {

    }

    // 切点前
    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    // 切点后
    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    // 返回值后
    @AfterReturning("pointcut()")
    public void afterRetuning() {
        System.out.println("afterRetuning");
    }

    // 异常后
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    // 特殊情况，前后都织入逻辑，这种情况需要返回值
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        // 这句话表示调用目标组件的方法，目标组件可能有返回值，所以用object接收
        Object obj = joinPoint.proceed();
        System.out.println("around after");
        return obj;
    }

}

