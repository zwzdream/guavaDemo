package com.guava.multimap;

import com.google.common.collect.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author WH1707008
 * @date 2018/8/3 15:31
 * Description: 多重映射接口扩展映射，使得其键一次可被映射到多个值
 *  Multimap<K,V>: 一个扩展来映射接口，以便其键可一次被映射到多个值
 */
public class MultimapTest {
    public static void main(String[] args) {
        MultimapTest multimapTest=new MultimapTest();
        Multimap<String, String> multimap = multimapTest.getMultimap();

         List<String> lowerList =(List<String>) multimap.get("lower");
        System.out.println("Initial lower case list");
        System.out.println(lowerList.toString());
        lowerList.add("f");
        System.out.println("Modified lower case list");
        System.out.println(lowerList.toString());

        List<String> upperList = (List<String>)multimap.get("upper");
        System.out.println("Initial upper case list");
        System.out.println(upperList.toString());
        upperList.remove("D");
        System.out.println("Modified upper case list");
        System.out.println(upperList.toString());

        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("Multimap as a map");
        map.entrySet().forEach(entry ->{
            String key=entry.getKey();
            Collection<String> value=entry.getValue();
            System.out.println(key+":\t"+value);

        });

        System.out.println("Keys of Multimap");
        Set<String> keys = multimap.keySet();
        for(String key : keys){
            System.out.println(key);
        }

        System.out.println("Values of Multimap");
        Collection<String> values = multimap.values();
        System.out.println(values);

        Multiset<String> keys1 = multimap.keys();
        keys1.stream().filter(s -> s instanceof Object).forEach(System.out::print);


    }


    private Multimap<String,String> getMultimap(){
        /**创建一个Map<String,List<String>>
         * lower ->a,b,c,d,e
         * upper ->A,B,C,D
         */
        Multimap<String,String> multimap=ArrayListMultimap.create();


        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");


        return multimap;
    }
}
