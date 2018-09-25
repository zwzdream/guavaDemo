package com.guava.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.Set;

/**
 * @author WH1707008
 * @date 2018/8/3 14:46
 * Description: Multiset接口扩展设置有重复的元素，并提供了各种实用的方法来处理这样的元素在集合中出现
 * interface Multiset<E>:多重set ，允许重复的元素
 */
public class MultisetTest {
    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("b");
        multiset.add("b");

        //display all the elements of the multiset
        previewMultisetByForCircle(multiset);
        previewMultisetByIterator(multiset);


        //print the occurrence of an element
        System.out.println("Occurrence of 'b' : " + multiset.count("b"));
        //print the total size of the multiset
        System.out.println("Total Size : " + multiset.size());
        //get the distinct elements of the multiset as set
        Set<String> set = multiset.elementSet();



        //display the elements of the set
        previewSetByForCircle(set);
        previewSetByFoeEach(set);

        //display the distinct elements of the multiset with their occurrence count
         for(Multiset.Entry<String> entry :multiset.entrySet()){
             System.out.print("Element: "+entry.getElement() +", Occurrence(s): " + entry.getCount());
             System.out.println();
         }


        multiset.forEachEntry((s, value) -> System.out.print("Element: "+s+", Occurrence(s): "+value));

        System.out.println();


        //remove extra occurrences
        multiset.remove("b",1);
        //print the occurrence of an element
        System.out.println("Occurence of 'b' : "+multiset.count("b"));

        previewMultisetByIterator(multiset);
    }


    public static void previewMultisetByForCircle(Multiset<String> multiset) {
        for (String s:multiset){
            System.out.print(s+"\t");
        }
        System.out.println();
    }

    public static void previewSetByForCircle(Set<String> set) {
        for (String o : set) {
            System.out.print(o + "\t");
        }
        System.out.println();
    }



    public static void previewSetByFoeEach(Set<String> set){
        //lambda java8 features
        set.forEach(System.out::print);

    }

    public static void previewMultisetByIterator(Multiset<String> multiset){
        Iterator<String> iterator=multiset.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
    }
}
