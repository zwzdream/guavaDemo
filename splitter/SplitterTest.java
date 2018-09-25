package com.guava.splitter;

import com.google.common.base.Splitter;

import java.util.Map;

/**
 * @author WH1707008
 * @date 2018/8/6 16:14
 * Description: 实用程序用来分割字符串
 * Spilter
 */
public class SplitterTest {
    public static void main(String[] args) {
        SplitterTest test=new SplitterTest();
        test.testOne();
        test.testTwo();
    }

    /**trimResults（） 去除值前后的空格,值中间的空格去不了
     * omitEmptyStrings 去除结果里的空值
     *与顺序无关
     */
    private void testOne(){
        String str=" the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog. ";
        System.out.println("testOne  Function");
        Iterable<String> strings = Splitter.on(',').trimResults().split(str);
        Iterable<String> strings2 = Splitter.on(',').trimResults().omitEmptyStrings().split(str);
        Iterable<String> strings3 = Splitter.on(',').omitEmptyStrings().trimResults().split(str);

        System.out.println(strings);
        System.out.println(strings2);
        System.out.println(strings3);
    }

    private void testTwo(){
        System.out.println("testTwo  Function");
        String str="   1:  one,2 :  two Value , 3 :   three";
        Map map=Splitter.on(",").trimResults().omitEmptyStrings()
        .withKeyValueSeparator(":")
                .split(str);
        System.out.println(map);
        map.forEach((k,v)->System.out.println(k+":"+v));
    }
}
