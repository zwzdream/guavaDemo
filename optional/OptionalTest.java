package com.guava.optional;


import com.google.common.base.Optional;
import org.junit.Test;

/**
 * @author WH1707008
 * @date 2018/8/2 21:32
 * Description: Optional用于包含非空对象的不变对象。Optional对象，用于不存在值表示null。这个类
 * 用于各种实用的方法，以方便代码来处理为可用或不可用，而不是检查null值
 * Optional<T>：可选择的，相当于一个容器
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest optionalTest=new OptionalTest();
        Integer invalidInput=null;
        //Optional.fromNullable - allows passed parameter to be null.
        //这说明，运行到这个代码不会出现NullPointerException
        Optional<Integer> a= Optional.fromNullable(invalidInput);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(optionalTest.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());
        //Optional.or - returns the value if present otherwise returns the default value passed.
        //Optional.get - gets the value, value should be present
        return a.or(new Integer(0)) + b.get();
    }


    @Test
    public void testAbsent(){
        Optional<Object> absent = Optional.absent();
        System.out.println(absent.get());
    }

}

