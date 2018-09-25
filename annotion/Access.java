package com.guava.annotion;

import java.lang.annotation.*;

/**
 * @author WH1707008
 * @date 2018/8/14 20:01
 * Description: 自定义注解，使用注解将资源和权限级别关联起来，当然也可以使用xml配置文件
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {
    //什么级别可以访问，默认是管理员
    CommonIdentifier level() default CommonIdentifier.Admin;
}
