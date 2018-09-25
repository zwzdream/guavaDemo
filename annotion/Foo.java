package com.guava.annotion;

/**
 * @author WH1707008
 * @date 2018/8/14 20:05
 * Description: Foo 只能是作者级别的人访问
 */
@Access(level = CommonIdentifier.Author)
public class Foo {
    public static void main(String[] args) {
        Foo b=new Foo();
        //获取注解
        Access access = b.getClass().getAnnotation(Access.class);
        System.out.println(access);
        System.out.println(access.level().identify());
        //没有Access注解或者鉴权失败
        if(access==null||!access.level().identify()){
            System.out.println(access.level().REFUSE_WORD);
        }
    }
}
