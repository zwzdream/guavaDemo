package com.guava.bytes;

import com.google.common.primitives.Bytes;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author WH1707008
 * @date 2018/8/6 20:16
 * Description:
 */
public class BytesTest {
    public static void main(String[] args) {
        byte[] byteArray = {1, 2, 9, 4, 5, 6, 7, 9, 9};
        //将原语数组转换为对象数组
        List<Byte> objectArray = Bytes.asList(byteArray);
        System.out.println(objectArray.toString());

        //将对象数组转换为原语数组
        byteArray = Bytes.toArray(objectArray);
        System.out.print("[");
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print(byteArray[i] + " ");
        }
        System.out.println("]");

        byte data=9;
        byte[] dataByte1={1,2};
        byte[] dataByte2={1,2,3};
        //判断数组是否包含data
        System.out.println("9 is in list? "+ Bytes.contains(byteArray, data));

        //查看data在数组的索引
        System.out.println("Index of 9: " + Bytes.indexOf(byteArray,(byte)9));

        System.out.println("Index of [1,2]: " + Bytes.indexOf(byteArray,dataByte1));
        System.out.println("Index of [1,2,3]: " + Bytes.indexOf(byteArray,dataByte2));


        //查看data在数组的最大索引值
        System.out.println("Last index of 9: " + Bytes.lastIndexOf(byteArray,data));


    }

}
