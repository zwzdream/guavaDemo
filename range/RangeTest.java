package com.guava.range;


import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/8/3 13:44
 * Description: Range 表示一个间隔或一个序列。它被用于获取一组数字/串在一个特定范围之内。
 * Range<C extends Comparable>：范围
 */
public class RangeTest {
    public static void main(String[] args) {
        //create a range [a,b] = { x | a <= x <= b}
        Range<Integer> range1 = Range.closed(0, 9);
        previewRange(range1);
        System.out.println("5 is present: " + range1.contains(5));
        List list1= Ints.asList(1,2,3);
        previewList(list1);
        System.out.println("(1,2,3) is present:"+range1.containsAll(list1));
        System.out.println("Lower Bound: " + range1.lowerEndpoint());
        System.out.println("Upper Bound: " + range1.upperEndpoint());


        Range<Integer> range6 = Range.closed(3, 5);
        previewRange(range6);
        //check a subrange [3,5] in [0,9]
        System.out.println("[0,9] encloses [3,5]:" + range1.encloses(range6));

        Range range7= Range.closed(9, 12);
        previewRange(range7);
        //check ranges to be connected
        System.out.println("[0,9] is connected [9,20]:" + range1.isConnected(range7));


        Range<Integer> range8 = Range.closed(5, 15);

        //intersection   交集
        previewRange(range1.intersection(range8));


        //span   并集
        previewRange(range1.span(range8));

        System.out.println(Range.all());
    }

    public static void previewRange(Range<Integer> range){
        System.out.print("Range[ \t");
        for(Integer grade :ContiguousSet.create(range, DiscreteDomain.integers())){
            System.out.print(grade+"\t");
        }
        System.out.print("] \n");
    }


    public  static void previewList(List list){
        System.out.print("List[ \t");
        for (Object o : list){
            System.out.print(o+"\t");
        }
        System.out.print("] \n");
    }
}
