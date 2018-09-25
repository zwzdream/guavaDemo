package com.guava.bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author WH1707008
 * @date 2018/8/6 14:25
 * Description: BiMap是一种特殊的映射其保持映射，同时确保没有重复的值是存在于该映射和一个值可以安全地用于获取键背面的倒数映射
 *   key不能重复，value也不能重复
 *
 * BiMap<K,V> :一个扩展来映射接口，支持反向操作
 */
public class BimapTest {
    public static void main(String[] args) {
        BiMap<Integer,String> empIDNameMap= HashBiMap.create();

        empIDNameMap.put(new Integer(101), "Mahesh");
        empIDNameMap.put(new Integer(102), "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");

        empIDNameMap.forEach((i, s) -> System.out.println("[i: "+i+"\ts: "+s+"]") );
        //添加之前，如果已存在重复的key或者value，会将它组合的key-value删除，然后再添加
        empIDNameMap.forcePut(new Integer(104), "Mahesh");
        empIDNameMap.forEach((i, s) -> System.out.println("[i: "+i+"\ts: "+s+"]") );

        //Emp Id of Employee "Mahesh"
        System.out.println(empIDNameMap.inverse().get("Mahesh"));
        System.out.println(empIDNameMap.inverse().get("Sohan"));
    }
}
