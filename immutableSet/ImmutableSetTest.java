package com.guava.immutableSet;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @author WH1707008
 * @date 2018/8/14 9:47
 * Description: 不可变集合
 * opyOf方法，如ImmutableSet.copyOf(set);
 * of方法，如ImmutableSet.of(“a”, “b”, “c”)或 ImmutableMap.of(“a”, 1, “b”, 2);
 * Builder工具，如
 * public static final ImmutableSet<Color> GOOGLE_COLORS =
 *
 *         ImmutableSet.<Color>builder()
 *
 *             .addAll(WEBSAFE_COLORS)
 *
 *             .add(new Color(0, 191, 255))
 *
 *             .build();
 * 此外，对有序不可变集合来说，排序是在构造集合的时候完成的，如：
 *
 * ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
 * 会在构造时就把元素排序为a, b, c, d。
 */
public class ImmutableSetTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        ImmutableSet<String> set = ImmutableSet.of("a", "b", "c", "a", "b", "d");
        //会在构造时就把元素排序为a, b, c, ds
        set.forEach(System.out::print);
        System.out.println();
        //不可进行添加了
        //set.add("e");
    }


    public static void test2(){
        Set set=new HashSet<String>();
        set.add("a");
        set.add("c");
        set.add("b");
        set.add("a");
        set.add("d");
        for (Object o : set) {
            System.out.print(o+"\t");
        }
        System.out.println();

        ImmutableSet set1 = ImmutableSet.copyOf(set);
        set1.forEach(s->System.out.print(s+"\t"));
        System.out.println();
    }


    public static void test3(){
        ImmutableSet<String> build = ImmutableSet.<String>builder().add("a").add("c").add("o")
                .build();
        build.forEach(System.out::print);
        System.out.println();

    }



}
