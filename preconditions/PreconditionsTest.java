package com.guava.preconditions;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WH1707008
 * @date 2018/8/3 10:53
 * Description: Preconditions提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。
 *  它检查的先决条件，如果不满足，直接抛出相应的异常.
 *  Preconditions：先决条件，满足条件才能往下走
 */
public class PreconditionsTest {
    public static void main(String[] args) {

        PreconditionsTest test=new PreconditionsTest();
        try{
            System.out.println(test.sqart(-3.0));
        }catch (IllegalArgumentException e){
            //e.printStackTrace();
             System.out.println(e.getMessage());
        }
        try {
            System.out.println(test.sum(null,3));
        }catch(NullPointerException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }

        try{
            Object [] arr={1,2,3,4,5};
            System.out.println(test.getValue(arr, 6));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        try{
            List<String> stringList=new ArrayList<String>(){
                {
                       add("A");add("B");add("C");

                }
            };
            test.getValue(stringList, 5);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println(test.exp(-3.0));
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }



    }

    public double sqart(double input) throws IllegalArgumentException{
        Preconditions.checkArgument(input>0.0,"Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a,Integer b){
        a=Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b=Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");
        return  a+b;
    }

    public <T> int getValue(T [] arr,int index){
        Preconditions.checkElementIndex(index, arr.length,"Illegal Argument passed: Invalid index.");
        return 0;
    }

    public <T> int getValue(List<T> list, int index){
        Preconditions.checkElementIndex(index, list.size(), "Illegal Argument passed: Invalid index.");
        return 0;
    }

     public double exp(double param){
        Preconditions.checkState(param>0.0,"Illegal Argument passed: Negative value %s.", param);
        return Math.exp(param);
     }

}
