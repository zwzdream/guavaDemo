package com.guava.caseformat;

import com.google.common.base.CaseFormat;

/**
 * @author WH1707008
 * @date 2018/8/6 16:17
 * Description: 实用程序，用于改变字符串格式
 */
public class CaseFormatTest {
    public static void main(String[] args) {
        testCaseFormat();

    }

    /**
     * LOWER_CAMEL   Java变量的命名规则，如“lowerCamel”
     * LOWER_HYPHEN  连字符连接变量的命名规则，如“lower-hyphen”
     * LOWER_UNDERSCORE C ++变量命名规则，如“lower_underscore
     * UPPER_CAMEL Java和C++类的命名规则，如“UpperCamel”
     * UPPER_UNDERSCORE Java和C++常量的命名规则，如“UPPER_UNDERSCORE”
     *
     * 从样例可以看出CaseFormat的哪个常量调用to方法和to方法的第二个参数String，对to方法的结果没影响。
     * 真正影响to方法只有to的第一个参数，选择的命名规则
     */
    public static void testCaseFormat(){
        String data="test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "tEst_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "TEST_DATA"));

        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
    }
}
