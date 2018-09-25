package com.guava.charmatcher;

import com.google.common.base.CharMatcher;

/**
 * @author WH1707008
 * @date 2018/8/6 16:16
 * Description:实用的字符操作
 * CharMatcher
 */
public class CharMatcherTest {
    public static void main(String[] args) {
        CharMatcherTest test=new CharMatcherTest();
        test.testCharMather1();
    }

    private void testCharMather1(){
        // only the digits
        System.out.println(CharMatcher.DIGIT.retainFrom("mahesh123"));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.whitespace().trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // star out all digits
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("mahesh123", "*"));
        // eliminate all characters that aren't digits or lowercase
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("mahesh123"));
    }

}
