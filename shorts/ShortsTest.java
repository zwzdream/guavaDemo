package com.guava.shorts;

import com.google.common.primitives.Shorts;

import java.util.List;

/**
 * @author WH1707008
 * @date 2018/8/6 20:17
 * Description:
 */
public class ShortsTest {
    public static void main(String[] args) {
        short[] shortArray={1,2,3,4,5,6,7,8,9};
        List<Short> shortList = Shorts.asList(shortArray);
        System.out.println(shortList.toString());
        System.out.print("[ ");
        shortArray=Shorts.toArray(shortList);
        for(int i = 0; i< shortArray.length ; i++){
            System.out.print(shortArray[i] + " ");
        }
        System.out.println("]");
        short data = 5;
        //check if element is present in the list of primitives or not
        System.out.println("5 is in list? "+ Shorts.contains(shortArray, data));

        //Returns the minimum
        System.out.println("Min: " + Shorts.min(shortArray));

        //Returns the maximum
        System.out.println("Max: " + Shorts.max(shortArray));

        data = 2400;
        //get the byte array from an integer
        byte[] byteArray = Shorts.toByteArray(data);
        for(int i = 0; i< byteArray.length ; i++){
            System.out.print(byteArray[i] + " ");
        }
    }
}
