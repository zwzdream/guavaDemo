package com.guava.joiner;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WH1707008
 * @date 2018/8/6 16:13
 * Description: 实用加入对象，字符串等
 * Joiner
 */
public class JoinerTest {

    public static void main(String[] args) {
        JoinerTest joinerTest=new JoinerTest();
        joinerTest.testJoiner1();
        joinerTest.testJoiner2();
        joinerTest.testJoiner3();


    }

    private void testJoiner1(){
        System.out.println("testJoiner1");
       String s1= Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1,2,3,4,5,null,6));
        System.out.println(s1);

        String s2=Joiner.on(',')
                .useForNull("0")
                .join(Arrays.asList(1,2,3,4,5,null,6));
        System.out.println(s2);



    }


    private void testJoiner2(){
        System.out.println("testJoiner2");
        String[] sArr={"one","two","three","four"};

        /*appendTo在第一个元素前面添加(只能有一个），
        *append在最后一个元素后面添加（可以有多个）
         */
        StringBuilder hello = Joiner.on(",")
                .appendTo(new StringBuilder("hello"),sArr)
                .append(2).append("w");
        System.out.println(hello);


    }
    
    private void testJoiner3(){
        System.out.println("testJoiner3");
        String[] sArr={"one","two","three","four"};
        String join = Joiner.on(',').join(sArr);
        System.out.println(join);
        Map<String,String> map=new HashMap<>();
        map.put("oneKey", "oneValue");
        map.put("twoKey","twoValue" );
        map.put("threeValue", "threeValue");
        String mapString =Joiner.on(",").withKeyValueSeparator(":")
                .join(map);
        System.out.println(mapString);

    }
}
